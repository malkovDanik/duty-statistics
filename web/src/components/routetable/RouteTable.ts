import { Component, Vue } from 'vue-property-decorator';

@Component
export default class RouteTable extends Vue {
    private route: any[] = [];

    private selectedRow: any = null;

    private selectRow(row: any): void {
        this.selectedRow = row;
    }
}
