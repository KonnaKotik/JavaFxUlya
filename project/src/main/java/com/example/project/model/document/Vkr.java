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
@Table(name = "finish_vkr")
public class Vkr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    private String group;

    private String napravlenie;

    private String fio;

    private String tema;

    private String ruk;

    private String year;



}
