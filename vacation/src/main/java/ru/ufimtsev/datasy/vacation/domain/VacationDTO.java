package ru.ufimtsev.datasy.vacation.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VacationDTO {
    private String dateBegin;
    private String dateEnd;
    private Integer vacationRemains;
    private Long employeeId;
    private Long typeId;
}
