package ru.tvgtu.dutystatistics.web.dto;

import lombok.Data;

import java.util.UUID;

/**
 * Дто дежурного объекта
 */
@Data
public class DutyObjectDTO {
    private UUID id;
    /**
     * Наименование
     */
    private String name;
    /**
     * Полный ресурс двигателя
     */
    private Long engineResource;

    /**
     * Годовая норма
     */
    private Long annualPassageRate;

    public DutyObjectDTO(UUID id, String name, Long engineResource, Long annualPassageRate) {
        this.id = id;
        this.name = name;
        this.engineResource = engineResource;
        this.annualPassageRate = annualPassageRate;
    }
}
