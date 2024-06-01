package ru.tvgtu.dutystatistics.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Дежурство
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="duty", schema = "duty_statistics")
public class Duty {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * Дата и время начала дежурства
     */
    private LocalDateTime beginDate;

    /**
     * Дата и вермя окончания дежурства
     */
    private LocalDateTime endDate;

}
