package ru.tvgtu.dutystatistics.web.dto;

import lombok.Data;

import java.util.UUID;

/**
 * Дто данных расчета превышения годовой нормы
 */
@Data
public class AnnualNormExceedingDTO {

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
    private long annualNormExceeding;

    /**
     *
     */
    private long annualPassageRate;

    public AnnualNormExceedingDTO(UUID dutyObjectId, long annualNormExceeding, long annualPassageRate, String dutyObjectName) {
        this.dutyObjectId = dutyObjectId;
        this.annualNormExceeding = annualNormExceeding;
        this.annualPassageRate = annualPassageRate;
        this.dutyObjectName = dutyObjectName;
    }
}
