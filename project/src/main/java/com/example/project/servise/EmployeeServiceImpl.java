package com.example.project.servise;

import com.example.project.mapper.EmployeeMapper;
import com.example.project.model.Children;
import com.example.project.model.Employee;
import com.example.project.dto.EmployeeDto;
import com.example.project.model.document.Prikaz;
import com.example.project.model.document.Vkr;
import com.example.project.repository.ChildrenRepository;
import com.example.project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    @Autowired
    private ChildrenRepository childrenRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public void addNewEmployee(Employee newEmployee) {
        employeeRepository.save(newEmployee);
    }

    @Override
    public Employee getEmployeeByFio(String fio) {
        Optional<Employee> employeeCandidate = employeeRepository.findByFio(fio);
        return employeeCandidate.orElse(null);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
       return employeeMapper.convertModelsToDtos(employees);
    }

    @Override
    public List<Employee> getAllByChildren(List<Children> childrenList) {
        return null;
               // employeeRepository.findEmployeesByChildrenList(childrenList);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(String fio) {
        Employee employee = getEmployeeByFio(fio);
        List<Children> childrenList = employee.getChildrenList();
        List<Children> children = new LinkedList<>();
        if(!childrenList.isEmpty()) {
           children =  customParentsChildrenEmployee(childrenList);
        }
        List<Prikaz> prikazList = employee.getPrikazs();
        List<Vkr> vkrList = employee.getVkrs();
        employee.setPrikazs(null);
        employee.setChildrenList(null);
        employee.setVkrs(null);
        employeeRepository.save(employee);
        deleteChuldrenEmpl(children);
        employeeRepository.delete(employee);
    }

    private List<Children> customParentsChildrenEmployee(List<Children> children) {
        for (Children child: children) {
            child.setParents(null);
            childrenRepository.save(child);
        }
        return children;
    }

    private void deleteChuldrenEmpl(List<Children> children) {
        for (Children child: children) {
            childrenRepository.delete(child);
        }
    }


}
