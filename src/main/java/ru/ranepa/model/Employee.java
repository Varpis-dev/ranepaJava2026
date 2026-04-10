package ru.ranepa.model;

import java.time.LocalDate;

public class Employee {

    private Long id;              // уникальный ID
    private String name;          // имя
    private String position;      // должность
    private double salary;        // зарплата
    private LocalDate hireDate;   // дата приема

    // Пустой конструктор
    public Employee() {
    }

    // Конструктор со всеми параметрами
    public Employee(Long id, String name, String position, double salary, LocalDate hireDate) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    // ===== Геттеры и сеттеры =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    // ===== Метод toString =====

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", hireDate=" + hireDate +
                '}';
    }
}