package com.example.project.repository;

import com.example.project.model.Children;
import com.example.project.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChildrenRepository extends JpaRepository<Children, Long> {

    Children save(Children newChildren);

    List<Children> findAll();



}
