package com.example.project.controller;

import com.example.project.ControllersConfig;
import com.example.project.model.Children;
import com.example.project.model.Employee;
import com.example.project.servise.ChildrenService;
import com.example.project.servise.EmployeeService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.LinkedList;
import java.util.List;

@Controller
public class AddChildrenController extends AbstractController {
    @FXML
    private Label message;
    @FXML
    private Button exitButton;
    @FXML
    private TextField fioButton;
    @FXML
    private TextField dataButton;
    @FXML
    private TextField parentsButton;

    @Autowired
    private ChildrenService childrenService;

    @Autowired
    private EmployeeService employeeService;

    @Qualifier("ChildrenView")
    @Autowired
    private ControllersConfig.ViewHolder childrenView;


    @FXML
    private void clickExitButton(ActionEvent event) throws Exception {
        getNextStage(exitButton, childrenView);
    }


    @FXML
    private void addChildren(ActionEvent event) {
        String parentFio = parentsButton.getText();
        System.out.println(parentFio);
        Employee employee = employeeService.getEmployeeByFio(parentFio);
        System.out.println(employee.getFio());
        List<Employee> parents = new LinkedList<>();
        parents.add(employee);
        Children children = new Children(fioButton.getText(), dataButton.getText(), parents);
        System.out.println(children.getFio());
        childrenService.addNewChildren(children);
       addChildrenInEmployee(employee, children);
        message.setText("Ребенок добавлен");
        setNullField();
    }

    private void addChildrenInEmployee(Employee employee, Children children){
        List<Children> childrenList = new LinkedList<>();
        childrenList.add(children);
        employee.setChildrenList(childrenList);
       employeeService.addNewEmployee(employee);
    }
    private void setNullField(){
        fioButton.setText(null);
        dataButton.setText(null);
        parentsButton.setText(null);

    }

}