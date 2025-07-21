package a_demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Employee") 
public class Employee extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    // Step 1: Get parameters from the form
	    String empId = request.getParameter("empId");
	    String name = request.getParameter("name");
	    String email = request.getParameter("email");
	    String phone = request.getParameter("phone");
	    String gender = request.getParameter("gender");
	    String dobStr = request.getParameter("dob");
	    String joiningDateStr = request.getParameter("joiningDate");
	    String department = request.getParameter("department");
	    String designation = request.getParameter("designation");
	    String salaryStr = request.getParameter("salary");
	    String experienceStr = request.getParameter("experience");
	    String address = request.getParameter("address");
	    String city = request.getParameter("city");
	    String state = request.getParameter("state");
	    String country = request.getParameter("country");

	    // Step 2: Parse numeric and date fields
	    java.sql.Date dob = java.sql.Date.valueOf(dobStr);
	    java.sql.Date joiningDate = java.sql.Date.valueOf(joiningDateStr);
	    double salary = Double.parseDouble(salaryStr);
	    int experience = Integer.parseInt(experienceStr);

	    try {
	        // Step 3: Load JDBC driver and establish connection
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletJBK", "root", "shiu@123");

	        // Step 4: Prepare the SQL query
	        String query = "INSERT INTO employee (empId, name, email, phone, gender, dob, joiningDate, department, designation, salary, experience, address, city, state, country) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement ps = con.prepareStatement(query);

	        // Step 5: Set parameters in the PreparedStatement
	        ps.setString(1, empId);
	        ps.setString(2, name);
	        ps.setString(3, email);
	        ps.setString(4, phone);
	        ps.setString(5, gender);
	        ps.setDate(6, dob);
	        ps.setDate(7, joiningDate);
	        ps.setString(8, department);
	        ps.setString(9, designation);
	        ps.setDouble(10, salary);
	        ps.setInt(11, experience);
	        ps.setString(12, address);
	        ps.setString(13, city);
	        ps.setString(14, state);
	        ps.setString(15, country);
            
	        PrintWriter out = response.getWriter();
	        out.println("<html><body>");
	        //System.out.println("Succes...");
	        out.println("</body></html>");
	        // Step 6: Execute the insert
	        int result = ps.executeUpdate();
	        if (result > 0) {
	            response.getWriter().println("Employee added successfully!");
	        } else {
	            response.getWriter().println("Failed to add employee.");
	        }

	        // Step 7: Close resources
	        ps.close();
	        con.close();

	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	        response.getWriter().println("Error: " + e.getMessage());
	    }
	}
}
