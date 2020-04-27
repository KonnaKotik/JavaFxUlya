package com.example.project.dto.document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@AllArgsConstructor
@Data
@Builder
public class ZhurnalVhodDocDto {
    private String number;
    private String data;
    private String tipDoc;
    private String soderzhanie;
    private String kod;
    private String post;

}
