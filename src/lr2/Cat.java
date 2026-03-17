package lr2;

public class Cat extends Animal {
    private String color;

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    @Override
    public void makeSound() {
        System.out.println("Кошка мяукает: Мяу");
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Окрас: " + color);
    }
}
