package com.example.project.mapper.document;
import com.example.project.dto.document.SostavGekDto;
import com.example.project.model.document.SostavGek;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component

public class SostavGekMapper {
    public SostavGekDto convertModelToDto(SostavGek sostavGek) {
        return SostavGekDto.builder()
                .year(sostavGek.getYear())
                .napravlenie(sostavGek.getNapravlenie())
                .profil(sostavGek.getProfil())
                .pred(sostavGek.getPred())
                .zam(sostavGek.getZam())
                .komissia(sostavGek.getKomissia())
                .forma(sostavGek.getForma())
                .sekretar(sostavGek.getSekretar())
                .build();
    }

        private Stream<SostavGekDto> modelsToDtos(List<SostavGek> sostavGekList){
            return sostavGekList.stream().map(this::convertModelToDto);
        }

        public List<SostavGekDto> convertModelsToDtos(List<SostavGek> sostavGekList) {
            return modelsToDtos(sostavGekList).collect(Collectors.toList());
        }
}
