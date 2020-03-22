package com.example.project.servise;

import com.example.project.model.Children;
import com.example.project.model.Employee;
import com.example.project.model.dto.ChildrenDto;

import java.util.List;

public interface ChildrenService {

    void addNewChildren(Children newChildren);//добавляем нового ребенка

    List<ChildrenDto> getAllChildren();// находим все объекты класса(чилдренов) в подклассе

    String listToString(List<Employee> employeeList);
}
