package ru.tvgtu.dutystatistics.web.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class TotalNormExceedingDTO {
    //Идентификатор дежурного объекта
    private UUID dutyObjectId;
    //    Значение наплаванности
    private long totalNormExceeding;

    public TotalNormExceedingDTO(UUID dutyObjectId, long totalNormExceeding) {
        this.dutyObjectId = dutyObjectId;
        this.totalNormExceeding = totalNormExceeding;
    }
}
