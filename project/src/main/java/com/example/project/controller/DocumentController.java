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
    private boolean isCreateSostavGek = false;
    private boolean isCreateSroki = false;
    private boolean isCreateVkr = false;
    private boolean isCreateZhurnalVhodDoc = false;

    @FXML
    private Button menuButton;

    @FXML
    private Button recenzButton;

    @FXML
    private Button prikazButton;

    @FXML
    private Button sostavButton;

    @FXML
    private Button srokiButton;

    @FXML
    private Button vkrButton;

    @FXML
    private Button vhodDocButton;


    @Qualifier("recenzentView")
    @Autowired
    private ControllersConfig.ViewHolder recenzentView;

    @Qualifier("prikazView")
    @Autowired
    private ControllersConfig.ViewHolder prikazView;

    @Qualifier("sostavGekView")
    @Autowired
    private ControllersConfig.ViewHolder sostavGekView;

    @Qualifier("srokiView")
    @Autowired
    private ControllersConfig.ViewHolder srokiView;

    @Qualifier("vkrView")
    @Autowired
    private ControllersConfig.ViewHolder vkrView;

    @Qualifier("zhurnalVhodDocView")
    @Autowired
    private ControllersConfig.ViewHolder zhurnalVhodDocView;



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
    private void clickSostavGekButton(ActionEvent event) throws Exception{
        isCreateSostavGek = isCreateStage(sostavGekView, isCreateSostavGek, sostavButton);
    }

    @FXML
    private void clickSrokiButton(ActionEvent event) throws Exception{
        isCreateSroki = isCreateStage(srokiView, isCreateSroki, srokiButton);
    }

    @FXML
    private void clickVkrButton(ActionEvent event) throws Exception{
        isCreateVkr = isCreateStage(vkrView, isCreateVkr, vkrButton);
    }

    @FXML
    private void clickZhurnalVhodDocButton(ActionEvent event) throws Exception{
        if(MainMenuController.isLogin){
            isCreateZhurnalVhodDoc = isCreateStage(zhurnalVhodDocView, isCreateZhurnalVhodDoc, vhodDocButton);
        }

    }



    @FXML
    private void clickMenuButton(ActionEvent event) throws Exception{
       getMenuStage(menuButton);
    }

}
