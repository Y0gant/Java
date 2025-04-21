package advance.database_connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DataBaseOps {
    Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        DataBaseOps db = new DataBaseOps();
        Connection connection = db.connectToDB();
        try {
            Statement statement = connection.createStatement();
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }

    }

    public Connection connectToDB() {
        System.out.println("Enter database name :");
        String database = scanner.nextLine();
        String url = "jdbc:postgresql://localhost:5432/" + database;
        System.out.println("Enter Username :");
        String username = scanner.nextLine();
        System.out.println("Enter password for user " + username + " :");
        String passwd = scanner.nextLine();
        try {
            Class.forName("org.postgresql.Driver");//Don't need to explicitly declare this after java6+
            Connection connection = DriverManager.getConnection(url, username, passwd);
            System.out.println("Connected to database :" + database + " username :" + username);
            return connection;
        } catch (SQLException e) {
            System.out.println("Error Connecting to database " + database + " using username :" + username);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("PostgresSQL JDBC Driver not found.");
            e.printStackTrace();
        }
        return null;
    }
}
