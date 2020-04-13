package com.example.project.servise;

import com.example.project.mapper.EmployeeMapper;
import com.example.project.model.Children;
import com.example.project.model.Employee;
import com.example.project.model.dto.EmployeeDto;
import com.example.project.repository.ChildrenRepository;
import com.example.project.repository.EmployeeRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void deleteEmployee(String fio) {
        Employee employee = getEmployeeByFio(fio);
        List<Children> children = employee.getChildrenList();
        childrenRepository.deleteAll(children);
        employeeRepository.deleteByFio(fio);
    }


}
