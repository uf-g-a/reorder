package ru.ufimtsev.datasy.paysheet.app.api;

import ru.ufimtsev.datasy.paysheet.domain.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();
    Employee findById(Long id);
}
