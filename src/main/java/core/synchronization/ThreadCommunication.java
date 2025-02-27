package core.synchronization;

class SharedResources {
    int data;
    boolean hasData;

    public synchronized void produce(int val) {
        while (hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = val;
        hasData = true;
        System.out.println("Produced :" + val);
        notify();
    }

    public synchronized int consume() {
        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        System.out.println("Consumed :" + data);
        notify();
        return data;
    }


}

class Producer implements Runnable {
    SharedResources resources;

    Producer(SharedResources resources) {
        this.resources = resources;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            resources.produce(i);
        }
    }
}


class Consumer implements Runnable {
    SharedResources resources;

    public Consumer(SharedResources resources) {
        this.resources = resources;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            resources.consume();
        }
    }
}

public class ThreadCommunication {
    public static void main(String[] args) {
        SharedResources resources = new SharedResources();
        Thread producerThread = new Thread(new Producer(resources));
        Thread consumerThread = new Thread(new Consumer(resources));

        producerThread.start();
        consumerThread.start();

    }
}
