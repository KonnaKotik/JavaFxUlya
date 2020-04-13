package com.example.project.model;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Children {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fio;
    private String data;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "childrenList")
    private List<Employee> parents = new LinkedList<>();


    public Children(String fio, String data, List<Employee> parents) {
        this.fio = fio;
        this.data = data;
        this.parents = parents;
    }



    @Override
    public String toString(){
        return "Children(" +
                "id=" + id +
                ", fio=" + fio +
                ", data=" + data +
                ", parents=" + parents.stream().map(Employee::getFio).collect(Collectors.toList()) +
                ")";
    }

}
