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
}
