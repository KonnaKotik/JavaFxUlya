package com.example.project.servise;


import com.example.project.dto.document.RecenzentDto;
import com.example.project.dto.document.SostavGekDto;
import com.example.project.mapper.document.RecenzentMapper;

import com.example.project.mapper.document.SostavGekMapper;
import com.example.project.model.document.SostavGek;

import com.example.project.repository.SostavGekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SostavGekServiceImpl implements SostavGekService {
    @Autowired
    private SostavGekRepository sostavGekRepository;

    @Autowired
    private SostavGekMapper sostavGekMapper;

    @Override
    public List<SostavGekDto> getAllSostavGek(){
        List<SostavGek> sostavGekList = sostavGekRepository.findAll();
        return sostavGekMapper.convertModelsToDtos(sostavGekList);
    }

}
