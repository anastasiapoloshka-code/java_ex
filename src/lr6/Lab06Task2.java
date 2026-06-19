package lr6;

public class Lab06Task2 {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new NumberPrinter(), "NumberThread");
        t.start();
        t.join();
    }

    static class NumberPrinter implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
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