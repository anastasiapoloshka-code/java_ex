package lr2;

public class Task4PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person("Алексей", 25, "мужской");
        Person p2 = new Person("Мария", 30, "женский");

        p1.printInfo();
        p2.printInfo();

        p1.setAge(26);
        System.out.println("После изменения возраста:");
        p1.printInfo();
    }
}
