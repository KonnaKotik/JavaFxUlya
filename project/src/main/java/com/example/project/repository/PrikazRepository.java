package com.example.project.repository;

import com.example.project.model.User;
import com.example.project.model.document.Prikaz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrikazRepository extends JpaRepository<Prikaz, Long> {

    //находит все приказы
    List<Prikaz> findAll();
}
