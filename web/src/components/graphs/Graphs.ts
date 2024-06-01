import { Component, Vue } from 'vue-property-decorator';

@Component
export default class Graphs extends Vue {
    private ships: any[] = [];

    private selectedRow: any = null;

    private selectRow(row: any): void {
        this.selectedRow = row;
    }
}
