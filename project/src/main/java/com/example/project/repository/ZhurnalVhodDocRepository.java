package com.example.project.repository;
import com.example.project.model.User;
import com.example.project.model.document.Prikaz;
import com.example.project.model.document.ZhurnalVhodDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ZhurnalVhodDocRepository extends JpaRepository<ZhurnalVhodDoc, Long> {

    //находит все приказы
    List<ZhurnalVhodDoc> findAll();
}
