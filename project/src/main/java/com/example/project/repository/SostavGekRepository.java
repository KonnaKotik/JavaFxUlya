package com.example.project.repository;
import com.example.project.model.User;
import com.example.project.model.document.Prikaz;
import com.example.project.model.document.Recenzent;
import com.example.project.model.document.SostavGek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface SostavGekRepository extends JpaRepository<SostavGek, Long> {

   List<SostavGek> findAll();

   List<SostavGek> findAllByYear(String year);

   List<SostavGek> findAllByNapr(String napr);

   List<SostavGek> findAllByProfil(String profil);

   List<SostavGek> findAllByPred(String pred);

   List<SostavGek> findAllByZam(String zam);

   List<SostavGek> findAllByKom(String kom);

   List<SostavGek> findAllByForma(String forma);

   List<SostavGek> findAllBySek(String sek);

}
