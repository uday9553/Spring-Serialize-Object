package com.uday.service;

import com.uday.model.SerializedEmployee;
import com.uday.model.Employee;
import com.uday.repository.EmployeeRepository;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void persist(Employee emp) {
        byte[] employee = convert(emp);
        SerializedEmployee serialiazedObject = new SerializedEmployee(employee);
        repository.save(serialiazedObject);
    }

    private byte[] convert(Employee emp) {
		try {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(emp);
			return outputStream.toByteArray();

		} catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Employee> getEmployees() {

        return repository.findAll()
                .stream()
                .map(serializedEmployee -> convert(serializedEmployee.getSerializedEmployee()))
                .collect(Collectors.toList());

    }

    private Employee convert(byte[] serializedEmployee) {
        try (
                ByteArrayInputStream inputStream = new ByteArrayInputStream(serializedEmployee);
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            Employee emp = (Employee) objectInputStream.readObject();
            return emp;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
