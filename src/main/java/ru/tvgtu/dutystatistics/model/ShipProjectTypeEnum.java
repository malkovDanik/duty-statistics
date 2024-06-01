package ru.tvgtu.dutystatistics.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

/**
 * Типы проектов судов отображающие позицию в иерархии
 *
 * @author Aleksey Konkin
 * @since 09.09.2022
 */
public enum ShipProjectTypeEnum {

//    типичиная иерархия проектов представляет собой:
//    |__Группа
//      |__Класс
//          |__Подкласс
//              |__Подподкласс (опционально)
//              |__|__Проект* (от под-подкласса) - принадлежит транспортным средствам
//              |__Проект (от подкласса) - принадлежит транспортным средствам

    GROUP("Группа"),
    CLASS("Класс"),
    SUB_CLASS("Подкласс"),
//    Опциональная ступень иерархии проектов
    SUB_SUB_CLASS("Подподкласс"),
    PROJECT("Проект");

    @Getter
    private final String name;

    ShipProjectTypeEnum(String name) {
        this.name = name;
    }
}
