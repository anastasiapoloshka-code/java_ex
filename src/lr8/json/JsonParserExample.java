package lr8.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonParserExample {
    public static void main(String[] args) {
        // Файл с JSON-данными
        File jsonFile = new File("src/lr8/json/example-json.json");

        // Проверяем, что файл существует
        if (!jsonFile.exists()) {
            System.out.println("Файл не найден: " + jsonFile.getAbsolutePath());
            return;
        }

        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(jsonFile)) {
            // Разбираем JSON в объект
            Object obj = parser.parse(reader);
            JSONObject library = (JSONObject) obj;

            // Получаем массив книг
            JSONArray booksArray = (JSONArray) library.get("books");

            System.out.println("Список книг из JSON-файла:");
            for (Object bookObj : booksArray) {
                JSONObject book = (JSONObject) bookObj;
                String title = (String) book.get("title");
                String author = (String) book.get("author");
                String year = (String) book.get("year");

                System.out.println("Название: " + title);
                System.out.println("Автор: " + author);
                System.out.println("Год: " + year);
                System.out.println("-------------------------");
            }

        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        } catch (ParseException e) {
            System.out.println("Ошибка разбора JSON: " + e.getMessage());
        }
    }
}