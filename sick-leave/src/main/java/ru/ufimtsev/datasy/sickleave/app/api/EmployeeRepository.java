package ru.ufimtsev.datasy.sickleave.app.api;

import ru.ufimtsev.datasy.sickleave.domain.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee findById(Long id);
    List<Employee> findAll();
}
