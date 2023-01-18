package ru.ufimtsev.datasy.vacation.app.api.vacation;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import ru.ufimtsev.datasy.vacation.domain.Vacation;

public interface CreateVacationDocument {
    ByteArrayOutputStream execute(Vacation vacation);
}
