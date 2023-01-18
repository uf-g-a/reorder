package ru.ufimtsev.datasy.sickleave.app.api;

import ru.ufimtsev.datasy.sickleave.domain.Employee;
import ru.ufimtsev.datasy.sickleave.domain.SickLeave;

import java.util.List;

public interface SickLeaveRepository {
    List<SickLeave> findAll();
    SickLeave findById(Long id);
    SickLeave save(SickLeave sickLeave);
    void delete(Long id);
    public List<SickLeave> findByEmployee(Employee employee);
}
