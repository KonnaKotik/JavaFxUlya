package com.example.project.model.document;

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
@Table(name = "finish_recenzent")
public class Recenzent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    private String post;

    private String year;

    private String fio;

    public Recenzent(String number, String fio, String post, String year) {
        this.number = number;
        this.post = post;
        this.year = year;
        this.fio = fio;
    }

}
