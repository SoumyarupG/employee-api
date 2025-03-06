package com.example.employeeapi.service;

import com.example.employeeapi.model.Employee;
import com.example.employeeapi.model.Employees;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeManagerTest {
    private EmployeeManager employeeManager;

    @BeforeEach
    void setUp() {
        employeeManager = new EmployeeManager();
    }

    @Test
    void testGetEmployees() {
        Employees employees = EmployeeManager.getEmployees();
        assertNotNull(employees);
        assertEquals(3, employees.getEmployees().size());
    }

    @Test
    void testAddEmployee() {
        Employee newEmployee = new Employee("4", "Alice", "Brown", "alice.brown@example.com", "HR Manager");
        EmployeeManager.addEmployee(newEmployee);
        assertEquals(4, EmployeeManager.getEmployees().getEmployees().size());
    }
}
