package com.example.project.repository;
import com.example.project.model.User;
import com.example.project.model.document.Prikaz;
import com.example.project.model.document.Sroki;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface SrokiRepository extends JpaRepository<Sroki, Long> {

    //находит все
    List<Sroki> findAll();
}
