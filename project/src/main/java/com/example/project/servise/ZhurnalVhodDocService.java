package com.example.project.servise;
import com.example.project.dto.document.PrikazDto;
import com.example.project.dto.document.VkrDto;
import com.example.project.dto.document.ZhurnalVhodDocDto;
import com.example.project.model.document.Prikaz;
import com.example.project.model.document.Sroki;
import com.example.project.model.document.ZhurnalVhodDoc;

import java.util.List;

public interface ZhurnalVhodDocService {
    List<ZhurnalVhodDocDto> getAllZhurnalVhodDoc();

    ZhurnalVhodDocDto getZhurnalVhodDocByNumber(String number);

    List<ZhurnalVhodDocDto> getAllByData(String data);

    List<ZhurnalVhodDocDto> getAllByTip(String tip);

    List<ZhurnalVhodDocDto> getAllBySoder(String soder);

    List<ZhurnalVhodDocDto> getAllByKod(String kod);

    List<ZhurnalVhodDocDto> getAllByIsp(String isp);

    void addNewZhurnalVhodDoc(ZhurnalVhodDoc zhurnalVhodDoc);
}
