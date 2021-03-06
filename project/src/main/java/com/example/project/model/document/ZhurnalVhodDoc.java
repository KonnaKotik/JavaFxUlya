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
@Table(name = "finish_zhurnalVhodDoc")



public class ZhurnalVhodDoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    private String data;

    private String tipDoc;

    private String soderzhanie;

    private String kod;

    private String post;

    public ZhurnalVhodDoc(String number, String data, String tipDoc, String soderzhanie, String kod, String post) {
        this.number = number;
        this.data = data;
        this.tipDoc = tipDoc;
        this.soderzhanie = soderzhanie;
        this.kod = kod;
        this.post = post;
    }
}
