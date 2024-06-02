package ru.tvgtu.dutystatistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.tvgtu.dutystatistics.model.DutyObject;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface DutyStatisticsRepository extends JpaRepository<DutyObject, UUID> {

    /**
     * Получить корабли дежурившие в рамках периода
     * @param startDate
     * @param endDate
     * @return
     */
    @Query(" SELECT dutyObject  " +
            " FROM DutyObject dutyObject " +
            " JOIN Vehicle vehicle ON vehicle.id = dutyObject.vehicle.id " +
            " JOIN Duty duty ON duty.dutyObject.vehicle.id = vehicle.id " +
            " WHERE vehicle.startServiceDate < :endDate " +
//            корабли которые дежурили в течение указанного периода
//            окончание дежурства в рамках периода
            "AND ((duty.endDate between :startDate AND :endDate)  " +
//            Само дежурство в рамках периода
            "OR (duty.beginDate > :startDate AND duty.endDate < :endDate)" +
//            начало дежурства в рамках периода
            "OR (duty.beginDate between :startDate AND :endDate))" )
    List<DutyObject> getDutyObjectsByPeriod(@Param("startDate") LocalDateTime startDate,
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
