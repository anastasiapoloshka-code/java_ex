package lr2;

public class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("Животное издает звук");
    }

    public void printInfo() {
        System.out.println("Имя: " + name + ", возраст: " + age);
    }
}
