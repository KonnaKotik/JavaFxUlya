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
public class MenuController extends AbstractController{

    @FXML
    private Button employeeButton;
    @FXML
    private Button childrenButton;
    @FXML
    private Button documentButton;

    @FXML
    private Button exitButton;
    @Qualifier("ChildrenView")
    @Autowired
    private ControllersConfig.ViewHolder childrenView;
    @Qualifier("EmployeeView")
    @Autowired
    private ControllersConfig.ViewHolder employeeView;

    @Qualifier("DocumentView")
    @Autowired
    private ControllersConfig.ViewHolder documentView;
    @FXML
    private void click(ActionEvent event) throws Exception {
        getNextStage(employeeButton,employeeView );
    }
    @FXML
    private void clickDocument(ActionEvent event) throws Exception{
        getNextStage(documentButton, documentView);
    }

    @FXML
    private void clickChildren(ActionEvent event) throws  Exception {
        getNextStage(childrenButton,childrenView);
    }
    /*
        event - событие. НАши методы реагируют на како-либо1 событие.
        Например, нажатие кнопки (это событиые). Когда ты нажимаешь кнопку "расписание",
        происходит событие, программа отлавливает событие и смотреит с каким элементов
        (в нашем случае, с кнопкой timetableButton) это произошло и вызывает его. Следовательно иы переходим в другое окно.
        В нашем файле .fxml  в параметрах кнопки написано onAction, в нем мы указывает название метод,
        которое должно выполниться при каком-то действии с этим элементом.
    */

    @FXML
    private void clickExit (ActionEvent event) throws Exception{
    }

}
