package ru.tvgtu.dutystatistics.web.dto;

import lombok.Data;

import java.util.UUID;

/**
 * Дто данных расчета полной наработки двигателя
 */
@Data
public class EngineOperatingDTO {

    /**
     * Идентификатор дежурного объекта
     */
    private UUID dutyObjectId;

    /**
     * Наименование дежурного объекта
     */
    private String dutyObjectName;

    /**
     *  Значение наплаванности
     */
    private long operatingFullResource;

    public EngineOperatingDTO(UUID dutyObjectId, long operatingFullResource, String dutyObjectName) {
        this.dutyObjectId = dutyObjectId;
        this.operatingFullResource = operatingFullResource;
        this.dutyObjectName = dutyObjectName;
    }
}
