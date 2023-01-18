package ru.ufimtsev.datasy.paysheet.adapter.persistence.pay;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ufimtsev.datasy.paysheet.domain.Pay;

public interface PayJpaRepository extends JpaRepository<Pay, Long> {

}
