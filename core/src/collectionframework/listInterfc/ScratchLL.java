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

    //Method to display the linked list
    public void displayLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("END");
    }

    //Find particular value
    public Node find(int value) {
        Node node = head;
        while (node.data != value) {
            node = node.next;
        }
        return node;
    }

    //Find a particular node
    public Node getReference(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    //Method to insert at beginning of the list
    public void insertAtStart(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    //Method to insert data at end using tail O(1)
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

    //Insert in between of two nodes
    public void insertAt(int value, int index) {
        if (index == 0) {
            insertAtStart(value);
            return;
        }
        if (index == size) {
            insertAtEnd(value);
            return;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(value, temp.next);
        temp.next = node;
        size++;
    }

    //Delete node from beginning
    public int deleteFirst() {
        int val = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    //Delete the last node
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

    //Delete node at particular index
    public int deleteAt(int index) {
        if (index == 0) {
            deleteFirst();

        }
        if (index == size) {
            deleteLast();
        }
        Node prev = getReference(index - 1);
        int val = prev.data;
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

        //Inserting element at start
        linky.insertAtStart(10);

        //Inserting elements at ending
        linky.insertAtEnd(20);
        linky.insertAtEnd(30);
        linky.insertAtEnd(40);
        linky.insertAtEnd(50);
        linky.insertAtEnd(60);

        //method to dislplay linked list
        linky.displayLL();

        //Insert at particular index
        linky.insertAt(80, 3);
        linky.displayLL();

        //Deletion operations

        //From beginning
        System.out.println("Value deleted from beginning :" + linky.deleteFirst() + " Size :" + linky.getSize());
        linky.displayLL();
        //From ending
        System.out.println("Value deleted from ending :" + linky.deleteLast() + " Size :" + linky.getSize());
        linky.displayLL();
        //At particular index
        System.out.println("Value deleted from index 4 :" + linky.deleteAt(3) + " Size :" + linky.getSize());
        linky.displayLL();
    }

}
