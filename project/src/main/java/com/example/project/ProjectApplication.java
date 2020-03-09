package com.example.project;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Lazy;


@Lazy
@SpringBootApplication
public class ProjectApplication extends AbstractJavaFxAppSupport {


    @Qualifier("MainMenuView")
    @Autowired
    private ControllersConfig.ViewHolder viewHolder;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(viewHolder.getView()));
        primaryStage.setResizable(true);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launchApp(ProjectApplication.class, args);
    }
}
