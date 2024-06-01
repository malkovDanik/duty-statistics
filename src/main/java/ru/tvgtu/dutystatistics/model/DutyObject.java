package ru.tvgtu.dutystatistics.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.NonNull;

import java.util.UUID;

/**
 * Дежурный объект
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="duty_object", schema = "duty_statistics")
public class DutyObject {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NonNull
    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
}
