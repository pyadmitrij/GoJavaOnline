package module003;

public class MySemaphore implements Semaphore {
    private volatile int count = 0;
    final Object lock = new Object();

    public MySemaphore() {}

    public MySemaphore(int count) {
        this.count = count;
    }

    private void workOnTheThread() throws InterruptedException {
        while (true) {
            String threadName = Thread.currentThread().getName();
            if (count > 0) {
                System.out.println( threadName + " is working now. The number free resolution = " + count--);
                Thread.sleep(1000);
                break;
            }
            if (count == 0) {
                System.out.println(threadName + " is waiting");
                synchronized (lock) {
                    lock.wait();
                }
            }
        }
    }

    @Override
    public void acquire() throws InterruptedException {
        workOnTheThread();
    }

    @Override
    public void acquire(int permits) throws InterruptedException {
        if (count == 0) {
            this.count = permits;
        }
        workOnTheThread();
    }

    @Override
    public void release() {
        this.count++;
        synchronized (lock) {
            lock.notifyAll();
        }
        System.out.println("Number count: " + count);
    }

    @Override
    public void release(int permits) {
        this.count += permits;
        synchronized (lock) {
            lock.notifyAll();
        }
        System.out.println("Number count: " + count);
    }

    @Override
    public int getAvailablePermits() {
        return this.count;
    }
}
