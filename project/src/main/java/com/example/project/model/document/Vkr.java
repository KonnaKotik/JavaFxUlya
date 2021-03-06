package com.example.project.model.document;
import com.example.project.model.Children;
import com.example.project.model.Employee;
import lombok.*;
import org.hibernate.annotations.Fetch;

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

    @Column(name = "vkr_group")
    private String group;

    private String napravlenie;

    private String fio;

    private String tema;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "empl_id")
    private Employee ruk;

    @Column(name = "vkr_year")
    private String year;

    @Override
    public String toString(){
        return "Vkr(" +
                "id=" + id +
                ", number=" + number +
                ", group=" + group +
                ", napravlenie=" + napravlenie +
                ", fio=" + fio +
                ", tema=" + tema +
                ", year=" + year +
                ", ruk=" + ruk.getFio() +
                ")";
    }

    public Vkr(String number, String group, String napravlenie, String fio, String tema, String year) {
        this.number = number;
        this.group = group;
        this.napravlenie = napravlenie;
        this.fio = fio;
        this.tema = tema;
        this.year = year;
    }



}
