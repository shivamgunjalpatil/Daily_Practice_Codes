package controller;

import java.util.List;
import java.util.Scanner;

import entity.Employee;
import service.EmployeeService;

public class MainApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		EmployeeService service = new EmployeeService();
		
		while(true)
		{
			System.out.println("-------Welcome to App--------");
			System.out.println("1. Add Employee");
			System.out.println("2. Update Employee");
			System.out.println("3. Delete Employee");
			System.out.println("4. View Employee");
			System.out.println("5. Exit");
			System.out.println("-----------------------------");
			System.out.println();
			System.out.println("Enter Your Choice: ");
			int ch = sc.nextInt();
			
			switch(ch)
			{ 
			case 1:
				System.out.println("------ ADD EMPLOYEE ------");
				
				System.out.print("Enter Employee name : ");
				String name = sc.nextLine();
				
				System.out.print("Enter Employee city : ");
				String city = sc.nextLine();;
				
				System.out.print("Enter salary : ");
				Double salary =sc.nextDouble();
				
				service.insertEmployee(name,city,salary);
				System.out.println("Employee Inserted Successfully!");
				break;
				
			case 2:
				System.out.println("------ UPDATE EMPLOYEE ------");
				
				System.out.println("Enter employee id : ");
				int id1 = sc.nextInt();
				System.out.print("Enter Employee name : ");
				String name1 = sc.next();
				
				System.out.print("Enter Employee city : ");
				String city1 = sc.next();
				
				System.out.print("Enter salary : ");
				Double salary1 =sc.nextDouble();
				
				service.updateEmployee(id1, name1, city1, salary1);
				System.out.println("Employee Update Successfully...!");
				break;
				
				
			case 3:
				System.out.println("------ DELETE EMPLOYEE ------");
				
				System.out.println("Enter Employee id : ");
				int id=sc.nextInt();
				
				service.deleteEmployee(id);
				System.out.println("Employee deleted successfully");
				break;
				
			case 4:
				System.out.println("------ALL DATA --------");
				List<Employee> list = service.fetchALL();
				for (Employee emp : list) {
					System.out.println("ID: " + emp.getEmp_id() +
	                           " | Name   : " + emp.getEmp_name() +
	                           " | City   : " + emp.getCity() +
	                           " | Salary : " + emp.getSalary());
					
				}
				break;
				
			case 5:
				System.exit(0);
				System.out.println("Exit...!");
				break;
				
			default:
				System.out.println("Invalid choice try again..!");
				break;
			
			}
		}

	}

}
