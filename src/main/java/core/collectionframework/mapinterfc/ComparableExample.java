package core.collectionframework.mapinterfc;

import java.util.*;

    class Student implements Comparable<Student> {
        int rollNumber;
        String name;

        public Student(int rollNumber, String name) {
            this.rollNumber = rollNumber;
            this.name = name;
        }

        @Override
        public int compareTo(Student other) {
            return this.rollNumber - other.rollNumber; // Sort by roll number (ascending)
        }

        public String toString() {
            return rollNumber + " - " + name;
        }
    }

    public class ComparableExample {
        public static void main(String[] args) {
            List<Student> students = new ArrayList<>();
            students.add(new Student(3, "Alice"));
            students.add(new Student(1, "Bob"));
            students.add(new Student(2, "Charlie"));

            Collections.sort(students); // Uses compareTo() for sorting
            System.out.println(students); // Sorted by roll number
        }
    }


