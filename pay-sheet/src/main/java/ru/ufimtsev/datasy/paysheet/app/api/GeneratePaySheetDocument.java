package ru.ufimtsev.datasy.paysheet.app.api;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import ru.ufimtsev.datasy.paysheet.domain.Employee;
import ru.ufimtsev.datasy.paysheet.domain.PaySheet;

public interface GeneratePaySheetDocument {
    ByteArrayOutputStream execute(PaySheet paySheet);
}
