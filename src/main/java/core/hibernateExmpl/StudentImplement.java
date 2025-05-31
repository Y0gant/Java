package core.hibernateExmpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class StudentImplement {

    private static SessionFactory factory;

    public static void main(String[] args) {
        try {
            initSessionFactory();
            Student student = collectStudentData();
            persistStudent(student);
        } catch (Exception e) {
            System.err.println("Fatal error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }

    private static void initSessionFactory() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml") // explicitly specify config
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
    }

    private static Student collectStudentData() {
        Scanner scanner = new Scanner(System.in);
        Student st = new Student();

        try {
            System.out.print("Enter Student ID: ");
            st.setStudentId(scanner.nextInt());
            scanner.nextLine(); // consume newline

            System.out.print("Enter First Name: ");
            st.setFirstName(scanner.nextLine());

            System.out.print("Enter Last Name: ");
            st.setLastName(scanner.nextLine());

            System.out.print("Enter Major: ");
            st.setMajor(scanner.nextLine());

            System.out.print("Enter Age: ");
            st.setAge(scanner.nextByte());
            scanner.nextLine(); // consume newline

            System.out.print("Enter GPA: ");
            st.setGpa(scanner.nextDouble());

        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid input received. " + e.getMessage(), e);
        } finally {
            scanner.close();
        }

        return st;
    }

    private static void persistStudent(Student student) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(student);
            tx.commit();
            System.out.println("Student record saved successfully.");
        } catch (Exception e) {
            System.err.println("Error while persisting student: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
