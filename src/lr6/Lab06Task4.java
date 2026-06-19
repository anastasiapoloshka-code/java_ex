package lr6;

public class Lab06Task4 {

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            int threadNumber = i + 1;
            threads[i] = new Thread(() ->
                    System.out.println("Поток номер: " + threadNumber),
                    "Thread-" + threadNumber
            );
            threads[i].start();
        }

        // Ждём завершения всех 10 потоков
        for (Thread t : threads) {
            t.join();
        }
    }
}