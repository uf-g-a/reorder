package ru.ufimtsev.datasy.paysheet.domain;

import lombok.Data;

@Data
public class PayDTO {
    private float paySum;
    private Long payTypeId;
}
