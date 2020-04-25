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
public class DeleteEmployeeController extends AbstractController {

    private static String fio;


    private boolean isCreateDeleteWindow2 = false;
    private boolean isCreateDeleteMessage = false;

    @Autowired
    private EmployeeService employeeService;

    @FXML
    private Button deleteButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button yesButton;

    @FXML
    private Button noButton;

    @FXML
    private Label errorMessage;


    @FXML
    private TextField fioField;

    @FXML
    private Button okButton;


    @Qualifier("EmployeeView")
    @Autowired
    private ControllersConfig.ViewHolder employeeView;

    @Qualifier("deleteEmployee2View")
    @Autowired
    private ControllersConfig.ViewHolder deleteEmployee2View;

    @Qualifier("deleteEmployeeMessageView")
    @Autowired
    private ControllersConfig.ViewHolder deleteEmployeeMessageView;

    @Qualifier("DeleteEmployeeView")
    @Autowired
    private ControllersConfig.ViewHolder deleteEmployeeView;


    @FXML
    private void clickExitButton(ActionEvent event) {
        fioField.setText(null);
        errorMessage.setText(null);
        getNextStage(exitButton, employeeView);
    }


    @FXML
    private void clickDeleteButton(ActionEvent event) throws Exception {
        fio = fioField.getText();
        if( fio== null) {
           errorMessage.setText("Вы не ввели ФИО сотрудника");
        } else {
            Employee employee = employeeService.getEmployeeByFio(fio);
            if(employee != null) {
                isCreateDeleteWindow2 = isCreateStage(deleteEmployee2View, isCreateDeleteWindow2, deleteButton);
                fioField.setText(null);
                errorMessage.setText(null);
            } else {
                errorMessage.setText("Сотрудник " + fio + " не найден" );
            }
        }
    }

    @FXML
    private void clickYesButton(ActionEvent event) throws Exception {
        employeeService.deleteEmployee(fio);
       // fioField.setText(null);
        isCreateDeleteMessage = isCreateStage(deleteEmployeeMessageView, isCreateDeleteMessage, yesButton);
    }

    @FXML
    private void clickNoButton(ActionEvent event) {
        getNextStage(noButton,employeeView);

    }

    @FXML
    private void clickOkButton(ActionEvent event) {
        getNextStage(okButton, deleteEmployeeView);
    }

}
