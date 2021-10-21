package com.kiyotakeshi.employee.contoller;

import com.kiyotakeshi.employee.entity.Employee;
import com.kiyotakeshi.employee.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    private EmployeeService employeeService;

    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<?> getEmployees() {
        List<Employee> employeeList = employeeService.findAll();
        return ResponseEntity.ok().body(employeeList);
    }
}
