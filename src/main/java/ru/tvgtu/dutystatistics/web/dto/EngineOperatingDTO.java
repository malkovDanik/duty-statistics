package ru.tvgtu.dutystatistics.web.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class EngineOperatingDTO {
    //Идентификатор дежурного объекта
    private UUID dutyObjectId;
    //    Значение наплаванности
    private long operatingFullResource;

    public EngineOperatingDTO(UUID dutyObjectId, long operatingFullResource) {
        this.dutyObjectId = dutyObjectId;
        this.operatingFullResource = operatingFullResource;
    }
}
