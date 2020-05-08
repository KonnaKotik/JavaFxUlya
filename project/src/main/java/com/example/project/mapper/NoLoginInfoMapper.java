/*package com.example.project.mapper;
import com.example.project.dto.ChildrenDto;
import com.example.project.dto.NoLoginInfoDto;
import com.example.project.dto.document.PrikazDto;
import com.example.project.dto.document.RecenzentDto;
import com.example.project.model.Children;
import com.example.project.model.Employee;
import com.example.project.model.document.Prikaz;
import com.example.project.model.document.Recenzent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NoLoginInfoMapper {
    public NoLoginInfoDto convertModelToDto(NoLoginInfo noLoginInfo) {
        return NoLoginInfoDto.builder()
                .tubNum(noLoginInfo.getTubNum())
                .fio(noLoginInfo.getFio())
                .birthday(noLoginInfo.getBirthday())
                .phone(noLoginInfo.getPhone())
                .education(noLoginInfo.getEducation())
                .post(noLoginInfo.getPost())
                .addmission(noLoginInfo.getAddmission())
                .build();
    }
    private Stream<NoLoginInfoDto> modelsToDtos(List<NoLoginInfo> noLoginInfoList){
        return noLoginInfoList.stream().map(this::convertModelToDto);
    }

    public List<NoLoginInfoDto> convertModelsToDtos(List<NoLoginInfo> noLoginInfoList) {
        return modelsToDtos(noLoginInfoList).collect(Collectors.toList());
    }
}
*/
