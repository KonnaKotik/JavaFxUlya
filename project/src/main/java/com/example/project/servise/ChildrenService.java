package com.example.project.servise;

import com.example.project.dto.document.RecenzentDto;
import com.example.project.model.Children;
import com.example.project.model.Employee;
import com.example.project.dto.ChildrenDto;
import com.example.project.model.document.Recenzent;

import java.util.List;

public interface ChildrenService {
    List<ChildrenDto> getAllChildren();// находим все объекты класса(чилдренов) в подклассе
    List<ChildrenDto> getAllByFio(String fio);
    List<ChildrenDto> getAllByData(String data);
    List<ChildrenDto> getAllByNameParents(String nameParents);


    void addNewChildren(Children newChildren);//добавляем нового ребенка



    String listToString(List<Employee> employeeList);
}
