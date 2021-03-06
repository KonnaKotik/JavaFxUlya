package com.example.project.model;

import com.example.project.model.document.Prikaz;
import com.example.project.model.document.Vkr;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "parent_children", joinColumns = @JoinColumn(name = "employee_id"),
    inverseJoinColumns = @JoinColumn(name = "child_id"))
    private List<Children> childrenList = new LinkedList<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(name = "empl_prikaz", joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "prikaz_id"))
    private List<Prikaz> prikazs = new LinkedList<>();

    @OneToMany(mappedBy = "ruk" )
    private List<Vkr> vkrs = new LinkedList<>();



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



    @Override
    public String toString() {
        return "Employee(" +
                "id=" + id +
                ", tabNum=" + tabNum +
                ",  fio=" + fio +
                ", passport=" + passport +
                ", birthday=" + birthday +
                ", cc=" + cc +
                ", inn=" + inn +
                ", phone=" + phone +
                ", education=" + education +
                ", address=" + address +
                ", addmission=" + addmission +
                ", post=" + post +
                ", status=" + status +
                ", childrenList=" + childrenList.stream().map(Children::getFio).collect(Collectors.toList()) +
                ", prikazs=" + prikazs.stream().map(Prikaz::getNumber).collect(Collectors.toList()) +
                ", vkrs=" + vkrs.stream().map(Vkr::getNumber).collect(Collectors.toList()) +
                ")";
    }
}
