package com.example.project.servise;

import com.example.project.dto.document.PrikazDto;
import com.example.project.mapper.document.PrikazMapper;
import com.example.project.model.Employee;
import com.example.project.model.document.Prikaz;
import com.example.project.repository.PrikazRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class PrikazServiceImpl implements PrikazService {
    @Autowired
    private PrikazRepository prikazRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PrikazMapper prikazMapper;

    @Override
    public List<PrikazDto> getAllPrikaz() {
        List<Prikaz> prikazList = prikazRepository.findAll();
        return prikazMapper.convertModelsToDtos(prikazList);
    }

    @Override
    public PrikazDto getPrikazByNum(String num) {
        Optional<Prikaz> prikazOptional = prikazRepository.findByNumber(num);
        if(prikazOptional.isPresent()) {
            PrikazDto prikazDto = prikazMapper.convertModelToDto(prikazOptional.get());
            return prikazDto;
        }
        return null;
    }

    @Override
    public List<PrikazDto> getAllByData(String data) {
        List<Prikaz> prikazList = prikazRepository.findAllByData(data);
        return prikazMapper.convertModelsToDtos(prikazList);
    }

    @Override
    public List<PrikazDto> getAllByPost(String post) {
        List<Prikaz> prikazList = prikazRepository.findAllByPost(post);
        return prikazMapper.convertModelsToDtos(prikazList);
    }

    @Override
    public List<PrikazDto> getAllByDescription(String description) {
        List<Prikaz> prikazList = prikazRepository.findAllByDescription(description);
        return prikazMapper.convertModelsToDtos(prikazList);
    }

    @Override
    public List<PrikazDto> getAllByEmployee(String fio) {
        Employee employee = employeeService.getEmployeeByFio(fio);
       /* List<Employee> employees = new LinkedList<>();
        employees.add(employee);*/
       List<Prikaz> prikazList = prikazRepository.findAllByEmployees(employee);
       return prikazMapper.convertModelsToDtos(prikazList);
    }

    @Override
    public void addNewPrikaz(Prikaz prikaz, String fio) {
        prikaz = prikazRepository.save(prikaz);
        List<Employee> employees = getEmployeesFio(fio, prikaz);
        prikaz.setEmployees(employees);
      //  prikazRepository.save(prikaz);

    }

    private List<Employee> getEmployeesFio(String fio, Prikaz prikaz) {
        List<Employee> employeeList = new LinkedList<>();
        for (String name: fio.split(",")) {
            name = name.trim();
            Employee employee = employeeService.getEmployeeByFio(name);
            List<Prikaz> prikazList =employee.getPrikazs();
            prikazList.add(prikaz);
            employee.setPrikazs(prikazList);
            employeeService.updateEmployee(employee);
            employeeList.add(employeeService.getEmployeeByFio(name));
        }
        return employeeList;
    }
}
