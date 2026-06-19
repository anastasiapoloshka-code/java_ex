package lr6;

import java.util.Arrays;
import java.util.Random;

public class Lab06Task6 {

    public static void main(String[] args) throws InterruptedException {
        int size = 40;
        int[] array = new Random().ints(size, -50, 51).toArray();

        int cores = Runtime.getRuntime().availableProcessors();
        int threadsCount = Math.min(cores, size);

        System.out.println("Исходный массив: " + Arrays.toString(array));
        System.out.println("Количество потоков: " + threadsCount);

        Thread[] threads = new Thread[threadsCount];
        long[] partialSums = new long[threadsCount];

        int chunkSize = (int) Math.ceil(size * 1.0 / threadsCount);

        for (int i = 0; i < threadsCount; i++) {
            final int index = i;
            final int start = index * chunkSize;
            final int end = Math.min(start + chunkSize, size);

            threads[i] = new Thread(() -> {
                long sum = 0;
                for (int j = start; j < end; j++) {
                    sum += array[j];
                }
                partialSums[index] = sum;
                System.out.println(Thread.currentThread().getName()
                        + " диапазон [" + start + ";" + (end - 1) + "], частичная сумма = " + sum);
            }, "SumThread-" + (i + 1));

            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        long total = Arrays.stream(partialSums).sum();
        System.out.println("Итоговая сумма элементов массива: " + total);
    }
}