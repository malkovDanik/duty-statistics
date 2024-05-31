package ru.tvgtu.dutystatistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.tvgtu.dutystatistics.model.DutyObject;
import ru.tvgtu.dutystatistics.web.dto.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface DutyStatisticsRepository extends JpaRepository<DutyObject, UUID> {

    @Query("SELECT SubClassCountStatisticDTO(subclass.name, count(subclass)) " +
            "FROM DutyObject dutyObject " +
            "JOIN Vehicle vehicle ON vehicle.id = dutyObject.vehicle.id " +
            "JOIN Project subclass ON subclass.id = vehicle.project.parent.id " +
            "WHERE vehicle.startServiceDate between :startDate AND :endDate ")
    List<SubClassCountStatisticDTO> getSubClassCountStatistic(@Param("startDate") LocalDateTime startDate,
                                                              @Param("endDate") LocalDateTime endDate);

//    @Query("")
//    List<SubClassCountStatisticDTO> getSubClassCountStatistic(@Param("startDate") LocalDateTime startDate,
//                                                              @Param("endDate") LocalDateTime endDate);
//
//    @Query("")
//    List<SurfacingStatisticDTO> getSurfacingStatistic(@Param("startDate") LocalDateTime startDate,
//                                                      @Param("endDate") LocalDateTime endDate);
//    @Query("")
//    List<EngineOperatingDTO> getEngineOperating(@Param("startDate") LocalDateTime startDate,
//                                                @Param("endDate") LocalDateTime endDate);
//    @Query("")
//    List<EngineResourceRemainingDTO> getEngineResourceRemaining(@Param("startDate") LocalDateTime startDate,
//                                                                @Param("endDate") LocalDateTime endDate);
//    @Query("")
//    List<AnnualNormExceedingDTO> getAnnualNormExceeding(@Param("startDate") LocalDateTime startDate,
//                                                        @Param("endDate") LocalDateTime endDate);
//    @Query("")
//    List<TotalNormExceedingDTO> getTotalNormExceeding(@Param("startDate") LocalDateTime startDate,
//                                                      @Param("endDate") LocalDateTime endDate);
}
