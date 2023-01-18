package ru.ufimtsev.datasy.paysheet.adapter.persistence.paytype;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.ufimtsev.datasy.paysheet.app.api.PayTypeRepository;
import ru.ufimtsev.datasy.paysheet.domain.PayType;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PayTypeRepositoryImpl implements PayTypeRepository {
    private final PayTypeJpaRepository payTypeJpaRepository;
    @Override
    public List<PayType> findAll() {
        return payTypeJpaRepository.findAll();
    }

    @Override
    public PayType findById(Long id) {
        return payTypeJpaRepository.findById(id).orElseThrow();
    }
}
