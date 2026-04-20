package ru.ranepa;

import ru.ranepa.model.Employee;
import ru.ranepa.repository.EmployeeRepository;
import ru.ranepa.service.HRMService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class HrmApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeRepository employeeRepository = new EmployeeRepository();
        HRMService hrmService = new HRMService(employeeRepository);

        while (true) {
            System.out.println("\n=== HRM System Menu ===");
            System.out.println("1. Show all employees");
            System.out.println("2. Add employee");
            System.out.println("3. Delete employee by ID");
            System.out.println("4. Find employee by ID");
            System.out.println("5. Show statistics");
            System.out.println("6. Find employees by position");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    List<Employee> employees = hrmService.getAllEmployees();
                    if (employees.isEmpty()) {
                        System.out.println("Employee list is empty.");
                    } else {
                        for (Employee employee : employees) {
                            System.out.println(employee);
                        }
                    }
                    break;

                case "2":
                    try {
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter position: ");
                        String position = scanner.nextLine();

                        System.out.print("Enter salary: ");
                        double salary = Double.parseDouble(scanner.nextLine());

                        System.out.print("Enter hire date (YYYY-MM-DD): ");
                        LocalDate hireDate = LocalDate.parse(scanner.nextLine());

                        Employee employee = new Employee(null, name, position, salary, hireDate);
                        Employee savedEmployee = hrmService.addEmployee(employee);

                        System.out.println("Employee added successfully with ID: " + savedEmployee.getId());
                    } catch (Exception e) {
                        System.out.println("Input error. Please enter correct data.");
                    }
                    break;

                case "3":
                    try {
                        System.out.print("Enter employee ID to delete: ");
                        Long id = Long.parseLong(scanner.nextLine());

                        boolean deleted = hrmService.deleteEmployee(id);
                        if (deleted) {
                            System.out.println("Employee deleted.");
                        } else {
                            System.out.println("Employee not found.");
                        }
                    } catch (Exception e) {
                        System.out.println("Input error.");
                    }
                    break;

                case "4":
                    try {
                        System.out.print("Enter employee ID to find: ");
                        Long id = Long.parseLong(scanner.nextLine());

                        Employee employee = hrmService.getEmployeeById(id);
                        if (employee != null) {
                            System.out.println(employee);
                        } else {
                            System.out.println("Employee not found.");
                        }
                    } catch (Exception e) {
                        System.out.println("Input error.");
                    }
                    break;

                case "5":
                    double averageSalary = hrmService.calculateAverageSalary();
                    Employee topEmployee = hrmService.findTopPaidEmployee();

                    System.out.println("Average salary: " + averageSalary);
                    if (topEmployee != null) {
                        System.out.println("Top paid employee: " + topEmployee);
                    } else {
                        System.out.println("No employees in the system.");
                    }
                    break;

                case "6":
                    System.out.print("Enter position: ");
                    String position = scanner.nextLine();

                    List<Employee> foundEmployees = hrmService.findByPosition(position);

                    if (foundEmployees.isEmpty()) {
                        System.out.println("No employees found for this position.");
                    } else {
                        for (Employee employee : foundEmployees) {
                            System.out.println(employee);
                        }
                    }
                    break;

                case "7":
                    System.out.println("Exit from program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Wrong option. Try again.");
            }
        }
    }
}