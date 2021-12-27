package com.kiyotakeshi.employee.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @JsonProperty("Name")
    private String name;

    @NotNull
    @JsonProperty("Department")
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && name.equals(employee.name) && department.equals(employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, department);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}

