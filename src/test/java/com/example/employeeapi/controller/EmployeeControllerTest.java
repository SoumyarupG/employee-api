package com.example.employeeapi.controller;

import com.example.employeeapi.model.Employee;
import com.example.employeeapi.model.Employees;
import com.example.employeeapi.service.EmployeeManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class EmployeeControllerTest {
    private MockMvc mockMvc;

    @Mock
    private EmployeeManager employeeManager;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    void testGetAllEmployees() throws Exception {
        Employees employees = EmployeeManager.getEmployees();
        when(EmployeeManager.getEmployees()).thenReturn(employees);

        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employees").exists());

        verify(EmployeeManager, times(1)).getEmployees();
    }

    @Test
    void testAddEmployee() throws Exception {
        mockMvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"employee_id\":\"4\",\"first_name\":\"Alice\",\"last_name\":\"Brown\",\"email\":\"alice.brown@example.com\",\"title\":\"HR Manager\"}"))
                .andExpect(status().isOk());

        verify(EmployeeManager, times(1)).addEmployee(any(Employee.class));
    }
}
