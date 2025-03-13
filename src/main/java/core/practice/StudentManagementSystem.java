package core.practice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Student2 {
    private int studentID;
    private String name;
    private int age;
    private List<Course> courses;

    public Student2(int studentID, String name, int age) {
        this.age = age;
        this.courses = new ArrayList<>();
        this.name = name;
        this.studentID = studentID;
    }

    public int getAge() {
        return age;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public String getName() {
        return name;
    }

    public int getStudentID() {
        return studentID;
    }


    public void enrollCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }


    public void dropCourse(Course course) {
        courses.remove(course);
    }

    public void viewCourse() {
        for (Course course : courses) {
            System.out.println(course);
        }
    }


    public String toString() {
        return "ID: " + studentID + ", Name: " + name + ", Age: " + age + ", Courses enrolled : " + courses.size();
    }
}

class Course {
    int courseID;
    String name;
    String instructor;

    public Course(int courseID, String name, String instructor) {
        this.courseID = courseID;
        this.instructor = instructor;
        this.name = name;
    }

    public int getCourseID() {
        return courseID;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Course ID: " + courseID + ", Name: " + name + ", Instructor: " + instructor;
    }
}

class Enrollment {
    Student2 student2;
    Course course;
    Date enrollmentDate;

    public Enrollment(Student2 student2, Course course) {
        this.student2 = student2;
        this.course = course;
        this.enrollmentDate = new Date();
    }


    public void enroll() {
        student2.enrollCourse(course);
        System.out.println(student2.getName() + " enrolled in " + course.getName());
    }

    public void unenroll() {
        student2.dropCourse(course);
        System.out.println(student2.getName() + " dropped " + course.getName());
    }

    public String toString() {
        return "Student: " + student2.getName() + ", Course: " + course.getName() + ", Date: " + enrollmentDate;
    }
}

public class StudentManagementSystem {
    private static List<Student2> students;
    private static List<Course> courses;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student");
            System.out.println("4. Drop Course");
            System.out.println("5. View Students");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");


            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Student ID: ");
                    int studentID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    students.add(new Student2(studentID, name, age));
                    break;
                }
                case 2 -> {
                    System.out.print("Enter Course ID: ");
                    int courseID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Course Name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Enter Instructor Name: ");
                    String instructor = scanner.nextLine();
                    courses.add(new Course(courseID, courseName, instructor));
                    break;
                }
               /* case 3 -> {
                    System.out.print("Enter Student ID: ");
                    int enrollStudentID = scanner.nextInt();
                    System.out.print("Enter Course ID: ");
                    int enrollCourseID = scanner.nextInt();
                    Student student2 = findStudentByID(enrollStudentID);
                    Course course = findCourseByID(enrollCourseID);
                    if (student != null && course != null) {
                        new Enrollment(student, course).enroll();
                    } else {
                        System.out.println("Invalid Student or Course ID.");
                    }
                    break;
                }*/
            }

        }

    }


}

