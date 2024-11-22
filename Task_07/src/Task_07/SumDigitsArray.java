package Task_07;

import java.util.Random;
import java.util.concurrent.*;

public class SumDigitsArray {

    private static final int ARRAY_SIZE = 1_000_000;
    private static final int THREAD_COUNT = 5;
    private static final int[] array = new int[ARRAY_SIZE];
    public static void fillArray() {
        Random random = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = random.nextInt(1000); // Випадкові числа від 0 до 999
        }
    }
    public static int sumDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public static long singleThreadSum() {
        long startTime = System.currentTimeMillis();
        long totalSum = 0;
        for (int num : array) {
            totalSum += sumDigits(num);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Однопоточний підхід: Сума = " + totalSum + ", Час = " + (endTime - startTime) + " мс");
        return endTime - startTime;
    }
    public static long multiThreadSum() {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        int chunkSize = ARRAY_SIZE / THREAD_COUNT;
        Future<Long>[] results = new Future[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int start = i * chunkSize;
            final int end = (i == THREAD_COUNT - 1) ? ARRAY_SIZE : start + chunkSize;
            results[i] = executor.submit(() -> {
                long partialSum = 0;
                for (int j = start; j < end; j++) {
                    partialSum += sumDigits(array[j]);
                }
                return partialSum;
            });
        }
        long totalSum = 0;
        for (Future<Long> result : results) {
            try {
                totalSum += result.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
        long endTime = System.currentTimeMillis();
        System.out.println("Багатопоточний підхід: Сума = " + totalSum + ", Час = " + (endTime - startTime) + " мс");
        return endTime - startTime;
    }
}
