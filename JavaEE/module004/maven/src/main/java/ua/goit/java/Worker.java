package ua.goit.java;

public class Worker {
    private MySemaphore mySemaphore;
    private int count = 0;

    public Worker(int count ) {
        this.count = count;
    }

    public void test() throws InterruptedException {
        mySemaphore = new MySemaphore(count);

        for (int i = 0; i < 10; i++) {
            if (mySemaphore.getAvailablePermits() >= 0) {
                new Thread(new RunWorker()).start();
            }
        }
    }

    public class RunWorker implements Runnable {

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            try {
                System.out.println("The " + threadName + " start");
                mySemaphore.acquire();
                mySemaphore.release();
                System.out.println("The " + threadName + " is ending work");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            new Worker(5).test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
