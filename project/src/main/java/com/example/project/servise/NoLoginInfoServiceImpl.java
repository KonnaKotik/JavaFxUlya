/*package com.example.project.servise;
import com.example.project.dto.NoLoginInfoDto;
import com.example.project.mapper.NoLoginInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoLoginInfoServiceImpl implements NoLoginInfoService {
    @Autowired
    private NoLoginInfoRepository noLoginInfoRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private NoLoginInfoMapper noLoginInfoMapper;
    @Override
    public List<NoLoginInfoDto> getAllNoLoginInfo() {
        List<NoLoginInfo> noLoginInfoList = noLoginInfoRepository.findAll();
        return noLoginInfoMapper.convertModelsToDtos(noLoginInfoList);
    }
    @Override
    public NoLoginInfoDto getNoLoginInfoByTubNum(String tubNum) {
        Optional<NoLoginInfo> noLoginInfoOptional = noLoginInfoRepository.findByTubNum(tubNum);
        if(noLoginInfoOptional.isPresent()) {
            NoLoginInfoDto noLoginInfoDto = noLoginInfoMapper.convertModelToDto(noLoginInfoOptional.get());
            return noLoginInfoDto;
        }
        return null;
    }

}*/
