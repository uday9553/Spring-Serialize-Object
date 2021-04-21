package com.uday.model;

import java.io.Serializable;

public class Employee implements Serializable {

    private static final long serialVersionUID = 123L;

    private String name;
    private String dept;
    transient private Long salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Employee() {

    }

    public Employee(String name, String dept, Long salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
}
