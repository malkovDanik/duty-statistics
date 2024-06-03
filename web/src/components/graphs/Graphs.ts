import { Component, Prop, Vue, Watch } from 'vue-property-decorator';
import SubclassChart from '@/components/graphs/subclasschart/SubclassChart';
import DutyStatisticsApi from '@/api/dutystatistics/DutyStatisticsApi';
import EngineOperating from '@/components/graphs/engineoperating/EngineOperating';
import EngineResourceRemaining from '@/components/graphs/engineresourceremaining/EngineResourceRemaining';
import AnnualNormExceeding from '@/components/graphs/annualnormexceeding/AnnualNormExceeding';
import TotalNormExceeding from '@/components/graphs/totalnormexceeding/TotalNormExceeding';
import { EngineOperatingDTO } from '@/models/EngineOperatingDTO';
import { EngineResourceRemainingDTO } from '@/models/EngineResourceRemainingDTO';
import { AnnualNormExceedingDTO } from '@/models/AnnualNormExceedingDTO';
import { TotalNormExceedingDTO } from '@/models/TotalNormExceedingDTO';

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

    private engineOperating: EngineOperatingDTO[] = [];

    private engineResourceRemaining: EngineResourceRemainingDTO[] = [];

    private annualNormExceeding: AnnualNormExceedingDTO[] = [];

    private totalNormExceeding: TotalNormExceedingDTO[] = [];

    private mounted(): void {
        this.changePeriod();
    }

    @Watch('period')
    private changePeriod(): void {
        this.getEngineOperating();
        this.getEngineResourceRemaining();
        this.getAnnualNormExceeding();
        this.getTotalNormExceeding();
    }

    private getEngineOperating(): void {
        DutyStatisticsApi.getEngineOperating(this.period[1]).then(
            (data: EngineOperatingDTO[]): void => {
                this.engineOperating = data;
            }
        );
    }

    private getEngineResourceRemaining(): void {
        DutyStatisticsApi.getEngineResourceRemaining(this.period[1]).then(
            (data: EngineResourceRemainingDTO[]): void => {
                this.engineResourceRemaining = data;
            }
        );
    }

    private getAnnualNormExceeding(): void {
        DutyStatisticsApi.getAnnualNormExceeding(this.period[1]).then(
            (data: AnnualNormExceedingDTO[]): void => {
                this.annualNormExceeding = data;
            }
        );
    }

    private getTotalNormExceeding(): void {
        DutyStatisticsApi.getTotalNormExceeding(this.period[1]).then(
            (data: TotalNormExceedingDTO[]): void => {
                this.totalNormExceeding = data;
            }
        );
    }
}
