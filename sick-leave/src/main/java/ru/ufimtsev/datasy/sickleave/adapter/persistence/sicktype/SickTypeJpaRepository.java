package ru.ufimtsev.datasy.sickleave.adapter.persistence.sicktype;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ufimtsev.datasy.sickleave.domain.SickType;

public interface SickTypeJpaRepository extends JpaRepository<SickType, Long> {
}
