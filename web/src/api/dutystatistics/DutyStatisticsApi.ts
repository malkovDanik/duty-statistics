import { AxiosResponse } from 'axios';
import { AbstractApi } from '@/api/AbstractApi';
import { dataToArrayClass } from '@/api/ClassFactory';
import { DutyObjectDTO } from '@/models/DutyObjectDTO';
import RequestUrl from '@/api/requestUrl';
import { SubClassCountStatisticDTO } from '@/models/SubClassCountStatisticDTO';
import { DutyObjectRouteDTO } from '@/models/DutyObjectRouteDTO';

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
    ): Promise<DutyObjectDTO[]> {
        return this.get('/getDutyObjects', {
            params: {
                startDate,
                endDate,
            },
        }).then(
            (response: AxiosResponse): DutyObjectDTO[] =>
                dataToArrayClass(DutyObjectDTO, response.data)
        );
    }

    /**
     * Получить маршруты за объект
     * @param startDate начало периода
     * @param endDate   конец перида
     */
    public getDutyObjectsRoutes(
        startDate: Date,
        endDate: Date,
        dutyObjectId: string
    ): Promise<DutyObjectRouteDTO[]> {
        return this.get('/getDutyObjectsRoutes', {
            params: {
                startDate,
                endDate,
                dutyObjectId,
            },
        }).then(
            (response: AxiosResponse): DutyObjectRouteDTO[] =>
                dataToArrayClass(DutyObjectRouteDTO, response.data)
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
