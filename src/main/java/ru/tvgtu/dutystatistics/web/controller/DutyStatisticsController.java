package ru.tvgtu.dutystatistics.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.tvgtu.dutystatistics.service.DutyStatisticsService;
import ru.tvgtu.dutystatistics.web.dto.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Danik
 */
@RestController
@RequestMapping(path = "dutyStatistics", produces = "application/json")
@RequiredArgsConstructor
@ResponseStatus(HttpStatus.OK)
public class DutyStatisticsController {

    private final DutyStatisticsService dutyStatisticsService;

    /**
     * 1) График с количеством подклассов
     *
     * @param startDate начало периода
     * @param endDate   конец периожа
     */
    @GetMapping("/subClassCount")
//    todo - в каком виде присылают дату? можно конечно формат и свой задать, но вроде в кса и так работает DateTimeFormat(pattern = "dd.MM.yyyy")
    public List<SubClassCountStatisticDTO> getSubClassCountStatistic(
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime startDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime endDate) {
        return dutyStatisticsService.getSubClassCountStatistic(startDate, endDate);
    }

    /**
     * 2) График наплаванности
     *
     * @param startDate начало периода
     * @param endDate   конец периожа
     */
    @GetMapping("/surfacing")
    public List<SurfacingStatisticDTO> getSurfacingStatistic(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return dutyStatisticsService.getSurfacingStatistic(startDate, endDate);
    }

    /**
     * 3) График полной наработки двигателя
     *
     * @param startDate начало периода
     * @param endDate   конец периожа
     */
    @GetMapping("/engineOperating")
    public List<EngineOperatingDTO> getEngineOperating(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return dutyStatisticsService.getEngineOperating(startDate, endDate);
    }

    /**
     * 4) График остатка технического ресурса двигателя
     *
     * @param startDate начало периода
     * @param endDate   конец периожа
     */
    @GetMapping("/engineResourceRemaining")
    public List<EngineResourceRemainingDTO> getEngineResourceRemaining(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return dutyStatisticsService.getEngineResourceRemaining(startDate, endDate);
    }

    /**
     * 5) График превышения годовой нормы тех ресурса
     *
     * @param startDate начало периода
     * @param endDate   конец периожа
     */
    @GetMapping("/annualNormExceeding")
    public List<AnnualNormExceedingDTO> getAnnualNormExceeding(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return dutyStatisticsService.getAnnualNormExceeding(startDate, endDate);
    }

    /**
     * 6) График превышения полной нормы тех ресурса
     *
     * @param startDate начало периода
     * @param endDate   конец периожа
     */
    @GetMapping("/totalNormExceeding")
    public List<TotalNormExceedingDTO> getTotalNormExceeding(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return dutyStatisticsService.getTotalNormExceeding(startDate, endDate);
    }

}
