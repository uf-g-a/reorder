package ru.ufimtsev.datasy.paysheet.adapter.persistence.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.ufimtsev.datasy.paysheet.domain.Employee;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Long> {
}
