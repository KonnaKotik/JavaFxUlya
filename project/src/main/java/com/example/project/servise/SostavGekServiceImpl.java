package com.example.project.servise;


import com.example.project.dto.document.SostavGekDto;

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

    @Override
    public List<SostavGekDto> getAllByYear(String year) {
        List<SostavGek> sostavGekList = sostavGekRepository.findAllByYear(year);
        return sostavGekMapper.convertModelsToDtos(sostavGekList);
    }

    @Override
    public List<SostavGekDto> getAllByNapr(String napr) {
        List<SostavGek> sostavGekList = sostavGekRepository.findAllByNapravlenie(napr);
        return sostavGekMapper.convertModelsToDtos(sostavGekList);
    }

    @Override
    public List<SostavGekDto> getAllByProfil(String profil) {
        List<SostavGek> sostavGekList = sostavGekRepository.findAllByProfil(profil);
        return sostavGekMapper.convertModelsToDtos(sostavGekList);
    }

    @Override
    public List<SostavGekDto> getAllByPred(String pred) {
        List<SostavGek> sostavGekList = sostavGekRepository.findAllByPred(pred);
        return sostavGekMapper.convertModelsToDtos(sostavGekList);
    }

    @Override
    public List<SostavGekDto> getAllByZam(String zam) {
        List<SostavGek> sostavGekList = sostavGekRepository.findAllByZam(zam);
        return sostavGekMapper.convertModelsToDtos(sostavGekList);
    }

    @Override
    public List<SostavGekDto> getAllByKom(String kom) {
        List<SostavGek> sostavGekList = sostavGekRepository.findAllByKomissia(kom);
        return sostavGekMapper.convertModelsToDtos(sostavGekList);
    }

    @Override
    public List<SostavGekDto> getAllByForma(String forma) {
        List<SostavGek> sostavGekList = sostavGekRepository.findAllByForma(forma);
        return sostavGekMapper.convertModelsToDtos(sostavGekList);
    }

    @Override
    public List<SostavGekDto> getAllBySek(String sek) {
        List<SostavGek> sostavGekList = sostavGekRepository.findAllBySekretar(sek);
        return sostavGekMapper.convertModelsToDtos(sostavGekList);
    }

    @Override
    public void addNewSostavGek(SostavGek sostavGek) {
        sostavGekRepository.save(sostavGek);
    }


}
