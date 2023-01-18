package ru.ufimtsev.datasy.sickleave.adapter.persistence.sickleave;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ufimtsev.datasy.sickleave.domain.Employee;
import ru.ufimtsev.datasy.sickleave.domain.SickLeave;

import java.util.List;

public interface SickLeaveJpaRepository extends JpaRepository<SickLeave, Long> {
    List<SickLeave> findByEmployee(Employee employee);
}
