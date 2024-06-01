import { AxiosResponse } from 'axios';
import { AbstractApi } from '@/api/AbstractApi';
import { dataToArrayClass } from '@/api/ClassFactory';
import { SurfacingStatisticDTO } from '@/models/SurfacingStatisticDTO';
import RequestUrl from '@/api/requestUrl';

@RequestUrl('dutyStatistics')
class DutyStatisticsApi extends AbstractApi {
    /**
     * Получить дежурные объекты
     * @param startDate начало периода
     * @param endDate   конец периожа
     */
    public getDutyObjects(
        startDate: Date,
        endDate: Date
    ): Promise<SurfacingStatisticDTO[]> {
        return this.get('/getDutyObjects', {
            params: {
                startDate,
                endDate,
            },
        }).then(
            (response: AxiosResponse): SurfacingStatisticDTO[] =>
                dataToArrayClass(SurfacingStatisticDTO, response.data)
        );
    }

    /**
     * Получить маршруты за объект
     * @param startDate начало периода
     * @param endDate   конец перида
     */
    public getDutyObjectsRoutes(
        startDate: Date,
        endDate: Date
    ): Promise<SurfacingStatisticDTO[]> {
        return this.get('/getDutyObjectsRoutes', {
            params: {
                startDate,
                endDate,
            },
        }).then(
            (response: AxiosResponse): SurfacingStatisticDTO[] =>
                dataToArrayClass(SurfacingStatisticDTO, response.data)
        );
    }
}

export default new DutyStatisticsApi();
