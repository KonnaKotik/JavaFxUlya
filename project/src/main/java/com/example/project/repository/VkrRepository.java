package com.example.project.repository;
import com.example.project.model.User;
import com.example.project.model.document.Prikaz;
import com.example.project.model.document.Vkr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository

public interface VkrRepository extends JpaRepository<Vkr, Long> {

    //находит все
    List<Vkr> findAll();
}

