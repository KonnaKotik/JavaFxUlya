package com.example.project.controller;

import com.example.project.ControllersConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController extends AbstractController {

    @FXML
    private Button menuButton;

    @FXML
    private Button infoButton;

    @FXML
    private Button addEmployeeButton;

    @Qualifier("InfoView")
    @Autowired
    private ControllersConfig.ViewHolder infoView;

    @Qualifier("AddEmployeeView")
    @Autowired
    private ControllersConfig.ViewHolder addEmployeeView;

    @Qualifier("MenuMenuView")
    @Autowired
    private ControllersConfig.ViewHolder menuView;


    @FXML
    private void clickMenuButton(ActionEvent event) throws Exception{
        getNextNewStage(menuButton, menuView);
    }
    @FXML
    private void clickInfoButton(ActionEvent event) throws Exception{
       getNextNewStage(infoButton,infoView);
    }
    @FXML
    private  void clickAddEmployeeButton(ActionEvent event) throws Exception{
        getNextNewStage(addEmployeeButton, addEmployeeView);
    }

}
