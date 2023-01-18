package ru.ufimtsev.datasy.sickleave.adapter.persistence.sicktype;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.ufimtsev.datasy.sickleave.app.api.SickTypeRepository;
import ru.ufimtsev.datasy.sickleave.domain.SickType;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SickTypeRepositoryImpl implements SickTypeRepository {
    private final SickTypeJpaRepository sickTypeJpaRepository;

    @Override
    public List<SickType> findAll() {
        return sickTypeJpaRepository.findAll();
    }

    @Override
    public SickType findById(Long id) {
        return sickTypeJpaRepository.findById(id).orElseThrow();
    }
}
