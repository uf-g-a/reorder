package ru.ufimtsev.datasy.paysheet.app.impl;

import lombok.RequiredArgsConstructor;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.stereotype.Component;
import ru.ufimtsev.datasy.paysheet.app.api.GeneratePaySheetDocument;
import ru.ufimtsev.datasy.paysheet.domain.Employee;
import ru.ufimtsev.datasy.paysheet.domain.Pay;
import ru.ufimtsev.datasy.paysheet.domain.PaySheet;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

@Component
@RequiredArgsConstructor
public class GeneratePaySheetDocumentImpl implements GeneratePaySheetDocument {
    public static final String FONT_TIMES_NEW_ROMAN = "Times New Roman";


    @Override
    public ByteArrayOutputStream execute(PaySheet paySheet) {
        XWPFDocument document = new XWPFDocument();
        createHeader(document, paySheet);
        createMainPart(document, paySheet);

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            document.write(stream);
            stream.close();
            document.close();
            return stream;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // ===================================================================================================================
    // = Implementation
    // ===================================================================================================================

    private float calculatePaySum(PaySheet paySheet) {
        return (float) paySheet.getPays().stream()
                .map(Pay::getPaySum)
                .mapToDouble(Float::doubleValue)
                .sum();
    }

    private void createHeader(XWPFDocument document, PaySheet paySheet){
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.LEFT);
        setTextWithFormatting(paragraph, "Расчетный лист");

        paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.LEFT);
        setTextWithFormatting(paragraph, "За " + paySheet.getPayDate().format(DateTimeFormatter.ofPattern("MM.yyyy")));

        paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.LEFT);
        setTextWithFormatting(paragraph, "Сотрудник: " + getSurnameWithInitials(paySheet.getEmployee()));
        generateEmptyLine(document);
        generateEmptyLine(document);
    }

    private void createMainPart(XWPFDocument document, PaySheet paySheet){
        XWPFTable table = document.createTable();
        table.setWidth("100%");
        XWPFTableRow tableRowOne = table.getRow(0);
        tableRowOne.getCell(0).setText("Код");
        tableRowOne.addNewTableCell().setText("Наименование");
        tableRowOne.addNewTableCell().setText("Плата");

        for (Pay pay : paySheet.getPays()){
            XWPFTableRow row = table.createRow();
            row.getCell(0).setWidth("20%");
            row.getCell(0).setText(String.valueOf(pay.getPayType().getPayTypeCode()));
            row.getCell(1).setWidth("60%");
            row.getCell(1).setText(pay.getPayType().getPayTypeName());
            row.getCell(2).setWidth("20%");
            row.getCell(2).setText(String.valueOf(pay.getPaySum()));
        }

        XWPFTableRow row = table.createRow();
        row.getCell(1).setText("Сумма");
        row.getCell(2).setText(String.valueOf(calculatePaySum(paySheet)));
    }

    private void generateEmptyLine(XWPFDocument document){
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("");
    }

    private String getSurnameWithInitials(Employee employee) {
        return employee.getSurname() + " " + employee.getName().charAt(0) + "." + employee.getPatronymic().charAt(0) + ".";
    }
    private void setTextWithFormatting(XWPFParagraph paragraph, String text){
        XWPFRun run = paragraph.createRun();
        run.setText(text);
        run.setFontFamily(FONT_TIMES_NEW_ROMAN);
        run.setFontSize(14);
    }
}
