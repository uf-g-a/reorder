package ru.ufimtsev.datasy.vacation.adapter.persistence.vacation;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ufimtsev.datasy.vacation.domain.Employee;
import ru.ufimtsev.datasy.vacation.domain.Vacation;

import java.util.List;

public interface VacationJpaRepository extends JpaRepository<Vacation, Long> {
    List<Vacation> findByEmployee(Employee employee);
}
