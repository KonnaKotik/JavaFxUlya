package com.example.project.dto.document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder

public class SostavGekDto {
    private String year;
    private String napravlenie;
    private String profil;
    private String pred;
    private String zam;
    private String komissia;
    private String forma;
    private String sekretar;

}
