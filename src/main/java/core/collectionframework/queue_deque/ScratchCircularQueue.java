package core.collectionframework.queue_deque;


class CircularQueue {
    private static final int DEFAULT_SIZE = 10;
    protected int front = 0;
    protected int end = 0;
    protected int size = 0;
    protected int[] data;

    public CircularQueue(int size) {
        this.data = new int[size];
    }

    public CircularQueue() {
        this(DEFAULT_SIZE);
    }

    public boolean isFull() {
        return size == data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean insert(int item) {
        if (isFull()) {
            return false;
        }
        data[end++] = item;
        end = end % data.length;
        size++;
        return true;
    }

    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        int removed = data[front++];
        front = front % data.length;
        size--;
        return removed;
    }

    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return data[front];


    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        int i = front;
        do {
            System.out.print(data[i] + " <- ");
            i = (i + 1) % data.length;
        } while (i != end);

        System.out.println("END");
    }


}


public class ScratchCircularQueue {
    public static void main(String[] args) throws Exception {
        CircularQueue queue = new CircularQueue(5);
        queue.insert(2);
        queue.insert(34);
        queue.insert(22);
        queue.insert(56);
        queue.insert(7);
        System.out.println(queue.insert(10));

        System.out.println(queue.front());
        queue.display();

        System.out.println(queue.remove());
        System.out.println(queue.insert(10));
        queue.display();
    }
}
