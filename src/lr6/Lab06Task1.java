package lr6;

public class Lab06Task1 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new TimePrinter(), "Thread-1");
        Thread t2 = new Thread(new TimePrinter(), "Thread-2");

        t1.start();
        t2.start();

        // Ждём завершения обоих потоков
        t1.join();
        t2.join();
    }

    // Задача потока: 10 секунд печатать имя и время раз в секунду
    static class TimePrinter implements Runnable {
        @Override
        public void run() {
            long end = System.currentTimeMillis() + 10_000;
            while (System.currentTimeMillis() < end) {
                System.out.println(Thread.currentThread().getName()
                        + " : " + System.currentTimeMillis());
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }
}