package src.collectionframework.listInterfc;

class CDLL {
    int size;
    private Node head;
    private Node tail;

    public CDLL() {
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    // Display the linked list
    public void displayDLL() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        } while (temp != head);
        System.out.println("END");
    }

    //Display in reverse
    public void displayDLLRev() {
        if (tail == null) {
            System.out.println("List is Empty");
            return;
        }
        Node temp = tail;
        do {
            System.out.print(temp.data + "<->");
            temp = temp.prev;
        } while (temp != tail);
        System.out.println("START");
    }


    // Find a particular value
    public Node find(int value) {
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
        Node node;
        if (index < size / 2) { // Start from head if index is in first half
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else { // Start from tail if index is in second half
            node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    // Insert at beginning
    public void insertAtStart(int value) {
        Node node = new Node(value);

        if (size == 0) {
            head = node;
            tail = node;
            head.next = head; // Circular connection
            head.prev = head;
        } else {
            node.next = head;
            node.prev = tail;
            head.prev = node;
            tail.next = node;
            head = node;
        }
        size++;
    }


    // Insert at end using tail O(1)
    public void insertAtEnd(int value) {

        Node node = new Node(value);

        if (size == 0) {
            head = node;
            tail = node;
            head.next = head;
            head.prev = head;
        } else {
            node.next = head;
            node.prev = tail;
            head.prev = node;
            tail.next = node;
            tail = node;
        }
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
        Node node = new Node(value, temp.next, temp);
        node.next.prev = node;
        temp.next = node;
        size++;
    }

    // Delete first node
    public int deleteFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        int val = head.data;
        if (head == tail) { // Only one node in the list
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
        size--;
        return val;
    }

    // Delete last node
    public int deleteLast() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        if (head == tail) {
            return deleteFirst();
        }
        int val = tail.data;
        tail = tail.prev;
        tail.next = head;
        head.prev = tail;
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
        Node toDelete = getReference(index);
        int val = toDelete.data;
        toDelete.prev.next = toDelete.next;
        if (toDelete.next != null) {
            toDelete.next.prev = toDelete.prev;
        }

        size--;
        return val;
    }

    private static class Node {
        private int data;
        private Node next;
        private Node prev;

        public Node(int data) {
            this.data = data;
        }

        Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
}

public class ScratchDCLL {
    public static void main(String[] args) {

        CDLL circularDoublyLinky = new CDLL();

        // Inserting at start
        circularDoublyLinky.insertAtStart(10);

        // Inserting at end
        circularDoublyLinky.insertAtEnd(20);
        circularDoublyLinky.insertAtEnd(30);
        circularDoublyLinky.insertAtEnd(40);
        circularDoublyLinky.insertAtEnd(50);
        circularDoublyLinky.insertAtEnd(60);

        // Display linked list
        circularDoublyLinky.displayDLL();
        circularDoublyLinky.displayDLLRev();

        // Insert at index 3
        circularDoublyLinky.insertAt(80, 3);
        circularDoublyLinky.displayDLL();

        // Deletion operations
        System.out.println("Value deleted from beginning: " + circularDoublyLinky.deleteFirst() + " Size: " + circularDoublyLinky.getSize());
        circularDoublyLinky.displayDLL();

        System.out.println("Value deleted from ending: " + circularDoublyLinky.deleteLast() + " Size: " + circularDoublyLinky.getSize());
        circularDoublyLinky.displayDLL();

        System.out.println("Value deleted from index 3: " + circularDoublyLinky.deleteAt(3) + " Size: " + circularDoublyLinky.getSize());
        circularDoublyLinky.displayDLL();
    }


}
