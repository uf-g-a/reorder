package ru.ufimtsev.datasy.vacation.app.api.vacation;

import ru.ufimtsev.datasy.vacation.domain.Employee;
import ru.ufimtsev.datasy.vacation.domain.Vacation;

import java.util.List;
import java.util.Optional;

public interface VacationRepository {
    Vacation save(Vacation vacation);
    List<Vacation> findByEmployee(Employee employee);
    void delete(Vacation vacation);
    Optional<Vacation> findById(Long id);
}
