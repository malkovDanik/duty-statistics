package ru.tvgtu.dutystatistics.web.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class EngineResourceRemainingDTO {

    /**
     * Идентификатор дежурного объекта
     */
    private UUID dutyObjectId;
    /**
     * Значение остатка
     */
    private long engineResourceRemaining;
    /**
     * Полный ресурс двигателя
     */
    private long totalEngineResource;

    public EngineResourceRemainingDTO(UUID dutyObjectId, long engineResourceRemaining, long totalEngineResource) {
        this.dutyObjectId = dutyObjectId;
        this.engineResourceRemaining = engineResourceRemaining;
        this.totalEngineResource = totalEngineResource;
    }
}
