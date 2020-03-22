package com.example.project.controller;
import com.example.project.ControllersConfig;
import com.example.project.servise.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;


@Controller
public class UserController extends AbstractController {

    private boolean isCreateEnter = false;

    @FXML
    private Button menuButton;
    @FXML
    private TextField loginField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button enterButton;

    @Autowired
    private UserService userService;

    @Qualifier("MenuMenuView")
    @Autowired
    private ControllersConfig.ViewHolder menuView;

    @Qualifier("MainMenuView")
    @Autowired
    private ControllersConfig.ViewHolder viewHolder;

    @FXML
    public void clickMenuButton(ActionEvent event) throws Exception {
        getNextStage(menuButton, viewHolder);
    }

    @FXML
    private void  clickEnterButton(ActionEvent event) throws Exception{
        boolean result = userService.signIn(loginField.getText(), passwordField.getText());
        if(result) {
            MainMenuController.isLogin = true;
            if(!isCreateEnter) {
                getNextNewStage(enterButton, menuView);
                isCreateEnter = true;
            } else {
                getNextStage(enterButton, menuView);
            }
        }
    }

}
