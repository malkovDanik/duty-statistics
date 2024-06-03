import { AxiosResponse } from 'axios';
import { AbstractApi } from '@/api/AbstractApi';
import { dataToArrayClass } from '@/api/ClassFactory';
import { DutyObjectDTO } from '@/models/DutyObjectDTO';
import RequestUrl from '@/api/requestUrl';
import { SubClassCountStatisticDTO } from '@/models/SubClassCountStatisticDTO';
import { DutyObjectRouteDTO } from '@/models/DutyObjectRouteDTO';
import { EngineOperatingDTO } from '@/models/EngineOperatingDTO';
import { EngineResourceRemainingDTO } from '@/models/EngineResourceRemainingDTO';
import { AnnualNormExceedingDTO } from '@/models/AnnualNormExceedingDTO';
import {TotalNormExceedingDTO} from "@/models/TotalNormExceedingDTO";

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

    /**
     * 2) График полной наработки двигателя
     *
     * @param endDate   конец периожа
     */
    public getEngineOperating(endDate: Date): Promise<EngineOperatingDTO[]> {
        return this.get('/engineOperating', {
            params: {
                endDate,
            },
        }).then(
            (response: AxiosResponse): EngineOperatingDTO[] =>
                dataToArrayClass(EngineOperatingDTO, response.data)
        );
    }

    /**
     * 3) График остатка технического ресурса двигателя
     *
     * @param endDate   конец периожа
     */
    public getEngineResourceRemaining(
        endDate: Date
    ): Promise<EngineResourceRemainingDTO[]> {
        return this.get('/engineResourceRemaining', {
            params: {
                endDate,
            },
        }).then(
            (response: AxiosResponse): EngineResourceRemainingDTO[] =>
                dataToArrayClass(EngineResourceRemainingDTO, response.data)
        );
    }

    /**
     * 4) График превышения годовой нормы тех ресурса
     *
     * @param endDate   конец периожа
     */
    public getAnnualNormExceeding(
        endDate: Date
    ): Promise<AnnualNormExceedingDTO[]> {
        return this.get('/annualNormExceeding', {
            params: {
                endDate,
            },
        }).then(
            (response: AxiosResponse): AnnualNormExceedingDTO[] =>
                dataToArrayClass(AnnualNormExceedingDTO, response.data)
        );
    }

    /**
     * 5) График превышения полной нормы тех ресурса
     *
     * @param endDate   конец периожа
     */
    public getTotalNormExceeding(
        endDate: Date
    ): Promise<TotalNormExceedingDTO[]> {
        return this.get('/totalNormExceeding', {
            params: {
                endDate,
            },
        }).then(
            (response: AxiosResponse): TotalNormExceedingDTO[] =>
                dataToArrayClass(TotalNormExceedingDTO, response.data)
        );
    }
}

export default new DutyStatisticsApi();
