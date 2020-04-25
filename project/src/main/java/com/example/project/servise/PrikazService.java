package com.example.project.servise;


import com.example.project.dto.document.PrikazDto;
import com.example.project.model.document.Prikaz;

import java.util.List;

public interface PrikazService {

    List<PrikazDto> getAllPrikaz();
}
