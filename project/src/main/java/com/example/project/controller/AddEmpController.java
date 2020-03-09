package com.example.project.controller;


import com.example.project.model.Employee;
import com.example.project.servise.EmployeeService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.xml.soap.Text;

@Controller
public class AddEmpController extends AbstractController {

    @FXML
    private Button addChildrenButton;

    @FXML
    private TextField tabNumButton;

    @FXML
    private TextField passButton;

    @FXML
    private TextField fioButton;

    @FXML
    private TextField birthButton;

    @FXML
    private TextField ccButton;

    @FXML
    private TextField innButton;

    @FXML
    private TextField numButton;

    @FXML
    private TextField addmiButton;

    @FXML
    private TextField dateButton;

    @FXML
    private TextField addressButton;

    @FXML
    private TextField educButton;

    @Autowired
    private EmployeeService employeeService;

    @FXML
    private void addNewEmployee() {
        Employee newEmployee = new Employee(tabNumButton.getText(), fioButton.getText(), passButton.getText(), birthButton.getText(), ccButton.getText(), innButton.getText(), numButton.getText(), educButton.getText(), addressButton.getText(), dateButton.getText(), addmiButton.getText());
        employeeService.addNewEmployee(newEmployee);

    }


}