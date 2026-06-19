package lr8.Excel;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteSongsExcelExample {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Песни");

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Песня");
        headerRow.createCell(1).setCellValue("Исполнитель");
        headerRow.createCell(2).setCellValue("Год");

        Row dataRow1 = sheet.createRow(1);
        dataRow1.createCell(0).setCellValue("Imagine");
        dataRow1.createCell(1).setCellValue("John Lennon");
        dataRow1.createCell(2).setCellValue(1971);

        Row dataRow2 = sheet.createRow(2);
        dataRow2.createCell(0).setCellValue("Billie Jean");
        dataRow2.createCell(1).setCellValue("Michael Jackson");
        dataRow2.createCell(2).setCellValue(1982);

        String filePath = "src/lr8/Excel/songs.xlsx";
        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        }
        workbook.close();

        System.out.println("Данные записаны в файл: " + filePath);
    }
}