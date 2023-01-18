package ru.ufimtsev.datasy.vacation.app.impl.vacation;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.stereotype.Component;
import ru.ufimtsev.datasy.vacation.app.api.vacation.CreateVacationDocument;
import ru.ufimtsev.datasy.vacation.domain.Employee;
import ru.ufimtsev.datasy.vacation.domain.Vacation;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

@Component
public class CreateVacationDocumentImpl implements CreateVacationDocument {
    public static final String FONT_TIMES_NEW_ROMAN = "Times New Roman";

    @Override
    public ByteArrayOutputStream execute(Vacation vacation) {
        XWPFDocument document = new XWPFDocument();
        createHeader(document, vacation.getEmployee());
        createMainPart(document, vacation);
        createFooter(document, vacation.getEmployee());

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            document.write(stream);
            return stream;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // ===================================================================================================================
    // = Implementation
    // ===================================================================================================================

    private void createHeader(XWPFDocument document, Employee employee){
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.RIGHT);
        setTextWithFormatting(paragraph, "Директору компании");

        paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.RIGHT);
        setTextWithFormatting(paragraph, "ООО \"DataSy\"");

        paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.RIGHT);
        setTextWithFormatting(paragraph, "Краснову А.В.");

        paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.RIGHT);
        setTextWithFormatting(paragraph, "От ");
        setTextWithFormatting(paragraph, getSurnameWithInitials(employee));

        generateEmptyLine(document);
        generateEmptyLine(document);
        generateEmptyLine(document);
        generateEmptyLine(document);
    }

    private void createMainPart(XWPFDocument document, Vacation vacation){
        XWPFParagraph title = document.createParagraph();
        title.setAlignment(ParagraphAlignment.CENTER);
        setTextWithFormatting(title, "Заявление");

        XWPFParagraph mainText = document.createParagraph();
        mainText.setAlignment(ParagraphAlignment.BOTH);
        mainText.setSpacingBetween(1.5);
        String text = generateMainText(vacation);
        setTextWithFormatting(mainText, text);
    }

    private void createFooter(XWPFDocument document, Employee employee){
        generateEmptyLine(document);
        generateEmptyLine(document);
        XWPFParagraph employeeSigned = document.createParagraph();
        employeeSigned.setAlignment(ParagraphAlignment.RIGHT);
        setTextWithFormatting(employeeSigned, "Дата подписания: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));

        employeeSigned = document.createParagraph();
        employeeSigned.setAlignment(ParagraphAlignment.RIGHT);
        setTextWithFormatting(employeeSigned, "___________ " + getSurnameWithInitials(employee));

        XWPFParagraph headSigned = document.createParagraph();
        headSigned.setAlignment(ParagraphAlignment.RIGHT);
        setTextWithFormatting(headSigned, "Дата подписания: _________");

        headSigned = document.createParagraph();
        headSigned.setAlignment(ParagraphAlignment.RIGHT);
        setTextWithFormatting(headSigned, "___________ " + "Краснов А.В.");
    }

    private void generateEmptyLine(XWPFDocument document){
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("");
    }

    private String generateMainText(Vacation vacation) {
        //LocalDate vacationBeginDate =
        return "        Прошу Вас предоставить мне ежегодный оплачиваемый отпуск с \"" +
                vacation.getDateBegin().getDayOfMonth() +
                "\" " +
                formatMonth(vacation.getDateBegin().getMonth()) +
                " " +
                vacation.getDateBegin().getYear() +
                " года по \"" +
                vacation.getDateEnd().getDayOfMonth() +
                "\" " +
                formatMonth(vacation.getDateEnd().getMonth()) +
                " " +
                vacation.getDateEnd().getYear() +
                " года сроком на " +
                (vacation.getDateEnd().getDayOfYear() - vacation.getDateBegin().getDayOfYear()) +
                " календарных дней.";
    }

    private void setTextWithFormatting(XWPFParagraph paragraph, String text){
        XWPFRun run = paragraph.createRun();
        run.setText(text);
        run.setFontFamily(FONT_TIMES_NEW_ROMAN);
        run.setFontSize(14);
    }

    private String getSurnameWithInitials(Employee employee) {
        return employee.getSurname() + " " + employee.getName().charAt(0) + "." + employee.getPatronymic().charAt(0) + ".";
    }

    private String formatMonth(Month month){
        return switch (month) {
            case JANUARY -> "января";
            case FEBRUARY -> "февраля";
            case MARCH -> "марта";
            case APRIL -> "апреля";
            case MAY -> "мая";
            case JUNE -> "июня";
            case JULY -> "июля";
            case AUGUST -> "августа";
            case SEPTEMBER -> "сентября";
            case OCTOBER -> "октября";
            case NOVEMBER -> "ноября";
            case DECEMBER -> "декабря";
        };
    }
}
