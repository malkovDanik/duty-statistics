package ru.tvgtu.dutystatistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.tvgtu.dutystatistics.model.Route;
import ru.tvgtu.dutystatistics.web.dto.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface RouteRepository extends JpaRepository<Route, UUID> {

    @Query(" SELECT route " +
            " FROM Route route " +
            " JOIN Duty duty ON duty.id = route.duty.id " +
            " JOIN DutyObject dutyObject ON dutyObject.id = duty.dutyObject.id " +
            " WHERE dutyObject.id = :dutyObjectId " +
//           корабли которые дежурили в течение указанного периода
//           окончание дежурства в рамках периода
            " AND ((duty.endDate between :startDate AND :endDate)  " +
//            Само дежурство в рамках периода
            " OR (duty.beginDate > :startDate AND duty.endDate < :endDate) " +
//            начало дежурства в рамках периода
            " OR (duty.beginDate between :startDate AND :endDate)) ")
    List<Route> getRoutesByObjectIdAndPeriod(UUID dutyObjectId, LocalDateTime startDate, LocalDateTime endDate);

    @Query("SELECT new ru.tvgtu.dutystatistics.web.dto.SurfacingStatisticDTO(dutyObject.id, sum(route.length))" +
            "FROM Route route " +
            " JOIN Duty duty ON duty.id = route.duty.id " +
            " JOIN DutyObject dutyObject ON dutyObject.id = duty.dutyObject.id " +
            " JOIN Vehicle vehicle ON vehicle.id = dutyObject.vehicle.id " +
            " WHERE duty.endDate < :endDate " +
            "GROUP BY dutyObject.id ")
    List<SurfacingStatisticDTO> getSurfacingStatistic(LocalDateTime endDate);

    @Query("SELECT new ru.tvgtu.dutystatistics.web.dto.EngineOperatingDTO(dutyObject.id, sum(route.operatingFullResource)," +
            " vehicle.name)" +
            "FROM Route route " +
            " JOIN Duty duty ON duty.id = route.duty.id " +
            " JOIN DutyObject dutyObject ON dutyObject.id = duty.dutyObject.id " +
            " JOIN Vehicle vehicle ON vehicle.id = dutyObject.vehicle.id " +
            " WHERE duty.endDate < :endDate " +
            "GROUP BY dutyObject.id, vehicle.name ")
    List<EngineOperatingDTO> getEngineOperating(LocalDateTime endDate);


    @Query("SELECT new ru.tvgtu.dutystatistics.web.dto.EngineResourceRemainingDTO(dutyObject.id," +
            " vehicleTth.engineResource - sum(route.operatingFullResource), vehicleTth.engineResource, vehicle.name)" +
            "FROM Route route " +
            " JOIN Duty duty ON duty.id = route.duty.id " +
            " JOIN DutyObject dutyObject ON dutyObject.id = duty.dutyObject.id " +
            " JOIN Vehicle vehicle ON vehicle.id = dutyObject.vehicle.id " +
            " JOIN Project project ON project.id = vehicle.project.id " +
            " JOIN VehicleTth vehicleTth ON vehicleTth.project.id = project.id " +
            " WHERE duty.endDate < :endDate " +
            "GROUP BY dutyObject.id , vehicleTth.engineResource, vehicle.name ")
    List<EngineResourceRemainingDTO> getEngineResourceRemaining(LocalDateTime endDate);

    @Query("SELECT new ru.tvgtu.dutystatistics.web.dto.AnnualNormExceedingDTO(dutyObject.id," +
            " (sum(route.operatingFullResource) - vehicleTth.annualPassageRate), vehicleTth.annualPassageRate, vehicle.name)" +
            "FROM Route route " +
            " JOIN Duty duty ON duty.id = route.duty.id " +
            " JOIN DutyObject dutyObject ON dutyObject.id = duty.dutyObject.id " +
            " JOIN Vehicle vehicle ON vehicle.id = dutyObject.vehicle.id " +
            " JOIN Project project ON project.id = vehicle.project.id " +
            " JOIN VehicleTth vehicleTth ON vehicleTth.project.id = project.id " +
            " WHERE duty.endDate < :endDate " +
            "GROUP BY dutyObject.id , vehicleTth.annualPassageRate, vehicle.name ")
    List<AnnualNormExceedingDTO> getAnnualNormExceeding(LocalDateTime endDate);

    @Query("SELECT new ru.tvgtu.dutystatistics.web.dto.TotalNormExceedingDTO(dutyObject.id," +
            " (sum(route.operatingFullResource) - vehicleTth.engineResource),  vehicleTth.engineResource, vehicle.name)" +
            "FROM Route route " +
            " JOIN Duty duty ON duty.id = route.duty.id " +
            " JOIN DutyObject dutyObject ON dutyObject.id = duty.dutyObject.id " +
            " JOIN Vehicle vehicle ON vehicle.id = dutyObject.vehicle.id " +
            " JOIN Project project ON project.id = vehicle.project.id " +
            " JOIN VehicleTth vehicleTth ON vehicleTth.project.id = project.id " +
            " WHERE duty.endDate < :endDate " +
            "GROUP BY dutyObject.id , vehicleTth.engineResource, vehicle.name ")
    List<TotalNormExceedingDTO> getTotalNormExceeding(LocalDateTime endDate);
}
