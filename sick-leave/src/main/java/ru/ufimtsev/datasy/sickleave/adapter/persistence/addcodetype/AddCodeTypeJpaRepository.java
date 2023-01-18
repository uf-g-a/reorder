package ru.ufimtsev.datasy.sickleave.adapter.persistence.addcodetype;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ufimtsev.datasy.sickleave.domain.AddCodeType;

public interface AddCodeTypeJpaRepository extends JpaRepository<AddCodeType, Long> {
}
