package core.oops.inheritance;

/**
 * Write a program where the Animal class has a method eat() and the Dog class inherits it.
 * Add a method bark() in the Dog class and call both methods using the Dog class object.
 */
class Animal {
    void eat() {
        System.out.println("Animal eats");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}

public class Inherit1 {
    public static void main(String[] args) {
        Dog d1 = new Dog();
        d1.eat();
        d1.bark();
    }
}
