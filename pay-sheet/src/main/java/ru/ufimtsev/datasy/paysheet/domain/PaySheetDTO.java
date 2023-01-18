package ru.ufimtsev.datasy.paysheet.domain;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PaySheetDTO {
    private String payDate;
    private Long employeeId;
    private List<Long> payIdList;
}
