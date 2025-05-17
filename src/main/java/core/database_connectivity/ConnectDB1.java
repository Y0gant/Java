package core.database_connectivity;

import java.sql.*;

public class ConnectDB1 {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/test";
        String userName = "postgres";
        String passwd = "419650";

        try {
            // load postgres JDBC driver
            Class.forName("org.postgresql.Driver");

            //Establish connection
            Connection connection = DriverManager.getConnection(url, userName, passwd);
            System.out.println("Connected to DataBase");

            Statement statement = connection.createStatement();

            try {
                String query = """
                        INSERT INTO person (first_name, last_name,gender, email, date_of_birth, country_of_birth) VALUES
                        ('Merry', 'Jane', 'Female', 'jane.Watson@example.com', '1985-01-25', 'United Kingdom'),
                        ('Steve', 'Rogers', 'Male', 'Captain.Rogers@example.com', '1918-07-01', 'USA');""";

                int count = statement.executeUpdate(query);
                System.out.println(
                        "Number of rows affected by this query: "
                                + count);
            } catch (SQLException e) {
                System.out.println(
                        "Query can't be executed!!"
                );
            }

            String result = "SELECT * FROM person\n" +
                    "ORDER BY id DESC";
            ResultSet resultSet = statement.executeQuery(result);

            while (resultSet.next()) {
                System.out.println(
                        "ID: " + resultSet.getLong("id") +
                                ", First Name: " + resultSet.getString("first_name") +
                                ", Last Name: " + resultSet.getString("last_name") +
                                ", Gender: " + resultSet.getString("gender") +
                                ", Email: " + resultSet.getString("email") +
                                ", Date of Birth: " + resultSet.getDate("date_of_birth") +
                                ", Country of Birth: " + resultSet.getString("country_of_birth") +
                                ", Car ID: " + resultSet.getObject("car_id") // use getObject for nullable bigint
                );
            }
            //Close connection
            connection.close();
            System.out.println("Connection closed");


        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
