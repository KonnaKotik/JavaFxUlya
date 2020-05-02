package com.example.project.servise;
import com.example.project.dto.document.RecenzentDto;
import com.example.project.dto.document.SostavGekDto;
import com.example.project.model.document.SostavGek;

import java.util.List;

public interface SostavGekService {

    List<SostavGekDto> getAllSostavGek();

    List<SostavGekDto> getAllByYear(String year);

    List<SostavGekDto> getAllByNapr(String napr);

    List<SostavGekDto> getAllByProfil(String profil);

    List<SostavGekDto> getAllByPred(String pred);

    List<SostavGekDto> getAllByZam(String zam);

    List<SostavGekDto> getAllByKom(String kom);

    List<SostavGekDto> getAllByForma(String forma);

    List<SostavGekDto> getAllBySek(String sek);

    void addNewSostavGek(SostavGek sostavGek);

}
