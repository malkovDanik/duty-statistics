package ru.tvgtu.dutystatistics.web.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AnnualNormExceedingDTO {
    //Идентификатор дежурного объекта
    private UUID dutyObjectId;

    /**
     * Значение наплаванности
     */
    private long annualNormExceeding;

    /**
     *
     */
    private long annualPassageRate;

    public AnnualNormExceedingDTO(UUID dutyObjectId, long annualNormExceeding, long annualPassageRate) {
        this.dutyObjectId = dutyObjectId;
        this.annualNormExceeding = annualNormExceeding;
        this.annualPassageRate = annualPassageRate;
    }
}
