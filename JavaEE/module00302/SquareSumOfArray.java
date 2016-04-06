package module00302;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SquareSumOfArray implements SquareSum {

    List<Callable<Integer>> callables = new ArrayList<>();

    @Override
    public long getSquareSum(int[] values, int numberOfThreads) {
        int numberElementsInThread = (values.length % numberOfThreads == 0) ?
                values.length / numberOfThreads : (values.length / numberOfThreads) + 1;

        final Phaser phaser = new Phaser() {
            @Override
            protected boolean onAdvance(int phase, int parties) {
                return phase >= numberOfThreads;
            }
        };

        phaser.register();

        for (int i = 0; i < numberOfThreads; i++) {
            int finalI = i;
            System.out.println("Start registered in Phaser");
            phaser.register();

            callables.add(new Callable<Integer>() {
                int sum = 0;
                String threadName = Thread.currentThread().getName();

                @Override
                public Integer call() throws Exception {
                    System.out.println("Thread name: " + threadName + " waiting" + phaser.getRoot());
                    phaser.arriveAndAwaitAdvance();

                    int length = (finalI + 1) * numberElementsInThread;
                    int start = finalI * numberElementsInThread;

                    for (int k = start; k < length; k++) {
                        if (k < values.length)
                            sum += values[k] * values[k];
                        else break;
                    }
                    phaser.arriveAndDeregister();

                    return sum;
                }
            });
        }
        phaser.arriveAndDeregister();

        int maxSum = 0;
        ExecutorService executor = Executors.newCachedThreadPool();

        try {
            List<Future<Integer>> result = executor.invokeAll(callables);

            for (Future f : result)
                maxSum += (int) f.get();

        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Exception my");
        } finally {
            executor.shutdown();
        }

        return maxSum;
    }
}
