package ru.ufimtsev.datasy.vacation.app.impl.vacation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.ufimtsev.datasy.vacation.app.api.employee.EmployeeRepository;
import ru.ufimtsev.datasy.vacation.app.api.vacation.CreateVacationInbound;
import ru.ufimtsev.datasy.vacation.app.api.vacationtype.VacationTypeRepository;
import ru.ufimtsev.datasy.vacation.domain.Employee;
import ru.ufimtsev.datasy.vacation.domain.Vacation;
import ru.ufimtsev.datasy.vacation.domain.VacationDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@RequiredArgsConstructor
public class CreateVacationImpl implements CreateVacationInbound {
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private final EmployeeRepository employeeRepository;
    private final VacationTypeRepository vacationTypeRepository;
    @Override
    public Vacation execute(VacationDTO vacationDTO) {
        Vacation vacation = new Vacation();
        vacation.setEmployee(employeeRepository.findById(vacationDTO.getEmployeeId()));
        vacation.setVacationType(vacationTypeRepository.findById(vacationDTO.getTypeId()));
        vacation.setDateBegin(LocalDate.parse(vacationDTO.getDateBegin(), FORMATTER));
        vacation.setDateEnd(LocalDate.parse(vacationDTO.getDateEnd(), FORMATTER));
        vacation.setVacationRemains(vacationDTO.getVacationRemains());
        return vacation;
    }
}
