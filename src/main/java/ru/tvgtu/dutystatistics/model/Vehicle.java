package ru.tvgtu.dutystatistics.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Средство передвижения
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="vehicle", schema = "duty_statistics")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id = UUID.randomUUID();

    /**
     * Наименование объекта
     */
    protected String name;

    /**
     * Проект объекта
     */
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    /**
     * Дата начала эксплуатации
     */
    @Column(name = "start_service_date")
    private LocalDateTime startServiceDate;

}
