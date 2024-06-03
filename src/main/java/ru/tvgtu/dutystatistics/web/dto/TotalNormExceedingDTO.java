package ru.tvgtu.dutystatistics.web.dto;

import lombok.Data;

import java.util.UUID;

/**
 * Дто данных расчета превышения полной нормы
 */
@Data
public class TotalNormExceedingDTO {

    /**
     * Идентификатор дежурного объекта
     */
    private UUID dutyObjectId;

    /**
     * Наименование дежурного объекта
     */
    private String dutyObjectName;

    /**
     * Значение наплаванности
     */
    private long totalNormExceeding;

    /**
     * Полная норма двигателя
     */
    private long totalEngineResource;

    public TotalNormExceedingDTO(UUID dutyObjectId, long totalNormExceeding, long totalEngineResource, String dutyObjectName) {
        this.dutyObjectId = dutyObjectId;
        this.totalNormExceeding = totalNormExceeding;
        this.totalEngineResource = totalEngineResource;
        this.dutyObjectName = dutyObjectName;
    }
}
