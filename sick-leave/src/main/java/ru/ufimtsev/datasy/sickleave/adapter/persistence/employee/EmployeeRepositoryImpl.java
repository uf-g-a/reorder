package ru.ufimtsev.datasy.sickleave.adapter.persistence.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.ufimtsev.datasy.sickleave.app.api.EmployeeRepository;
import ru.ufimtsev.datasy.sickleave.domain.Employee;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final EmployeeJpaRepository employeeJpaRepository;

    @Override
    public Employee findById(Long id) {
        return employeeJpaRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Employee> findAll() {
        return employeeJpaRepository.findAll();
    }
}
