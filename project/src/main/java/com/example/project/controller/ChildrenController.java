package com.example.project.controller;

import com.example.project.ControllersConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ChildrenController extends AbstractController {

    private boolean isCreateInfo = false;

    private boolean isCreateAdd = false;


    @FXML
    private Button menuButton;
    @FXML
    private Button infoChildrenButton;
    @FXML
    private Button addChildrenButton;

    @Qualifier("InfoChildrenView")
    @Autowired
    private ControllersConfig.ViewHolder infoChildrenView;

    @Qualifier("AddChildrenView")
    @Autowired
    private ControllersConfig.ViewHolder addChildrenView;



    @FXML
    private void clickMenuButton (ActionEvent event) throws Exception {
       getMenuStage(menuButton);
    }
    @FXML
    private void clickInfoChildrenButton (ActionEvent event) throws  Exception {
       isCreateInfo = isCreateStage(infoChildrenView, isCreateInfo, infoChildrenButton);

    }
    @FXML
    private void clickAddChildrenButton (ActionEvent event) throws Exception{
        isCreateAdd = isCreateStage(addChildrenView, isCreateAdd, addChildrenButton);
    }

}
