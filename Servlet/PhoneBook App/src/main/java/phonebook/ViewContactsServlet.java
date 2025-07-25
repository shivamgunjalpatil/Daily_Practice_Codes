package phonebook;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/ViewContactsServlet")
public class ViewContactsServlet extends HttpServlet {
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

	    out.println("<html><head><title>View Contacts</title><style>");
	    out.println("body{background:linear-gradient(to bottom right,#f1f8e9,#dcedc8);font-family:Segoe UI;padding:30px;}");
	    out.println("h2{text-align:center;color:#2e7d32;margin-bottom:30px;}");
	    out.println("table{margin:auto;border-collapse:collapse;width:90%;background:#fff;box-shadow:0 6px 20px rgba(0,128,0,0.2);border-radius:12px;overflow:hidden;}");
	    out.println("th,td{padding:14px 20px;text-align:left;border-bottom:1px solid #c8e6c9;}");
	    out.println("th{background:#66bb6a;color:white;}tr:hover{background:#f1f8e9;}");
	    out.println("</style></head><body><h2>All Saved Contacts</h2>");

	    try {
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook", "root", "shiu@123");
	      Statement stmt = con.createStatement();
	      ResultSet rs = stmt.executeQuery("SELECT * FROM contacts");

	      out.println("<table><tr><th>ID</th><th>Name</th><th>Email</th><th>Phone</th><th>Address</th></tr>");

	      while(rs.next()) {
	        out.println("<tr><td>" + rs.getInt("id") + "</td><td>" + rs.getString("name") + "</td><td>" + rs.getString("email") + "</td><td>" + rs.getString("phone") + "</td><td>" + rs.getString("address") + "</td></tr>");
	      }

	      out.println("</table>");
	      con.close();
	    } catch(Exception e) {
	      out.println("<p style='color:red;text-align:center;'>Error: " + e.getMessage() + "</p>");
	    }

	    out.println("</body></html>");
	  }
	}
