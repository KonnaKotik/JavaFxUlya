package com.example.project.dto.document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder

public class RecenzentDto {

    private String number;
    private String fio;
    private String post;
    private String year;

}
