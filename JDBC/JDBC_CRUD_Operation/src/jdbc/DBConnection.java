package jdbc;

import java.sql.*;

public class DBConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/JBK1", "root", "shiu@123"
            );
        } catch (Exception e) {
            System.out.println("DB Connection Error: " + e);
            return null;
        }
    }
}
