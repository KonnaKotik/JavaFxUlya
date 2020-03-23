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

    private boolean isCreateInfo = false;
    private boolean isCreateAdd = false;


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
    private void clickInfoButton(ActionEvent event) throws Exception{
        if(!isCreateInfo){
            getNextNewStage(infoButton,infoView);
            isCreateInfo = true;
        } else {
            getNextStage(infoButton,infoView);
        }

    }
    @FXML
    private  void clickAddEmployeeButton(ActionEvent event) throws Exception{
        if(!isCreateAdd) {
            getNextNewStage(addEmployeeButton, addEmployeeView);
            isCreateAdd = true;

        } else {

            getNextStage(addEmployeeButton, addEmployeeView);
        }
    }

    @FXML
    private void clickMenuButton(ActionEvent event) throws Exception{
        getNextStage(menuButton, menuView);
    }

}
