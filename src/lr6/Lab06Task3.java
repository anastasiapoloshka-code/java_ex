package lr6;

public class Lab06Task3 {

    public static void main(String[] args) throws InterruptedException {
        NumberPrinterTask task = new NumberPrinterTask(1, 10);

        Thread evenThread = new Thread(() -> task.printNumbers(true), "EvenThread");
        Thread oddThread  = new Thread(() -> task.printNumbers(false), "OddThread");

        evenThread.start();
        oddThread.start();

        evenThread.join();
        oddThread.join();
    }

    static class NumberPrinterTask {
        private int current;
        private final int max;
        private final Object lock = new Object();

        public NumberPrinterTask(int start, int max) {
            this.current = start;
            this.max = max;
        }

        public void printNumbers(boolean even) {
            while (true) {
                synchronized (lock) {
                    while (current <= max && (current % 2 == 0) != even) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    if (current > max) {
                        lock.notifyAll();
                        return;
                    }

                    System.out.println(Thread.currentThread().getName() + " : " + current);
                    current++;
                    lock.notifyAll();
                }
            }
        }
    }
}