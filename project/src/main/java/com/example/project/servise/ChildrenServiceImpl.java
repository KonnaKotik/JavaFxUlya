package com.example.project.servise;

import com.example.project.mapper.ChildrenMapper;
import com.example.project.model.Children;
import com.example.project.model.Employee;
import com.example.project.model.dto.ChildrenDto;
import com.example.project.repository.ChildrenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ChildrenServiceImpl implements ChildrenService {

    @Autowired
    private ChildrenMapper childrenMapper;

    @Autowired
    private ChildrenRepository childrenRepository;

    @Override
    public void addNewChildren(Children newChildren) {
        childrenRepository.save(newChildren);
    }//добавляем нового ребенка и сохраняем его

    @Override
    public List<ChildrenDto> getAllChildren() {
        return childrenMapper.convertModelsToDtos(childrenRepository.findAll());
    }

    @Override
    public String listToString(List<Employee> employeeList){
        StringBuilder parents = new StringBuilder();
        System.out.println(employeeList.isEmpty() + "empty");
        for (Employee employee:employeeList) {
            parents.append(employee.getFio()).append(", ");
        }
        return parents.toString();
    }
}
