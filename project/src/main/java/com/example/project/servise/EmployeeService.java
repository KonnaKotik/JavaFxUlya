package com.example.project.servise;

import com.example.project.model.Employee;
import com.example.project.model.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    void addNewEmployee(Employee newEmployee);

    Employee getEmployeeByFio(String fio);

    List<EmployeeDto> getAllEmployees();

}
