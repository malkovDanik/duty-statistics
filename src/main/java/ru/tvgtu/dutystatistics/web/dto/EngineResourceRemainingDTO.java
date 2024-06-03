package ru.tvgtu.dutystatistics.web.dto;

import lombok.Data;

import java.util.UUID;

/**
 * Дто данных расчета остатка технического ресурса двигателя
 */
@Data
public class EngineResourceRemainingDTO {

    /**
     * Идентификатор дежурного объекта
     */
    private UUID dutyObjectId;

    /**
     * Наименование дежурного объекта
     */
    private String dutyObjectName;

    /**
     * Значение остатка
     */
    private long engineResourceRemaining;
    /**
     * Полный ресурс двигателя
     */
    private long totalEngineResource;

    public EngineResourceRemainingDTO(UUID dutyObjectId, long engineResourceRemaining, long totalEngineResource, String dutyObjectName) {
        this.dutyObjectId = dutyObjectId;
        this.engineResourceRemaining = engineResourceRemaining;
        this.totalEngineResource = totalEngineResource;
        this.dutyObjectName = dutyObjectName;
    }
}
