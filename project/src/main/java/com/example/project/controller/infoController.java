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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.List;
import java.util.PropertyPermission;
import java.util.ResourceBundle;

@Controller
public class infoController extends AbstractController{



    @FXML
    private TableColumn<String, EmployeeDto> tabNum;

    @FXML
    private TableColumn<String, EmployeeDto> fio;

    @FXML
    private TableColumn<String, EmployeeDto> cc;

    @FXML
    private TableColumn<String, EmployeeDto> inn;

    @FXML
    private TableColumn<String, EmployeeDto> passport;

    @FXML
    private TableColumn<String, EmployeeDto> birthday;

    @FXML
    private TableColumn<String, EmployeeDto> phone;

    @FXML
    private TableColumn<String, EmployeeDto> education;

    @FXML
    private TableColumn<String, EmployeeDto> post;

    @FXML
    private TableColumn<String, EmployeeDto> status;

    @FXML
    private TableColumn<String, EmployeeDto> address;

    @FXML
    private TableColumn<String, EmployeeDto> addmission;

    @FXML
    private Button exitButton;

    @FXML
    private Button loadButton;

    @Autowired
    private EmployeeService employeeService;


     @FXML
     private TableView<EmployeeDto> table;

     public void initialize() {
         tabNum.setCellValueFactory(new PropertyValueFactory<>("tabNum"));
         fio.setCellValueFactory(new PropertyValueFactory<>("fio"));
         cc.setCellValueFactory(new PropertyValueFactory<>("cc"));
         inn.setCellValueFactory(new PropertyValueFactory<>("inn"));
         address.setCellValueFactory(new PropertyValueFactory<>("address"));
         addmission.setCellValueFactory(new PropertyValueFactory<>("addmission"));
         birthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
         phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
         status.setCellValueFactory(new PropertyValueFactory<>("status"));
         post.setCellValueFactory(new PropertyValueFactory<>("post"));
         education.setCellValueFactory(new PropertyValueFactory<>("education"));
         passport.setCellValueFactory(new PropertyValueFactory<>("passport"));
     }

    @FXML
    private void clickLoadButton(ActionEvent event) {
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        table.setItems(FXCollections.observableArrayList(employees));
        loadButton.setDisable(true);

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
