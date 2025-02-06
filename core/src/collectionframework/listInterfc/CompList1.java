package src.collectionframework.listInterfc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class MyIntComparator implements Comparator<Integer> {

    //overriding the compare function to return list in descending order
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}

class MyStringComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        //Compare based on string size
        return o1.length() - o2.length();
    }
}

//custom class
class GreekGods {
    private String name;
    private double powerRating;

    GreekGods(String name, double powerRating) {
        this.powerRating = powerRating;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getPowerRating() {
        return powerRating;
    }
}

public class CompList1 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(List.of(23, 56, 32, 12, 33, 45, 67, 28, 86));

        System.out.println(list);
        //using method from comparator interface to sort the array list
        list.sort(null);//passing "null" will sort list in ascending order
        System.out.println("Sorted list :");
        System.out.println(list);

        System.out.println("Sorted in descending order :");
        list.sort(new MyIntComparator());//passing object of the class we created to sort list in descending
        System.out.println(list);

        List<String> stringList = new ArrayList<>();

        stringList.add("This");
        stringList.add("is");
        stringList.add("a");
        stringList.add("List");
        stringList.add("of");
        stringList.add("String");
        System.out.println(stringList);

        System.out.println("Sorting stringList based on the length of each string :");
        stringList.sort(new MyStringComparator());
        System.out.println(stringList);

        System.out.println("Sorting the stringList using lambda expression :");
        stringList.sort((a, b) -> b.length() - a.length());//using lambda expressions to sort string based on some logic
        System.out.println(stringList);


        List<GreekGods> godsList = new ArrayList<>();
        godsList.add(new GreekGods("Adonis", 45.98));
        godsList.add(new GreekGods("Hera", 98.32));
        godsList.add(new GreekGods("Hermes", 85.65));
        godsList.add(new GreekGods("Poseidon", 98.43));
        godsList.add(new GreekGods("Demeter", 88.54));
        System.out.println("Custom comparator function :");
        System.out.println("[God : Power]");
        godsList.sort((a, b) -> {
            if (b.getPowerRating() - a.getPowerRating() > 0) {
                return 1;
            }
            if (b.getPowerRating() - a.getPowerRating() < 0) {
                return -1;
            } else return 0;
        });
        for (GreekGods i : godsList) {
            System.out.println(i.getName() + " : " + i.getPowerRating());
        }
    }


}
