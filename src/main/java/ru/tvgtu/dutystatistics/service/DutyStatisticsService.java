package ru.tvgtu.dutystatistics.service;

import ru.tvgtu.dutystatistics.web.dto.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface DutyStatisticsService {
    List<SubClassCountStatisticDTO> getSubClassCountStatistic(LocalDateTime startDate, LocalDateTime endDate);

    List<SurfacingStatisticDTO> getSurfacingStatistic(LocalDateTime endDate);

    List<EngineOperatingDTO> getEngineOperating(LocalDateTime endDate);

    List<EngineResourceRemainingDTO> getEngineResourceRemaining(LocalDateTime endDate);

    List<AnnualNormExceedingDTO> getAnnualNormExceeding(LocalDateTime endDate);

    List<TotalNormExceedingDTO> getTotalNormExceeding(LocalDateTime endDate);

    List<DutyObjectDTO> getDutyObjects(LocalDateTime startDate, LocalDateTime endDate);

    List<DutyObjectRouteDTO> getDutyObjectRoutes(UUID dutyObjectId, LocalDateTime startDate, LocalDateTime endDate);

}
