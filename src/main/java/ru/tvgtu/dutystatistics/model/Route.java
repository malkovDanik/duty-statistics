package ru.tvgtu.dutystatistics.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Маршрут
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="route", schema = "duty_statistics")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    /**
     * Длина маршрута
     */
    private Long length;


    /**
     * Наработка полного технического ресурса двигателя, ч
     */
    @Column(name = "operating_full_resource")
    private Long operatingFullResource;


    @ManyToOne
    @JoinColumn(name = "duty_id")
    private Duty duty;

    /**
     * Дата начала маршрута
     */
    @Column(name = "start_date")
    private LocalDateTime startDate;

    /**
     * Дата окончания маршрута
     */
    @Column(name = "end_date")
    private LocalDateTime endDate;

}
