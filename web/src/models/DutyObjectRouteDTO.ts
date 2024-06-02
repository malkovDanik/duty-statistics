import moment from 'moment';

export class DutyObjectRouteDTO {
    public id!: string;
    /**
     * Длина маршрута, км
     */
    public length: number | null = null;
    public operatingFullResource: number | null = null;
    public startDate: Date = new Date();
    public endDate: Date = new Date();

    public get formatDate(): string {
        return `от ${moment(this.startDate).format('DD.MM.YYYY')}`;
    }
}
