package com.example.project.controller;

import com.example.project.ControllersConfig;
import com.example.project.dto.EmployeeDto;
import com.example.project.servise.EmployeeService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class InfoEmployeeController extends AbstractController{



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

    @Qualifier("EmployeeView")
    @Autowired
    private ControllersConfig.ViewHolder employeeView;

    @Qualifier("noLoginEmployeeView")
    @Autowired
    private ControllersConfig.ViewHolder noLoginEmployeeView;


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
        

    }




    @FXML
    private void clickExitButton (ActionEvent event) throws Exception {
         if(MainMenuController.isLogin) {
             getNextStage(exitButton, employeeView);
         } else {
             getNextStage(exitButton, noLoginEmployeeView);
         }
    }



}
