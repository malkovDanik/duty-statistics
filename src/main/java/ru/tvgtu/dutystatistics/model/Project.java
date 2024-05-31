package ru.tvgtu.dutystatistics.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.UUID;

/**
 * Проект транспортного средства
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="project", schema = "duty_statistics")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id = UUID.randomUUID();

    /**
     * Наименование объекта
     */
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Project parent;

    /**
     * Код проекта
     */
    private String code;

    /**
     * Тип проекта - позиция в иерархии
     */
    @Enumerated(value = EnumType.STRING)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private ShipProjectTypeEnum projectType;

    /**
     * Установленный полный ресурс двигателя, ч
     */
    private Long engineResource;

    /**
     * Годовая норма, ч
     */
    private Long annualPassageRate;

}
