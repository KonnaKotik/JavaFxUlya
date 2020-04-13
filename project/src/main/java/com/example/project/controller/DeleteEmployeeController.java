package com.example.project.controller;



import com.example.project.ControllersConfig;
import com.example.project.model.Employee;
import com.example.project.servise.EmployeeService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.soap.Text;

@Controller
public class DeleteEmployeeController extends AbstractController {

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
    private TextField fioField;

    @Qualifier("EmployeeView")
    @Autowired
    private ControllersConfig.ViewHolder employeeView;

    @Qualifier("deleteEmployee2View")
    @Autowired
    private ControllersConfig.ViewHolder deleteEmployee2View;

    @Qualifier("deleteEmployeeMessageView")
    @Autowired
    private ControllersConfig.ViewHolder deleteEmployeeMessageView;


    @FXML
    private void clickExitButton(ActionEvent event) {
        getNextStage(exitButton, employeeView);
    }


    @FXML
    private void clickDeleteButton(ActionEvent event) throws Exception {
        if(fioField.getText() == null) {
            int i = 0;
        } else {
            Employee employee = employeeService.getEmployeeByFio(fioField.getText());
            if(employee != null) {
                isCreateDeleteWindow2 = isCreateStage(deleteEmployee2View, isCreateDeleteWindow2, deleteButton);
            } else {
                int i = 0;
            }
        }
    }

    @FXML
    private void clickYesButton(ActionEvent event) throws Exception {
        employeeService.deleteEmployee(fioField.getText());
        fioField.setText(null);
        isCreateDeleteMessage = isCreateStage(deleteEmployeeMessageView, isCreateDeleteMessage, yesButton);
    }

    @FXML
    private void clickNoButton(ActionEvent event) {

    }

}
