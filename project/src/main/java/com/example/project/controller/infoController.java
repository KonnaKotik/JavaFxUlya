package com.example.project.controller;

import com.example.project.model.Employee;
import com.example.project.model.dto.EmployeeDto;
import com.example.project.servise.EmployeeService;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class infoController extends AbstractController{

    @FXML
    private Button exitButton;

    @FXML
    private Button loadButton;

    @Autowired
    private EmployeeService employeeService;

    private ObservableList<EmployeeDto> employeeList;

     @FXML
     private TableView<EmployeeDto> table;

    @FXML
    private void clickLoadButton(ActionEvent event) {
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        employeeList.setAll(FXCollections.observableList(employees));
        table.setItems(employeeList);

    }




    @FXML
    private void clickExitButton (ActionEvent event) throws Exception {

    }

   /* @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Employee> employees = employeeService.getAllEmployees();
        employeeList.setAll(FXCollections.observableList(employees));
    }*/


}
