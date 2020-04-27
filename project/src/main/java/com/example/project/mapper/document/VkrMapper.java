package com.example.project.mapper.document;
import com.example.project.dto.ChildrenDto;
import com.example.project.dto.document.PrikazDto;
import com.example.project.dto.document.VkrDto;
import com.example.project.model.Children;
import com.example.project.model.Employee;
import com.example.project.model.document.Prikaz;
import com.example.project.model.document.Vkr;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class VkrMapper {
    public VkrDto convertModelToDto(Vkr vkr) {
        return VkrDto.builder()
                .number(vkr.getNumber())
                .group(vkr.getGroup())
                .napravlenie(vkr.getNapravlenie())
                .fio(vkr.getFio())
                .tema(vkr.getTema())
                .ruk(vkr.getRuk())
                .year(vkr.getYear())
                .build();
    }
    private Stream<VkrDto> modelsToDtos(List<Vkr> vkrList){
        return vkrList.stream().map(this::convertModelToDto);
    }

    public List<VkrDto> convertModelsToDtos(List<Vkr> vkrList) {
        return modelsToDtos(vkrList).collect(Collectors.toList());
    }
}
