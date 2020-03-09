package com.example.project.repository;

import com.example.project.model.Children;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildrenRepository extends JpaRepository<Children, Long> {

    Children save(Children newChildren);
}
