package com.example.project.servise;

import com.example.project.dto.document.PrikazDto;
import com.example.project.dto.document.RecenzentDto;
import com.example.project.mapper.document.RecenzentMapper;
import com.example.project.model.document.Prikaz;
import com.example.project.model.document.Recenzent;
import com.example.project.repository.RecenzentRepozitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecenzentServiceImpl implements RecenzentService {

    @Autowired
    private RecenzentRepozitory recenzentRepozitory;

    @Autowired
    private RecenzentMapper recenzentMapper;


    @Override
    public List<RecenzentDto> getAllRecenzent() {
        List<Recenzent> recenzentList = recenzentRepozitory.findAll();
        return recenzentMapper.convertModelsToDtos(recenzentList);
    }

    @Override
    public RecenzentDto getRecenzentByNumber(String number) {
        Optional<Recenzent> recenzentOptional = recenzentRepozitory.findByNumber(number);
        if (recenzentOptional.isPresent()) {
            RecenzentDto recenzentDto = recenzentMapper.convertModelToDto(recenzentOptional.get());
            return recenzentDto;
        }
        return null;
    }

    @Override
    public List<RecenzentDto> getAllByFio(String fio) {
        List<Recenzent> recenzentList = recenzentRepozitory.findAllByFio(fio);
        return recenzentMapper.convertModelsToDtos(recenzentList);
    }

    @Override
    public List<RecenzentDto> getAllByPost(String post) {
        List<Recenzent> recenzentList = recenzentRepozitory.findAllByPost(post);
        return recenzentMapper.convertModelsToDtos(recenzentList);
    }

    @Override
    public List<RecenzentDto> getAllByYear(String year) {
        List<Recenzent> recenzentList = recenzentRepozitory.findAllByYear(year);
        return recenzentMapper.convertModelsToDtos(recenzentList);
    }

    @Override
    public void addNewRecenzent(Recenzent recenzent) {
        recenzentRepozitory.save(recenzent);
    }
}


