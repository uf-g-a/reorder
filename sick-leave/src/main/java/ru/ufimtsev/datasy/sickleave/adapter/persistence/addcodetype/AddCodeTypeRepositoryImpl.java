package ru.ufimtsev.datasy.sickleave.adapter.persistence.addcodetype;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.ufimtsev.datasy.sickleave.app.api.AddCodeTypeRepository;
import ru.ufimtsev.datasy.sickleave.domain.AddCodeType;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AddCodeTypeRepositoryImpl implements AddCodeTypeRepository {
    private final AddCodeTypeJpaRepository addCodeTypeJpaRepository;

    @Override
    public List<AddCodeType> findAll() {
        return addCodeTypeJpaRepository.findAll();
    }

    @Override
    public AddCodeType findById(Long id) {
        return addCodeTypeJpaRepository.findById(id).orElseThrow();
    }
}
