package com.example.project.repository;

import com.example.project.model.Employee;
import com.example.project.model.document.Prikaz;
import com.example.project.model.document.Recenzent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecenzentRepozitory extends JpaRepository<Recenzent, Long> {

    List<Recenzent> findAll();

    Optional<Recenzent> findByNumber(String num);

    List<Recenzent> findAllByFio(String fio);

    List<Recenzent> findAllByPost(String post);

    List<Recenzent> findAllByYear(String year);

}
