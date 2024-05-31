package ru.tvgtu.dutystatistics.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

/**
 * Типы проектов судов отображающие позицию проекта в иерархии
 *
 * @author Aleksey Konkin
 * @since 09.09.2022
 */
public enum ShipProjectTypeEnum {

    GROUP("Группа"),
    CLASS("Класс"),
    SUB_CLASS("Подкласс"),
    SUB_SUB_CLASS("Подподкласс"),
    PROJECT("Проект");

    @Getter
    private final String name;

    ShipProjectTypeEnum(String name) {
        this.name = name;
    }
}
