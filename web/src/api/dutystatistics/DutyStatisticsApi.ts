import { AxiosResponse } from 'axios';
import { AbstractApi } from '@/api/AbstractApi';
import { dataToArrayClass } from '@/api/ClassFactory';
import { SurfacingStatisticDTO } from '@/models/SurfacingStatisticDTO';
import RequestUrl from '@/api/requestUrl';
import { SubClassCountStatisticDTO } from '@/models/SubClassCountStatisticDTO';

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

    /**
     * 1) График с количеством подклассов
     *
     * @param startDate начало периода
     * @param endDate   конец периожа
     */
    public getSubClassCountStatistic(
        startDate: Date,
        endDate: Date
    ): Promise<SubClassCountStatisticDTO[]> {
        return this.get('/subClassCount', {
            params: {
                startDate,
                endDate,
            },
        }).then(
            (response: AxiosResponse): SubClassCountStatisticDTO[] =>
                dataToArrayClass(SubClassCountStatisticDTO, response.data)
        );
    }
}

export default new DutyStatisticsApi();
