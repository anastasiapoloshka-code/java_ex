package lr8.xml;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SongXmlParser {

    private static final String FILE_PATH = "src/lr8/xml/songs.xml";

    public static void main(String[] args) throws Exception {
        // Загружаем XML в DOM
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(FILE_PATH));
        doc.getDocumentElement().normalize();

        System.out.println("Исходный список песен:");
        printAllSongs(doc);

        // 1. Добавление новой песни
        addSong(doc, "Smells Like Teen Spirit", "Nirvana", "1991");
        saveDocument(doc, FILE_PATH);
        System.out.println("\nПосле добавления новой песни:");
        printAllSongs(doc);

        // 2. Поиск песен по исполнителю или году
        System.out.println("\nПоиск песен исполнителя 'Michael Jackson':");
        List<Element> byArtist = findSongs(doc, "Michael Jackson", null);
        byArtist.forEach(SongXmlParser::printSong);

        System.out.println("\nПоиск песен за 1971 год:");
        List<Element> byYear = findSongs(doc, null, "1971");
        byYear.forEach(SongXmlParser::printSong);

        // 3. Удаление песни по названию
        deleteSongByTitle(doc, "Imagine");
        saveDocument(doc, FILE_PATH);
        System.out.println("\nПосле удаления песни 'Imagine':");
        printAllSongs(doc);
    }

    // Вывод всех песен
    private static void printAllSongs(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("song");
        IntStream.range(0, nodeList.getLength())
                .mapToObj(nodeList::item)
                .filter(node -> node.getNodeType() == Node.ELEMENT_NODE)
                .map(node -> (Element) node)
                .forEach(SongXmlParser::printSong);
    }

    private static void printSong(Element song) {
        String title = song.getElementsByTagName("title").item(0).getTextContent();
        String artist = song.getElementsByTagName("artist").item(0).getTextContent();
        String year = song.getElementsByTagName("year").item(0).getTextContent();
        System.out.println("Песня: " + title + ", Исполнитель: " + artist + ", Год: " + year);
    }

    // Добавление новой песни
    public static void addSong(Document doc, String title, String artist, String year) {
        Element root = doc.getDocumentElement(); // <songs>

        Element song = doc.createElement("song");

        Element titleElement = doc.createElement("title");
        titleElement.setTextContent(title);
        song.appendChild(titleElement);

        Element artistElement = doc.createElement("artist");
        artistElement.setTextContent(artist);
        song.appendChild(artistElement);

        Element yearElement = doc.createElement("year");
        yearElement.setTextContent(year);
        song.appendChild(yearElement);

        root.appendChild(song);
    }

    // Поиск песен по исполнителю и/или году (Stream API)
    public static List<Element> findSongs(Document doc, String artistFilter, String yearFilter) {
        NodeList nodeList = doc.getElementsByTagName("song");

        return IntStream.range(0, nodeList.getLength())
                .mapToObj(nodeList::item)
                .filter(node -> node.getNodeType() == Node.ELEMENT_NODE)
                .map(node -> (Element) node)
                .filter(element -> {
                    String artist = element.getElementsByTagName("artist").item(0).getTextContent();
                    String year = element.getElementsByTagName("year").item(0).getTextContent();
                    boolean byArtist = artistFilter == null || artist.equalsIgnoreCase(artistFilter);
                    boolean byYear = yearFilter == null || year.equals(yearFilter);
                    return byArtist && byYear;
                })
                .collect(Collectors.toList());
    }

    // Удаление песни по названию
    public static void deleteSongByTitle(Document doc, String titleToDelete) {
        NodeList nodeList = doc.getElementsByTagName("song");
        List<Element> toDelete = new ArrayList<>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element song = (Element) node;
                String title = song.getElementsByTagName("title").item(0).getTextContent();
                if (titleToDelete.equals(title)) {
                    toDelete.add(song);
                }
            }
        }

        for (Element song : toDelete) {
            Node parent = song.getParentNode();
            parent.removeChild(song);
        }
    }

    // Сохранение DOM обратно в XML-файл
    public static void saveDocument(Document doc, String filePath) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(filePath));
        transformer.transform(source, result);
    }
}