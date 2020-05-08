package com.example.project.controller;


import com.example.project.ControllersConfig;
import com.example.project.model.Employee;
import com.example.project.servise.EmployeeService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.soap.Text;

@Controller
public class AddEmpController extends AbstractController {

    private boolean isCreateAddEmployeeMassage = false;

    @FXML
    private Label message;

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
    // почему Button??

    @FXML
    private Button exitButton;


   /* @Qualifier("AddEmployeeMassageView")
    @Autowired
    private ControllersConfig.ViewHolder addEmployeeMassageView;*/

    @Qualifier("EmployeeView")
    @Autowired
    private ControllersConfig.ViewHolder employeeView;

    @Autowired
    private EmployeeService employeeService;


    @FXML
    private void clickDeleteButton(ActionEvent event) throws Exception {

    }

    @FXML
    private void addNewEmployee(ActionEvent event) {
        Employee newEmployee = new Employee(tabNumButton.getText(), fioButton.getText(), passButton.getText(), birthButton.getText(), ccButton.getText(), innButton.getText(), numButton.getText(), educButton.getText(), addressButton.getText(), dateButton.getText(), addmiButton.getText());
        employeeService.addNewEmployee(newEmployee); //создвем сотрудника,который включает в себя: табельный номер, фио, паспорт, день рождения,страховое свидетельство, инн, номер телефона ,образование, адрес и тд.
        message.setText("Сотрудник добавлен");
        setNullField();

    }

    @FXML
    private void clickExitButton(ActionEvent event) {
        message.setText(null);
        getNextStage(exitButton, employeeView);
    }
    private void setNullField(){
        tabNumButton.setText(null);
        fioButton.setText(null);
        passButton.setText(null);
        birthButton.setText(null);
        ccButton.setText(null);
        innButton.setText(null);
        numButton.setText(null);
        educButton.setText(null);
        addressButton.setText(null);
        dateButton.setText(null);
        addmiButton.setText(null);
    }


}
