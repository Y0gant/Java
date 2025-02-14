package core.collectionframework.queue_deque;

import java.util.ArrayDeque;

public class DequeDemo {
    public static void main(String[] args) {
        // Creating an ArrayDeque
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        // Adding elements
        deque.add(10);             // Adds at the end
        deque.addFirst(5);         // Adds at the front
        deque.addLast(15);         // Adds at the end
        deque.offer(20);           // Adds at the end
        deque.offerFirst(1);       // Adds at the front
        deque.offerLast(25);       // Adds at the end

        System.out.println("Deque after additions: " + deque);

        // Removing elements
        deque.remove();            // Removes first element
        deque.removeFirst();       // Removes first element
        deque.removeLast();        // Removes last element
        System.out.println("Deque after removals: " + deque);

        // Polling (similar to remove but returns null if empty)
        System.out.println("Polled first: " + deque.pollFirst());
        System.out.println("Polled last: " + deque.pollLast());

        // Retrieving elements (without removing)
        System.out.println("First Element: " + deque.getFirst());
        System.out.println("Last Element: " + deque.getLast());

        // Checking elements
        System.out.println("Contains 10? " + deque.contains(10));

        // Iterating through elements
        System.out.print("Deque elements: ");
        for (int num : deque) {
            System.out.print(num + " ");
        }

        // Clearing the deque
        deque.clear();
        System.out.println("\nIs deque empty? " + deque.isEmpty());
    }
}
