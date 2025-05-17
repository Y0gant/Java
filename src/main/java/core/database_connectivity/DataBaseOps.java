package core.database_connectivity;

import java.sql.*;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class DataBaseOps {
    private static final Logger logger = Logger.getLogger(DataBaseOps.class.getName());
    private static final Scanner scanner = new Scanner(System.in);

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

        DataBaseOps dbOps = new DataBaseOps();

        while (true) {
            System.out.println("""
                        \n========= Database Operations Menu =========
                        1. Create User
                        2. Delete User
                        3. Update User Password
                        4. View Privileges
                        5. Create Table
                        6. View Table
                        7. View Table (Limited)
                        8. Insert Into Table
                        9. Revoke Role
                        10. Revoke Privilege
                        11. List All Users
                        12. Delete Table
                        0. Exit
                    """);

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> dbOps.createUser();
                case 2 -> dbOps.deleteUser();
                case 3 -> dbOps.updatePassword();
                case 4 -> dbOps.viewPrivileges();
                case 5 -> dbOps.createTableFromUserInput();
                case 6 -> dbOps.viewTable();
                case 7 -> dbOps.viewTableLimited();
                case 8 -> dbOps.insertIntoTable();
                case 9 -> dbOps.revokeRoles();
                case 10 -> dbOps.revokePrivileges();
                case 11 -> dbOps.listAllUsers();
                case 12 -> dbOps.deleteTable();
                case 0 -> {
                    System.out.println("Exiting program. Goodbye!");
                    dbOps.closeConnection();
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static Connection connectToDB() {
        Connection conn;
        int attempts = 0;
        final int MAX_ATTEMPTS = 3;

        while (attempts < MAX_ATTEMPTS) {
            attempts++;

            System.out.println("Enter database name:");
            String database = scanner.nextLine();
            String url = "jdbc:postgresql://localhost:5432/" + database;

            System.out.println("Enter Username:");
            String username = scanner.nextLine();

            System.out.println("Enter password for user " + username + ":");
            String passwd = scanner.nextLine();

            try {
                conn = DriverManager.getConnection(url, username, passwd);
                logger.info("Connected to database: " + database + " with username: " + username);
                System.out.println("Connection established successfully.");
                return conn;
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Error connecting to database " + database + " using username: " + username, e);
                System.out.println("Connection failed: " + e.getMessage());

                if (attempts < MAX_ATTEMPTS) {
                    System.out.println("Attempt " + attempts + " of " + MAX_ATTEMPTS + ". Please try again.");
                    try {
                        Thread.sleep(attempts * 1000L);
                    } catch (InterruptedException ex) {
                        logger.warning("Error at connection timeout logic" + e.getMessage() + e);
                    }
                }
            }
        }

        logger.severe("Failed to connect to database after " + MAX_ATTEMPTS + " attempts.");

        return null;
    }

    public boolean customQuery() {
        String custom = scanner.nextLine();
        if (connection != null) {
            try (Statement stmt = connection.createStatement()) {
                stmt.execute(custom);
                logger.info("Custom query executed successfully.");
                return true;
            } catch (SQLException e) {
                logger.severe("Error while executing custom query " + e.getMessage() + e);
            }
        }
        return false;
    }


    public boolean tableExists(String tableName) {
        String sql = "SELECT EXISTS (SELECT FROM information_schema.tables WHERE table_name = ?)";
        if (connection != null) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, tableName);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getBoolean(1);
                }
            } catch (SQLException e) {
                logger.warning("Error checking table existence: " + e.getMessage());
            }
        }
        return false;
    }

    public void createTableFromUserInput() {
        System.out.print("Enter table name: ");
        String tableName = scanner.nextLine();

        System.out.print("Enter number of columns: ");
        int columnCount = scanner.nextInt();
        scanner.nextLine();

        StringBuilder query = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        query.append(tableName).append(" (");

        for (int i = 1; i <= columnCount; i++) {
            System.out.print("Enter column " + i + " name: ");
            String columnName = scanner.nextLine();

            System.out.print("Enter column " + i + " type (e.g., VARCHAR(100), INT, SERIAL): ");
            String columnType = scanner.nextLine();

            System.out.print("Enter constraints for column " + i + " (e.g., NOT NULL, PRIMARY KEY) or press Enter to skip: ");
            String constraint = scanner.nextLine();

            query.append(columnName).append(" ").append(columnType);
            if (!constraint.isEmpty()) {
                query.append(" ").append(constraint);
            }

            if (i != columnCount) {
                query.append(", ");
            }
        }

        query.append(");");

        if (connection != null) {
            try (Statement stmt = connection.createStatement()) {
                stmt.executeUpdate(query.toString());
                logger.info("Table '" + tableName + "' created successfully.");
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Failed to create table: " + e.getMessage(), e);
            }
        } else {
            logger.warning("No active database connection.");
        }
    }

    public void insertIntoTable() {
        System.out.print("Enter table name: ");
        String tableName = scanner.nextLine();

        System.out.print("Enter number of columns: ");
        int columnCount = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String[] columns = new String[columnCount];
        String[] values = new String[columnCount];

        for (int i = 0; i < columnCount; i++) {
            System.out.print("Enter column name " + (i + 1) + ": ");
            columns[i] = scanner.nextLine();

            System.out.print("Enter value for " + columns[i] + ": ");
            values[i] = scanner.nextLine();
        }

        String columnPart = String.join(", ", columns);
        String valuePlaceholders = String.join(", ", Collections.nCopies(columnCount, "?"));

        String sql = "INSERT INTO " + tableName + " (" + columnPart + ") VALUES (" + valuePlaceholders + ")";

        if (connection != null) {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                for (int i = 0; i < columnCount; i++) {
                    stmt.setString(i + 1, values[i]);
                }
                stmt.executeUpdate();
                System.out.println("Data inserted successfully.");
            } catch (SQLException e) {
                System.out.println("Error inserting data: " + e.getMessage());
            }
        }
    }

    public boolean updateTableRow() {
        System.out.println("Enter table name to update:");
        String tableName = scanner.nextLine();

        if (!tableExists(tableName)) {
            logger.warning("Table '" + tableName + "' does not exist.");
            return false;
        }

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT column_name, data_type, is_identity " +
                     "FROM information_schema.columns " +
                     "WHERE table_name = '" + tableName + "' " +
                     "ORDER BY ordinal_position")) {

            System.out.println("Available columns in table '" + tableName + "':");
            while (rs.next()) {
                String colName = rs.getString("column_name");
                String dataType = rs.getString("data_type");
                String isIdentity = rs.getString("is_identity");

                if (isIdentity.equals("YES")) {
                    System.out.println(colName + " (" + dataType + ", PRIMARY KEY) - cannot be updated");
                } else {
                    System.out.println(colName + " (" + dataType + ")");
                }
            }

            System.out.println("\nEnter column name to use in WHERE condition (to identify row):");
            String whereColumn = scanner.nextLine();

            System.out.println("Enter value to match in WHERE condition:");
            String whereValue = scanner.nextLine();

            System.out.println("Enter column name to update:");
            String updateColumn = scanner.nextLine();

            System.out.println("Enter new value for column '" + updateColumn + "':");
            String newValue = scanner.nextLine();

            String updateSQL = "UPDATE " + tableName + " SET " + updateColumn + " = ? WHERE " + whereColumn + " = ?";

            try (PreparedStatement pstmt = connection.prepareStatement(updateSQL)) {
                pstmt.setString(1, newValue);
                pstmt.setString(2, whereValue);

                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println(rowsAffected + " row(s) updated.");
                    logger.info("Updated " + rowsAffected + " row(s) in table '" + tableName +
                            "', set " + updateColumn + " = '" + newValue + "' where " +
                            whereColumn + " = '" + whereValue + "'");
                    return true;
                } else {
                    System.out.println("No rows matched the criteria. Nothing updated.");
                    logger.info("No rows updated in table '" + tableName +
                            "' where " + whereColumn + " = '" + whereValue + "'");
                    return false;
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error updating row in table '" + tableName + "'", e);
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteTableRow() {
        System.out.println("Enter table name to delete from:");
        String tableName = scanner.nextLine();

        if (!tableExists(tableName)) {
            logger.warning("Table '" + tableName + "' does not exist.");
            return false;
        }

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT column_name, data_type, is_identity, is_nullable " +
                     "FROM information_schema.columns " +
                     "WHERE table_name = '" + tableName + "' " +
                     "ORDER BY ordinal_position")) {

            System.out.println("Table columns (use these to identify row to delete):");
            while (rs.next()) {
                String colName = rs.getString("column_name");
                String dataType = rs.getString("data_type");
                String isIdentity = rs.getString("is_identity");
                String isNullable = rs.getString("is_nullable");

                System.out.println(colName + " (" + dataType +
                        (isIdentity.equals("YES") ? ", PRIMARY KEY" : "") +
                        (isNullable.equals("NO") ? ", NOT NULL" : "") + ")");
            }

            System.out.println("\nEnter column name to use in WHERE condition:");
            String whereColumn = scanner.nextLine();

            System.out.println("Enter value to match in WHERE condition:");
            String whereValue = scanner.nextLine();

            String deleteSQL = "DELETE FROM " + tableName + " WHERE " + whereColumn + " = ?";

            try (PreparedStatement pstmt = connection.prepareStatement(deleteSQL)) {
                pstmt.setString(1, whereValue);

                System.out.println("This will delete all rows where " + whereColumn + " = '" + whereValue + "'");
                System.out.println("Are you sure? (yes/no)");
                String confirm = scanner.nextLine();

                if (!confirm.equalsIgnoreCase("yes")) {
                    System.out.println("Operation cancelled.");
                    return false;
                }

                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println(rowsAffected + " row(s) deleted.");
                    logger.info("Deleted " + rowsAffected + " row(s) from table '" + tableName +
                            "' where " + whereColumn + " = '" + whereValue + "'");
                    return true;
                } else {
                    System.out.println("No rows matched the criteria. Nothing deleted.");
                    logger.info("No rows deleted from table '" + tableName +
                            "' where " + whereColumn + " = '" + whereValue + "'");
                    return false;
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error deleting row from table '" + tableName + "'", e);
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }


    public boolean viewAllTables() {
        String viewAll = "SELECT table_name FROM information_schema.tables WHERE table_schema = 'public'";
        if (connection != null) {
            try (Statement stmt = connection.createStatement();
                 ResultSet result = stmt.executeQuery(viewAll)) {

                System.out.println("Tables in database:");
                int count = 0;
                while (result.next()) {
                    System.out.println("- " + result.getString("table_name"));
                    count++;
                }

                if (count == 0) {
                    System.out.println("No tables found.");
                } else {
                    logger.info("Successfully listed " + count + " tables.");
                    return true;
                }
            } catch (SQLException e) {
                logger.severe("Error viewing all tables: " + e.getMessage());
            }
        }
        return false;
    }

    public boolean deleteTable() {
        System.out.println("Enter the table name you want to delete:");
        String toBeDeleted = scanner.nextLine();

        if (!checkSuperUser()) {
            logger.warning("Insufficient privileges to delete the table.");
            return false;
        }
        if (!tableExists(toBeDeleted)) {
            logger.warning("Table '" + toBeDeleted + "' does not exist.");
            return false;
        }
        String drop = "DROP TABLE IF EXISTS " + toBeDeleted;

        if (connection != null) {
            try (Statement stmt = connection.createStatement()) {
                stmt.executeUpdate(drop);
                logger.info("Successfully deleted table: " + toBeDeleted);
                return true;
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Failed to delete table: " + toBeDeleted, e);
            }
        }


        return false;
    }


    public void listAllUsers() {
        String sql = "SELECT rolname FROM pg_roles;";
        if (connection != null) {
            try (Statement statement = connection.createStatement();
                 ResultSet rs = statement.executeQuery(sql)) {
                System.out.println("Existing users:");
                while (rs.next()) {
                    String roleName = rs.getString("rolname");
                    System.out.println("- " + roleName);
                }
                logger.info("Listed all users successfully.");
            } catch (SQLException e) {
                logger.severe("Error displaying all users: " + e);
            }
        }
    }

    public void viewTable() {
        System.out.println("Enter table name");
        String tableName = scanner.nextLine();
        if (!tableExists(tableName)) {
            logger.warning("Table does not exists!!");
            return;
        }
        String view = "SELECT * FROM " + tableName;
        if (connection != null) {
            try (Statement statement = connection.createStatement();
                 ResultSet rs = statement.executeQuery(view)) {
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();

                while (rs.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.print(rsmd.getColumnName(i) + ": " + rs.getString(i) + "  ");
                    }
                    System.out.println();
                }
            } catch (SQLException e) {
                logger.severe("Error displaying table :" + tableName + e.getMessage() + e);
            }
        }
    }

    public void viewTableLimited() {
        System.out.println("Enter table name");
        String tableName = scanner.nextLine();
        if (!tableExists(tableName)) {
            logger.warning("Table does not exists!!");
            return;
        }
        System.out.println("Enter number of rows to view:");
        String rows = scanner.nextLine();
        String view = "SELECT * FROM " + tableName + " LIMIT " + rows;
        if (connection != null) {
            try (Statement statement = connection.createStatement();
                 ResultSet rs = statement.executeQuery(view)) {
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();

                while (rs.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.print(rsmd.getColumnName(i) + ": " + rs.getString(i) + "  ");
                    }
                    System.out.println();
                }
            } catch (SQLException e) {
                logger.severe("Error displaying table :" + tableName + e.getMessage() + e);
            }
        }
    }

    public boolean createUser() {
        if (!checkSuperUser() && !checkCanCreateRoles()) {
            logger.severe("You do NOT have permission to create a user");
            return false;
        }

        try {
            System.out.println("Enter user name :");
            String userToAdd = scanner.nextLine();
            if (checkUser(userToAdd)) {
                logger.warning("Attempted to create a user that already exists: " + userToAdd);
                return false;
            }
            System.out.println("Enter password for username :" + userToAdd);
            String passwd = scanner.nextLine();
            String addUser = "CREATE USER " + userToAdd + " WITH PASSWORD ?";
            if (connection != null) {
                try (PreparedStatement stmt2 = connection.prepareStatement(addUser)) {
                    stmt2.setString(1, passwd);
                    stmt2.executeUpdate();
                }
            }
            logger.info("User '" + userToAdd + "' created successfully.");
            return true;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error creating user: " + e.getMessage(), e);
        }
        return false;
    }

    public boolean deleteUser() {
        if (!checkSuperUser() && !checkCanCreateRoles()) {
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
        if (checkUser(userToDelete)) {
            if (connection != null) {
                try (Statement statement = connection.createStatement()) {
                    logger.info("Deleting user: " + userToDelete);
                    String dropUserSQL = "DROP ROLE " + userToDelete;
                    statement.execute(dropUserSQL);
                    logger.info("User '" + userToDelete + "' deleted successfully.");
                    return true;
                } catch (SQLException e) {
                    logger.log(Level.SEVERE, "Error deleting user: " + e.getMessage(), e);
                }
            }
        }
        return false;
    }

    public boolean updatePassword() {
        System.out.println("Enter username whose password is to be changed:");
        String usersPasswdToBeChanged = scanner.nextLine();
        System.out.println("Enter NEW password :");
        String passwd = scanner.nextLine();

        if (usersPasswdToBeChanged.equals("postgres")) {
            logger.warning("Attempt to change password of 'postgres' user denied.");
            System.out.println("Can't perform operations on this user");
            return false;
        }

        if (checkUser(usersPasswdToBeChanged) && (checkSuperUser() || checkCanCreateRoles())) {
            String alter = "ALTER USER " + usersPasswdToBeChanged + " WITH PASSWORD ?";
            if (connection != null) {
                try (PreparedStatement ps = connection.prepareStatement(alter)) {
                    ps.setString(1, passwd);
                    ps.execute();

                    logger.info("Password updated successfully for user: " + usersPasswdToBeChanged);
                    return true;
                } catch (SQLException e) {
                    logger.severe("Error altering password for user " + usersPasswdToBeChanged + ": " + e.getMessage());
                }
            }
        }
        return false;
    }

    private boolean grantRole() {
        System.out.println("Enter username :");
        String userName = scanner.nextLine().trim();
        if (userName.equals("postgres")) {
            logger.warning("Attempt to grant role to 'postgres' user denied.");
            System.out.println("Can't perform operations on this user");
            return false;
        }
        if (checkUser(userName)) {
            System.out.println("Enter a role to assign (or press Enter to skip):");
            String roleToGrant = scanner.nextLine().trim();
            if (!roleToGrant.isEmpty()) {
                String grantRoleSQL = "GRANT " + roleToGrant + " TO " + userName;
                if (connection != null) {
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
        }
        return false;
    }

    public boolean revokeRoles() {
        System.out.println("Enter username from whom the role is to be revoked:");
        String userName = scanner.nextLine().trim();

        if (userName.equals("postgres")) {
            logger.warning("Attempt to revoke role from 'postgres' user denied.");
            System.out.println("Can't perform operations on this user");
            return false;
        }

        if (checkUser(userName)) {
            System.out.println("Enter the role to revoke:");
            String role = scanner.nextLine().trim();

            if (!role.isEmpty()) {
                String revokeRoleSQL = "REVOKE " + role + " FROM " + userName;
                if (connection != null) {
                    try (Statement stmt = connection.createStatement()) {
                        stmt.executeUpdate(revokeRoleSQL);
                        logger.info("Revoked role '" + role + "' from user '" + userName + "'");
                        System.out.println("Role revoked successfully.");
                        return true;
                    } catch (SQLException e) {
                        logger.severe("Error revoking role '" + role + "' from user '" + userName + "': " + e.getMessage());
                    }
                }
            }
        } else {
            logger.warning("User " + userName + " does not exist.");
        }

        return false;
    }

    private boolean grantPrivileges() {
        System.out.println("Enter username :");
        String userName = scanner.nextLine().trim();
        if (userName.equals("postgres")) {
            logger.warning("Attempt to grant privileges to 'postgres' user denied.");
            System.out.println("Can't perform operations on this user");
            return false;
        }
        if (checkUser(userName)) {
            System.out.println("Grant SELECT on which table? (or press Enter to skip):");
            String table = scanner.nextLine().trim();
            if (!table.isEmpty()) {
                String grantPrivSQL = "GRANT SELECT ON " + table + " TO " + userName;
                if (connection != null) {
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
        }
        return false;
    }

    public boolean revokePrivileges() {
        System.out.println("Enter username from whom privileges are to be revoked:");
        String userName = scanner.nextLine().trim();

        if (userName.equalsIgnoreCase("postgres")) {
            logger.warning("Attempt to revoke privileges from 'postgres' user denied.");
            System.out.println("Can't perform operations on this user");
            return false;
        }

        if (checkUser(userName)) {
            System.out.println("Enter the table name from which privileges should be revoked:");
            String table = scanner.nextLine().trim();

            System.out.println("Enter the privilege to revoke (e.g., SELECT, INSERT, UPDATE):");
            String privilege = scanner.nextLine().trim().toUpperCase();

            if (!table.isEmpty() && !privilege.isEmpty()) {
                String revokePrivSQL = "REVOKE " + privilege + " ON " + table + " FROM " + userName;
                if (connection != null) {
                    try (Statement stmt = connection.createStatement()) {
                        stmt.executeUpdate(revokePrivSQL);
                        logger.info("Revoked " + privilege + " on table '" + table + "' from user '" + userName + "'");
                        System.out.println("Privilege revoked successfully.");
                        return true;
                    } catch (SQLException e) {
                        logger.severe("Error revoking " + privilege + " from user " + userName + " on table " + table + ": " + e.getMessage());
                    }
                }
            } else {
                logger.warning("Table name or privilege was empty.");
            }
        } else {
            logger.warning("User " + userName + " does not exist.");
        }

        return false;
    }

    public void viewPrivileges() {
        if (connection != null) {
            try (Statement stmt = connection.createStatement()) {

                String query = """
                        SELECT
                            r.rolname AS role_name,
                            r.rolsuper AS is_superuser,
                            r.rolcreaterole AS can_create_roles,
                            r.rolcreatedb AS can_create_db,
                            ARRAY(
                                SELECT b.rolname
                                FROM pg_auth_members m
                                JOIN pg_roles b ON (m.roleid = b.oid)
                                WHERE m.member = r.oid
                            ) AS member_of
                        FROM pg_roles r
                        ORDER BY r.rolname;
                        """;

                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    System.out.println("Role Name     : " + rs.getString("role_name"));
                    System.out.println("Superuser     : " + rs.getBoolean("is_superuser"));
                    System.out.println("Create Role   : " + rs.getBoolean("can_create_roles"));
                    System.out.println("Create DB     : " + rs.getBoolean("can_create_db"));
                    Array rolesArray = rs.getArray("member_of");
                    String[] roles = (String[]) rolesArray.getArray();
                    System.out.println("Member of     : " + String.join(", ", roles));
                    System.out.println("------------------------------");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //? Helper methods
    private boolean checkUser(String userName) {
        String checkIfUserExists = "SELECT 1 FROM pg_roles WHERE rolname = ?";
        try {
            ResultSet rs = null;
            if (connection != null) {
                try (PreparedStatement stmt = connection.prepareStatement(checkIfUserExists)) {
                    stmt.setString(1, userName);
                    rs = stmt.executeQuery();
                }
            }
            if (rs != null && rs.next()) {
                logger.fine("User '" + userName + "' exists.");
                return true;
            }
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Error checking if user exists: " + e.getMessage(), e);
        }
        return false;
    }

    private boolean checkSuperUser() {
        String sql = "SELECT rolsuper FROM pg_roles WHERE rolname = current_user";
        boolean isSuperUser = false;
        if (connection != null) {
            try (PreparedStatement prepared = connection.prepareStatement(sql);
                 ResultSet resultSet = prepared.executeQuery()) {
                if (resultSet.next()) {
                    isSuperUser = resultSet.getBoolean("rolsuper");
                    logger.fine("Is superuser: " + isSuperUser);
                }
            } catch (SQLException e) {
                logger.log(Level.WARNING, "Error checking superuser permission: " + e.getMessage(), e);
            }
        }
        return isSuperUser;
    }

    private boolean checkCanCreateRoles() {
        String sql = "SELECT rolcreaterole FROM pg_roles WHERE rolname = current_user";
        boolean canCreateRoles = false;
        if (connection != null) {
            try (PreparedStatement prepared = connection.prepareStatement(sql);
                 ResultSet resultSet = prepared.executeQuery()) {
                if (resultSet.next()) {
                    canCreateRoles = resultSet.getBoolean("rolcreaterole");
                    logger.fine("Can create roles: " + canCreateRoles);
                }
            } catch (SQLException e) {
                logger.log(Level.WARNING, "Error checking role creation permission: " + e.getMessage(), e);
            }
        }
        return canCreateRoles;
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            logger.severe("Error closing connection " + e.getMessage() + e);
        }
    }
}
