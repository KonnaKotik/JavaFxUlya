package com.example.project.mapper;

import com.example.project.model.Employee;
import com.example.project.model.dto.EmployeeDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class EmployeeMapper {

    public EmployeeDto convertModelToDto(Employee employee) {

        return EmployeeDto.builder()
                .addmission(employee.getAddmission())
                .address(employee.getAddress())
                .birthday(employee.getBirthday())
                .cc(employee.getCc())
                .education(employee.getEducation())
                .fio(employee.getFio())
                .inn(employee.getInn())
                .passport(employee.getPassport())
                .phone(employee.getPhone())
                .post(employee.getPost())
                .tabNum(employee.getTabNum())
                .status(employee.getStatus())
                .build();
    }



    private Stream<EmployeeDto> modelsToDtos(List<Employee> employeeList){
        return employeeList.stream().map(this::convertModelToDto);
    }

    public List<EmployeeDto> convertModelsToDtos(List<Employee> employees) {
        return modelsToDtos(employees).collect(Collectors.toList());
    }
}
