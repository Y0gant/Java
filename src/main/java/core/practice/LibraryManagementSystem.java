package core.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Library {
    List<Book> books;
    List<Student> students;

    public Library() {
        this.books = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }
        System.out.println("\nAvailable Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void issueBook(int studentID, int bookID) {
        Student student = findStudentByID(studentID);
        Book book = findBookByID(bookID);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        if (!book.isAvailable()) {
            System.out.println("Book is already issued.");
            return;
        }

        student.borrowBook(book);
        System.out.println("Book issued successfully.");
    }

    public void returnBook(int studentID, int bookID) {
        Student student = findStudentByID(studentID);
        Book book = findBookByID(bookID);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        student.returnBook(book);
        System.out.println("Book returned successfully.");
    }

    Student findStudentByID(int id) {
        for (Student s : students) {
            if (s.getStudentID() == id) return s;
        }
        return null;
    }

    private Book findBookByID(int id) {
        for (Book b : books) {
            if (b.getBookID() == id) return b;
        }
        return null;
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }
        System.out.println("\nRegistered Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

class Book {
    private int bookID;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getAuthor() {
        return author;
    }

    public int getBookID() {
        return bookID;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public void borrowBook() {
        isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }

    public String toString() {
        return "Book ID: " + bookID + ", Title: " + title + ", Author: " + author + ", Available: " + isAvailable;
    }
}

class Student {
    private int studentID;
    private String name;
    private List<Book> borrowedBooks;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Book book) {
        if (!book.isAvailable()) {
            System.out.println("Book is already borrowed.");
            return;
        }
        borrowedBooks.add(book);
        book.borrowBook();
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.returnBook();
        } else {
            System.out.println("Book not found in borrowed list.");
        }
    }

    public void viewBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println(name + " has not borrowed any books.");
            return;
        }
        System.out.println("\n" + name + "'s Borrowed Books:");
        for (Book book : borrowedBooks) {
            System.out.println(book);
        }
    }

    public String toString() {
        return "Student ID: " + studentID + ", Name: " + name;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    \n1. Add Book
                    2. View Books
                    3. Add Student
                    4. View Students
                    5. Issue Book
                    6. Return Book
                    7. View Borrowed Books (by Student)
                    8. Exit
                    """);
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Book ID: ");
                    int bookID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(bookID, title, author));
                }
                case 2 -> library.viewBooks();
                case 3 -> {
                    System.out.print("Enter Student ID: ");
                    int studentID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();
                    library.addStudent(new Student(studentID, studentName));
                }
                case 4 -> library.viewStudents();
                case 5 -> {
                    System.out.print("Enter Student ID: ");
                    int studentID = scanner.nextInt();
                    System.out.print("Enter Book ID to Issue: ");
                    int issueBookID = scanner.nextInt();
                    library.issueBook(studentID, issueBookID);
                }
                case 6 -> {
                    System.out.print("Enter Student ID: ");
                    int returnStudentID = scanner.nextInt();
                    System.out.print("Enter Book ID to Return: ");
                    int returnBookID = scanner.nextInt();
                    library.returnBook(returnStudentID, returnBookID);
                }
                case 7 -> {
                    System.out.print("Enter Student ID: ");
                    int stuID = scanner.nextInt();
                    Student student = library.findStudentByID(stuID);
                    if (student != null) {
                        student.viewBorrowedBooks();
                    } else {
                        System.out.println("Student not found.");
                    }
                }
                case 8 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
