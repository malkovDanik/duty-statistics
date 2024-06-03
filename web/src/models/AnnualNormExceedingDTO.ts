export class AnnualNormExceedingDTO {
    /**
     * Идентификатор дежурного объекта
     */
    public dutyObjectId!: string;
    public dutyObjectName: string = '';
    public annualNormExceeding: number = 0;
    public annualPassageRate: number = 0;
}
