package com.example.project.model.document;

import com.example.project.model.Children;
import com.example.project.model.Employee;
import lombok.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "finish_prikaz")
public class Prikaz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    private String post;

    private String data;

    private String description;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "prikazs")
    private List<Employee> employees = new LinkedList<>();

    @Override
    public String toString() {
        return "Prikaz(" +
                "id=" + id +
                ", number=" + number +
                ",  post=" + post +
                ", description=" + description +
                ", employees=" + employees.stream().map(Employee::getFio).collect(Collectors.toList()) +
                ")";
    }
}
