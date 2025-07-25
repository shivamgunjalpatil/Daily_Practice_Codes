package phonebook;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteContactServlet")
public class DeleteContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL DB
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook", "root", "shiu@123");

            // Prepare DELETE query
            String query = "DELETE FROM contacts WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                out.println("<h2 style='color:green; text-align:center;'>Contact deleted successfully!</h2>");
            } else {
                out.println("<h2 style='color:red; text-align:center;'>No contact found with ID: " + id + "</h2>");
            }

            con.close();

        } catch (Exception e) {
            out.println("<h3 style='color:red; text-align:center;'>Error: " + e.getMessage() + "</h3>");
            e.printStackTrace(out);
        }
    }
}
