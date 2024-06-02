package ru.tvgtu.dutystatistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.tvgtu.dutystatistics.model.DutyObject;
import ru.tvgtu.dutystatistics.web.dto.DutyObjectDTO;

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
    List<DutyObject> getDutyObjectsByPeriod(LocalDateTime startDate,
                                            LocalDateTime endDate);

    /**
     * Получить заполненные дежурные объекты
     * @param dutyObjectIds идентификаторы дежурных объектов
     * @return
     */
    @Query(" SELECT new ru.tvgtu.dutystatistics.web.dto.DutyObjectDTO(dutyObject.id, vehicle.name, " +
            " vehicleTth.engineResource, vehicleTth.annualPassageRate) " +
            " FROM DutyObject dutyObject " +
            " JOIN Vehicle vehicle ON vehicle.id = dutyObject.vehicle.id " +
            " JOIN Project project ON project.id = vehicle.project.id " +
            " JOIN VehicleTth vehicleTth ON vehicleTth.project.id = project.id " +
            " WHERE dutyObject.id IN :dutyObjectIds " +
            " ORDER BY vehicle.name ")
    List<DutyObjectDTO> getDutyObjectsData(List<UUID> dutyObjectIds);

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
