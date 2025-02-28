package core.synchronization;

class SharedResource {
    private volatile boolean flag = false;

    public synchronized void setFlagTrue() {
        flag = true;
        notify();
    }

    public synchronized void printIfFlagTrue() {
        while (!flag) {
            try {
                System.out.println("Flag is false");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Flag is now set to true by writerThread");
    }
}


public class VolatileExample {
    public static void main(String[] args) {
        SharedResource obj = new SharedResource();

        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            obj.setFlagTrue();
        });

        Thread readerThread = new Thread(obj::printIfFlagTrue);

        writerThread.start();
        readerThread.start();
    }
}
