import { Component, Prop, Watch } from 'vue-property-decorator';
import Vue from 'vue';
import anychart from 'anychart';

@Component
export default class EngineOperating extends Vue {
    /** Данные для графика */
    @Prop({ default: [] })
    private chartData!: any[];

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

    /** Обновить графики */
    private updateChartData(): void {
        const data = anychart.data.set([
            ['Корабль 1', 120],
            ['Корабль 2', 200],
            ['Корабль 3', 1000],
            ['Корабль 4', 6500],
            ['Корабль 5', 6000],
            ['Корабль 6', 120],
            ['Корабль 7', 200],
            ['Корабль 8', 1000],
            ['Корабль 9', 6500],
            ['Корабль 10', 6000],
            ['Корабль 11', 6000],
        ]);
        this.chart = anychart.bar();
        this.chart.container(this.containerId);
        this.chart.draw();

        const seriesData1 = data.mapAs({ x: 0, value: 1 });
        const series1 = this.chart.bar(seriesData1);
        series1.name('Наработка двигателя');
        series1.normal().fill('#1976d2', 0.8);
        series1.hovered().fill('#1976d2', 0.8);
        series1.selected().fill('#1976d2', 0.8);
        series1.normal().stroke('#1976d2');
        series1.hovered().stroke('#1976d2', 2);
        series1.selected().stroke('#1976d2', 2);

        this.chart.xAxis().title('Список объектов');
        this.chart.yAxis().title('ч');

        const xLabels = this.chart.xAxis().labels();
        xLabels.wordWrap('break-word');
        xLabels.wordBreak('break-all');
        xLabels.width(100);
        xLabels.hAlign('right');
    }
}
