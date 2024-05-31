package ru.tvgtu.dutystatistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.tvgtu.dutystatistics.model.Project;

import java.time.LocalDateTime;
import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, UUID> {

    /**
     * Получить общее количество подклассов за дежурные объекты
     * @param startDate
     * @param endDate
     * @return
     */
    @Query("SELECT COUNT(subclass)" +
            "FROM Project subclass " +
            "JOIN DutyObject dutyObject ON dutyObject.vehicle.project.parent.id = subclass.id " +
            "WHERE subclass.projectType = 'SUB_CLASS'")
    Integer getDutyObjectSubclassCount(@Param("startDate") LocalDateTime startDate,
                                       @Param("endDate") LocalDateTime endDate);

}
