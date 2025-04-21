package advance.database_connectivity;

import java.sql.*;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


/*
TODO
  Update User Password	    -> Allow changing a user’s password using ALTER USER SQL.
  List All Users	            -> Show all users in the database using SELECT rolname FROM pg_roles.
  Revoke Privileges	        -> Option to revoke SELECT or other privileges from a user.
  Revoke Roles	            -> Revoke assigned roles using REVOKE ... FROM ....
  View Privileges	            -> View granted roles or privileges for a user (e.g., \du equivalent).
  Create Table	            -> Allow user to create a table by entering column names/types.
  Insert / Update / Delete    -> Table Data	Enable CRUD operations on table rows.
  View Table                  -> Data	Option to SELECT * FROM table_name and display rows.
  Drop Table	                -> Allow user to delete a table from the DB.
  List Tables	                -> Show all tables using information_schema.tables or \dt.
  Backup & Restore	        -> Integrate basic support for pg_dump and restore operations (CLI-based or via code).
  Login & Role-based Menu     -> Access Build an authentication/role-based menu flow for regular users vs admins.
  Execute Custom SQL	        -> Let users run custom queries for advanced use.
  Exception Handling & Retry	-> Add retry logic on failure for robustness.
  */


public class DataBaseOps {
    private static final Logger logger = Logger.getLogger(DataBaseOps.class.getName());
    public static Scanner scanner = new Scanner(System.in);

    static {
        try {
            FileHandler fh = new FileHandler("app.log", true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final Connection connection = connectToDB();

    public static void main(String[] args) {
        while (true) {
            int num = scanner.nextByte();
            logger.info("User selected option: " + num);
            switch (num) {
                case 0 -> {
                    break;
                }
                case 1 -> {

                }
            }
        }
    }

    public static Connection connectToDB() {
        System.out.println("Enter database name :");
        String database = scanner.nextLine();
        String url = "jdbc:postgresql://localhost:5432/" + database;
        System.out.println("Enter Username :");
        String username = scanner.nextLine();
        System.out.println("Enter password for user " + username + " :");
        String passwd = scanner.nextLine();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, username, passwd);
            logger.info("Connected to database :" + database + " username :" + username);
            return connection;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error Connecting to database " + database + " using username :" + username + " " + e);
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "PostgresSQL JDBC Driver not found.");
        }
        return null;
    }

    public boolean createUser(Connection connection) {
        if (!checkSuperUser(connection) && !checkCanCreateRoles(connection)) {
            logger.severe("You do NOT have permission to create a user");
            return false;
        }

        try {
            System.out.println("Enter user name :");
            String userToAdd = scanner.nextLine();
            if (checkUser(connection, userToAdd)) {
                logger.warning("Attempted to create a user that already exists: " + userToAdd);
                return false;
            }
            System.out.println("Enter password for username :" + userToAdd);
            String passwd = scanner.nextLine();
            String addUser = "CREATE USER " + userToAdd + " WITH PASSWORD ?";
            PreparedStatement stmt2 = connection.prepareStatement(addUser);
            stmt2.setString(1, passwd);
            stmt2.executeUpdate();
            logger.info("User '" + userToAdd + "' created successfully.");
            return true;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error creating user: " + e.getMessage(), e);
        }
        return false;
    }

    public boolean deleteUser(Connection connection) {
        if (!checkSuperUser(connection) && !checkCanCreateRoles(connection)) {
            logger.warning("Permission denied for deleting users.");
            System.out.println("You do NOT have permission to delete a user");
            return false;
        }
        System.out.println("User to be deleted :");
        String userToDelete = scanner.nextLine();
        if (userToDelete.equals("postgres")) {
            logger.warning("Attempt to delete 'postgres' user denied.");
            System.out.println("Can't perform operations on this user");
            return false;
        }
        if (checkUser(connection, userToDelete)) {
            try (Statement statement = connection.createStatement()) {
                logger.info("Deleting user: " + userToDelete);
                String dropUserSQL = "DROP ROLE " + userToDelete;
                statement.execute(dropUserSQL);
                logger.info("User '" + userToDelete + "' deleted successfully.");
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Error deleting user: " + e.getMessage(), e);
            }
        }
        return false;
    }

