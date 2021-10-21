package com.kiyotakeshi.employee.service;

import com.kiyotakeshi.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
}
