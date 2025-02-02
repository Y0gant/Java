package src.OOPS.polymorphism;

// This program shows how methods are
// dynamically dispatched according to the object of
// the reference variable.
// (Dynamic Method Dispatch)
// Anonymous objects.
class A {
    void show() {
        System.out.println("In class A Method show()");
    }
}

class B extends A {
    @Override
    void show() {
        System.out.println("In class B Method show()");
    }
}

class C extends A {
    @Override
    void show() {
        System.out.println("In class C Method show()");
    }
}

public class Polymorphism3 {
    public static void main(String[] args) {
        //object type for reference variable "obj" is of Class A
        // And object that is being created is also of class A
        A obj = new A();
        obj.show();
        //Assigning "obj" new object of class B
        obj = new B();
        obj.show();
        // Again assigning "obj" new object of class c
        obj = new C();
        obj.show();

        //Anonymous Objects
        System.out.println("From anonymous object :");
        new A();
        //using anonymous object to call methods in the respective classes
        new B().show();
        new C().show();


    }
}
