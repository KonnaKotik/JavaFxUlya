package com.example.project.mapper.document;


import com.example.project.dto.document.ZhurnalVhodDocDto;

import com.example.project.model.document.ZhurnalVhodDoc;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component

public class ZhurnalVhodDocMapper {
    public ZhurnalVhodDocDto convertModelToDto(ZhurnalVhodDoc zhurnalVhodDoc) {
        return ZhurnalVhodDocDto.builder()
                .number(zhurnalVhodDoc.getNumber())
                .data(zhurnalVhodDoc.getData())
                .tipDoc(zhurnalVhodDoc.getTipDoc())
                .soderzhanie(zhurnalVhodDoc.getSoderzhanie())
                .kod(zhurnalVhodDoc.getKod())
                .post(zhurnalVhodDoc.getPost())
                .build();
    }

    private Stream<ZhurnalVhodDocDto> modelsToDtos(List<ZhurnalVhodDoc> zhurnalVhodDocList) {
        return zhurnalVhodDocList.stream().map(this::convertModelToDto);
    }

    public List<ZhurnalVhodDocDto> convertModelsToDtos(List<ZhurnalVhodDoc> zhurnalVhodDocList) {
        return modelsToDtos(zhurnalVhodDocList).collect(Collectors.toList());
    }
}
