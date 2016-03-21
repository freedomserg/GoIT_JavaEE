package syrotskyi.module3.multithreading.semaphore;

public class SemaphoreImpl implements Semaphore {
    private volatile int permitsCounter;

    public SemaphoreImpl(int permitsCounter) {
        if (permitsCounter < 0) {
            throw new IllegalArgumentException(permitsCounter + " < 0");
        }
        this.permitsCounter = permitsCounter;
    }

    @Override
    public void acquire() {
        synchronized (this) {
            while (permitsCounter == 0) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            permitsCounter--;
        }
    }

    @Override
    public void acquire(int permits) {
        synchronized (this) {
            while (permitsCounter < permits) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            permitsCounter -= permits;
        }

    }

    @Override
    public void release() {
        synchronized (this) {
            this.notifyAll();
            permitsCounter++;
        }
    }

    @Override
    public void release(int permits) {
        synchronized (this) {
            this.notifyAll();
            permitsCounter += permits;
        }
    }

    @Override
    public int getAvailablePermits() {
        return permitsCounter;
    }
}
