package ru.ufimtsev.datasy.vacation.app.api.vacationtype;

import ru.ufimtsev.datasy.vacation.domain.VacationType;

import java.util.List;

public interface VacationTypeRepository {
    List<VacationType> findAll();
    VacationType findById(Long id);
}
