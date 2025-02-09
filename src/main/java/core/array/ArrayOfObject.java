package core.array;

/**
 * Here we created a constructor of our class ArrayOfObject
 * which creates a new object each time it is called using
 * the "new" keyword so that means when assign 1st index
 * of the reference variable for array of object that is obj1
 * to it's first index we can then initialize that object with parameters.
 */
public class ArrayOfObject {
    int roll_no;
    String name;

    // constructor of  main class with 2 parameters
    ArrayOfObject(int roll_no, String name) {
        this.name = name;
        this.roll_no = roll_no;
    }

    public static void main(String[] args) {
        ArrayOfObject[] obj1 = new ArrayOfObject[5];
        obj1[0] = new ArrayOfObject(11, "Rahul");
        obj1[1] = new ArrayOfObject(12, "Aditya");
        obj1[2] = new ArrayOfObject(13, "Dhruv");
        obj1[3] = new ArrayOfObject(14, "Abhishek");
        obj1[4] = new ArrayOfObject(15, "Yash");

        for (int i = 0; i < 5; i++)
            System.out.println("Student " + (i + 1) + " Roll no: " + obj1[i].roll_no + " name: " + obj1[i].name);
    }
}
