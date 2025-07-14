package jdbc;

import java.sql.*;
import java.util.Scanner;

public class LibraryCRUD {
    public static void menu() throws Exception {
        Scanner sc = new Scanner(System.in);
        Connection con = DBConnection.getConnection();

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Insert\n2. Update\n3. Delete\n4. View All\n5. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    String insert = "INSERT INTO library VALUES (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement ps1 = con.prepareStatement(insert);
                    System.out.print("ID: "); ps1.setInt(1, sc.nextInt());
                    System.out.print("Title: "); ps1.setString(2, sc.next());
                    System.out.print("Author: "); ps1.setString(3, sc.next());
                    System.out.print("Publisher: "); ps1.setString(4, sc.next());
                    System.out.print("Price: "); ps1.setDouble(5, sc.nextDouble());
                    System.out.print("Quantity: "); ps1.setInt(6, sc.nextInt());
                    System.out.print("Category: "); ps1.setString(7, sc.next());
                    System.out.println(ps1.executeUpdate() + " record inserted.");
                    break;

                case 2:
                    System.out.print("Enter ID to update quantity: ");
                    int id = sc.nextInt();
                    System.out.print("New Quantity: ");
                    int qty = sc.nextInt();
                    PreparedStatement ps2 = con.prepareStatement("UPDATE library SET quantity=? WHERE id=?");
                    ps2.setInt(1, qty); ps2.setInt(2, id);
                    System.out.println(ps2.executeUpdate() + " record updated.");
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    int delId = sc.nextInt();
                    PreparedStatement ps3 = con.prepareStatement("DELETE FROM library WHERE id=?");
                    ps3.setInt(1, delId);
                    System.out.println(ps3.executeUpdate() + " record deleted.");
                    break;

                case 4:
                    ResultSet rs = con.createStatement().executeQuery("SELECT * FROM library");
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + " " + rs.getString(2) + " Qty: " + rs.getInt(6));
                    }
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
