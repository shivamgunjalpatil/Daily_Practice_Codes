package phonebook;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.*;
@WebServlet("/AddContactServlet")
public class AddContactServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook", "root", "shiu@123");
            PreparedStatement ps = con.prepareStatement("INSERT INTO contacts(name, email, phone, address) VALUES (?, ?, ?, ?)");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, address);
            ps.executeUpdate();

            res.setContentType("text/html");
            PrintWriter out = res.getWriter();
            out.println("<h2 style='color:green;text-align:center;'>Contact Added Successfully!</h2>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
