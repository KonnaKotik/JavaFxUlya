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
    private boolean isNoCreateInfo = false;
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

    @Qualifier("DeleteEmployeeView")
    @Autowired
    private ControllersConfig.ViewHolder deleteEmployeeView;

    @Qualifier("noLoginInfoEmployeeView")
    @Autowired
    private ControllersConfig.ViewHolder noLoginInfoView;



    @FXML
    private void clickInfoButton(ActionEvent event) throws Exception{
        if(!MainMenuController.isLogin){
            isNoCreateInfo = isCreateStage(noLoginInfoView, isNoCreateInfo, infoButton);
        } else {
            isCreateInfo = isCreateStage(infoView, isCreateInfo, infoButton);
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
    private void clickDeleteEmployeeButton(ActionEvent event) throws Exception{
        if(!isCreateDelete){
            getNextStage(deleteEmployeeButton, deleteEmployeeView);
            isCreateDelete = true;
        } else {

            getNextStage(deleteEmployeeButton,deleteEmployeeView);
        }
    }

    @FXML
    private void clickMenuButton(ActionEvent event) throws Exception{
        getMenuStage(menuButton);
    }

}
