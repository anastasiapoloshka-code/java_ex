package lr8.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XmlParserExample {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("src/lr8/xml/example.xml");
            System.out.println("Чтение XML-файла: " + xmlFile.getAbsolutePath());

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Нормализация документа
            doc.getDocumentElement().normalize();

            // Корневой элемент
            Element root = doc.getDocumentElement();
            System.out.println("Корневой элемент: " + root.getNodeName());

            // Все элементы <book>
            NodeList bookNodes = doc.getElementsByTagName("book");
            System.out.println("Количество книг: " + bookNodes.getLength());

            for (int i = 0; i < bookNodes.getLength(); i++) {
                Element bookElement = (Element) bookNodes.item(i);

                String title = bookElement.getElementsByTagName("title")
                        .item(0).getTextContent();
                String author = bookElement.getElementsByTagName("author")
                        .item(0).getTextContent();
                String year = bookElement.getElementsByTagName("year")
                        .item(0).getTextContent();

                System.out.println("\nКнига " + (i + 1) + ":");
                System.out.println("Название: " + title);
                System.out.println("Автор: " + author);
                System.out.println("Год издания: " + year);
            }
        } catch (Exception e) {
            System.out.println("Ошибка при чтении XML-файла: " + e.getMessage());
        }
    }
}