package core.collectionframework.listInterfc;

import java.util.ArrayList;

class Stack {
    private static final int DEFAULT_SIZE = 10;
    protected ArrayList<Integer> data;
    private int ptr = -1;

    Stack(int size) {
        this.data = new ArrayList<>(size);
    }

    Stack() {
        this(DEFAULT_SIZE);
    }

    public void display() {
        for (Integer datum : data) {
            System.out.print(datum + " ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return ptr == -1;
    }

    public void push(int item) {
        ptr++;
        data.add(item);
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Cannot pop from an Empty Stack!!!");
        }
        return data.remove(ptr--);
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Cannot peek from an Empty Stack!!!");
        }
        return data.get(ptr);
    }
}

public class ScratchStack {
    public static void main(String[] args) throws Exception {
        Stack stc = new Stack();

        stc.push(10);
        stc.push(20);
        stc.push(30);
        stc.push(40);
        stc.push(50);

        stc.display();

        System.out.println("Popped: " + stc.pop());
        System.out.println("Peek: " + stc.peek());

        stc.display();
    }
}
