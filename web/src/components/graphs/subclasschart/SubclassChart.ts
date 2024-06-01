import { Component, Prop, Watch } from 'vue-property-decorator';
import Vue from 'vue';
import anychart from 'anychart';
import { SubClassCountStatisticDTO } from '@/models/SubClassCountStatisticDTO';

@Component
export default class SubclassChart extends Vue {
    /** Заголовок графика */
    @Prop({ default: '' })
    private header!: string;

    /** Данные для графика */
    @Prop({ default: [] })
    private chartData!: SubClassCountStatisticDTO[];

    /** Цветовая палитра */
    private palette = [
        '#64b5f6',
        '#1976d2',
        '#ef6c00',
        '#ffa000',
        '#cd5dec',
        '#851cf5',
    ];

    /** Возрастные группы */
    private get subclassRange(): string[] {
        if (this.chartData.length) {
            return this.chartData.map(
                (item: SubClassCountStatisticDTO): string => item.subclassName
            );
        } else {
            return [];
        }
    }

    /** График */
    private chart: any = null;

    /** Идентификатор контейнера для графика */
    public containerId: string = 'subclass-chart';

    /**
     * Действия по отрисовке компонента
     */
    @Watch('chartData.length', { immediate: false })
    private dataChanged(): void {
        if (this.chart) {
            this.chart.dispose();
        }
        this.updateChartData();
    }

    /** Обновить графики */
    private updateChartData(): void {
        const data: {
            x: string;
            value: number;
            fill: string;
            total: number;
        }[] = [];
        this.chartData.forEach(
            (item: SubClassCountStatisticDTO, index: number): void => {
                const label = this.subclassRange.find(
                    (value: string): boolean => item.subclassName === value
                );
                if (label) {
                    data.push({
                        x: item.subclassName,
                        value: item.subclassCount,
                        fill: this.palette[index],
                        total: item.totalSubclassCount,
                    });
                }
            }
        );
        this.chart = anychart.pie(data);
        this.chart.container(this.containerId);
        this.chart.draw();

        const title = this.chart.title();
        title.enabled(true);
        title.useHtml(true);
        title.hAlign('center');
        let total = 0;
        this.chartData.forEach(
            (item: SubClassCountStatisticDTO): void => {
                total = total + item.totalSubclassCount;
            }
        );
        title.text(
            `<span style="font-size: 14px">${
                this.header
            }<br><span style="font-size: 13px">Общее количество подклассов: ${total}
</span></span>`
        );

        this.chart.radius('43%').innerRadius('30%');

        this.chart.legend().itemsLayout('horizontal-expandable');

        this.chart
            .tooltip()
            .titleFormat('{%X}')
            .displayMode('union');
        this.chart.tooltip().format(
            (value: any): string | void => {
                const sum = this.chart.getStat('sum');
                let percent = 0;
                if (value.value && sum) {
                    percent = (value.value / sum) * 100;
                }
                return `Количество: ${value.value}\n Процент: ${percent.toFixed(
                    0
                )}%`;
            }
        );

        const labels = this.chart.labels();
        labels.useHtml(true);
        labels.format(
            (value: any): string => {
                const sum = this.chart.getStat('sum');
                let percent = 0;
                if (value.value && sum) {
                    percent = (value.value / sum) * 100;
                }
                return `${percent.toFixed(0)}%`;
            }
        );
    }
}
