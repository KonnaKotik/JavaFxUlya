package com.example.project.servise;
import com.example.project.dto.document.PrikazDto;
import com.example.project.dto.document.SrokiDto;
import com.example.project.model.document.Prikaz;

import java.util.List;

public interface SrokiService {
    List<SrokiDto> getAllSroki();
}
