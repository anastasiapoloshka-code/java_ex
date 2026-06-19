package lr6;

import java.util.Arrays;
import java.util.Random;

public class Lab06Task5 {

    public static void main(String[] args) throws InterruptedException {
        int size = 40;
        int[] array = new Random().ints(size, -100, 101).toArray();

        int cores = Runtime.getRuntime().availableProcessors();
        int threadsCount = Math.min(cores, size); // чтобы потоков не было больше, чем элементов

        System.out.println("Исходный массив: " + Arrays.toString(array));
        System.out.println("Количество потоков: " + threadsCount);

        Thread[] threads = new Thread[threadsCount];
        int[] localMax = new int[threadsCount];

        int chunkSize = (int) Math.ceil(size * 1.0 / threadsCount);

        for (int i = 0; i < threadsCount; i++) {
            final int index = i;
            final int start = index * chunkSize;
            final int end = Math.min(start + chunkSize, size);

            threads[i] = new Thread(() -> {
                int max = Integer.MIN_VALUE;
                for (int j = start; j < end; j++) {
                    if (array[j] > max) {
                        max = array[j];
                    }
                }
                localMax[index] = max;
                System.out.println(Thread.currentThread().getName()
                        + " диапазон [" + start + ";" + (end - 1) + "], локальный максимум = " + max);
            }, "MaxThread-" + (i + 1));

            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        int globalMax = Arrays.stream(localMax).max().orElse(Integer.MIN_VALUE);
        System.out.println("Глобальный максимум: " + globalMax);
    }
}