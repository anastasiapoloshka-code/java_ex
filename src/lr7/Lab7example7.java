package lr7;

import java.io.*;

class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + '\'' + ", age=" + age + '}';
    }
}

public class Lab7example7 {
    public static void main(String[] args) {
        File folder = new File("src/lr7/example7");
        if (!folder.exists()) {
            boolean created = folder.mkdirs();
            System.out.println("Создаём папку: " + folder.getAbsolutePath());
            System.out.println("Папка создана: " + created);
        }

        File file = new File(folder, "person.dat");

        // Создаём объект для сериализации
        Person person = new Person("Иван Иванов", 25);

        // Сериализация объекта в файл
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            System.out.println("Начало сериализации объекта Person в файл: " + file.getAbsolutePath());
            oos.writeObject(person);
            System.out.println("Объект Person успешно сериализован.");
        } catch (IOException e) {
            System.out.println("Ошибка при сериализации: " + e.getMessage());
        }

        // Десериализация объекта из файла
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            System.out.println("Начало десериализации объекта Person из файла: " + file.getAbsolutePath());
            Person restoredPerson = (Person) ois.readObject();
            System.out.println("Объект Person успешно десериализован.");
            System.out.println("Восстановленный объект: " + restoredPerson);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при десериализации: " + e.getMessage());
        }
    }
}