package core.oops.encapsulation;

/**
 * This program contains implementation
 * of the encapsulation concept through
 * defining data as private in the Person
 * class and providing public methods to
 * access or modify the data variables.
 */
class Person {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class Encap1 {
    public static void main(String[] args) {
        Person obj = new Person();
        obj.setAge(21);
        obj.setName("Charles");
        System.out.println("Name :" + obj.getName());
        System.out.println("Age :" + obj.getAge());
    }
}
