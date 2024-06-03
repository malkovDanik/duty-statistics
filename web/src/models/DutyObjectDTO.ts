export class DutyObjectDTO {
    public id!: string;
    public length: number | null = null;
    public engineResource: number | null = null;
    public annualPassageRate: number | null = null;
    public subclassName: string = '';
    public startDate: Date = new Date();
    public endDate: Date = new Date();
}
