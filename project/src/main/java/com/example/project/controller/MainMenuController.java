package com.example.project.controller;

import com.example.project.ControllersConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
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

    @Qualifier("noLoginMenuMenuView")
    @Autowired
    private  ControllersConfig.ViewHolder noLoginView;



    @FXML
    public void clickLogin(ActionEvent event) throws Exception {
        isCreateLogin = isCreateStage(loginView, isCreateLogin, loginButton);

    }
    @FXML
    public void clickNoLogin(ActionEvent event) throws Exception{
        isLogin = false;
        isCreateNoLogin = isCreateStage(noLoginView, isCreateNoLogin, noLoginButton);

    }
}
