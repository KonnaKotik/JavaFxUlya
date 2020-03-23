package com.example.project.controller;

import com.example.project.ControllersConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class MainMenuController extends AbstractController {

    public static boolean isLogin;

    private boolean isCreateLogin = false;
    private  boolean isCreateNoLogin = false;


    @FXML
    private Button loginButton;

    @FXML
    private Button noLoginButton;

    @Qualifier("loginView")
    @Autowired
    private ControllersConfig.ViewHolder loginView;

    @Qualifier("MenuMenuView")
    @Autowired
    private  ControllersConfig.ViewHolder noLoginView;



    @FXML
    public void clickLogin(ActionEvent event) throws Exception {
        if(!isCreateLogin){
            getNextNewStage(loginButton, loginView);
            isCreateLogin = true;
        }else{
            getNextStage(loginButton, loginView);
        }

    }
    @FXML
    public void clickNoLogin(ActionEvent event) throws Exception{
        isLogin = false;
        if (!isCreateNoLogin) {
            getNextNewStage(noLoginButton, noLoginView);
            isCreateNoLogin = true;
        }else {
            getNextStage(noLoginButton, noLoginView);
        }

    }
}
