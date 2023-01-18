package ru.ufimtsev.datasy.vacation.app.api.employee;

import ru.ufimtsev.datasy.vacation.domain.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    List<Employee> findAll();
    Employee findById(Long id);
}
