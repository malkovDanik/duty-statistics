import { Component, Vue, Watch } from 'vue-property-decorator';
import moment from 'moment';
import { ElDatePicker } from 'element-ui/types/date-picker';
import SectionTopPanel from '@/components/sectiontoppanel/SectionTopPanel';
import ShipsTable from '@/components/shipstable/ShipsTable';
import RouteTable from '@/components/routetable/RouteTable';
import Graphs from '@/components/graphs/Graphs';
import DutyStatisticsApi from '@/api/dutystatistics/DutyStatisticsApi';
import { DutyObjectDTO } from '@/models/DutyObjectDTO';
import { SubClassCountStatisticDTO } from '@/models/SubClassCountStatisticDTO';
import SubclassChart from '@/components/graphs/subclasschart/SubclassChart';
import { DutyObjectRouteDTO } from '@/models/DutyObjectRouteDTO';

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

    private ships: DutyObjectDTO[] = [];

    private routes: DutyObjectRouteDTO[] = [];

    private selectedShip: DutyObjectDTO | null = null;

    private subclassChart: SubClassCountStatisticDTO[] = [];

    @Watch('selectedShip')
    private changeSelectedShip(): void {
        if (this.selectedShip)
            DutyStatisticsApi.getDutyObjectsRoutes(
                this.period[0],
                this.period[1],
                this.selectedShip.id
            ).then(
                (data: DutyObjectRouteDTO[]): void => {
                    this.routes = data;
                }
            );
    }

    private get swimming(): string {
        let total = 0;
        this.routes.forEach(
            (item: DutyObjectRouteDTO): void => {
                total = total + (item.length ? item.length : 0);
            }
        );
        return `${total} км / ${this.distanceToMiles(total).toFixed(2)} миль`;
    }

    public distanceToMiles(distanceInKilometer: number): number {
        return distanceInKilometer * 0.539957;
    }

    private mounted(): void {
        this.getShips();
        this.getSubClassCountStatistic();
    }

    private changePeriod(): void {
        this.getShips();
        this.getSubClassCountStatistic();
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
            (data: DutyObjectDTO[]): void => {
                this.ships = data;
            }
        );
    }

    private selectShip(ship: DutyObjectDTO): void {
        this.selectedShip = ship;
    }
}
