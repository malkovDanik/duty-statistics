import { Component, Vue, Watch } from 'vue-property-decorator';
import moment from 'moment';
import { ElDatePicker } from 'element-ui/types/date-picker';
import SectionTopPanel from '@/components/sectiontoppanel/SectionTopPanel';
import ShipsTable from '@/components/shipstable/ShipsTable';
import RouteTable from '@/components/routetable/RouteTable';
import Graphs from '@/components/graphs/Graphs';
import DutyStatisticsApi from '@/api/dutystatistics/DutyStatisticsApi';
import { SurfacingStatisticDTO } from '@/models/SurfacingStatisticDTO';
import { SubClassCountStatisticDTO } from '@/models/SubClassCountStatisticDTO';
import SubclassChart from '@/components/graphs/subclasschart/SubclassChart';

@Component({
    components: {
        SectionTopPanel,
        ShipsTable,
        RouteTable,
        SubclassChart,
        Graphs,
    },
})
export default class DutyStatistics extends Vue {
    /** Период дат */
    private period: Date[] = [
        moment()
            .subtract(1, 'year')
            .toDate(),
        moment()
            .add(0, 'hour')
            .toDate(),
    ];

    /** Настройки для календаря дат */
    private pickerOptions: object = {
        shortcuts: [
            {
                text: 'За последний месяц',
                onClick(picker: ElDatePicker): void {
                    const end = new Date();
                    const start = moment()
                        .subtract(1, 'month')
                        .toDate();
                    picker.$emit('pick', [start, end]);
                },
            },
            {
                text: 'За последние три месяца',
                onClick(picker: ElDatePicker): void {
                    const end = new Date();
                    const start = moment()
                        .subtract(3, 'month')
                        .toDate();
                    picker.$emit('pick', [start, end]);
                },
            },
            {
                text: 'За последний год',
                onClick(picker: ElDatePicker): void {
                    const end = new Date();
                    const start = moment()
                        .subtract(1, 'year')
                        .toDate();
                    picker.$emit('pick', [start, end]);
                },
            },
        ],
        firstDayOfWeek: 1, // чтобы Пн был началом неделе, а не Вск.
    };

    private ships: SurfacingStatisticDTO[] = [];

    private routes: any = [];

    private selectedShip: SurfacingStatisticDTO | null = null;

    private subclassChart: SubClassCountStatisticDTO[] = [];

    @Watch('selectedShip')
    private changeSelectedShip(): void {
        DutyStatisticsApi.getDutyObjectsRoutes(
            this.period[0],
            this.period[1]
        ).then(
            (data: any[]): void => {
                this.routes = data;
            }
        );
    }

    private mounted(): void {
        this.getShips();
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

    private getShips(): void {
        DutyStatisticsApi.getDutyObjects(this.period[0], this.period[1]).then(
            (data: SurfacingStatisticDTO[]): void => {
                this.ships = data;
            }
        );
    }

    private selectShip(ship: SurfacingStatisticDTO): void {
        this.selectedShip = ship;
    }
}
