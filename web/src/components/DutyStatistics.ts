import { Component, Vue } from 'vue-property-decorator';
import moment from 'moment';
import { ElDatePicker } from 'element-ui/types/date-picker';
import SectionTopPanel from '@/components/sectiontoppanel/SectionTopPanel';
import ShipsTable from '@/components/shipstable/ShipsTable';
import RouteTable from '@/components/routetable/RouteTable';
import Graphs from '@/components/graphs/Graphs';

@Component({ components: { SectionTopPanel, ShipsTable, RouteTable, Graphs } })
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
}
