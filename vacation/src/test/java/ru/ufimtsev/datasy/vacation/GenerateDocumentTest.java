package ru.ufimtsev.datasy.vacation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.ufimtsev.datasy.vacation.app.api.vacation.CreateVacationDocument;
import ru.ufimtsev.datasy.vacation.app.impl.vacation.CreateVacationDocumentImpl;
import ru.ufimtsev.datasy.vacation.domain.Employee;
import ru.ufimtsev.datasy.vacation.domain.Vacation;
import ru.ufimtsev.datasy.vacation.domain.VacationType;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.Collections;

@ExtendWith(MockitoExtension.class)
public class GenerateDocumentTest {

    @Test
    void generateDocument() throws IOException {
        CreateVacationDocument createVacationDocument = new CreateVacationDocumentImpl();
        Employee employee = new Employee(1L, "Иван", "Иванов", "Иванович", 25, true, LocalDateTime.now(), Collections.emptyList());
        Vacation vacation = new Vacation(1L, LocalDateTime.now(), LocalDateTime.now().plusDays(14), 14, employee, new VacationType());
        vacation.setEmployee(employee);


        OutputStream outputStream = new FileOutputStream("C:\\Users\\GUfimtsev\\JavaProject\\Reorder\\vacation\\src\\test\\resources\\ru\\ufimtsev\\datasy\\vacation\\testDoc.docx");
        createVacationDocument.execute(vacation).writeTo(outputStream);

    }
}
