package src.OOPS;

public class Constructor {
    static int count = 0;
    int age;
    String name;

    //Default Constructor
    Constructor() {
        count++;
    }

    //Parameterized constructor 1
    Constructor(String name) {

        count++;
        System.out.println("constructor with 1 string variable :" + name);
    }

    //Parameterized constructor 2
    Constructor(int a) {

        count++;
        System.out.println("constructor with 1 int variable :" + a);
    }

    //Parameterized constructor 3
    Constructor(int a, int b) {

        count++;
        System.out.println("constructor with 2 int variables :" + a + " " + b);
    }

    //Parameterized constructor to set default values for variables
    Constructor(int age, String name) {

        count++;
        this.age = age;
        this.name = name;
    }

    // copy constructor
    Constructor(Constructor obj) {
        this.name = obj.name;
        this.age = obj.age;
        count++;
    }

    //method to print total no of instances created
    public static void get() {

        System.out.println("Total number of instances of class :" + count);
    }

    public static void main(String[] args) {
        Constructor obj1 = new Constructor(24, 25);
        Constructor obj2 = new Constructor(4);
        Constructor obj3 = new Constructor("Hello");
        Constructor obj4 = new Constructor(21, "Harsh");
        System.out.println("Default age in constructor :" + obj4.age + " & default name :" + obj4.name);
        Constructor obj5 = new Constructor(obj4);
        System.out.println("Copy constructor values :" + obj4.age + " & :" + obj4.name);
        Constructor obj = new Constructor();
        get();
    }
}
