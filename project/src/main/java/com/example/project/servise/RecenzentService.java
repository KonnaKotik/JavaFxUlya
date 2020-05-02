package com.example.project.servise;

import com.example.project.dto.document.PrikazDto;
import com.example.project.dto.document.RecenzentDto;
import com.example.project.model.document.Prikaz;

import java.util.List;

public interface RecenzentService {

    List<RecenzentDto> getAllRecenzent();

    RecenzentDto getRecenzentByNum(String num);

    List<RecenzentDto> getAllByFio(String fio);

    List<RecenzentDto> getAllByPost(String post);

    List<RecenzentDto> getAllByYear(String year);


}
