package lr7;

import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fullName;
    private int age;
    private double averageGrade;

    public Student(String fullName, int age, double averageGrade) {
        this.fullName = fullName;
        this.age = age;
        this.averageGrade = averageGrade;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", averageGrade=" + averageGrade +
                '}';
    }
}

public class Lab7Task8 {
    public static void main(String[] args) {
        File folder = new File("src/lr7/task8");
        if (!folder.exists()) {
            boolean created = folder.mkdirs();
            System.out.println("Создаём папку: " + folder.getAbsolutePath());
            System.out.println("Папка создана: " + created);
        }

        File file = new File(folder, "student.dat");

        // Создаём объект класса Student
        Student student = new Student("Иван Иванов", 22, 4.5);

        // Сериализация объекта Student в файл
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            System.out.println("Начало сериализации объекта Student в файл: " + file.getAbsolutePath());
            oos.writeObject(student);
            System.out.println("Объект Student успешно сериализован.");
        } catch (IOException e) {
            System.out.println("Ошибка при сериализации: " + e.getMessage());
        }

        // Десериализация объекта Student из файла
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            System.out.println("Начало десериализации объекта Student из файла: " + file.getAbsolutePath());
            Student restoredStudent = (Student) ois.readObject();
            System.out.println("Объект Student успешно десериализован.");
            System.out.println("Восстановленный объект: " + restoredStudent);
            System.out.println("ФИО: " + restoredStudent.getFullName());
            System.out.println("Возраст: " + restoredStudent.getAge());
            System.out.println("Средний балл: " + restoredStudent.getAverageGrade());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при десериализации: " + e.getMessage());
        }
    }
}