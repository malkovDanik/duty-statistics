package ru.tvgtu.dutystatistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tvgtu.dutystatistics.model.Duty;

import java.util.UUID;

public interface DutyRepository extends JpaRepository<Duty, UUID> {
}
