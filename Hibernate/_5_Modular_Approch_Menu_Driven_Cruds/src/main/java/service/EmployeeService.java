package service;

import java.util.List;

import dao.EmployeeDAO;
import entity.Employee;

public class EmployeeService {
	
	EmployeeDAO dao = new EmployeeDAO();
	
	public void insertEmployee(String name,String city,Double salary)
	{
		Employee emp = new Employee();
		
		emp.setEmp_name(name);
		emp.setCity(city);
		emp.setSalary(salary);
		
		dao.save(emp);
		
	}
	public void deleteEmployee(int id)
	{
		Employee emp = new Employee();
		emp.setEmp_id(id);
		
		dao.remove(emp);
		
	}
	public void updateEmployee(int id1, String name1, String city1, Double salary1)
	{
		Employee emp = new Employee();
		emp.setEmp_id(id1);
		emp.setEmp_name(name1);
		emp.setCity(city1);
		emp.setSalary(salary1);
		
		dao.update(emp);
		
	}
	public List<Employee> fetchALL()
	{
		return dao.getAll();
	}

}
