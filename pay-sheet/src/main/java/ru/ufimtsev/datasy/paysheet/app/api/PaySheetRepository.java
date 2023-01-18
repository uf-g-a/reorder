package ru.ufimtsev.datasy.paysheet.app.api;

import ru.ufimtsev.datasy.paysheet.domain.Employee;
import ru.ufimtsev.datasy.paysheet.domain.PaySheet;

import java.util.List;

public interface PaySheetRepository {
    public PaySheet findById(Long id);
    public PaySheet save(PaySheet paySheet);
    public List<PaySheet> findByEmployee(Employee employee);
    public void delete(Long id);
}
