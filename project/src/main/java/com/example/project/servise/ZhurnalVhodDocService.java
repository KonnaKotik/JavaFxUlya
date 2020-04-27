package com.example.project.servise;
import com.example.project.dto.document.PrikazDto;
import com.example.project.dto.document.VkrDto;
import com.example.project.dto.document.ZhurnalVhodDocDto;
import com.example.project.model.document.Prikaz;

import java.util.List;

public interface ZhurnalVhodDocService {
    List<ZhurnalVhodDocDto> getAllZhurnalVhodDoc();
}
