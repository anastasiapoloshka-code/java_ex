package lr8.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class FatUrfuParser {
    public static void main(String[] args) {
        String url = "http://fat.urfu.ru/index.html";

        try {
            // Загружаем HTML-страницу
            Document doc = Jsoup.connect(url).get();

            System.out.println("Заголовок страницы: " + doc.title());
            System.out.println("----------");

            // Пример: выводим все заголовки h3 (обычно там названия курсов/разделов)
            Elements headers = doc.select("h3");
            System.out.println("Заголовки h3:");
            for (Element h : headers) {
                System.out.println("- " + h.text());
            }

            System.out.println("----------");

            // Пример: выводим ссылки на странице
            Elements links = doc.select("a[href]");
            System.out.println("Ссылки на странице:");
            for (Element link : links) {
                System.out.println(link.text() + " -> " + link.attr("href"));
            }

        } catch (IOException e) {
            System.out.println("Ошибка при загрузке страницы: " + e.getMessage());
        }
    }
}