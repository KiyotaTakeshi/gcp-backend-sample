package com.kiyotakeshi.employee.contoller;

import com.kiyotakeshi.employee.entity.Employee;
import com.kiyotakeshi.employee.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = {
        "http://localhost:3000",
        "http://example.com:3000"
})
public class EmployeesController {

    private EmployeeService employeeService;

    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<?> getEmployees() {
        List<Employee> employeeList = employeeService.findEmployees();
        return ResponseEntity.ok().body(employeeList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable Integer id) {
        Employee employee = employeeService.findEmployeeById(id);
        return ResponseEntity.ok().body(employee);
    }
}
