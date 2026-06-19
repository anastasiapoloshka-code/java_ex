package lr8.json;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonCreatorExample {
    public static void main(String[] args) {
        // Корневой объект JSON
        JSONObject library = new JSONObject();

        // Массив книг
        JSONArray booksArray = new JSONArray();

        // Первая книга
        JSONObject book1 = new JSONObject();
        book1.put("title", "Java Programming");
        book1.put("author", "John Doe");
        book1.put("year", "2015");
        booksArray.add(book1);

        // Вторая книга
        JSONObject book2 = new JSONObject();
        book2.put("title", "Python Programming");
        book2.put("author", "Jane Smith");
        book2.put("year", "2018");
        booksArray.add(book2);

        // Третья книга
        JSONObject book3 = new JSONObject();
        book3.put("title", "Ruby Programming");
        book3.put("author", "Bob Johnson");
        book3.put("year", "2016");
        booksArray.add(book3);

        // Добавляем массив книг в корневой объект
        library.put("books", booksArray);

        // Папка и файл для записи
        File folder = new File("src/lr8/json/example-json.json");
        if (!folder.exists()) {
            boolean created = folder.mkdirs();
            System.out.println("Создаём папку: " + folder.getAbsolutePath());
            System.out.println("Папка создана: " + created);
        }

        File jsonFile = new File(folder, "example-json.json");

        // Запись JSON в файл
        try (FileWriter fileWriter = new FileWriter(jsonFile)) {
            fileWriter.write(library.toJSONString());
            fileWriter.flush();
            System.out.println("JSON-файл успешно создан: " + jsonFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Ошибка при записи JSON-файла: " + e.getMessage());
        }
    }
}