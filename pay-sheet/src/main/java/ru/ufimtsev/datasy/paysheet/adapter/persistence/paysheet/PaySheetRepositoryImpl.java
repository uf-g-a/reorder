package ru.ufimtsev.datasy.paysheet.adapter.persistence.paysheet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.ufimtsev.datasy.paysheet.app.api.PaySheetRepository;
import ru.ufimtsev.datasy.paysheet.domain.Employee;
import ru.ufimtsev.datasy.paysheet.domain.PaySheet;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PaySheetRepositoryImpl implements PaySheetRepository {
    private final PaySheetJpaRepository paySheetJpaRepository;

    @Override
    public PaySheet findById(Long id) {
        return paySheetJpaRepository.findById(id).orElseThrow();
    }

    @Override
    public PaySheet save(PaySheet paySheet) {
        return paySheetJpaRepository.save(paySheet);
    }

    @Override
    public List<PaySheet> findByEmployee(Employee employee) {
        return paySheetJpaRepository.findByEmployee(employee);
    }

    @Override
    public void delete(Long id) {
        paySheetJpaRepository.delete(findById(id));
    }
}
