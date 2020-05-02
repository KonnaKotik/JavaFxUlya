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
@Table(name = "finish_sroki")

public class Sroki {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String institute;

    private String numberGroup;

    private String napravlenie;

    private String data;

    private String start;

    private String numberAudit;

    private String formaOb;

    public Sroki(String institute, String numberGroup, String napravlenie, String data, String start, String numberAudit, String formaOb) {
        this.institute = institute;
        this.numberGroup = numberGroup;
        this.napravlenie = napravlenie;
        this.data = data;
        this.start = start;
        this.numberAudit = numberAudit;
        this.formaOb = formaOb;
    }
}
