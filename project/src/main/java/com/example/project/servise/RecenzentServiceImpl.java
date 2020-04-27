package com.example.project.servise;

import com.example.project.dto.document.RecenzentDto;
import com.example.project.mapper.document.RecenzentMapper;
import com.example.project.model.document.Prikaz;
import com.example.project.model.document.Recenzent;
import com.example.project.repository.RecenzentRepozitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecenzentServiceImpl implements RecenzentService {

    @Autowired
    private RecenzentRepozitory recenzentRepozitory;

    @Autowired
    private RecenzentMapper recenzentMapper;

    @Override
    public List<RecenzentDto> getAllRecenzent(){
        List<Recenzent> recenzentList = recenzentRepozitory.findAll();
        return recenzentMapper.convertModelsToDtos(recenzentList);
    }

}
