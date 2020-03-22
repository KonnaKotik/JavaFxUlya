package com.example.project.controller;

import com.example.project.ControllersConfig;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public abstract class AbstractController {

    // метод создания/перехода нового окна (сцены)
    protected void getNextNewStage(Button button, ControllersConfig.ViewHolder viewName ) throws Exception {
        Stage stage = (Stage) button.getScene().getWindow(); // какое окно сейчас открыто
        stage.close(); // закрывает данное окно
        stage.setScene(new Scene(viewName.getView())); // передаем новую сцену для отрисовки окна
        stage.show(); // открывает наше новое окно
    }

    //метод перехода для кнопки "Назад" для открытия предыдущего окна
    protected void getNextStage(Button button, ControllersConfig.ViewHolder viewName) {
        Stage stage = (Stage) button.getScene().getWindow(); // какое окно сейчас открыто
        stage.close(); // закрывает данное окно
        stage.setScene(viewName.getView().getScene());
        stage.show();
    }
}
