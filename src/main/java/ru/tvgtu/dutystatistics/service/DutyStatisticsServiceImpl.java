package ru.tvgtu.dutystatistics.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tvgtu.dutystatistics.model.DutyObject;
import ru.tvgtu.dutystatistics.repository.DutyStatisticsRepository;
import ru.tvgtu.dutystatistics.repository.ProjectRepository;
import ru.tvgtu.dutystatistics.repository.RouteRepository;
import ru.tvgtu.dutystatistics.web.dto.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Сервис по работе с аналитикой по дежурствам
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DutyStatisticsServiceImpl implements DutyStatisticsService {

    private final DutyStatisticsRepository dutyStatisticsRepository;
    private final ProjectRepository projectRepository;
    private final RouteRepository routeRepository;

    /**
     * Получить данные графика количественной оценки подклассов
     *
     * @param startDate начало периода выборки
     * @param endDate   окончание периода выборки
     * @return количественная оценка подклассов за дежурные объекты
     */
    @Override
    public List<SubClassCountStatisticDTO> getSubClassCountStatistic(LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate == null && endDate == null) {
            startDate = LocalDateTime.now().minusYears(1);
            endDate = LocalDateTime.now();
        }

//        Получить корабли дежурившие в рамках периода
        List<DutyObject> dutyObjects = dutyStatisticsRepository.getDutyObjectsByPeriod(startDate, endDate);
        List<UUID> vehicleIds = dutyObjects.stream().map(dutyObject -> dutyObject.getVehicle().getId()).toList();
//        Получить статистику подклассов по кораблям
        List<SubClassCountStatisticDTO> subClassCountStatistic = projectRepository.getSubClassCountStatistic(vehicleIds);
//        Получить общее количество подклассов за дежурные объекты
        Integer totalSubclassCount = projectRepository.getDutyObjectSubclassCount(endDate);

        return subClassCountStatistic.stream().peek(statistic -> {
            statistic.setTotalSubclassCount(totalSubclassCount);
            statistic.setSubclassPercent((int) (statistic.getSubclassCount() * 100 / totalSubclassCount));
        }).toList();
    }

    @Override
    public List<SurfacingStatisticDTO> getSurfacingStatistic(LocalDateTime endDate) {
        if (endDate == null) {
            endDate = LocalDateTime.now();
        }

        return routeRepository.getSurfacingStatistic(endDate);
    }

    @Override
    public List<EngineOperatingDTO> getEngineOperating(LocalDateTime endDate) {
        if (endDate == null) {
            endDate = LocalDateTime.now();
        }

        return routeRepository.getEngineOperating(endDate);
    }

    @Override
    public List<EngineResourceRemainingDTO> getEngineResourceRemaining(LocalDateTime endDate) {
        if (endDate == null) {
            endDate = LocalDateTime.now();
        }

        return routeRepository.getEngineResourceRemaining(endDate);
    }

    @Override
    public List<AnnualNormExceedingDTO> getAnnualNormExceeding(LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate == null && endDate == null) {
            startDate = LocalDateTime.now().minusYears(1);
            endDate = LocalDateTime.now();
        }

        return null;
    }

    @Override
    public List<TotalNormExceedingDTO> getTotalNormExceeding(LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate == null && endDate == null) {
            startDate = LocalDateTime.now().minusYears(1);
            endDate = LocalDateTime.now();
        }

        return null;
    }

    /**
     * Получить объекты дежурившие в рамках периода
     *
     * @param startDate дата начала периода выборки
     * @param endDate   дата окончания периода выборки
     */
    @Override
    public List<DutyObjectDTO> getDutyObjects(LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate == null && endDate == null) {
            startDate = LocalDateTime.now().minusYears(1);
            endDate = LocalDateTime.now();
        }
//        Получить объекты дежурившие в рамках периода
        List<DutyObject> dutyObjects = dutyStatisticsRepository.getDutyObjectsByPeriod(startDate, endDate);
        List<UUID> dutyObjectIds = dutyObjects.stream().map(DutyObject::getId).toList();
        return dutyStatisticsRepository.getDutyObjectsData(dutyObjectIds);
    }

    /**
     * ПОлучить маршруты дежурного объекта
     *
     * @param dutyObjectId идентификатор дежурного объекта
     * @param startDate    начало периода выборки
     * @param endDate      окончание периода выборки
     * @return
     */
    @Override
    public List<DutyObjectRouteDTO> getDutyObjectRoutes(UUID dutyObjectId, LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate == null && endDate == null) {
            startDate = LocalDateTime.now().minusYears(1);
            endDate = LocalDateTime.now();
        }

        var routes = routeRepository.getRoutesByObjectIdAndPeriod(dutyObjectId, startDate, endDate);
        return routes.stream().map(DutyObjectRouteDTO::new).toList();
    }
}
