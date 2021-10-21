package com.kiyotakeshi.employee.contoller;

import com.kiyotakeshi.employee.entity.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    @GetMapping
    public ResponseEntity<?> getEmployees() {
        List<Employee> employeeList = new ArrayList(Arrays.asList(
                new Employee("taro", "president"),
                new Employee("jiro", "sales")
        ));
        return ResponseEntity.ok().body(employeeList);
    }
}
