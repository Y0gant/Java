package src.OOPS;

import java.util.Scanner;

//Base class
abstract class Employee {
    //Data fields
    private int salary;
    private String name;
    private int id;

    //Constructor to initialize data fields

    Employee(String name, int id, int totalSalary) {
        this.salary = totalSalary;
        this.name = name;
        this.id = id;
    }

    //print details methods
    void printDetails() {
        System.out.println("--------------------");
        System.out.println("Name :" + name);
        System.out.println("ID :" + id);
        System.out.println("Role :" + getClass().getSimpleName());

    }

    void printDetails(int id) {
        this.id = id;
        printDetails();
    }


    void printDetails(String name) {
        this.name = name;
        printDetails();
    }

    //Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //    Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //Getter and Setter for Salary
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    abstract int calculateSalary();
}

//Subclass 1
class Manager extends Employee {
    int bonus;

    Manager(String name, int id, int salary, int bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    protected int calculateSalary() {
        return getSalary() + bonus;
    }

    @Override
    void printDetails() {
        super.printDetails();
        System.out.println("Base Salary :" + getSalary());
        System.out.println("Bonus :" + bonus);
        System.out.println("Total Salary :" + calculateSalary());
        System.out.println();
    }
}

//Subclass 2
class Developer extends Employee {
    int projectIncentives;

    Developer(String name, int id, int salary, int projectIncentives) {
        super(name, id, salary);
        this.projectIncentives = projectIncentives;
    }

    @Override
    protected int calculateSalary() {
        return getSalary() + projectIncentives;
    }

    @Override
    void printDetails() {
        super.printDetails();
        System.out.println("Base Salary :" + getSalary());
        System.out.println("Project Incentives :" + projectIncentives);
        System.out.println("Total Salary :" + calculateSalary());
        System.out.println();
    }

}

//Subclass 3
class Intern extends Employee {
    int stipend;

    Intern(String name, int id, int totalSalary) {
        super(name, id, totalSalary);
        this.stipend = totalSalary;
    }

    @Override
    protected int calculateSalary() {
        return stipend;
    }

    @Override
    void printDetails() {
        super.printDetails();
        // System.out.println("Base Salary :" + getSalary());
        System.out.println("Project Incentives :" + stipend);
        System.out.println("Total Stipend :" + calculateSalary());
        System.out.println();
    }
}

//Driver class
public class EmpManagement {

    //Method to create a dynamic object using user input
    //return type=object of the class.
    public static Employee createEmployee(String role) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter details for " + role + " :");
        System.out.println("Name :");
        String name = scanner.nextLine();
        System.out.println("ID :");
        int id = scanner.nextInt();
        System.out.println("Salary :");
        int salary = scanner.nextInt();
        if (role.equals("Manager")) {
            System.out.println("Bonus :");
            int bonus = scanner.nextInt();
            return new Manager(name, id, salary, bonus);
        } else if (role.equals("Developer")) {
            System.out.println("Project Incentives :");
            int incentives = scanner.nextInt();
            return new Developer(name, id, salary, incentives);
        } else if (role.equals("Intern")) {
            return new Intern(name, id, salary);
        } else {
            System.out.println("Invalid Input");
            return null;
        }
    }


    public static void main(String[] args) {
        Employee manager1 = new Manager("Alice", 1, 80000, 10000); // Manager 1
        Employee manager2 = new Manager("David", 4, 90000, 12000); // Manager 2
        Employee developer1 = new Developer("Bob", 2, 75000, 5000); // Developer 1
        Employee developer2 = new Developer("Eve", 5, 70000, 6000); // Developer 2
        Employee intern1 = new Intern("Charlie", 3, 15000); // Intern 1
        Employee intern2 = new Intern("Grace", 6, 20000); // Intern 2
        //Creating user defined objects
        Employee manager3 = createEmployee("Manager");
        Employee developer3 = createEmployee("Developer");
        Employee intern3 = createEmployee("Intern");

        // Printing details of all employees
        manager1.printDetails();
        manager2.printDetails();
        manager3.printDetails();
        developer1.printDetails();
        developer2.printDetails();
        developer3.printDetails();
        intern1.printDetails();
        intern2.printDetails();
        intern3.printDetails();

        // Testing Overloaded printDetails
        System.out.println("Testing overloaded printDetails method:");
        manager1.printDetails("Alfred"); // Updated Manager 1 Name
        developer2.printDetails(6345); // Updated Developer 2 ID
        manager2.printDetails("Rebecca"); // Updated Manager 2 Name
        intern1.printDetails(5567); // Updated Intern 1 ID
    }
}