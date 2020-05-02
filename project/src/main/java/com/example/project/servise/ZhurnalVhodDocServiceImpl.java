package com.example.project.servise;
import com.example.project.dto.document.ZhurnalVhodDocDto;
import com.example.project.mapper.document.ZhurnalVhodDocMapper;
import com.example.project.model.document.ZhurnalVhodDoc;
import com.example.project.repository.ZhurnalVhodDocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public ZhurnalVhodDocDto getZhurnalVhodDocByNumber(String number) {
        Optional<ZhurnalVhodDoc> zhurnalVhodDocOptional = zhurnalVhodDocRepository.findByNumber(number);
        if(zhurnalVhodDocOptional.isPresent()) {
            ZhurnalVhodDocDto zhurnalVhodDocDto = zhurnalVhodDocMapper.convertModelToDto(zhurnalVhodDocOptional.get());
            return zhurnalVhodDocDto;
        }
        return null;
    }

    @Override
    public List<ZhurnalVhodDocDto> getAllByData(String data) {
        List<ZhurnalVhodDoc> zhurnalVhodDocList = zhurnalVhodDocRepository.findAllByData(data);
        return zhurnalVhodDocMapper.convertModelsToDtos(zhurnalVhodDocList);
    }
    @Override
    public List<ZhurnalVhodDocDto> getAllByTip(String tip) {
        List<ZhurnalVhodDoc> zhurnalVhodDocList = zhurnalVhodDocRepository.findAllByTipDoc(tip);
        return zhurnalVhodDocMapper.convertModelsToDtos(zhurnalVhodDocList);
    }

    @Override
    public List<ZhurnalVhodDocDto> getAllBySoder(String soder) {
        List<ZhurnalVhodDoc> zhurnalVhodDocList = zhurnalVhodDocRepository.findAllBySoderzhanie(soder);
        return zhurnalVhodDocMapper.convertModelsToDtos(zhurnalVhodDocList);
    }

    @Override
    public List<ZhurnalVhodDocDto> getAllByKod(String kod) {
        List<ZhurnalVhodDoc> zhurnalVhodDocList = zhurnalVhodDocRepository.findAllByKod(kod);
        return zhurnalVhodDocMapper.convertModelsToDtos(zhurnalVhodDocList);
    }

    @Override
    public List<ZhurnalVhodDocDto> getAllByIsp(String isp) {
        List<ZhurnalVhodDoc> zhurnalVhodDocList = zhurnalVhodDocRepository.findAllByPost(isp);
        return zhurnalVhodDocMapper.convertModelsToDtos(zhurnalVhodDocList);
    }
}
