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
    private boolean isCreateNoInfo = false;

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

    @Qualifier("MenuMenuView")
    @Autowired
    private ControllersConfig.ViewHolder menuView;

    @Qualifier("noLoginInfoChildrenView")
    @Autowired
    private  ControllersConfig.ViewHolder noInfoChildrenView;


    @FXML
    private void clickMenuButton (ActionEvent event) throws Exception {
        getNextStage(menuButton, menuView);
    }
    @FXML
    private void clickInfoChildrenButton (ActionEvent event) throws  Exception {
        if(!isCreateAdd){
            getNextNewStage(infoChildrenButton,infoChildrenView);
            isCreateAdd=true;
        } else {
            getNextStage(infoChildrenButton, infoChildrenView);
        }
      /*  if(MainMenuController.isLogin){
            isCreateInfo = isCreateStage(infoChildrenView,isCreateInfo,infoChildrenButton);
        } else{
            isCreateNoInfo = isCreateStage(noInfoChildrenView,isCreateNoInfo,infoChildrenButton);
        }*/
    }
    @FXML
    private void clickAddChildrenButton (ActionEvent event) throws Exception{
        if(!isCreateAdd){
            getNextNewStage(addChildrenButton,addChildrenView);
            isCreateAdd=true;
        } else {
            getNextStage(addChildrenButton, addChildrenView);
        }
    }

}
