package ru.ufimtsev.datasy.sickleave.adapter.persistence.sickleave;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.ufimtsev.datasy.sickleave.app.api.SickLeaveRepository;
import ru.ufimtsev.datasy.sickleave.domain.Employee;
import ru.ufimtsev.datasy.sickleave.domain.SickLeave;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SickLeaveRepositoryImpl implements SickLeaveRepository {
    private final SickLeaveJpaRepository sickLeaveJpaRepository;

    @Override
    public List<SickLeave> findAll() {
        return sickLeaveJpaRepository.findAll();
    }

    @Override
    public SickLeave findById(Long id) {
        return sickLeaveJpaRepository.findById(id).orElseThrow();
    }

    @Override
    public SickLeave save(SickLeave sickLeave) {
        return sickLeaveJpaRepository.save(sickLeave);
    }

    @Override
    public void delete(Long id) {
        sickLeaveJpaRepository.delete(findById(id));
    }

    @Override
    public List<SickLeave> findByEmployee(Employee employee) {
        return sickLeaveJpaRepository.findByEmployee(employee);
    }
}
