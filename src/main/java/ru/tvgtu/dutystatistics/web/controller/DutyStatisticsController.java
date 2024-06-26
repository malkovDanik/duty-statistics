package ru.tvgtu.dutystatistics.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.tvgtu.dutystatistics.service.DutyStatisticsService;
import ru.tvgtu.dutystatistics.web.dto.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Контроллер api аналитики по дежурствам
 */
@RestController
@RequestMapping(path = "dutyStatistics", produces = "application/json")
@RequiredArgsConstructor
@ResponseStatus(HttpStatus.OK)
public class DutyStatisticsController {

    private final DutyStatisticsService dutyStatisticsService;


    /**
     * Получить дежурные объекты
     *
     * @param startDate начало периода
     * @param endDate   конец периожа
     */
    @GetMapping("/getDutyObjects")
    public List<DutyObjectDTO> getDutyObjects(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return dutyStatisticsService.getDutyObjects(startDate, endDate);
    }


    /**
     * Получить маршруты за объект
     *
     * @param startDate начало периода
     * @param endDate   конец периожа
     */
    @GetMapping("/getDutyObjectsRoutes")
    public List<DutyObjectRouteDTO> getDutyObjectRoutes(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
            @RequestParam UUID dutyObjectId) {
        return dutyStatisticsService.getDutyObjectRoutes(dutyObjectId, startDate, endDate);
    }

    /**
     * 1) График с количеством подклассов
     *
     * @param startDate начало периода
     * @param endDate   конец периожа
     */
    @GetMapping("/subClassCount")
    public List<SubClassCountStatisticDTO> getSubClassCountStatistic(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return dutyStatisticsService.getSubClassCountStatistic(startDate, endDate);
    }

    /**
     * 2) Получить значение наплаванности
     *
     * @param endDate   конец периожа
     */
    @GetMapping("/surfacing")
    public List<SurfacingStatisticDTO> getSurfacingStatistic(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return dutyStatisticsService.getSurfacingStatistic(endDate);
    }

    /**
     * 3) График полной наработки двигателя
     *
     * @param endDate   конец периожа
     */
    @GetMapping("/engineOperating")
    public List<EngineOperatingDTO> getEngineOperating(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return dutyStatisticsService.getEngineOperating(endDate);
    }

    /**
     * 4) График остатка технического ресурса двигателя
     *
     * @param endDate   конец периожа
     */
    @GetMapping("/engineResourceRemaining")
    public List<EngineResourceRemainingDTO> getEngineResourceRemaining(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return dutyStatisticsService.getEngineResourceRemaining(endDate);
    }

    /**
     * 5) График превышения годовой нормы тех ресурса
     *
     * @param endDate   конец периожа
     */
    @GetMapping("/annualNormExceeding")
    public List<AnnualNormExceedingDTO> getAnnualNormExceeding(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return dutyStatisticsService.getAnnualNormExceeding(endDate);
    }

    /**
     * 6) График превышения полной нормы тех ресурса
     *
     * @param endDate   конец периожа
     */
    @GetMapping("/totalNormExceeding")
    public List<TotalNormExceedingDTO> getTotalNormExceeding(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return dutyStatisticsService.getTotalNormExceeding(endDate);
    }

}
