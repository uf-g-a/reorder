package ru.ufimtsev.datasy.paysheet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.ufimtsev.datasy.paysheet.app.api.EmployeeRepository;
import ru.ufimtsev.datasy.paysheet.app.api.GeneratePaySheetDocument;
import ru.ufimtsev.datasy.paysheet.app.api.PaySheetRepository;
import ru.ufimtsev.datasy.paysheet.app.impl.GeneratePaySheetDocumentImpl;
import ru.ufimtsev.datasy.paysheet.domain.Employee;
import ru.ufimtsev.datasy.paysheet.domain.Pay;
import ru.ufimtsev.datasy.paysheet.domain.PaySheet;
import ru.ufimtsev.datasy.paysheet.domain.PayType;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GenerateDocumentTest {

    @Test
    void generateDocument() throws IOException {
        PaySheet paySheet = createPaySheet(1L);
        GeneratePaySheetDocument generatePaySheetDocument = new GeneratePaySheetDocumentImpl();

        OutputStream outputStream = new FileOutputStream("C:\\Users\\GUfimtsev\\JavaProject\\Reorder\\pay-sheet\\src\\test\\resources\\testDoc.docx");
        generatePaySheetDocument.execute(paySheet).writeTo(outputStream);
    }

    private PaySheet createPaySheet(Long id){
        Employee employee = new Employee(1L,
                "Дмитрий",
                "Зубенко",
                "Петрович",
                25,
                true,
                LocalDateTime.now(),
                "dzp@gmail.com",
                Collections.emptyList());

        Pay pay1 = new Pay(1L, 3000, new PaySheet(), new PayType());
        Pay pay2 = new Pay(2L, 10000, new PaySheet(), new PayType());
        Pay pay3 = new Pay(3L, 35000, new PaySheet(), new PayType());

        PayType payType1 = new PayType(1L, "Надбавка за проект.деят", 2040, Collections.emptyList());
        PayType payType2 = new PayType(1L, "Надбавка за сложность", 2050, Collections.emptyList());
        PayType payType3 = new PayType(1L, "Заработная плата", 8230, Collections.emptyList());

        pay1.setPayType(payType1);
        pay2.setPayType(payType2);
        pay3.setPayType(payType3);

        PaySheet paySheet = new PaySheet(id, LocalDateTime.now(), new Employee(), Collections.emptyList());

        pay1.setPaySheet(paySheet);
        pay2.setPaySheet(paySheet);
        pay3.setPaySheet(paySheet);

        employee.setPaySheets(List.of(paySheet));

        paySheet.setPays(List.of(pay1, pay2, pay3));
        paySheet.setEmployee(employee);

        return paySheet;
    }
}
