package lr8.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Iterator;

public class SongJsonParser {

    private static final String FILE_PATH = "src/lr8/json/songs.json";

    public static void main(String[] args) {
        try {
            // 1. Читаем JSON-файл
            JSONObject root = readJsonFromFile(FILE_PATH);
            JSONArray songsArray = (JSONArray) root.get("songs");

            System.out.println("Исходный список песен:");
            printAllSongs(songsArray);

            // 2. Поиск песен по исполнителю
            System.out.println("\nПоиск песен исполнителя 'Michael Jackson':");
            findSongsByArtist(songsArray, "Michael Jackson");

            // 3. Добавление новой песни
            addNewSong(songsArray, "Smells Like Teen Spirit", "Nirvana", 1991);
            writeJsonToFile(root, FILE_PATH);
            System.out.println("\nПосле добавления новой песни:");
            printAllSongs(songsArray);

            // 4. Удаление песни по названию
            deleteSongByTitle(songsArray, "Imagine");
            writeJsonToFile(root, FILE_PATH);
            System.out.println("\nПосле удаления песни 'Imagine':");
            printAllSongs(songsArray);

        } catch (IOException | ParseException e) {
            System.out.println("Ошибка при работе с JSON-файлом: " + e.getMessage());
        }
    }

    // Чтение JSON из файла
    private static JSONObject readJsonFromFile(String filePath) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader(filePath)) {
            Object obj = parser.parse(reader);
            return (JSONObject) obj;
        }
    }

    // Запись JSON в файл
    private static void writeJsonToFile(JSONObject root, String filePath) throws IOException {
        try (Writer writer = new FileWriter(filePath)) {
            writer.write(root.toJSONString());
            writer.flush();
        }
    }

    // Вывод всех песен
    private static void printAllSongs(JSONArray songsArray) {
        for (Object obj : songsArray) {
            if (obj instanceof JSONObject) {
                JSONObject song = (JSONObject) obj;
                printSong(song);
            }
        }
    }

    private static void printSong(JSONObject song) {
        String title = (String) song.get("title");
        String artist = (String) song.get("artist");
        Object year = song.get("year");
        System.out.println("Песня: " + title + ", Исполнитель: " + artist + ", Год: " + year);
    }

    // 2. Поиск песен по исполнителю
    public static void findSongsByArtist(JSONArray songsArray, String artist) {
        for (Object obj : songsArray) {
            if (obj instanceof JSONObject) {
                JSONObject song = (JSONObject) obj;
                if (artist.equals(song.get("artist"))) {
                    System.out.println("\nТекущий элемент: song");
                    System.out.println("Название песни: " + song.get("title"));
                    System.out.println("Исполнитель: " + song.get("artist"));
                    System.out.println("Год выпуска: " + song.get("year"));
                }
            }
        }
    }

    // 3. Добавление новой песни в массив
    public static void addNewSong(JSONArray songsArray,
                                  String title, String artist, int year) {
        JSONObject newSong = new JSONObject();
        newSong.put("title", title);
        newSong.put("artist", artist);
        newSong.put("year", year);
        songsArray.add(newSong);
    }

    // 4. Удаление песни из массива по названию (Iterator.remove)
    public static void deleteSongByTitle(JSONArray songsArray, String titleToDelete) {
        Iterator<?> iterator = songsArray.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if (obj instanceof JSONObject) {
                JSONObject song = (JSONObject) obj;
                if (titleToDelete.equals(song.get("title"))) {
                    iterator.remove();
                }
            }
        }
    }
}