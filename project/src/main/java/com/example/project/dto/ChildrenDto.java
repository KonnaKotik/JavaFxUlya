package com.example.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ChildrenDto {

    private String fio;
    private String data;
    private String nameParents;

}
