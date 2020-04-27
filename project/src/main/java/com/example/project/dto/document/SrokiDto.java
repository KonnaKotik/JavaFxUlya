package com.example.project.dto.document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder

public class SrokiDto {
    private String institute;
    private String numberGroup;
    private String napravlenie;
    private String data;
    private String start;
    private String numberAudit;
    private String formaOb;

}
