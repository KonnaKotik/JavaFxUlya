package com.example.project.dto.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class PrikazDto {

    private String data;
    private String post;
    private String number;
    private String description;
    private String fio;
}
