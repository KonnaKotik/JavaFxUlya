package com.example.project.controller;

import com.example.project.ControllersConfig;
import com.example.project.dto.EmployeeDto;
//import com.example.project.dto.NoLoginInfoDto;
import com.example.project.dto.document.PrikazDto;
import com.example.project.servise.EmployeeService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.LinkedList;
import java.util.List;

@Controller
public class NoLoginInfoEmployeeController extends AbstractController {


    @FXML
    private TableColumn<String, EmployeeDto> tabNum;

    @FXML
    private TableColumn<String, EmployeeDto> fio;

    @FXML
    private TableColumn<String, EmployeeDto> birthday;

    @FXML
    private TableColumn<String, EmployeeDto> phone;

    @FXML
    private TableColumn<String, EmployeeDto> education;

    @FXML
    private TableColumn<String, EmployeeDto> post;

    @FXML
    private TableColumn<String, EmployeeDto> addmission;
/*
    @FXML
    private TextField tabNumField;
    @FXML
    private TextField fioField;
    @FXML
    private TextField birthdayField;
    @FXML
    private TextField phoneField;
    @FXML
    private  TextField educationField;
    @FXML
    private TextField postField;
    @FXML
    private TextField addmissionField;*/


    @FXML
    private Button exitButton;

    @FXML
    private Button loadButton;
   /* @FXML
    private Label errorMessage;*/

    @Autowired
    private EmployeeService employeeService;

    @Qualifier("noLoginEmployeeView")
    @Autowired
    private ControllersConfig.ViewHolder noLoginEmployeeView;


    @FXML
    private TableView<EmployeeDto> table;

    public void initialize() {
        tabNum.setCellValueFactory(new PropertyValueFactory<>("tabNum"));
        fio.setCellValueFactory(new PropertyValueFactory<>("fio"));
        addmission.setCellValueFactory(new PropertyValueFactory<>("addmission"));
        birthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        post.setCellValueFactory(new PropertyValueFactory<>("post"));
        education.setCellValueFactory(new PropertyValueFactory<>("education"));
       // setNullField();
    }

    @FXML
    private void clickLoadButton(ActionEvent event) {
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        table.setItems(FXCollections.observableArrayList(employees));

    }

    @FXML
    private void clickExitButton(ActionEvent event) throws Exception {
        getNextStage(exitButton, noLoginEmployeeView);

    }
    /*private void setTable(List<NoLoginInfoDto> noLoginInfoDtos) { table.setItems(FXCollections.observableArrayList(noLoginInfoDtos)); }
    @FXML
    private void clickFindTabNum(ActionEvent event) {
        String tubNum = tubNumField.getText();
        NoLoginInfoDto noLoginInfoDto = noLoginInfoService.getNoLoginInfoByTubNum(tubNum);
        if (noLoginInfoDto != null) {
            List<NoLoginInfoDto> noLoginInfoDtos = new LinkedList<>();
            noLoginInfoDtos.add(noLoginInfoDto);
            setTable(noLoginInfoDtos);
        } else {
            errorMessage.setText("Данные не найдены");
        }
        setNullField();
    }
    private void setNullField() {
        tabNumField.setText(null);
        fioField.setText(null);
        birthdayField.setText(null);
        phoneField.setText(null);
        educationField.setText(null);
        postField.setText(null);
        addmissionField.setText(null);

    }*/


}
