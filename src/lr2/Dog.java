package lr2;

public class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Собака лает: Гав-гав");
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Порода: " + breed);
    }
}
