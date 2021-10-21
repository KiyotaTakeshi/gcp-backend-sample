package com.kiyotakeshi.employee.service;

import com.kiyotakeshi.employee.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public List<Employee> findAll() {
        return new ArrayList(Arrays.asList(
                new Employee("taro", "president"),
                new Employee("jiro", "sales")
        ));
    }

    @Override
    public Employee findById() {
        return null;
    }
}
