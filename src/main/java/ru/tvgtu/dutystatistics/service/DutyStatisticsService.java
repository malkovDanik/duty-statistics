package ru.tvgtu.dutystatistics.service;

import ru.tvgtu.dutystatistics.web.dto.*;

import java.time.LocalDateTime;
import java.util.List;

public interface DutyStatisticsService {
    List<SubClassCountStatisticDTO> getSubClassCountStatistic(LocalDateTime startDate, LocalDateTime endDate);

    List<SurfacingStatisticDTO> getSurfacingStatistic(LocalDateTime startDate, LocalDateTime endDate);

    List<EngineOperatingDTO> getEngineOperating(LocalDateTime startDate, LocalDateTime endDate);

    List<EngineResourceRemainingDTO> getEngineResourceRemaining(LocalDateTime startDate, LocalDateTime endDate);

    List<AnnualNormExceedingDTO> getAnnualNormExceeding(LocalDateTime startDate, LocalDateTime endDate);

    List<TotalNormExceedingDTO> getTotalNormExceeding(LocalDateTime startDate, LocalDateTime endDate);
}
