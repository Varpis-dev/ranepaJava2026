package ru.ranepa.service;

import ru.ranepa.model.Employee;
import ru.ranepa.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class HRMService {

    private final EmployeeRepository employeeRepository;

    public HRMService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public boolean deleteEmployee(Long id) {
        return employeeRepository.delete(id);
    }

    public double calculateAverageSalary() {
        List<Employee> employees = employeeRepository.findAll();

        if (employees.isEmpty()) {
            return 0;
        }

        double sum = 0;

        for (Employee employee : employees) {
            sum += employee.getSalary();
        }

        return sum / employees.size();
    }

    public Employee findTopPaidEmployee() {
        List<Employee> employees = employeeRepository.findAll();

        if (employees.isEmpty()) {
            return null;
        }

        Employee topEmployee = employees.get(0);

        for (Employee employee : employees) {
            if (employee.getSalary() > topEmployee.getSalary()) {
                topEmployee = employee;
            }
        }

        return topEmployee;
    }

    public List<Employee> findByPosition(String position) {
        List<Employee> result = new ArrayList<>();
        List<Employee> employees = employeeRepository.findAll();

        for (Employee employee : employees) {
            if (employee.getPosition().equalsIgnoreCase(position)) {
                result.add(employee);
            }
        }

        return result;
    }
}