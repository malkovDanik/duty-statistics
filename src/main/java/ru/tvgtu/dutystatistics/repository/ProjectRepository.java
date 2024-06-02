package ru.tvgtu.dutystatistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.tvgtu.dutystatistics.model.Project;
import ru.tvgtu.dutystatistics.web.dto.SubClassCountStatisticDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, UUID> {

    /**
     * Получить общее количество подклассов за дежурные объекты
     * @param endDate окончание периода выборки
     * @return
     */
    @Query("SELECT COUNT(subclass)" +
            "FROM DutyObject dutyObject " +
            " JOIN Vehicle vehicle ON vehicle.id = dutyObject.vehicle.id " +
            " JOIN Project subclass ON subclass.id = vehicle.project.parent.id " +
            " WHERE vehicle.startServiceDate < :endDate ")
    Integer getDutyObjectSubclassCount(@Param("endDate") LocalDateTime endDate);


    /**
     * Получить статистику подклассов по кораблям
     * @param vehicleIds список кораблей
     * @return
     */
    @Query(" SELECT new ru.tvgtu.dutystatistics.web.dto.SubClassCountStatisticDTO(subclass.name, COUNT(subclass)) " +
            " FROM Project subclass " +
            " JOIN Vehicle vehicle ON vehicle.project.parent.id = subclass.id " +
            " WHERE vehicle.id in :vehicleIds" +
            " AND subclass.projectType = 'SUB_CLASS' " +
            " GROUP BY subclass.name ")
    List<SubClassCountStatisticDTO> getSubClassCountStatistic(@Param("vehicleIds") List<UUID> vehicleIds);

}
