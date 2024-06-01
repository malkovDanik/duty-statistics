import { Component, Prop, Vue, Watch } from 'vue-property-decorator';
import { SurfacingStatisticDTO } from '@/models/SurfacingStatisticDTO';
import { ElTable } from 'element-ui/types/table';

@Component
export default class ShipsTable extends Vue {
    public $refs!: {
        shipsTable: ElTable;
    };

    @Prop({ default: (): [] => [] })
    private ships!: SurfacingStatisticDTO[];

    @Watch('ships')
    private changeShips(): void {
        if (this.ships.length)
            this.$refs.shipsTable.setCurrentRow(this.ships[0]);
    }

    private selectedRow: any = null;

    private selectRow(row: any): void {
        this.selectedRow = row;
        this.$emit('selectShip', row);
    }
}
