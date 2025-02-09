package core.collectionframework.listInterfc;

import java.util.LinkedList;
import java.util.List;

public class LinkdLst1 {
    public static void main(String[] args) {
        /* Can also reference with "List" interface but can only access
        the methods in list interface so it's referenced using "LinkedList" class
        so that we can access methods of linkedlist class. */
        LinkedList<Integer> list1 = new LinkedList<>();

        list1.add(11);
        list1.add(12);
        list1.add(13);
        list1.add(14);
        list1.add(15);
        System.out.println(list1);

        list1.add(3, 20);
        list1.addFirst(10);
        list1.addLast(16);
        System.out.println("First element of list is :" + list1.getFirst());
        System.out.println("Last element of list is :" + list1.getLast());
        System.out.println(list1);
        System.out.println("Size of list =" + list1.size());
        list1.set(4, 8);
        System.out.println(list1);

        list1.remove(Integer.valueOf(15));
        list1.removeFirst();
        list1.removeLast();
        System.out.println(list1);
        list1.removeAll(List.of(11, 14, 16));
        System.out.println(list1);
        list1.clear();
        System.out.println(list1);


    }
}
