package lr8.Excel;

import org.apache.poi.openxml4j.exceptions.OLE2NotOfficeXmlFileException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadSongsExcelExample {
    public static void main(String[] args) {
        String filePath = "src/lr8/Excel/songs.xlsx";
        int sheetIndex = 0; // читаем первый лист

        try (FileInputStream inputStream = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {

            // Проверка наличия листа
            if (workbook.getNumberOfSheets() <= sheetIndex) {
                System.out.println("Ошибка: в файле " + filePath +
                        " нет листа с индексом " + sheetIndex + ".");
                System.out.println("Рекомендация: проверьте, что программа записи Excel создала хотя бы один лист с данными.");
                return;
            }

            Sheet sheet = workbook.getSheetAt(sheetIndex);

            System.out.println("Содержимое файла: " + filePath);
            System.out.println("-----------");

            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        default:
                            System.out.print("\t");
                    }
                }
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: файл " + filePath + " не найден.");
            System.out.println("Рекомендация: сначала запустите программу записи Excel (WriteSongsExcelExample), " +
                    "убедитесь, что файл songs.xlsx создан по указанному пути.");
        } catch (OLE2NotOfficeXmlFileException e) {
            System.out.println("Ошибка формата файла: " + filePath + " не является корректным XLSX-файлом.");
            System.out.println("Рекомендация: проверьте, что вы используете файл формата .xlsx, " +
                    "а не .xls или другой формат (не переименовывайте файлы вручную).");
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода при работе с файлом: " + e.getMessage());
            System.out.println("Рекомендация: повторите запуск программы после устранения проблемы с доступом к файлу.");
        }
    }
}