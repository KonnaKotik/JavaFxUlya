package com.example.project.servise;

import com.example.project.dto.document.RecenzentDto;
import com.example.project.dto.document.SostavGekDto;
import com.example.project.mapper.document.RecenzentMapper;
import com.example.project.model.document.Prikaz;
import com.example.project.model.document.Recenzent;
import com.example.project.model.document.SostavGek;
import com.example.project.repository.RecenzentRepozitory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
public class SostavGekServiceImpl implements SostavGekService {
    @Autowired
    private RecenzentRepozitory sostavGekRepository;

    @Autowired
    private RecenzentMapper sostavGekMapper;

    @Override
    public List<SostavGekDto> getAllSostavGek(){
        List<SostavGek> sostavGekList = sostavGekRepository.findAll();
        return sostavGekMapper.convertModelToDto(sostavGekList);
    }

}
