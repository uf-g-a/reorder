package ru.ufimtsev.datasy.sickleave.app.api;

import ru.ufimtsev.datasy.sickleave.domain.SickType;

import java.util.List;

public interface SickTypeRepository {
    List<SickType> findAll();
    SickType findById(Long id);
}
