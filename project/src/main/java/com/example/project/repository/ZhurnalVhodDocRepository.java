package com.example.project.repository;
import com.example.project.dto.document.ZhurnalVhodDocDto;
import com.example.project.model.Employee;
import com.example.project.model.User;
import com.example.project.model.document.Prikaz;
import com.example.project.model.document.ZhurnalVhodDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface ZhurnalVhodDocRepository extends JpaRepository<ZhurnalVhodDoc, Long> {

    //находит все приказы
    List<ZhurnalVhodDoc> findAll();

    Optional<ZhurnalVhodDoc> findByNumber(String number);

    List<ZhurnalVhodDoc> findAllByData(String data);

    List<ZhurnalVhodDoc> findAllByTipDoc(String tip);

    List<ZhurnalVhodDoc> findAllBySoderzhanie(String soder);

    List<ZhurnalVhodDoc> findAllByKod(String kod);

    List<ZhurnalVhodDoc> findAllByPost(String post);
}
