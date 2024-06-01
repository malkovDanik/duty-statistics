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
        this.chart = anychart.bar(data);
        this.chart.container(this.containerId);
        this.chart.draw();

        this.chart.tooltip().format(
            (value: any): string | void => {
                return `Наработка двигателя: ${value.value}`;
            }
        );

        this.chart.xAxis().title('Список объектов');
        this.chart.yAxis().title('ч');

        const xLabels = this.chart.xAxis().labels();
        xLabels.wordWrap('break-word');
        xLabels.wordBreak('break-all');
        xLabels.width(100);
        xLabels.hAlign('right');
    }
}
