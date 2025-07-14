package jdbc;

import java.sql.*;
import java.util.Scanner;

public class EmployeeCRUD {
    public static void menu() throws Exception {
        Scanner sc = new Scanner(System.in);
        Connection con = DBConnection.getConnection();

        while (true) {
            System.out.println("\n--- Employee Menu ---");
            System.out.println("1. Insert\n2. Update\n3. Delete\n4. View All\n5. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    String insert = "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement ps1 = con.prepareStatement(insert);
                    System.out.print("ID: "); ps1.setInt(1, sc.nextInt());
                    System.out.print("Name: "); ps1.setString(2, sc.next());
                    System.out.print("Age: "); ps1.setInt(3, sc.nextInt());
                    System.out.print("Gender: "); ps1.setString(4, sc.next());
                    System.out.print("Dept: "); ps1.setString(5, sc.next());
                    System.out.print("Salary: "); ps1.setDouble(6, sc.nextDouble());
                    System.out.print("City: "); ps1.setString(7, sc.next());
                    System.out.print("Contact: "); ps1.setString(8, sc.next());
                    System.out.println(ps1.executeUpdate() + " record inserted.");
                    break;

                case 2:
                    System.out.print("Enter ID to update salary: ");
                    int id = sc.nextInt();
                    System.out.print("New Salary: ");
                    double sal = sc.nextDouble();
                    PreparedStatement ps2 = con.prepareStatement("UPDATE employee SET salary=? WHERE id=?");
                    ps2.setDouble(1, sal); ps2.setInt(2, id);
                    System.out.println(ps2.executeUpdate() + " record updated.");
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    int delId = sc.nextInt();
                    PreparedStatement ps3 = con.prepareStatement("DELETE FROM employee WHERE id=?");
                    ps3.setInt(1, delId);
                    System.out.println(ps3.executeUpdate() + " record deleted.");
                    break;

                case 4:
                    ResultSet rs = con.createStatement().executeQuery("SELECT * FROM employee");
                    while (rs.next()) {
                        System.out.println(
                            rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getDouble(6)
                        );
                    }
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
