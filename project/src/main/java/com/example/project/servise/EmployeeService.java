package com.example.project.servise;

import com.example.project.dto.ChildrenDto;
import com.example.project.dto.document.PrikazDto;
import com.example.project.model.Children;
import com.example.project.model.Employee;
import com.example.project.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    void addNewEmployee(Employee newEmployee);

    Employee getEmployeeByFio(String fio);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto getEmployeeByTabNum(String tabNum);
    List<EmployeeDto> getAllByFio(String fio);
    List<EmployeeDto> getAllByPassport(String passport);
    List<EmployeeDto> getAllByBirthday(String birthday);
    List<EmployeeDto> getAllByCc(String cc);
    List<EmployeeDto> getAllByInn(String inn);
    List<EmployeeDto> getAllByPhone(String phone);
    List<EmployeeDto> getAllByEducation(String education);
    List<EmployeeDto> getAllByAddress(String address);
    List<EmployeeDto> getAllByAddmission(String addmision);
    List<EmployeeDto> getAllByPost(String post);

    List<Employee> getAllByChildren(List<Children> childrenList);

    void updateEmployee(Employee employee);

    void deleteEmployee(String fio);

}
