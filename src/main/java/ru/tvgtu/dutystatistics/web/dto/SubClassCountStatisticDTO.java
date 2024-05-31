package ru.tvgtu.dutystatistics.web.dto;

import lombok.Data;

@Data
public class SubClassCountStatisticDTO {

    /**
     * Наименование подкласса
     */
    private String subclassName;

    /**
     * Процент таких подклассов
     */
    private int subclassPercent;

    /**
     * Реальное количество подклассов
     */
    private int subclassCount;

    /**
     * Общее количество подклассов
     */
    private int totalSubclassCount;

    public SubClassCountStatisticDTO(String subclassName, int subclassCount) {
        this.subclassName = subclassName;
        this.subclassCount = subclassCount;
    }
}
