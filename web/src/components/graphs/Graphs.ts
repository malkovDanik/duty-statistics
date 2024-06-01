import { Component, Prop, Vue } from 'vue-property-decorator';
import SubclassChart from '@/components/graphs/subclasschart/SubclassChart';
import DutyStatisticsApi from '@/api/dutystatistics/DutyStatisticsApi';
import { SubClassCountStatisticDTO } from '@/models/SubClassCountStatisticDTO';

@Component({ components: { SubclassChart } })
export default class Graphs extends Vue {
    @Prop()
    private period!: Date[];

    private ships: any[] = [];

    private subclassChart: SubClassCountStatisticDTO[] = [];

    private selectedRow: any = null;

    private selectRow(row: any): void {
        this.selectedRow = row;
    }

    private mounted(): void {
        this.getSubClassCountStatistic();
        setTimeout((): void => {
            this.subclassChart = [
                {
                    subclassName: 'Подкласс1',
                    subclassCount: 4,
                    totalSubclassCount: 10,
                    subclassPercent: 11,
                },
                {
                    subclassName: 'Подкласс2',
                    subclassCount: 46,
                    totalSubclassCount: 36,
                    subclassPercent: 28,
                },
                {
                    subclassName: 'Подкласс3',
                    subclassCount: 23,
                    totalSubclassCount: 22,
                    subclassPercent: 21,
                },
            ];
        }, 0);
    }

    /** Получить график с количеством подклассов */
    private getSubClassCountStatistic(): void {
        DutyStatisticsApi.getSubClassCountStatistic(
            this.period[0],
            this.period[1]
        ).then(
            (data: SubClassCountStatisticDTO[]): void => {
                this.subclassChart = data;
            }
        );
    }
}
