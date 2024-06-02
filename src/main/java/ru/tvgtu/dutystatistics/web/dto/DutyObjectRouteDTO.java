package ru.tvgtu.dutystatistics.web.dto;

import lombok.Data;
import ru.tvgtu.dutystatistics.model.Route;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class DutyObjectRouteDTO {

    private UUID id;

    /**
     * Длина маршрута
     */
    private Long length;

    /**
     * Наработка полного технического ресурса двигателя, ч
     */
    private Long operatingFullResource;

    /**
     * Дата начала маршрута
     */
    private LocalDateTime startDate;

    /**
     * Дата окончания маршрута
     */
    private LocalDateTime endDate;

    public DutyObjectRouteDTO(Route route) {
        this.id = route.getId();
        this.length = route.getLength();
        this.operatingFullResource = route.getOperatingFullResource();
        this.startDate = route.getStartDate();
        this.endDate = route.getEndDate();
    }
}
