package ru.tvgtu.dutystatistics.web.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class SurfacingStatisticDTO {
//Идентификатор дежурного объекта
    private UUID dutyObjectId;
//    Значение наплаванности
    private long surfacing;

    public SurfacingStatisticDTO(UUID dutyObjectId, long surfacing) {
        this.dutyObjectId = dutyObjectId;
        this.surfacing = surfacing;
    }
}
