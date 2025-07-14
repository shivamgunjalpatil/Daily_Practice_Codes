package jdbc;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Employee CRUD");
            System.out.println("2. Student CRUD");
            System.out.println("3. Library CRUD");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    EmployeeCRUD.menu();
                    break;
                case 2:
                    StudentCRUD.menu();
                    break;
                case 3:
                    LibraryCRUD.menu();
                    break;
                case 4:
                    System.out.println("Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
