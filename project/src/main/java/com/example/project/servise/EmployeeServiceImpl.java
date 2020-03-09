package com.example.project.servise;

import com.example.project.mapper.EmployeeMapper;
import com.example.project.model.Employee;
import com.example.project.model.dto.EmployeeDto;
import com.example.project.repository.EmployeeRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public void addNewEmployee(Employee newEmployee) {
        employeeRepository.save(newEmployee);
    }

    @Override
    public Employee getEmployeeByFio(String fio) {
        Optional<Employee> employeeCandidate = employeeRepository.findByFio(fio);
        if(employeeCandidate.isPresent()) {
            return employeeCandidate.get();
        }
        return null;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
       return employeeMapper.convertModelsToDtos(employeeRepository.findAll());
    }


}
