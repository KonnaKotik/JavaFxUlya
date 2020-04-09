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
                .nameParents(toStringParentName(children.getParents().stream().map(Employee::getFio).collect(Collectors.toList())))
                .build();

    }

    private String toStringParentName(List<String> patentsName){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < patentsName.size(); i++) {
            stringBuilder.append(patentsName.get(i));
            if (i != patentsName.size() - 1) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
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
