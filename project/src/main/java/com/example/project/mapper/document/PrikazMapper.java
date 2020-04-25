package com.example.project.mapper.document;

import com.example.project.dto.ChildrenDto;
import com.example.project.dto.document.PrikazDto;
import com.example.project.model.Children;
import com.example.project.model.Employee;
import com.example.project.model.document.Prikaz;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class PrikazMapper {

    public PrikazDto convertModelToDto(Prikaz prikaz) {
        return PrikazDto.builder()
                .number(prikaz.getNumber())
                .data(prikaz.getData())
                .post(prikaz.getPost())
                .description(prikaz.getDescription())
                .fio(toStringFioEmpl(prikaz.getEmployees().stream().map(Employee::getFio).collect(Collectors.toList())))
                .build();
    }

    private String toStringFioEmpl(List<String> employees) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < employees.size(); i++) {
            stringBuilder.append(employees.get(i));
            if(i != employees.size() - 1) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }



    private Stream<PrikazDto> modelsToDtos(List<Prikaz> prikazList){
        return prikazList.stream().map(this::convertModelToDto);
    }

    public List<PrikazDto> convertModelsToDtos(List<Prikaz> prikazList) {
        return modelsToDtos(prikazList).collect(Collectors.toList());
    }
}
