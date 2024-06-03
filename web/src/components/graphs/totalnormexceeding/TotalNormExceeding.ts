import { Component, Prop, Watch } from 'vue-property-decorator';
import Vue from 'vue';
import anychart from 'anychart';
import { TotalNormExceedingDTO } from '@/models/TotalNormExceedingDTO';
import { AnnualNormExceedingDTO } from '@/models/AnnualNormExceedingDTO';

@Component
export default class TotalNormExceeding extends Vue {
    /** Данные для графика */
    @Prop({ default: [] })
    private chartData!: TotalNormExceedingDTO[];

    /** График */
    private chart: any = null;

    /** Идентификатор контейнера для графика */
    public containerId: string = 'total-norm-exceeding';

    private mounted(): void {
        this.updateChartData();
    }

    private get items(): [string, number, number][] {
        return this.chartData.map(
            (item: TotalNormExceedingDTO): [string, number, number] => [
                item.dutyObjectName,
                item.totalNormExceeding,
                item.totalEngineResource,
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

        const seriesData1 = data.mapAs({ x: 0, value: 1 });
        const seriesData2 = data.mapAs({ x: 0, value: 2 });

        const series1 = this.chart.bar(seriesData1);
        series1.name(
            'Остаток (перерасход) полного технического ресурса двигателя'
        );
        series1.normal().fill('#1976d2', 0.8);
        series1.hovered().fill('#1976d2', 0.8);
        series1.selected().fill('#1976d2', 0.8);
        series1.normal().stroke('#1976d2');
        series1.hovered().stroke('#1976d2', 2);
        series1.selected().stroke('#1976d2', 2);

        const series2 = this.chart.bar(seriesData2);
        series2.name('Полный технический ресурс двигателя');
        series2.normal().fill('#ef6c00', 0.8);
        series2.hovered().fill('#ef6c00', 0.8);
        series2.selected().fill('#ef6c00', 0.8);
        series2.normal().stroke('#ef6c00');
        series2.hovered().stroke('#ef6c00', 2);
        series2.selected().stroke('#ef6c00', 2);

        this.chart.xAxis().title('Список объектов');
        this.chart.yAxis().title('ч');

        this.chart.legend(true);

        this.chart.barsPadding(0);
        this.chart.barGroupsPadding(2);

        const xLabels = this.chart.xAxis().labels();
        xLabels.wordWrap('break-word');
        xLabels.wordBreak('break-all');
        xLabels.width(100);
        xLabels.hAlign('right');
    }
}
