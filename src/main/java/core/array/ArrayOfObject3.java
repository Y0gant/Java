package core.array;

/**
 * For this example we will create a method that
 * will take two parameters as input and will create a method
 * to create an array of that object to store the parameters
 * and assigning those values using for loop
 */
public class ArrayOfObject3 {
    // instance variables to store parameters of the method we will create
    int rollno;
    String name;

    public static void main(String[] args) {
        ArrayOfObject3 obj3 = new ArrayOfObject3();
        obj3.ArrayObject();
    }

    //method to hold value of instance variables
    void Student(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    void ArrayObject() {
        // created a reference variable to store array of objects
        ArrayOfObject3[] obj1 = new ArrayOfObject3[5];
        String[] nm = new String[]{"Aadi", "somya", "Shreyas", "rastogi", "vedant"};
        //for loop to create object for each element of the array obj1
        for (int i = 0; i < obj1.length; i++) {
            obj1[i] = new ArrayOfObject3();
            obj1[i].Student(i, nm[i]);
        }

        for (ArrayOfObject3 arrayOfObject3 : obj1) {
            System.out.println("Roll no. of Student :" + arrayOfObject3.rollno + " Name :" + arrayOfObject3.name);
        }
    }

}
