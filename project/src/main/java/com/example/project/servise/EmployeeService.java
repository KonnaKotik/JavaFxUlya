package com.example.project.servise;

import com.example.project.model.Children;
import com.example.project.model.Employee;
import com.example.project.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    void addNewEmployee(Employee newEmployee);

    Employee getEmployeeByFio(String fio);

    List<EmployeeDto> getAllEmployees();

    List<Employee> getAllByChildren(List<Children> childrenList);

    void updateEmployee(Employee employee);

    void deleteEmployee(String fio);

}
