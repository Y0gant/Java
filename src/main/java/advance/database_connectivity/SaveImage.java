package advance.database_connectivity;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SaveImage {
    private static final Logger logger = Logger.getLogger(SaveImage.class.getName());

    static {
        try {
            FileHandler file = new FileHandler("app.log", true);
            file.setFormatter(new SimpleFormatter());
            logger.addHandler(file);
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    String url = "jdbc:postgresql://localhost:5432/imagedb";
    String userName = "postgres";
    String passwd = "419650";
    Connection connection;
    Scanner sc = new Scanner(System.in);

    {
        try {
            connection = DriverManager.getConnection(url, userName, passwd);
        } catch (SQLException e) {
            logger.severe("Cannot connect to the database " + url + e);
        }
    }

    public static void main(String[] args) {
        SaveImage obj = new SaveImage();
        obj.saveImage();
        obj.closeConnections();
    }

    void saveImage() {
        String insertSQL = "INSERT INTO images (name, data) VALUES (?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(insertSQL);
            System.out.println("Enter image name :");
            String name = sc.nextLine();
            System.out.println("Enter image path :");
            String path = sc.nextLine();
            FileInputStream image = new FileInputStream(path);
            stmt.setString(1, name);
            stmt.setBinaryStream(2, image);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                logger.info("Image saved successfully.");
            }
            image.close();
        } catch (SQLException e) {
            logger.warning("Incorrect query " + e.getMessage() + e);
        } catch (FileNotFoundException e) {
            logger.warning("Cannot find image " + e.getMessage() + e);
        } catch (IOException e) {
            logger.warning("IOException " + e.getMessage() + e);
        }
    }

    void closeConnections() {
        try {
            connection.close();
        } catch (SQLException e) {
            logger.warning("cannot close connection " + e.getMessage() + e);
        }
        sc.close();
    }
}
