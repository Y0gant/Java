package core.collectionframework.listInterfc;

class DLL {
    int size;
    private Node head;
    private Node tail;

    public DLL() {
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    // Display the linked list
    public void displayDLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("END");
    }

    //Display in reverse
    public void displayDLLRev() {
        if (tail == null) {
            System.out.println("List is Empty");
            return;
        }
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.prev;
        }
        System.out.println("START");
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
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
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
        node.prev = tail;
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
        Node node = new Node(value, temp.next, temp);
        if (node.next != null) {
            node.next.prev = node;
        }
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
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
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
            int val = deleteFirst();
            tail = null;  // Ensure tail is also null
            return val;
        }
        int val = tail.data;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
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
        private final int data;
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


public class ScratchDLL {
    public static void main(String[] args) {

        DLL doublyLinky = new DLL();

        // Inserting at start
        doublyLinky.insertAtStart(10);

        // Inserting at end
        doublyLinky.insertAtEnd(20);
        doublyLinky.insertAtEnd(30);
        doublyLinky.insertAtEnd(40);
        doublyLinky.insertAtEnd(50);
        doublyLinky.insertAtEnd(60);

        // Display linked list
        doublyLinky.displayDLL();
        doublyLinky.displayDLLRev();

        // Insert at index 3
        doublyLinky.insertAt(80, 3);
        doublyLinky.displayDLL();

        // Deletion operations
        System.out.println("Value deleted from beginning: " + doublyLinky.deleteFirst() + " Size: " + doublyLinky.getSize());
        doublyLinky.displayDLL();

        System.out.println("Value deleted from ending: " + doublyLinky.deleteLast() + " Size: " + doublyLinky.getSize());
        doublyLinky.displayDLL();

        System.out.println("Value deleted from index 3: " + doublyLinky.deleteAt(3) + " Size: " + doublyLinky.getSize());
        doublyLinky.displayDLL();
    }


}
