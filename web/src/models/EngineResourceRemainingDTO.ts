export class EngineResourceRemainingDTO {
    /**
     * Идентификатор дежурного объекта
     */
    public dutyObjectId!: string;

    public dutyObjectName: string = '';
    /**
     * Значение остатка
     */
    public engineResourceRemaining: number = 0;
    /**
     * Полный ресурс двигателя
     */
    public totalEngineResource: number = 0;
}
