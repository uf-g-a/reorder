package ru.ufimtsev.datasy.vacation.app.api.vacation;

import ru.ufimtsev.datasy.vacation.domain.Vacation;
import ru.ufimtsev.datasy.vacation.domain.VacationDTO;

public interface CreateVacationInbound {
    Vacation execute(VacationDTO vacationDTO);
}
