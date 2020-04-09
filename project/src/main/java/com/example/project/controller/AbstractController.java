package com.example.project.controller;

import com.example.project.ControllersConfig;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class AbstractController {

    @Qualifier("MenuMenuView")
    @Autowired
    private ControllersConfig.ViewHolder menuView;

    @Qualifier("noLoginMenuMenuView")
    @Autowired
    private  ControllersConfig.ViewHolder noLoginView;

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


    protected boolean isCreateStage(ControllersConfig.ViewHolder nameView, boolean isCreate, Button button ) throws Exception {
      if(!isCreate) {
          getNextNewStage(button, nameView);
          isCreate = true;
      } else {
          getNextStage(button, nameView);
      }
      return  isCreate;
    }

    protected void getMenuStage(Button button) {
        if(!MainMenuController.isLogin) {
            getNextStage(button, noLoginView);
        } else {
            getNextStage(button, menuView);
        }
    }
}
