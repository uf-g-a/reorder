package ru.ufimtsev.datasy.paysheet.adapter.persistence.paysheet;

import org.springframework.data.repository.CrudRepository;
import ru.ufimtsev.datasy.paysheet.domain.Employee;
import ru.ufimtsev.datasy.paysheet.domain.PaySheet;

import java.util.List;

public interface PaySheetJpaRepository extends CrudRepository<PaySheet, Long> {
    List<PaySheet> findByEmployee(Employee employee);
}
