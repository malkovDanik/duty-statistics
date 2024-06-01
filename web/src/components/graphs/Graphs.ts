import { Component, Prop, Vue } from 'vue-property-decorator';
import SubclassChart from '@/components/graphs/subclasschart/SubclassChart';
import DutyStatisticsApi from '@/api/dutystatistics/DutyStatisticsApi';
import { SubClassCountStatisticDTO } from '@/models/SubClassCountStatisticDTO';
import EngineOperating from '@/components/graphs/engineoperating/EngineOperating';
import EngineResourceRemaining from '@/components/graphs/engineresourceremaining/EngineResourceRemaining';
import AnnualNormExceeding from '@/components/graphs/annualnormexceeding/AnnualNormExceeding';
import TotalNormExceeding from '@/components/graphs/totalnormexceeding/TotalNormExceeding';

@Component({
    components: {
        SubclassChart,
        EngineOperating,
        EngineResourceRemaining,
        AnnualNormExceeding,
        TotalNormExceeding,
    },
})
export default class Graphs extends Vue {
    @Prop()
    private period!: Date[];

    private ships: any[] = [];

    private selectedRow: any = null;

    private selectRow(row: any): void {
        this.selectedRow = row;
    }
}
