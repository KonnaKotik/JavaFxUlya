package com.example.project.servise;
import com.example.project.dto.document.PrikazDto;
import com.example.project.dto.document.SostavGekDto;
import com.example.project.dto.document.SrokiDto;
import com.example.project.model.document.Prikaz;

import javax.xml.soap.SAAJResult;
import java.util.List;

public interface SrokiService {
    List<SrokiDto> getAllSroki();

    List<SrokiDto> getAllByInstitute(String institute);

    List<SrokiDto> getAllByNumber(String number);

    List<SrokiDto> getAllByNapr(String napr);

    List<SrokiDto> getAllByData(String data);

    List<SrokiDto> getAllByStart(String start);

    List<SrokiDto> getAllByAudit(String audit);

    List<SrokiDto> getAllByForma(String forma);

}
