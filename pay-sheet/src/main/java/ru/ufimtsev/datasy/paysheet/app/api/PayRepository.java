package ru.ufimtsev.datasy.paysheet.app.api;

import ru.ufimtsev.datasy.paysheet.domain.Pay;

import java.util.List;

public interface PayRepository {
    Pay findById(Long id);
    List<Pay> findAll();
    Pay save(Pay pay);
    void delete(Long id);
}
