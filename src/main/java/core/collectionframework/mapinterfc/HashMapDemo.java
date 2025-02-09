package core.collectionframework.mapinterfc;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer, String> students = new HashMap<>();

        // Adding key-value pairs
        students.put(101, "Alice");
        students.put(102, "Bob");
        students.put(103, "Charlie");
        students.put(104, "David");
        students.put(105, "Eve");
        students.put(106, "Frank");

        //Printing if an object is present
        System.out.println("Does contains David ??"+students.containsValue("David"));
        // Printing the HashMap
        System.out.println("Student HashMap: " + students);
        // Accessing a value by key
        System.out.println("Student with Roll No 103: " + students.get(103));
        // Removing a key-value pair
        students.remove(104);
        System.out.println("After removing Roll No 104: " + students);
        students.remove(106,"Annie");//won't remove anything as mapped object is different

        // Iterating through the HashMap
        System.out.println("All students:");
        for (Integer key : students.keySet()) {
            System.out.println("Roll No: " + key + ", Name: " + students.get(key));
        }

        //Iterating through hashmap using entrySet(); method
        //printing key's values in upper case
        Set<Map.Entry<Integer,String>> entries = students.entrySet();

        for (Map.Entry<Integer,String> itr : entries){
            System.out.println(itr.getKey()+" : "+itr.getValue().toUpperCase());
        }
    }
}
