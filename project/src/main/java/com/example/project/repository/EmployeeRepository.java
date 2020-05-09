package com.example.project.repository;

import com.example.project.model.Children;
import com.example.project.model.Employee;
import com.example.project.model.document.Prikaz;
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
    //Optional<Employee> findAllByFio(String fio);
    Optional<Employee> findByTabNum(String tabNum);
    List<Employee> findAllByPassport(String passport);
    List<Employee> findAllByBirthday(String birthday);
    List<Employee> findAllByCc(String cc);
    List<Employee> findAllByInn(String inn);
    List<Employee> findAllByPhone(String phone);
    List<Employee> findAllByEducation(String education);
    List<Employee> findAllByAddress(String address);
    List<Employee> findAllByAddmission(String addmission);
    List<Employee> findAllByPost(String post);

    List<Employee> findAllByFio(String fio);




    void deleteByFio(String fio);

    void removeByFio(String fio);

    //
  //  List<Employee> findEmployeesByChildrenList(List<Children> childrenList);
}
