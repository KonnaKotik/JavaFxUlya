package com.example.project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Children {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fio;
    private String data;

    @ManyToMany(mappedBy = "childrenList")
    private List<Employee> parents;


    public Children(String fio, String data, List<Employee> parents) {
        this.fio = fio;
        this.data = data;
        this.parents = parents;
    }
}
