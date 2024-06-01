package ru.tvgtu.dutystatistics.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tvgtu.dutystatistics.repository.DutyStatisticsRepository;
import ru.tvgtu.dutystatistics.repository.ProjectRepository;
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

    /**
     * Получить данные графика количественной оценки подклассов
     *
     * @param startDate начало периода выборки
     * @param endDate окончание периода выборки
     * @return количественная оценка подклассов за дежурные объекты
     */
    @Override
    public List<SubClassCountStatisticDTO> getSubClassCountStatistic(LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate == null && endDate == null) {
            startDate = LocalDateTime.now().minusYears(1);
            endDate = LocalDateTime.now();
        }
//        Получить статистику подклассов и их количества за дежурные объекты
        List<SubClassCountStatisticDTO> subclass_statistic = dutyStatisticsRepository.getSubClassCountStatistic(startDate, endDate);
//        Получить общее количество подклассов за дежурные объекты
        Integer totalSubclassCount = projectRepository.getDutyObjectSubclassCount(startDate, endDate);

        return subclass_statistic.stream().peek(statistic -> {
            statistic.setTotalSubclassCount(totalSubclassCount);
            statistic.setSubclassPercent(statistic.getSubclassCount() / totalSubclassCount);
        }).toList();
    }

    @Override
    public List<SurfacingStatisticDTO> getSurfacingStatistic(LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate == null && endDate == null) {
            startDate = LocalDateTime.now().minusYears(1);
            endDate = LocalDateTime.now();
        }

        return null;
    }

    @Override
    public List<EngineOperatingDTO> getEngineOperating(LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate == null && endDate == null) {
            startDate = LocalDateTime.now().minusYears(1);
            endDate = LocalDateTime.now();
        }

        return null;
    }

    @Override
    public List<EngineResourceRemainingDTO> getEngineResourceRemaining(LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate == null && endDate == null) {
            startDate = LocalDateTime.now().minusYears(1);
            endDate = LocalDateTime.now();
        }

        return null;
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

    @Override
    public List<SurfacingStatisticDTO> getDutyObjects(LocalDateTime startDate, LocalDateTime endDate) {
        return null;
    }

    @Override
    public List<SurfacingStatisticDTO> getDutyObjectRoutes(LocalDateTime startDate, LocalDateTime endDate, UUID dutyObjectId) {
        return null;
    }
}
