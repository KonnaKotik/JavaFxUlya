package com.example.project.mapper.document;
import com.example.project.dto.ChildrenDto;
import com.example.project.dto.document.PrikazDto;
import com.example.project.dto.document.RecenzentDto;
import com.example.project.model.Children;
import com.example.project.model.Employee;
import com.example.project.model.document.Prikaz;
import com.example.project.model.document.Recenzent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component

public class RecenzentMapper {

    public RecenzentDto convertModelToDto(Recenzent recenzent) {
        return RecenzentDto.builder()
                .number(recenzent.getNumber())
                .fio(recenzent.getFio())
                .post(recenzent.getPost())
                .year(recenzent.getYear())
                .build();
    }
    private Stream<RecenzentDto> modelsToDtos(List<Recenzent> recenzentList){
        return recenzentList.stream().map(this::convertModelToDto);
    }

    public List<RecenzentDto> convertModelsToDtos(List<Recenzent> recenzentList) {
        return modelsToDtos(recenzentList).collect(Collectors.toList());
    }
}
