package ru.ufimtsev.datasy.vacation.adapter.persistence.vacationtype;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.ufimtsev.datasy.vacation.app.api.vacationtype.VacationTypeRepository;
import ru.ufimtsev.datasy.vacation.domain.VacationType;

import java.util.List;

@Component
@RequiredArgsConstructor
public class VacationTypeRepositoryImpl implements VacationTypeRepository {
    private final VacationTypeJpaRepository vacationTypeJpaRepository;

    @Override
    public List<VacationType> findAll() {
        return vacationTypeJpaRepository.findAll();
    }

    @Override
    public VacationType findById(Long id) {
        return vacationTypeJpaRepository.findById(id).orElseThrow();
    }
}
