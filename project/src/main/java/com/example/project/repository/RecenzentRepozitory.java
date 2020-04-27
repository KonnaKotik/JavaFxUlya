package com.example.project.repository;

import com.example.project.model.document.Recenzent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecenzentRepozitory extends JpaRepository<Recenzent, Long> {

    List<Recenzent> findAll();

}
