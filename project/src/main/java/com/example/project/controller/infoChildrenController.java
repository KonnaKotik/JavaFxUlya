package com.example.project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class infoChildrenController  {
    @FXML
    private Button exitButton;

    private void getNextStage(Button button, String nameFile ) throws Exception {
        Stage stage = (Stage) button.getScene().getWindow(); // какое окно сейчас открыто
        stage.close(); // закрывает данное окно
        Parent root = FXMLLoader.load(getClass().getResource(nameFile)); // загружаем файл для отрислвки интерфейса приложения
        stage.setScene(new Scene(root)); // передаем новую сцену для отрисовки окна
        stage.show(); // открывает наше новое окно

}

    @FXML
    private void clickExitButton (ActionEvent event) throws  Exception{
        getNextStage(exitButton,"/fxml/children.fxml");
    }
}
