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
public class ChildrenController extends AbstractController {

    @FXML
    private Button menuButton;
    @FXML
    private Button infoChildrenButton;
    @FXML
    private Button addChildrenButton;

    /*private void getNextStage(Button button, String nameFile ) throws Exception {
        Stage stage = (Stage) button.getScene().getWindow(); // какое окно сейчас открыто
        stage.close(); // закрывает данное окно
        Parent root = FXMLLoader.load(getClass().getResource(nameFile)); // загружаем файл для отрислвки интерфейса приложения
        stage.setScene(new Scene(root)); // передаем новую сцену для отрисовки окна
        stage.show(); // открывает наше новое окно

     */
    @Qualifier("InfoChildrenView")
    @Autowired
    private ControllersConfig.ViewHolder infoChildrenView;

    @Qualifier("AddChildrenView")
    @Autowired
    private ControllersConfig.ViewHolder addChildrenView;

    @FXML
    private void clickMenuButton (ActionEvent event) throws Exception {
       // getNextStage(menuButton, "/fxml/menu.fxml");
    }
    @FXML
    private void clickInfoChildrenButton (ActionEvent event) throws  Exception {
        getNextStage(infoChildrenButton,infoChildrenView);
    }
    @FXML
    private void clickAddChildrenButton (ActionEvent event) throws Exception{
       getNextStage(addChildrenButton, addChildrenView);
    }

}
