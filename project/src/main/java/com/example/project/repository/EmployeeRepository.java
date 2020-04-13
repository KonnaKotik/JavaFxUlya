package com.example.project.repository;

import com.example.project.model.Children;
import com.example.project.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //добавляет в бд (нового сорулника)
    Employee save(Employee employee);

    //находим сотрдника по fio
    Optional<Employee> findByFio(String fio);

    //находим сех сотрудников из бд
    List<Employee> findAll();

    void deleteByFio(String fio);

    //
  //  List<Employee> findEmployeesByChildrenList(List<Children> childrenList);
}
