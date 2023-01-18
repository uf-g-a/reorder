package ru.ufimtsev.datasy.paysheet.adapter.persistence.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.ufimtsev.datasy.paysheet.app.api.EmployeeRepository;
import ru.ufimtsev.datasy.paysheet.domain.Employee;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final EmployeeJpaRepository employeeJpaRepository;

    @Override
    public List<Employee> findAll() {
        return employeeJpaRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeJpaRepository.findById(id).orElseThrow();
    }
}
