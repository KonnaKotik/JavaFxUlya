package com.example.project.repository;
import com.example.project.model.Employee;
import com.example.project.model.User;
import com.example.project.model.document.Prikaz;
import com.example.project.model.document.Vkr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository

public interface VkrRepository extends JpaRepository<Vkr, Long> {

    //находит все
    List<Vkr> findAll();

    List<Vkr> findAllByRuk(Employee employee);

    Vkr findByNumber(String number);

    List<Vkr> findAllByGroup(String group);

    List<Vkr> findAllByFio(String fio);

    List<Vkr> findAllByTema(String tema);

    List<Vkr> findAllByYear(String year);

    List<Vkr> findAllByNapravlenie(String napr);
}

