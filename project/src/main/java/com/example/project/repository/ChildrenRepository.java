package com.example.project.repository;

import com.example.project.model.Children;
import com.example.project.model.Employee;
import com.example.project.model.document.Recenzent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChildrenRepository extends JpaRepository<Children, Long> {

    Children save(Children newChildren);

    List<Children> findAll();

    void removeByFio(String fio);

    List<Children> findAllByFio(String fio);
    List<Children> findAllByData(String data);
    List<Children> findAllByNameParents(String nameParents);










}
