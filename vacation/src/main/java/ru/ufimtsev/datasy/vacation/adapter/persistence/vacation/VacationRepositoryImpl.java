package ru.ufimtsev.datasy.vacation.adapter.persistence.vacation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.ufimtsev.datasy.vacation.app.api.vacation.VacationRepository;
import ru.ufimtsev.datasy.vacation.domain.Employee;
import ru.ufimtsev.datasy.vacation.domain.Vacation;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VacationRepositoryImpl implements VacationRepository {
    private final VacationJpaRepository vacationJpaRepository;

    @Override
    public Vacation save(Vacation vacation) {
        return vacationJpaRepository.save(vacation);
    }

    @Override
    public List<Vacation> findByEmployee(Employee employee) {
        return vacationJpaRepository.findByEmployee(employee);
    }

    @Override
    public void delete(Vacation vacation) {
        vacationJpaRepository.delete(vacation);
    }

    @Override
    public Optional<Vacation> findById(Long id) {
        return vacationJpaRepository.findById(id);
    }
}
