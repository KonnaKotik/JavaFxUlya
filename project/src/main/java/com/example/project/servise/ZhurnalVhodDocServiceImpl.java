package com.example.project.servise;
import com.example.project.dto.document.PrikazDto;
import com.example.project.dto.document.ZhurnalVhodDocDto;
import com.example.project.mapper.document.PrikazMapper;
import com.example.project.mapper.document.ZhurnalVhodDocMapper;
import com.example.project.model.document.Prikaz;
import com.example.project.model.document.ZhurnalVhodDoc;
import com.example.project.repository.PrikazRepository;
import com.example.project.repository.ZhurnalVhodDocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ZhurnalVhodDocServiceImpl implements ZhurnalVhodDocService {
    @Autowired
    private ZhurnalVhodDocRepository zhurnalVhodDocRepository;

    @Autowired
    private ZhurnalVhodDocMapper zhurnalVhodDocMapper;

    @Override
    public List<ZhurnalVhodDocDto> getAllZhurnalVhodDoc() {
        List<ZhurnalVhodDoc> zhurnalVhodDocList = zhurnalVhodDocRepository.findAll();
        return zhurnalVhodDocMapper.convertModelsToDtos(zhurnalVhodDocList);
    }
}
