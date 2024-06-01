package ru.tvgtu.dutystatistics.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
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
    @Column(name = "begin_date")
    private LocalDateTime beginDate;

    /**
     * Дата и вермя окончания дежурства
     */
    @Column(name = "end_date")
    private LocalDateTime endDate;

    @NonNull
    @ManyToOne
    @JoinColumn(name="duty_object_id")
    private DutyObject dutyObject;

}
