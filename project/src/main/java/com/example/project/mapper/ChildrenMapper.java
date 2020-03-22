package com.example.project.mapper;

import com.example.project.model.Children;
import com.example.project.model.Employee;
import com.example.project.model.dto.ChildrenDto;
import com.example.project.model.dto.EmployeeDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ChildrenMapper {

    public ChildrenDto convertModelToDto(Children children) {
        return ChildrenDto.builder()
                .fio(children.getFio())
                .data(children.getData())
                .build();

    }

    public Children convertDtoToModel(ChildrenDto childrenDto) {
        return Children.builder()
                .fio(childrenDto.getFio())
                .data(childrenDto.getData())
                .build();
    }



    private Stream<ChildrenDto> modelsToDtos(List<Children> childrenList){
        return childrenList.stream().map(this::convertModelToDto);
    }

    public List<ChildrenDto> convertModelsToDtos(List<Children> childrenList) {
        return modelsToDtos(childrenList).collect(Collectors.toList());
    }
}
