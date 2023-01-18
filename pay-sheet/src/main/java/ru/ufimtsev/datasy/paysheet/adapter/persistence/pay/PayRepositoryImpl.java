package ru.ufimtsev.datasy.paysheet.adapter.persistence.pay;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.ufimtsev.datasy.paysheet.app.api.PayRepository;
import ru.ufimtsev.datasy.paysheet.domain.Pay;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PayRepositoryImpl implements PayRepository {
    private final PayJpaRepository payJpaRepository;

    @Override
    public Pay findById(Long id) {
        return payJpaRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Pay> findAll() {
        return payJpaRepository.findAll();
    }

    @Override
    public Pay save(Pay pay) {
        return payJpaRepository.save(pay);
    }

    @Override
    public void delete(Long id) {
        payJpaRepository.delete(findById(id));
    }
}
