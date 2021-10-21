package com.kiyotakeshi.employee.controller;

import com.kiyotakeshi.employee.entity.Employee;
import com.kiyotakeshi.employee.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeesControllerTest {

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getEmployees() throws Exception {

        var employees = new ArrayList(Arrays.asList(
                new Employee("taro", "president"),
                new Employee("jiro", "sales")
        ));

        doReturn(employees).when(employeeService).findAll();
        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", is("taro")))
                .andExpect(content().json("""
                        [{"id":0,"name":"taro","department":"president"},{"id":0,"name":"jiro","department":"sales"}]
                        """));
    }
}
