package com.example.project.controller;



import com.example.project.ControllersConfig;
import com.example.project.model.Employee;
import com.example.project.servise.EmployeeService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.soap.Text;

@Controller
public class DeleteEmployeeController extends AbstractController {

    @FXML
    private Button deleteButton;

    @FXML
    private Button exitButton;


    @FXML
    private TextField fioField;

    @Qualifier("EmployeeView")
    @Autowired
    private ControllersConfig.ViewHolder employeeView;


    @FXML
    private void clickExitButton() {
        getNextStage(exitButton, employeeView);
    }

}
