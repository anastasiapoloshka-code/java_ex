package lr8.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XmlCreatorExample {
    public static void main(String[] args) {
        try {
            // Создаём фабрику и билдер документов
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Создаём пустой документ
            Document doc = builder.newDocument();

            // Корневой элемент <library>
            Element rootElement = doc.createElement("library");
            doc.appendChild(rootElement);

            // Первая книга
            Element book1 = doc.createElement("book");

            Element title1 = doc.createElement("title");
            title1.appendChild(doc.createTextNode("Война и мир"));
            book1.appendChild(title1);

            Element author1 = doc.createElement("author");
            author1.appendChild(doc.createTextNode("Лев Толстой"));
            book1.appendChild(author1);

            Element year1 = doc.createElement("year");
            year1.appendChild(doc.createTextNode("1869"));
            book1.appendChild(year1);

            rootElement.appendChild(book1);

            // Вторая книга
            Element book2 = doc.createElement("book");

            Element title2 = doc.createElement("title");
            title2.appendChild(doc.createTextNode("Мастер и Маргарита"));
            book2.appendChild(title2);

            Element author2 = doc.createElement("author");
            author2.appendChild(doc.createTextNode("Михаил Булгаков"));
            book2.appendChild(author2);

            Element year2 = doc.createElement("year");
            year2.appendChild(doc.createTextNode("1967"));
            book2.appendChild(year2);

            rootElement.appendChild(book2);

            // Подготовка к записи в файл
            File folder = new File("src/lr8/xml");
            if (!folder.exists()) {
                boolean created = folder.mkdirs();
                System.out.println("Создаём папку: " + folder.getAbsolutePath());
                System.out.println("Папка создана: " + created);
            }

            File xmlFile = new File(folder, "example.xml");

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(xmlFile);

            transformer.transform(source, result);

            System.out.println("XML-файл успешно создан: " + xmlFile.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Ошибка при создании XML-файла: " + e.getMessage());
        }
    }
}