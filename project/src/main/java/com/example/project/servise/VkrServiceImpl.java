package com.example.project.servise;
import com.example.project.dto.document.PrikazDto;
import com.example.project.dto.document.VkrDto;
import com.example.project.mapper.document.PrikazMapper;
import com.example.project.mapper.document.VkrMapper;
import com.example.project.model.Employee;
import com.example.project.model.document.Prikaz;
import com.example.project.model.document.Vkr;
import com.example.project.repository.PrikazRepository;
import com.example.project.repository.VkrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class VkrServiceImpl implements VkrService {
    @Autowired
    private VkrRepository vkrRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private VkrMapper vkrMapper;

    @Override
    public List<VkrDto> getAllVkr() {
        List<Vkr> vkrList = vkrRepository.findAll();
        return vkrMapper.convertModelsToDtos(vkrList);
    }

    @Override
    public List<VkrDto> getAllByRuk(String rukFio) {
        Employee employee = employeeService.getEmployeeByFio(rukFio);
        List<Vkr> vkrList = vkrRepository.findAllByRuk(employee);
        return vkrMapper.convertModelsToDtos(vkrList);
    }

    @Override
    public VkrDto getVkrByNumber(String number) {
        Vkr vkr = vkrRepository.findByNumber(number);
        return vkrMapper.convertModelToDto(vkr);
    }

    @Override
    public List<VkrDto> getAllByGroup(String group) {
        List<Vkr> vkrList = vkrRepository.findAllByGroup(group);
        return vkrMapper.convertModelsToDtos(vkrList);
    }

    @Override
    public List<VkrDto> getAllByFio(String fio) {
        List<Vkr> vkrList = vkrRepository.findAllByFio(fio);
        return vkrMapper.convertModelsToDtos(vkrList);
    }

    @Override
    public List<VkrDto> getAllByTema(String tema) {
        List<Vkr> vkrList = vkrRepository.findAllByTema(tema);
        return vkrMapper.convertModelsToDtos(vkrList);
    }

    @Override
    public List<VkrDto> getAllByYear(String year) {
        List<Vkr> vkrList = vkrRepository.findAllByYear(year);
        return vkrMapper.convertModelsToDtos(vkrList);
    }

    @Override
    public List<VkrDto> getAllByNapr(String napr) {
        List<Vkr> vkrList = vkrRepository.findAllByNapravlenie(napr);
        return vkrMapper.convertModelsToDtos(vkrList);
    }
}
