package com.example.project.repository;
import com.example.project.dto.document.SrokiDto;
import com.example.project.model.User;
import com.example.project.model.document.Prikaz;
import com.example.project.model.document.SostavGek;
import com.example.project.model.document.Sroki;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface SrokiRepository extends JpaRepository<Sroki, Long> {

    //находит все
    List<Sroki> findAll();

    List<Sroki> findAllByInstitute(String institute);

    List<Sroki> findAllByNumberGroup(String number);

    List<Sroki> findAllByNapravlenie(String napr);

    List<Sroki> findAllByData(String data);

    List<Sroki> findAllByStart(String start);

    List<Sroki> findAllByNumberAudit(String audit);

    List<Sroki> findAllByFormaOb(String forma);

}
