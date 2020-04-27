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
@Table(name = "finish_sostavGek")

public class SostavGek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String year;

    private String napravlenie;

    private String profil;

    private String pred;

    private String zam;

    private String komissia;

    private String forma;

    private String sekretar;
}

