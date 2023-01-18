package ru.ufimtsev.datasy.paysheet.app.api;

import ru.ufimtsev.datasy.paysheet.domain.PayType;

import java.util.List;
import java.util.Optional;

public interface PayTypeRepository {
    List<PayType> findAll();
    PayType findById(Long id);
}
