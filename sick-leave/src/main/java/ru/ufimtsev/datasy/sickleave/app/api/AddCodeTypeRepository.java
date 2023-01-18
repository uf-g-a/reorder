package ru.ufimtsev.datasy.sickleave.app.api;

import ru.ufimtsev.datasy.sickleave.domain.AddCodeType;

import java.util.List;

public interface AddCodeTypeRepository {
    List<AddCodeType> findAll();
    AddCodeType findById(Long id);
}
