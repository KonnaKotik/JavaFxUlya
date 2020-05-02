package com.example.project.servise;
import com.example.project.dto.document.SrokiDto;
import com.example.project.mapper.document.SrokiMapper;
import com.example.project.model.document.Sroki;
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

    @Override
    public List<SrokiDto> getAllByInstitute(String institute) {
        List<Sroki> srokiList = srokiRepository.findAllByInstitute(institute);
        return srokiMapper.convertModelsToDtos(srokiList);
    }

    @Override
    public List<SrokiDto> getAllByNumber(String number) {
        List<Sroki> srokiList = srokiRepository.findAllByNumberGroup(number);
        return srokiMapper.convertModelsToDtos(srokiList);
    }
    @Override
    public List<SrokiDto> getAllByNapr(String napr) {
        List<Sroki> srokiList = srokiRepository.findAllByNapravlenie(napr);
        return srokiMapper.convertModelsToDtos(srokiList);
    }

    @Override
    public List<SrokiDto> getAllByData(String data) {
        List<Sroki> srokiList = srokiRepository.findAllByData(data);
        return srokiMapper.convertModelsToDtos(srokiList);
    }

    @Override
    public List<SrokiDto> getAllByStart(String start) {
        List<Sroki> srokiList = srokiRepository.findAllByStart(start);
        return srokiMapper.convertModelsToDtos(srokiList);
    }

    @Override
    public List<SrokiDto> getAllByAudit(String audit) {
        List<Sroki> srokiList = srokiRepository.findAllByNumberAudit(audit);
        return srokiMapper.convertModelsToDtos(srokiList);
    }

    @Override
    public List<SrokiDto> getAllByForma(String forma) {
        List<Sroki> srokiList = srokiRepository.findAllByFormaOb(forma);
        return srokiMapper.convertModelsToDtos(srokiList);
    }

    @Override
    public void addNewSroki(Sroki sroki) {
        srokiRepository.save(sroki);
    }

}
