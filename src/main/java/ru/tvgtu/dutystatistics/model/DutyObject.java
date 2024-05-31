package ru.tvgtu.dutystatistics.model;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.Type;


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
    private UUID id = UUID.randomUUID();

    @NotNull
    @OneToOne
    @JoinColumn(name = "duty_id")
    private Duty duty;

    @NotNull
    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
}
