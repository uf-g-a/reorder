package ru.ufimtsev.datasy.vacation.adapter.persistence.employee;

import org.springframework.data.repository.CrudRepository;
import ru.ufimtsev.datasy.vacation.domain.Employee;

public interface EmployeeJpaRepository extends CrudRepository<Employee, Long> {
}
