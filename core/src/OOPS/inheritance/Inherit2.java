package src.OOPS.inheritance;

/**
 * Create a Person class with fields' name and age.
 * Extend it with a Student class that adds grade and a method to display all the details.
 */
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Student extends Person {
    int grade;

    Student(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }

    void display() {
        System.out.println("Student Name:" + name + " Age:" + age + " Grade:" + grade);
    }
}

public class Inherit2 {
    public static void main(String[] args) {
        Student s1 = new Student("James", 21, 80);
        s1.display();
    }
}
