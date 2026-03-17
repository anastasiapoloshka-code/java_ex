package lr2;

public class Task8AnimalsTest {
    public static void main(String[] args) {
        Animal dog = new Dog("Бобик", 3, "овчарка");
        Animal cat = new Cat("Мурка", 2, "рыжий");
        Animal bird = new Bird("Кеша", 1, true);

        testAnimal(dog);
        testAnimal(cat);
        testAnimal(bird);
    }

    private static void testAnimal(Animal animal) {
        animal.printInfo();
        animal.makeSound();
        System.out.println();
    }
}
