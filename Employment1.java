import java.sql.*;
import java.util.Scanner;

public class Employment1 {
    // MySQL connection details
    
    private static final String URL = "jdbc:mysql://localhost:3306/employee_db";
    private static final String USER = "root";      // your MySQL username
    private static final String PASS = "12345678";  // your MySQL password

    public static void main(String[] args) {
        try {
            // Load MySQL driver (important for some environments)
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
                 Scanner sc = new Scanner(System.in)) {

                System.out.println("Connected to Database!");

                while (true) {
                    System.out.println("\n--- Employee DB Menu ---");
                    System.out.println("1. Add Employee");
                    System.out.println("2. View Employees");
                    System.out.println("3. Update Employee");
                    System.out.println("4. Delete Employee");
                    System.out.println("5. Exit");
                    System.out.print("Choose option: ");

                    // Check input type to prevent crashes
                    while (!sc.hasNextInt()) {
                        System.out.println("Please enter a valid number.");
                        sc.next();
                    }
                    int choice = sc.nextInt();
                    sc.nextLine(); // consume newline

                    switch (choice) {
                        case 1 -> addEmployee(conn, sc);
                        case 2 -> viewEmployees(conn);
                        case 3 -> updateEmployee(conn, sc);
                        case 4 -> deleteEmployee(conn, sc);
                        case 5 -> {
                            System.out.println("Exiting...");
                            return;
                        }
                        default -> System.out.println("Invalid choice!");
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found!");
        }
    }

    // Add Employee
    private static void addEmployee(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Salary: ");
        while (!sc.hasNextDouble()) {
            System.out.println("Please enter a valid salary.");
            sc.next();
        }
        double salary = sc.nextDouble();
        sc.nextLine(); // consume newline

        String sql = "INSERT INTO employees (name, salary) VALUES (?, ?)";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, name);
            pst.setDouble(2, salary);
            pst.executeUpdate();
            System.out.println("Employee Added!");
        }
    }

    // View Employees
    private static void viewEmployees(Connection conn) throws SQLException {
        String sql = "SELECT * FROM employees";
        try (PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            System.out.println("\nID | Name | Salary");
            System.out.println("------------------");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                                   rs.getString("name") + " | " +
                                   rs.getDouble("salary"));
            }
        }
    }

    // Update Employee
    private static void updateEmployee(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter Employee ID to Update: ");
        while (!sc.hasNextInt()) {
            System.out.println("Please enter a valid ID.");
            sc.next();
        }
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Name: ");
        String name = sc.nextLine();
        System.out.print("Enter New Salary: ");
        while (!sc.hasNextDouble()) {
            System.out.println("Please enter a valid salary.");
            sc.next();
        }
        double salary = sc.nextDouble();
        sc.nextLine();

        String sql = "UPDATE employees SET name=?, salary=? WHERE id=?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, name);
            pst.setDouble(2, salary);
            pst.setInt(3, id);
            int rows = pst.executeUpdate();
            if (rows > 0) System.out.println("Employee Updated!");
            else System.out.println("Employee Not Found!");
        }
    }

    // Delete Employee
    private static void deleteEmployee(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter Employee ID to Delete: ");
        while (!sc.hasNextInt()) {
            System.out.println("Please enter a valid ID.");
            sc.next();
        }
        int id = sc.nextInt();
        sc.nextLine();

        String sql = "DELETE FROM employees WHERE id=?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            int rows = pst.executeUpdate();
            if (rows > 0) System.out.println("Employee Deleted!");
            else System.out.println("Employee Not Found!");
        }
    }
}
