package ru.tvgtu.dutystatistics.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * Тактико-технические характеристики (ТТХ) транспортных средств
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="vehicle_tth", schema = "duty_statistics")
public class VehicleTth {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * Установленный полный ресурс двигателя, ч
     */
    @Column(name = "engine_resource")
    private Long engineResource;

    /**
     * Годовая норма, ч
     */
    @Column(name = "annual_passage_rate")
    private Long annualPassageRate;


    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
