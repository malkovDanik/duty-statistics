import { Component, Prop, Watch } from 'vue-property-decorator';
import Vue from 'vue';
import anychart from 'anychart';
import { EngineOperatingDTO } from '@/models/EngineOperatingDTO';

@Component
export default class EngineOperating extends Vue {
    /** Данные для графика */
    @Prop({ default: (): [] => [] })
    private chartData!: EngineOperatingDTO[];

    /** График */
    private chart: any = null;

    /** Идентификатор контейнера для графика */
    public containerId: string = 'engine-operating-chart';

    private mounted(): void {
        this.updateChartData();
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

    private get items(): [string, number][] {
        return this.chartData.sort(
            (a: EngineOperatingDTO, b: EngineOperatingDTO) => {
                return (a.dutyObjectName
                        ? a.dutyObjectName
                        : ''
                ).localeCompare(
                    b.dutyObjectName ? b.dutyObjectName : ''
                );
            }
        ).map(
            (item: EngineOperatingDTO): [string, number] => [
                item.dutyObjectName,
                item.operatingFullResource,
            ]
        );
    }

    /** Обновить графики */
    private updateChartData(): void {
        const data = anychart.data.set(this.items);
        this.chart = anychart.bar();
        this.chart.container(this.containerId);
        this.chart.draw();

        this.chart.yScale().maximum(18000);

        const seriesData1 = data.mapAs({ x: 0, value: 1 });
        const series1 = this.chart.bar(seriesData1);
        series1.name('Наработка двигателя');
        series1.labels(true);
        series1.normal().fill('#1976d2', 0.8);
        series1.hovered().fill('#1976d2', 0.8);
        series1.selected().fill('#1976d2', 0.8);
        series1.normal().stroke('#1976d2');
        series1.hovered().stroke('#1976d2', 2);
        series1.selected().stroke('#1976d2', 2);

        this.chart.xAxis().title('Список объектов');
        this.chart.yAxis().title('ч');

        this.chart.legend(true);
        this.chart.legend().itemsLayout("vertical");

        const xLabels = this.chart.xAxis().labels();
        xLabels.wordWrap('break-word');
        xLabels.wordBreak('break-all');
        xLabels.width(100);
        xLabels.hAlign('right');
    }
}
