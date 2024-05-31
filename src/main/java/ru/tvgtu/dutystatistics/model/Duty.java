package ru.tvgtu.dutystatistics.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;


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
    private UUID id = UUID.randomUUID();

    /**
     * Дата и время начала дежурства
     */
    private LocalDateTime beginDate;

    /**
     * Дата и вермя окончания дежурства
     */
    private LocalDateTime endDate;

}
