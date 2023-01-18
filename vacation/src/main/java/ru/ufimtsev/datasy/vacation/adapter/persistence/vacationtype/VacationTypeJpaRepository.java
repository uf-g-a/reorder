package ru.ufimtsev.datasy.vacation.adapter.persistence.vacationtype;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ufimtsev.datasy.vacation.domain.VacationType;

public interface VacationTypeJpaRepository extends JpaRepository<VacationType, Long> {
}
