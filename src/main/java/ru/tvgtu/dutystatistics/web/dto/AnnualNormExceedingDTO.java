package ru.tvgtu.dutystatistics.web.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AnnualNormExceedingDTO {
    //Идентификатор дежурного объекта
    private UUID dutyObjectId;
    //    Значение наплаванности
    private long annualNormExceeding;

    public AnnualNormExceedingDTO(UUID dutyObjectId, long annualNormExceeding) {
        this.dutyObjectId = dutyObjectId;
        this.annualNormExceeding = annualNormExceeding;
    }
}
