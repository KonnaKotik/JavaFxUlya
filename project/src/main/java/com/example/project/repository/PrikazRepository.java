package com.example.project.repository;

import com.example.project.model.Employee;
import com.example.project.model.User;
import com.example.project.model.document.Prikaz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PrikazRepository extends JpaRepository<Prikaz, Long> {

    //находит все приказы
    List<Prikaz> findAll();

    Optional<Prikaz> findByNumber(String num);

    List<Prikaz> findAllByData(String data);

    List<Prikaz> findAllByPost(String post);

    List<Prikaz> findAllByDescription(String description);

    List<Prikaz> findAllByEmployees(Employee employee);
}
