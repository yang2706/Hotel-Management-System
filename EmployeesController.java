import java.util.ArrayList;
import java.util.Scanner;

public class EmployeesController {

    public static void addNewEmployee(ArrayList<Employee> employees, Scanner scanner) {
        System.out.println("Enter name:");
        String name = scanner.next();
        System.out.println("Enter salary:");
        double salary = scanner.nextDouble();
        System.out.println("Enter job:");
        String job = scanner.next();

        employees.add(new Employee(employees.size(), name, salary, job));
    }

    public static void showAllEmployees(ArrayList<Employee> employees) {
        for (Employee e : employees) {
            e.printDetails();
            System.out.println("----------------");
        }
    }
}