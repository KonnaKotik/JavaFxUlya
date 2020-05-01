package com.example.project.servise;


import com.example.project.dto.document.PrikazDto;
import com.example.project.model.document.Prikaz;

import java.util.List;

public interface PrikazService {

    List<PrikazDto> getAllPrikaz();

    PrikazDto getPrikazByNum(String num);

    List<PrikazDto> getAllByData(String data);

    List<PrikazDto> getAllByPost(String post);

    List<PrikazDto> getAllByDescription(String description);

    List<PrikazDto> getAllByEmployee(String fio);
}
