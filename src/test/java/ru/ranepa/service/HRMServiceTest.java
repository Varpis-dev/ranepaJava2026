package ru.ranepa.service;

import org.junit.jupiter.api.Test;
import ru.ranepa.model.Employee;
import ru.ranepa.repository.EmployeeRepository;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class HRMServiceTest {

    @Test
    void shouldCalculateAverageSalary() {
        EmployeeRepository repository = new EmployeeRepository();
        HRMService service = new HRMService(repository);

        service.addEmployee(new Employee(null, "Ivan", "Developer", 100, LocalDate.of(2024, 1, 1)));
        service.addEmployee(new Employee(null, "Petr", "Manager", 200, LocalDate.of(2024, 1, 2)));
        service.addEmployee(new Employee(null, "Anna", "QA", 300, LocalDate.of(2024, 1, 3)));

        double result = service.calculateAverageSalary();

        assertEquals(200.0, result);
    }
}