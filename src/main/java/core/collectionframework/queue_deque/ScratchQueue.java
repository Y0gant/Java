package core.collectionframework.queue_deque;

class CustomQueue {
    private static final int DEFAULT_SIZE = 10;
    private final int[] data;
    int end = 0;

    public CustomQueue(int size) {
        this.data = new int[size];
    }

    public CustomQueue() {
        this(DEFAULT_SIZE);
    }

    public boolean isFull() {
        return end == data.length;
    }

    public boolean isEmpty() {
        return end == 0;
    }

    public boolean insertItem(int item) {
        if (isFull()) {
            return false;
        }
        data[end++] = item;
        return true;
    }

    public int removeItem() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        int removed = data[0];
        //shift elements to left
        for (int i = 1; i < end; i++) {
            data[i - 1] = data[i];
        }
        end--;
        return removed;
    }

    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty ");
        }
        return data[0];
    }

    public void display() {
        for (int i = 0; i < end; i++) {
            System.out.print(data[i] + "<-");
        }
        System.out.println("END");
    }
}

public class ScratchQueue {
    public static void main(String[] args) throws Exception {

        CustomQueue queue = new CustomQueue(15);
        queue.insertItem(23);
        queue.insertItem(25);
        queue.insertItem(44);
        queue.insertItem(12);
        queue.insertItem(34);
        queue.insertItem(53);
        queue.insertItem(21);
        queue.insertItem(43);
        queue.insertItem(12);
        System.out.println("First item :" + queue.front());
        queue.display();
        System.out.println("Removed item :" + queue.removeItem());
        queue.display();
        System.out.println("Removed item :" + queue.removeItem());
        queue.display();
        System.out.println("Removed item :" + queue.removeItem());
        queue.display();
        System.out.println("Removed item :" + queue.removeItem());
        queue.display();
        System.out.println("Removed item :" + queue.removeItem());
        queue.display();
        System.out.println("Removed item :" + queue.removeItem());
        queue.display();
        System.out.println("Removed item :" + queue.removeItem());
        queue.display();
        System.out.println("Removed item :" + queue.removeItem());
        queue.display();
        System.out.println("Removed item :" + queue.removeItem());
        queue.display();
        queue.removeItem();//Will throw exception

    }
}
