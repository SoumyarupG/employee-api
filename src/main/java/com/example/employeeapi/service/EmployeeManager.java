package com.example.employeeapi.service;

import com.example.employeeapi.model.Employee;
import com.example.employeeapi.model.Employees;
import java.util.Arrays;

public class EmployeeManager {
    private static final Employees EMPLOYEES = new Employees(Arrays.asList(
            new Employee("1", "John", "Doe", "john.doe@example.com", "Software Engineer"),
            new Employee("2", "Jane", "Smith", "jane.smith@example.com", "Project Manager"),
            new Employee("3", "Mike", "Johnson", "mike.johnson@example.com", "QA Engineer")
    ));

    public static Employees getEmployees() {
        return EMPLOYEES;
    }
}
