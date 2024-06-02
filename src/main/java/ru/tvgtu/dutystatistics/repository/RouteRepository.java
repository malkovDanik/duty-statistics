package ru.tvgtu.dutystatistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.tvgtu.dutystatistics.model.Route;

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
}