export class TotalNormExceedingDTO {
    /**
     * Идентификатор дежурного объекта
     */
    public dutyObjectId!: string;
    public dutyObjectName: string = '';
    public totalNormExceeding: number = 0;
    public totalEngineResource: number = 0;
}
