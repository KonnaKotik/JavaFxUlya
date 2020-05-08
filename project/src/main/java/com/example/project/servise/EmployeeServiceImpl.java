package com.example.project.servise;

import com.example.project.dto.ChildrenDto;
import com.example.project.dto.document.PrikazDto;
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
    public EmployeeDto getEmployeeByTabNum(String tabNum) {
        Optional<Employee> employeeOptional = employeeRepository.findByTabNum(tabNum);
        if(employeeOptional.isPresent()) {
            EmployeeDto employeeDto = employeeMapper.convertModelToDto(employeeOptional.get());
            return employeeDto;
        }
        return null;
    }
   /* @Override
   public List<EmployeeDto> getEmployeeByFio(String fio) {
        List<Employee> employeeList = employeeRepository.findAllByFio(fio);
        return employeeMapper.convertModelsToDtos(employeeList);
    }*/
   @Override
   public List<EmployeeDto> getAllByFio(String fio) {
       List<Employee> employeeList = employeeRepository.findAllByPassport(fio);
       return employeeMapper.convertModelsToDtos(employeeList);
   }
    @Override
    public List<EmployeeDto> getAllByPassport(String passport) {
        List<Employee> employeeList = employeeRepository.findAllByPassport(passport);
        return employeeMapper.convertModelsToDtos(employeeList);
    }
    @Override
    public List<EmployeeDto> getAllByBirthday(String birthday) {
        List<Employee> employeeList = employeeRepository.findAllByBirthday(birthday);
        return employeeMapper.convertModelsToDtos(employeeList);
    }
    @Override
    public List<EmployeeDto> getAllByCc(String cc) {
        List<Employee> employeeList = employeeRepository.findAllByCc(cc);
        return employeeMapper.convertModelsToDtos(employeeList);
    }
    @Override
    public List<EmployeeDto> getAllByInn(String inn) {
        List<Employee> employeeList = employeeRepository.findAllByInn(inn);
        return employeeMapper.convertModelsToDtos(employeeList);
    }
    @Override
    public List<EmployeeDto> getAllByPhone(String phone) {
        List<Employee> employeeList = employeeRepository.findAllByPhone(phone);
        return employeeMapper.convertModelsToDtos(employeeList);
    }
    @Override
    public List<EmployeeDto> getAllByEducation(String education) {
        List<Employee> employeeList = employeeRepository.findAllByEducation(education);
        return employeeMapper.convertModelsToDtos(employeeList);
    }
    @Override
    public List<EmployeeDto> getAllByAddress(String address) {
        List<Employee> employeeList = employeeRepository.findAllByAddress(address);
        return employeeMapper.convertModelsToDtos(employeeList);
    }
    @Override
    public List<EmployeeDto> getAllByAddmission(String addmission) {
        List<Employee> employeeList = employeeRepository.findAllByAddmission(addmission);
        return employeeMapper.convertModelsToDtos(employeeList);
    }
    @Override
    public List<EmployeeDto> getAllByPost(String post) {
        List<Employee> employeeList = employeeRepository.findAllByPost(post);
        return employeeMapper.convertModelsToDtos(employeeList);
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
