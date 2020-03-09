package com.example.project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "parent_children", joinColumns = @JoinColumn(name = "employee_id"),
    inverseJoinColumns = @JoinColumn(name = "child_id"))
    private List<Children> childrenList;


    public Employee(String tubNum, String fio, String passport, String birthday, String cc, String inn, String phone, String education, String address, String addmission, String post) {
        this.tabNum = tubNum;
        this.fio = fio;
        this.passport = passport;
        this.birthday = birthday;
        this.cc = cc;
        this.inn = inn;
        this.phone = phone;
        this.education = education;
        this.address = address;
        this.addmission = addmission;
        this.post = post;
        status = "Нанят";
    }


}
