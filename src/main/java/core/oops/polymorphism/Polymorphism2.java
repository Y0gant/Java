package core.oops.polymorphism;

//Polymorphism using method overriding
class Person {
    public void printDetails() {
        System.out.println("In " + this.getClass().getSimpleName() + " class current object is a Person");
    }
}

class Father extends Person {
    @Override
    public void printDetails() {
        System.out.println("In " + this.getClass().getSimpleName() + " class current object is a Father");
    }
}

class Friend extends Person {
    @Override
    public void printDetails() {
        System.out.println("In " + this.getClass().getSimpleName() + " class current object is a Friend");
    }
}

//driver class
public class Polymorphism2 {
    public static void main(String[] args) {
        Person obj = new Person();
        Person obj2 = new Father();
        Person obj3 = new Friend();
        obj.printDetails();
        obj2.printDetails();
        obj3.printDetails();
    }
}
