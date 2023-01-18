package ru.ufimtsev.datasy.sickleave.adapter.persistence.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ufimtsev.datasy.sickleave.domain.Employee;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Long> {
}
