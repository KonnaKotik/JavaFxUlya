package com.example.project.repository;
import com.example.project.model.User;
import com.example.project.model.document.Prikaz;
import com.example.project.model.document.SostavGek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface SostavGekRepository extends JpaRepository<SostavGek, Long> {
    List<SostavGek> findAll();
}
