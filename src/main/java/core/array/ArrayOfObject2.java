package core.array;

/**
 * For this example we will create a method that
 * will take two parameters as input and will create
 * an array of that object to store the parameters
 */
public class ArrayOfObject2 {
    // instance variables to store parameters of the method we will create
    int rollno;
    String name;

    public static void main(String[] args) {
        // created a reference variable to store array of objects
        ArrayOfObject2[] obj1 = new ArrayOfObject2[5];
        //for loop to create object for each element of the array obj1
        for (int i = 0; i < obj1.length; i++) {
            obj1[i] = new ArrayOfObject2();
        }
        //passing values to each object we created in the for loop
        obj1[0].Student(1, "Atharva");
        obj1[1].Student(2, "Deva");
        obj1[2].Student(3, "Gagan");
        obj1[3].Student(4, "Abhishek");
        obj1[4].Student(5, "Jatin");

        for (int k = 0; k < obj1.length; k++) {
            System.out.println("Roll no. of Student :" + obj1[k].rollno + " name :" + obj1[k].name);
        }


    }

    //method to hold value of instance variables
    void Student(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

}
