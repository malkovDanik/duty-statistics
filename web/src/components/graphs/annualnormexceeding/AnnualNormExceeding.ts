import { Component, Prop, Watch } from 'vue-property-decorator';
import Vue from 'vue';
import anychart from 'anychart';
import { AnnualNormExceedingDTO } from '@/models/AnnualNormExceedingDTO';

@Component
export default class AnnualNormExceeding extends Vue {
    /** Данные для графика */
    @Prop({ default: (): [] => [] })
    private chartData!: AnnualNormExceedingDTO[];

    /** График */
    private chart: any = null;

    /** Идентификатор контейнера для графика */
    public containerId: string = 'annual-norm-exceeding';

    private mounted(): void {
        this.updateChartData();
    }

    private get items(): [string, number, number][] {
        return this.chartData.sort(
            (a: AnnualNormExceedingDTO, b: AnnualNormExceedingDTO) => {
                return (a.dutyObjectName
                        ? a.dutyObjectName
                        : ''
                ).localeCompare(
                    b.dutyObjectName ? b.dutyObjectName : ''
                );
            }
        ).map(
            (item: AnnualNormExceedingDTO): [string, number, number] => [
                item.dutyObjectName,
                item.annualNormExceeding > 0 ? item.annualNormExceeding : 0,
                item.annualPassageRate,
            ]
        );
    }

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
        const data = anychart.data.set(this.items);
        this.chart = anychart.bar();
        this.chart.container(this.containerId);
        this.chart.draw();

        this.chart.yScale().minimum(0);

        const seriesData1 = data.mapAs({ x: 0, value: 1 });
        const seriesData2 = data.mapAs({ x: 0, value: 2 });

        const series1 = this.chart.bar(seriesData1);
        series1.name(
            'Перерасход наработки технического\nресурса годовой нормы двигателя'
        );
        series1.labels(true);
        series1.labels().fontColor('#000');
        series1.normal().fill('#1976d2', 0.8);
        series1.hovered().fill('#1976d2', 0.8);
        series1.selected().fill('#1976d2', 0.8);
        series1.normal().stroke('#1976d2');
        series1.hovered().stroke('#1976d2', 2);
        series1.selected().stroke('#1976d2', 2);

        const series2 = this.chart.bar(seriesData2);
        series2.name('Годовая норма технического ресурса двигателя');
        series2.labels(true);
        series2.labels().fontColor('#000');
        series2.normal().fill('#ef6c00', 0.8);
        series2.hovered().fill('#ef6c00', 0.8);
        series2.selected().fill('#ef6c00', 0.8);
        series2.normal().stroke('#ef6c00');
        series2.hovered().stroke('#ef6c00', 2);
        series2.selected().stroke('#ef6c00', 2);

        this.chart.xAxis().title('Список объектов');
        this.chart.yAxis().title('ч');

        this.chart.legend(true);
        this.chart.legend().itemsLayout("vertical");

        this.chart.barsPadding(0.5);
        this.chart.barGroupsPadding(2);

        const xLabels = this.chart.xAxis().labels();
        xLabels.wordWrap('break-word');
        xLabels.wordBreak('break-all');
        xLabels.width(100);
        xLabels.hAlign('right');
    }
}
