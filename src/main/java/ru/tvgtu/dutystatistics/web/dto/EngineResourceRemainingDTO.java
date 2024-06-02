package ru.tvgtu.dutystatistics.web.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class EngineResourceRemainingDTO {
    //Идентификатор дежурного объекта
    private UUID dutyObjectId;
    //    Значение наплаванности
    private long EngineResourceRemaining;

    public EngineResourceRemainingDTO(UUID dutyObjectId, long EngineResourceRemaining) {
        this.dutyObjectId = dutyObjectId;
        this.EngineResourceRemaining = EngineResourceRemaining;
    }
}
