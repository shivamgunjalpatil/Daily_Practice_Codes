package jdbc;

import java.sql.*;
import java.util.Scanner;

public class StudentCRUD {
    public static void menu() throws Exception {
        Scanner sc = new Scanner(System.in);
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();

        while (true) {
            System.out.println("\n--- Student Menu ---");
            System.out.println("1. Insert\n2. Update\n3. Delete\n4. View All\n5. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Roll No: ");
                    int roll = sc.nextInt();
                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Course: ");
                    String course = sc.next();
                    System.out.print("Year: ");
                    int year = sc.nextInt();
                    System.out.print("City: ");
                    String city = sc.next();
                    System.out.print("Email: ");
                    String email = sc.next();

                    String q = "INSERT INTO student VALUES(" + roll + ",'" + name + "','" + course + "'," + year + ",'" + city + "','" + email + "')";
                    System.out.println(st.executeUpdate(q) + " inserted.");
                    break;

                case 2:
                    System.out.print("Enter roll no to update email: ");
                    int r = sc.nextInt();
                    System.out.print("New email: ");
                    String em = sc.next();
                    String update = "UPDATE student SET email='" + em + "' WHERE roll=" + r;
                    System.out.println(st.executeUpdate(update) + " updated.");
                    break;

                case 3:
                    System.out.print("Enter roll no to delete: ");
                    int d = sc.nextInt();
                    System.out.println(st.executeUpdate("DELETE FROM student WHERE roll=" + d) + " deleted.");
                    break;

                case 4:
                    ResultSet rs = st.executeQuery("SELECT * FROM student");
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(6));
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
