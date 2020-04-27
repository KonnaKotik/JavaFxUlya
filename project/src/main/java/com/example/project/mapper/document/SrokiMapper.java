package com.example.project.mapper.document;
import com.example.project.dto.ChildrenDto;
import com.example.project.dto.document.PrikazDto;
import com.example.project.dto.document.SrokiDto;
import com.example.project.model.Children;
import com.example.project.model.Employee;
import com.example.project.model.document.Prikaz;
import com.example.project.model.document.Sroki;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component

public class SrokiMapper {

    public SrokiDto convertModelToDto(Sroki sroki) {
        return SrokiDto.builder()
                .institute(sroki.getInstitute())
                .numberGroup(sroki.getNumberGroup())
                .napravlenie(sroki.getNapravlenie())
                .data(sroki.getData())
                .start(sroki.getStart())
                .numberAudit(sroki.getNumberAudit())
                .formaOb(sroki.getFormaOb())
                .build();
    }
    private Stream<SrokiDto> modelsToDtos(List<Sroki> srokiList){
        return srokiList.stream().map(this::convertModelToDto);
    }

    public List<SrokiDto> convertModelsToDtos(List<Sroki> srokiList) {
        return modelsToDtos(srokiList).collect(Collectors.toList());
    }
}
