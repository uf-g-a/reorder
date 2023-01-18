package ru.ufimtsev.datasy.sickleave.domain;

import lombok.Data;

@Data
public class SickLeaveDTO {
    private int code;
    private String sickBegin;
    private String sickEnd;
    private Long employeeId;
    private Long sickTypeId;
    private Long addCodeTypeId;
}
