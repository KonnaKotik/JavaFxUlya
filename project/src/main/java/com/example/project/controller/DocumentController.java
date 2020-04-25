package com.example.project.controller;

import com.example.project.ControllersConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class DocumentController extends AbstractController {

    private  boolean isCreatePrikaz = false;
    private boolean isCreateRecenzent = false;

    @FXML
    private Button menuButton;

    @FXML
    private Button recenzButton;

    @FXML
    private Button prikazButton;

    @Qualifier("recenzentView")
    @Autowired
    private ControllersConfig.ViewHolder recenzentView;

    @Qualifier("prikazView")
    @Autowired
    private ControllersConfig.ViewHolder prikazView;


    @FXML
    private void clickPrikazButton(ActionEvent event) throws Exception {
        if(MainMenuController.isLogin){
           isCreatePrikaz = isCreateStage(prikazView, isCreatePrikaz, prikazButton);
        }
    }

    @FXML
    private void clickRecenzentButton(ActionEvent event) throws Exception {
        isCreateRecenzent = isCreateStage(recenzentView, isCreateRecenzent, recenzButton);
    }



    @FXML
    private void clickMenuButton(ActionEvent event) throws Exception{
       getMenuStage(menuButton);
    }

}
