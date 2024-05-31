package ru.tvgtu.dutystatistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tvgtu.dutystatistics.model.Vehicle;

import java.util.UUID;

public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {
}
