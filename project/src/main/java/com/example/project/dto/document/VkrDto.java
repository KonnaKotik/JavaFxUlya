package com.example.project.dto.document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder

public class VkrDto {
    private String number;
    private String group;
    private String napravlenie;
    private String fio;
    private String tema;
    private String ruk;
    private String year;

}
