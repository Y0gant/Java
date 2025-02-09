package core.collectionframework.listInterfc;

class CLL {
    int size;
    private Node head;
    private Node tail;

    public CLL() {
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    // Display the linked list
    public void displayLL() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("END");
    }


    // Find a particular value
    public Node find(int value) {
        if (head == null) return null;
        Node node = head;
        do {
            if (node.data == value) {
                return node;
            }
            node = node.next;
        } while (node != head);
        return null;
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
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        tail.next = head;
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
        tail.next = head;
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
        if (size == 1) {
            head = null;
            tail = null;
            size = 0;
            return val;
        }
        if (head == tail) { // Only one element
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head;
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
        tail.next = head;
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
        private final int data;
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

public class ScratchCLL {
    public static void main(String[] args) {
        CLL circularLinky = new CLL();

        // Inserting at start
        circularLinky.insertAtStart(10);

        // Inserting at end
        circularLinky.insertAtEnd(20);
        circularLinky.insertAtEnd(30);
        circularLinky.insertAtEnd(40);
        circularLinky.insertAtEnd(50);
        circularLinky.insertAtEnd(60);

        // Display linked list
        circularLinky.displayLL();

        // Insert at index 3
        circularLinky.insertAt(80, 3);
        circularLinky.displayLL();

        // Deletion operations
        System.out.println("Value deleted from beginning: " + circularLinky.deleteFirst() + " Size: " + circularLinky.getSize());
        circularLinky.displayLL();

        System.out.println("Value deleted from ending: " + circularLinky.deleteLast() + " Size: " + circularLinky.getSize());
        circularLinky.displayLL();

        System.out.println("Value deleted from index 3: " + circularLinky.deleteAt(3) + " Size: " + circularLinky.getSize());
        circularLinky.displayLL();
    }

}
