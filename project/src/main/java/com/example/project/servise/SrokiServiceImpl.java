package com.example.project.servise;
import com.example.project.dto.document.PrikazDto;
import com.example.project.dto.document.SrokiDto;
import com.example.project.mapper.document.PrikazMapper;
import com.example.project.mapper.document.SrokiMapper;
import com.example.project.model.document.Prikaz;
import com.example.project.model.document.Sroki;
import com.example.project.repository.PrikazRepository;
import com.example.project.repository.SrokiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SrokiServiceImpl implements SrokiService {
    @Autowired
    private SrokiRepository srokiRepository;

    @Autowired
    private SrokiMapper srokiMapper;

    @Override
    public List<SrokiDto> getAllSroki() {
        List<Sroki> srokiList = srokiRepository.findAll();
        return srokiMapper.convertModelsToDtos(srokiList);
    }
}
