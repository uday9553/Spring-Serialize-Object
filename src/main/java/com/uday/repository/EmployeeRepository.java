package com.uday.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uday.model.SerializedEmployee;

public interface EmployeeRepository extends JpaRepository<SerializedEmployee, Integer> {
}
