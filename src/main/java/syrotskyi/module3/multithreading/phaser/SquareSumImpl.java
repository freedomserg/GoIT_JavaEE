package syrotskyi.module3.multithreading.phaser;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class SquareSumImpl implements SquareSum {
    private List<Callable<Long>> tasks = new ArrayList<>();
    private final Phaser phaser = new Phaser();
    private ExecutorService executor;
    private List<Future<Long>> results;
    private long ultimateSum;

    @Override
    public long getSquareSum(int[] values, int numberOfThreads) {
        IntStream.range(0, numberOfThreads).forEach(i -> {
            tasks.add(() -> {
                int registered = phaser.register();
                //System.out.println(Thread.currentThread().getName() + " registered, phase # " + registered);

                long intermediateSum = 0;
                int startPos = (values.length * i) / numberOfThreads;
                int endPos = (values.length * (i + 1)) / numberOfThreads;
                for (int j = startPos; j < endPos; j++) {
                    intermediateSum += Math.pow(values[j], 2);
                }

                //int phase = phaser.getPhase();
                phaser.arriveAndAwaitAdvance();
                //System.out.println(Thread.currentThread().getName() + " arriveAndAwaitAdvance"
                        //+ " phase # " + phase + " finished");
                //boolean isTerminated = phaser.isTerminated();
                //System.out.println(Thread.currentThread().getName() + " phaser is terminated " + isTerminated);

                //Thread.sleep(1000);
                phaser.arriveAndDeregister();
                //System.out.println(Thread.currentThread().getName() + " arriveAndDeregister");

                //isTerminated = phaser.isTerminated();
                //System.out.println(Thread.currentThread().getName() + "phaser is terminated " + isTerminated);

                return intermediateSum;
            });
        });

        executor = Executors.newFixedThreadPool(numberOfThreads);
        try {
            results = executor.invokeAll(tasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Future future : results) {
            try {
                ultimateSum += (long)future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();

        return ultimateSum;
    }

    public static void main(String[] args) {
        int[] digits = new int[32];
        Random random = new Random();
        IntStream.range(0, digits.length).forEach(i -> {
            digits[i] = random.nextInt(100);
        });
        long res = new SquareSumImpl().getSquareSum(digits, 4);
        System.out.println(res);
    }
}
