package com.example.project.controller;

import com.example.project.ControllersConfig;
import com.example.project.dto.ChildrenDto;
import com.example.project.dto.EmployeeDto;
import com.example.project.dto.document.PrikazDto;
import com.example.project.dto.document.RecenzentDto;
import com.example.project.dto.document.SrokiDto;
import com.example.project.mapper.ChildrenMapper;
import com.example.project.mapper.EmployeeMapper;
import com.example.project.model.Employee;
import com.example.project.servise.ChildrenService;
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
public class InfoEmployeeController extends AbstractController{
    @Autowired
    private EmployeeService employeeService;//?

    @Autowired
    private EmployeeMapper employeeMapper;//?



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
    private TextField tabNumField;
    @FXML
    private TextField fioField;
    @FXML
    private TextField ccField;
    @FXML
    private TextField innField;
    @FXML
    private TextField passportField;
    @FXML
    private TextField birthdayField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField educationField;
    @FXML
    private TextField postField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField addmissionField;
    @FXML
    private Label errorMessage;


    @FXML
    private Button exitButton;

    @FXML
    private Button loadButton;

    @Qualifier("EmployeeView")
    @Autowired
    private ControllersConfig.ViewHolder employeeView;

    @Qualifier("noLoginEmployeeView")
    @Autowired
    private ControllersConfig.ViewHolder noLoginEmployeeView;


     @FXML
     private TableView<EmployeeDto> table;
    private List<EmployeeDto> employeeDtoList; //?
    private List<Employee> employeeList;//?

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
    private void setTable(List<EmployeeDto> employeeDtos) {
        table.setItems(FXCollections.observableArrayList(employeeDtos));
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
    private void clickFindCc(ActionEvent event) {
        String cc = ccField.getText();
        List<EmployeeDto> employeeDtos = employeeService.getAllByCc(cc);
        if(!employeeDtos.isEmpty()) {
            setTable(employeeDtos);
        }else {
            errorMessage.setText("Данные не найдены");
        }
        setNullField();
    }
    @FXML
    private void clickFindInn(ActionEvent event) {
        String inn = innField.getText();
        List<EmployeeDto> employeeDtos = employeeService.getAllByInn(inn);
        if(!employeeDtos.isEmpty()) {
            setTable(employeeDtos);
        }else {
            errorMessage.setText("Данные не найдены");
        }
        setNullField();
    }
    @FXML
    private void clickFindPassport(ActionEvent event) {
        String passport = passportField.getText();
        List<EmployeeDto> employeeDtos = employeeService.getAllByPassport(passport);
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
    private void clickFindAddress(ActionEvent event) {
        String address = addressField.getText();
        List<EmployeeDto> employeeDtos = employeeService.getAllByAddress(address);
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
        ccField.setText(null);
        innField.setText(null);
        postField.setText(null);
        passportField.setText(null);
        birthdayField.setText(null);
        phoneField.setText(null);
        addmissionField.setText(null);
        addressField.setText(null);
    }


}
