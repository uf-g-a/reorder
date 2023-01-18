package ru.ufimtsev.datasy.vacation.adapter.persistence.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.ufimtsev.datasy.vacation.app.api.employee.EmployeeRepository;
import ru.ufimtsev.datasy.vacation.domain.Employee;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final EmployeeJpaRepository employeeJpaRepository;

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) employeeJpaRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeJpaRepository.findById(id).orElseThrow();
    }
}
