package lr8.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class HtmlItlearnParser {

    private static final String URL = "https://itlearn.ru/first-steps";
    private static final String OUTPUT_FILE = "src/lr8/html/itlearn-result.txt";

    public static void main(String[] args) {
        Document doc = fetchDocumentWithRetries(URL, 3);
        if (doc == null) {
            // если после нескольких попыток страница так и не загрузилась
            return;
        }

        System.out.println("Заголовок страницы: " + doc.title());
        System.out.println("----------");

        Elements headers = doc.select("h2");
        Elements links = doc.select("a[href]");

        System.out.println("Заголовки h2:");
        for (Element h : headers) {
            System.out.println("- " + h.text());
        }

        System.out.println("----------");
        System.out.println("Ссылки на странице:");
        for (Element link : links) {
            System.out.println(link.text() + " -> " + link.attr("href"));
        }

        // Запись результатов в файл
        List<String> lines = new ArrayList<>();
        lines.add("Заголовок страницы: " + doc.title());
        lines.add("----------");
        lines.add("Заголовки h2:");
        for (Element h : headers) {
            lines.add(h.text());
        }
        lines.add("----------");
        lines.add("Ссылки на странице:");
        for (Element link : links) {
            lines.add(link.text() + " -> " + link.attr("href"));
        }

        saveLinesToFile(lines, OUTPUT_FILE);
    }

    // Загрузка страницы с несколькими попытками
    private static Document fetchDocumentWithRetries(String url, int attempts) {
        for (int i = 1; i <= attempts; i++) {
            try {
                return Jsoup.connect(url).get();
            } catch (IOException e) {
                System.out.println("Ошибка при загрузке страницы (попытка " + i + "): " + e.getMessage());
                if (i == attempts) {
                    System.out.println("Не удалось получить страницу после " + attempts + " попыток.");
                } else {
                    try {
                        Thread.sleep(2000); // подождать 2 секунды и попробовать ещё раз
                    } catch (InterruptedException ignored) {
                    }
                }
            }
        }
        return null;
    }

    // Запись строк в текстовый файл
    private static void saveLinesToFile(List<String> lines, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(filePath, StandardCharsets.UTF_8))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Результаты парсинга сохранены в файл: " + filePath);
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла результатов: " + e.getMessage());
        }
    }
}