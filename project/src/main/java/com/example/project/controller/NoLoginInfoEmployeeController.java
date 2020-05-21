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
    private TextField addmissionField;


    @FXML
    private Button exitButton;

    @FXML
    private Button loadButton;
    @FXML
    private Label errorMessage;

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
       setNullField();
    }

    @FXML
    private void clickLoadButton(ActionEvent event) {
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        table.setItems(FXCollections.observableArrayList(employees));

    }
    private void setTable(List<EmployeeDto> employeeDtos) {
        table.setItems(FXCollections.observableArrayList(employeeDtos));
    }

    @FXML
    private void clickExitButton(ActionEvent event) throws Exception {
        getNextStage(exitButton, noLoginEmployeeView);
    }
        @FXML
        private void clickFindTabNum(ActionEvent event) {
            String tabNum = tabNumField.getText();
            EmployeeDto employeeDto = employeeService.getEmployeeByTabNum(tabNum);
            if (employeeDto != null) {
                List<EmployeeDto> employeeDtos = new LinkedList<>();
                employeeDtos.add(employeeDto);
                setTable(employeeDtos);
            } else {
                errorMessage.setText("Данные не найдены");
            }
            setNullField();
        }
    @FXML
    private void clickFindFio(ActionEvent event) {
        String fio = fioField.getText();
        List<EmployeeDto> employeeDtos = employeeService.getAllByFio(fio);
        if(!employeeDtos.isEmpty()) {
            setTable(employeeDtos);
        }else {
            errorMessage.setText("Данные не найдены");
        }
        setNullField();
    }
    @FXML
    private void clickFindBirthday(ActionEvent event) {
        String birthday = birthdayField.getText();
        List<EmployeeDto> employeeDtos = employeeService.getAllByBirthday(birthday);
        if(!employeeDtos.isEmpty()) {
            setTable(employeeDtos);
        }else {
            errorMessage.setText("Данные не найдены");
        }
        setNullField();
    }
    @FXML
    private void clickFindPhone(ActionEvent event) {
        String phone = phoneField.getText();
        List<EmployeeDto> employeeDtos = employeeService.getAllByPhone(phone);
        if(!employeeDtos.isEmpty()) {
            setTable(employeeDtos);
        }else {
            errorMessage.setText("Данные не найдены");
        }
        setNullField();
    }
    @FXML
    private void clickFindEducation(ActionEvent event) {
        String education = educationField.getText();
        List<EmployeeDto> employeeDtos = employeeService.getAllByEducation(education);
        if(!employeeDtos.isEmpty()) {
            setTable(employeeDtos);
        }else {
            errorMessage.setText("Данные не найдены");
        }
        setNullField();
    }
    @FXML
    private void clickFindPost(ActionEvent event) {
        String post = postField.getText();
        List<EmployeeDto> employeeDtos = employeeService.getAllByPost(post);
        if(!employeeDtos.isEmpty()) {
            setTable(employeeDtos);
        }else {
            errorMessage.setText("Данные не найдены");
        }
        setNullField();
    }
    @FXML
    private void clickFindAddmission(ActionEvent event) {
        String addmission = addmissionField.getText();
        List<EmployeeDto> employeeDtos = employeeService.getAllByAddmission(addmission);
        if(!employeeDtos.isEmpty()) {
            setTable(employeeDtos);
        }else {
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

    }
}



