package ru.tvgtu.dutystatistics.web.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class EngineResourceRemainingDTO {
    //Идентификатор дежурного объекта
    private UUID dutyObjectId;
    //    Значение наплаванности
    private long engineResourceRemaining;

    public EngineResourceRemainingDTO(UUID dutyObjectId, long engineResourceRemaining) {
        this.dutyObjectId = dutyObjectId;
        this.engineResourceRemaining = engineResourceRemaining;
    }
}
