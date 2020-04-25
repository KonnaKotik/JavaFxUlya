package com.example.project.servise;

import com.example.project.dto.document.PrikazDto;
import com.example.project.mapper.document.PrikazMapper;
import com.example.project.model.document.Prikaz;
import com.example.project.repository.PrikazRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrikazServiceImpl implements PrikazService {
    @Autowired
    private PrikazRepository prikazRepository;

    @Autowired
    private PrikazMapper prikazMapper;

    @Override
    public List<PrikazDto> getAllPrikaz() {
        List<Prikaz> prikazList = prikazRepository.findAll();
        return prikazMapper.convertModelsToDtos(prikazList);
    }
}
