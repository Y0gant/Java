package src.collectionframework.listInterfc;

class LL {
    int size;
    private Node head;
    private Node tail;

    public LL() {
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    // Display the linked list
    public void displayLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("END");
    }

    // Find a particular value
    public Node find(int value) {
        Node node = head;
        while (node != null) { // Check for null to prevent infinite loop
            if (node.data == value) {
                return node;
            }
            node = node.next;
        }
        return null; // Return null if value not found
    }

    // Get reference to node at given index
    public Node getReference(int index) {
        if (index < 0 || index >= size) { // Prevent out-of-bounds access
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node node = head;
        for (int i = 0; i < index; i++) { // Loop correctly
            node = node.next;
        }
        return node;
    }

    // Insert at beginning
    public void insertAtStart(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    // Insert at end using tail O(1)
    public void insertAtEnd(int value) {
        if (tail == null) {
            insertAtStart(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size++;
    }

    // Insert at specific index
    public void insertAt(int value, int index) {
        if (index < 0 || index > size) { // Check bounds
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            insertAtStart(value);
            return;
        }
        if (index == size) {
            insertAtEnd(value);
            return;
        }
        Node temp = getReference(index - 1);
        Node node = new Node(value, temp.next);
        temp.next = node;
        size++;
    }

    // Delete first node
    public int deleteFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        int val = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    // Delete last node
    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }
        Node secondLast = getReference(size - 2);
        int val = tail.data;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    // Delete at specific index
    public int deleteAt(int index) {
        if (index < 0 || index >= size) { // Check bounds
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }
        Node prev = getReference(index - 1);
        int val = prev.next.data;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}

public class ScratchLL {
    public static void main(String[] args) {
        LL linky = new LL();

        // Inserting at start
        linky.insertAtStart(10);

        // Inserting at end
        linky.insertAtEnd(20);
        linky.insertAtEnd(30);
        linky.insertAtEnd(40);
        linky.insertAtEnd(50);
        linky.insertAtEnd(60);

        // Display linked list
        linky.displayLL();

        // Insert at index 3
        linky.insertAt(80, 3);
        linky.displayLL();

        // Deletion operations
        System.out.println("Value deleted from beginning: " + linky.deleteFirst() + " Size: " + linky.getSize());
        linky.displayLL();

        System.out.println("Value deleted from ending: " + linky.deleteLast() + " Size: " + linky.getSize());
        linky.displayLL();

        System.out.println("Value deleted from index 3: " + linky.deleteAt(3) + " Size: " + linky.getSize());
        linky.displayLL();
    }
}
