package com.example.project.servise;
import com.example.project.dto.document.PrikazDto;
import com.example.project.dto.document.VkrDto;
import com.example.project.model.document.Prikaz;

import java.util.List;

public interface VkrService {
    List<VkrDto> getAllVkr();

    List<VkrDto> getAllByRuk(String rukFio);

    VkrDto getVkrByNumber(String number);

    List<VkrDto> getAllByGroup(String group);

    List<VkrDto> getAllByFio(String fio);

    List<VkrDto> getAllByTema(String tema);

    List<VkrDto> getAllByYear(String year);

    List<VkrDto> getAllByNapr(String napr);

}
