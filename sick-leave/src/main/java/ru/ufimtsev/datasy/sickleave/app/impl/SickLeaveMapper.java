package ru.ufimtsev.datasy.sickleave.app.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.ufimtsev.datasy.sickleave.app.api.AddCodeTypeRepository;
import ru.ufimtsev.datasy.sickleave.app.api.EmployeeRepository;
import ru.ufimtsev.datasy.sickleave.app.api.SickLeaveRepository;
import ru.ufimtsev.datasy.sickleave.app.api.SickTypeRepository;
import ru.ufimtsev.datasy.sickleave.domain.SickLeave;
import ru.ufimtsev.datasy.sickleave.domain.SickLeaveDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
@RequiredArgsConstructor
public class SickLeaveMapper {
    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private final EmployeeRepository employeeRepository;
    private final SickLeaveRepository sickLeaveRepository;
    private final SickTypeRepository sickTypeRepository;
    private final AddCodeTypeRepository addCodeTypeRepository;

    public SickLeave createSickLeave(SickLeaveDTO sickLeaveDTO){
        SickLeave sickLeave = new SickLeave();
        sickLeave.setDateBegin(LocalDate.parse(sickLeaveDTO.getSickBegin(), FORMATTER));
        sickLeave.setDateEnd(LocalDate.parse(sickLeaveDTO.getSickEnd(), FORMATTER));
        sickLeave.setEmployee(employeeRepository.findById(sickLeaveDTO.getEmployeeId()));
        sickLeave.setSickType(sickTypeRepository.findById(sickLeaveDTO.getSickTypeId()));
        sickLeave.setAddCodeType(addCodeTypeRepository.findById(sickLeaveDTO.getAddCodeTypeId()));
        return sickLeave;
    }
}
