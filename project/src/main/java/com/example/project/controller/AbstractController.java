package com.example.project.controller;

import com.example.project.ControllersConfig;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public abstract class AbstractController {

    protected void getNextStage(Button button, ControllersConfig.ViewHolder viewName ) throws Exception {
        Stage stage = (Stage) button.getScene().getWindow(); // какое окно сейчас открыто
        stage.close(); // закрывает данное окно
        stage.setScene(new Scene(viewName.getView())); // передаем новую сцену для отрисовки окна
        stage.show(); // открывает наше новое окно
    }
}
