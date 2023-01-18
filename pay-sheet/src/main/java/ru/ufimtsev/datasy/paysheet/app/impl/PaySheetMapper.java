package ru.ufimtsev.datasy.paysheet.app.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.ufimtsev.datasy.paysheet.app.api.EmployeeRepository;
import ru.ufimtsev.datasy.paysheet.app.api.PayRepository;
import ru.ufimtsev.datasy.paysheet.app.api.PayTypeRepository;
import ru.ufimtsev.datasy.paysheet.domain.Pay;
import ru.ufimtsev.datasy.paysheet.domain.PayDTO;
import ru.ufimtsev.datasy.paysheet.domain.PaySheet;
import ru.ufimtsev.datasy.paysheet.domain.PaySheetDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PaySheetMapper {
    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private final PayTypeRepository payTypeRepository;
    private final PayRepository payRepository;
    private final EmployeeRepository employeeRepository;

    public PaySheet createPaySheet(PaySheetDTO paySheetDTO) {
        PaySheet paySheet = new PaySheet();
        paySheet.setEmployee(employeeRepository.findById(paySheetDTO.getEmployeeId()));
        paySheet.setPayDate(LocalDate.parse(paySheetDTO.getPayDate(), FORMATTER));
        List<Pay> pays = new ArrayList<>();
        for (Long payId : paySheetDTO.getPayIdList()) {
            pays.add(payRepository.findById(payId));
        }
        paySheet.setPays(pays);
        return paySheet;
    }

    public Pay createPay(PayDTO payDTO) {
        Pay pay = new Pay();
        pay.setPaySum(payDTO.getPaySum());
        pay.setPayType(payTypeRepository.findById(payDTO.getPayTypeId()));
        return pay;
    }
}