    private boolean grantRole(Connection connection) {
        System.out.println("Enter username :");
        String userName = scanner.nextLine().trim();
        if (userName.equals("postgres")) {
            logger.warning("Attempt to grant role to 'postgres' user denied.");
            System.out.println("Can't perform operations on this user");
            return false;
        }
        if (checkUser(connection, userName)) {
            System.out.println("Enter a role to assign (or press Enter to skip):");
            String roleToGrant = scanner.nextLine().trim();
            if (!roleToGrant.isEmpty()) {
                String grantRoleSQL = "GRANT " + roleToGrant + " TO " + userName;
                try (Statement stmt = connection.createStatement()) {
                    stmt.executeUpdate(grantRoleSQL);
                    logger.info("Granted role '" + roleToGrant + "' to user '" + userName + "'");
                    System.out.println("Granted role " + roleToGrant + " to " + userName);
                    return true;
                } catch (Exception e) {
                    logger.log(Level.SEVERE, "Error granting role: " + e.getMessage(), e);
                }
            }
        }
        return false;
    }

    private boolean grantPrivileges(Connection connection) {
        System.out.println("Enter username :");
        String userName = scanner.nextLine().trim();
        if (userName.equals("postgres")) {
            logger.warning("Attempt to grant privileges to 'postgres' user denied.");
            System.out.println("Can't perform operations on this user");
            return false;
        }
        if (checkUser(connection, userName)) {
            System.out.println("Grant SELECT on which table? (or press Enter to skip):");
            String table = scanner.nextLine().trim();
            if (!table.isEmpty()) {
                String grantPrivSQL = "GRANT SELECT ON " + table + " TO " + userName;
                try (Statement stmt = connection.createStatement()) {
                    stmt.executeUpdate(grantPrivSQL);
                    logger.info("Granted SELECT on table '" + table + "' to user '" + userName + "'");
                    System.out.println("Granted SELECT on " + table + " to " + userName);
                    return true;
                } catch (Exception e) {
                    logger.log(Level.SEVERE, "Error granting SELECT privileges: " + e.getMessage(), e);
                }
            }
        }
        return false;
    }

    private boolean checkUser(Connection connection, String userName) {
        String checkIfUserExists = "SELECT 1 FROM pg_roles WHERE rolname = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(checkIfUserExists);
            stmt.setString(1, userName);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                logger.fine("User '" + userName + "' exists.");
                return true;
            } else {
                logger.fine("User '" + userName + "' does not exist.");
            }
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Error checking if user exists: " + e.getMessage(), e);
        }
        return false;
    }

    private boolean checkSuperUser(Connection connection) {
        String sql = "SELECT rolsuper FROM pg_roles WHERE rolname = current_user";
        boolean isSuperUser = false;
        try (PreparedStatement prepared = connection.prepareStatement(sql);
             ResultSet resultSet = prepared.executeQuery()) {
            if (resultSet.next()) {
                isSuperUser = resultSet.getBoolean("rolsuper");
                logger.fine("Is superuser: " + isSuperUser);
            }
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Error checking superuser permission: " + e.getMessage(), e);
        }
        return isSuperUser;
    }

    private boolean checkCanCreateRoles(Connection connection) {
        String sql = "SELECT rolcreaterole FROM pg_roles WHERE rolname = current_user";
        boolean canCreateRoles = false;
        try (PreparedStatement prepared = connection.prepareStatement(sql);
             ResultSet resultSet = prepared.executeQuery()) {
            if (resultSet.next()) {
                canCreateRoles = resultSet.getBoolean("rolcreaterole");
                logger.fine("Can create roles: " + canCreateRoles);
            }
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Error checking role creation permission: " + e.getMessage(), e);
        }
        return canCreateRoles;
    }
}
