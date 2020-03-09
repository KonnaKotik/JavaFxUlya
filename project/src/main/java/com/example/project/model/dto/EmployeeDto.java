package com.example.project.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class EmployeeDto {

    private String tabNum;
    private String fio;
    private String passport;
    private String birthday;
    private String cc;
    private String inn;
    private String phone;
    private String education;
    private String address;
    private String addmission;
    private String post;
    private String status;
}
