package ru.ufimtsev.datasy.paysheet.adapter.persistence.paytype;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ufimtsev.datasy.paysheet.domain.PayType;

public interface PayTypeJpaRepository extends JpaRepository<PayType, Long> {
}
