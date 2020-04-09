package com.example.project.controller;

import com.example.project.ControllersConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class MenuController extends AbstractController{

    private boolean isCreateEmployee = false;
    private boolean isCreateNoEmployee = false;
    private boolean isCreateChildren = false;
    private boolean isCreateNoChildren = false;
    private boolean isCreateDocument = false;
    private boolean isCreateNoDocument = false;


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

    @Qualifier("MainMenuView")
    @Autowired
    private  ControllersConfig.ViewHolder mainMenuView;

    @Qualifier("noLoginChildrenView")
    @Autowired
    private ControllersConfig.ViewHolder noLoginChildrenView;

    @Qualifier("noLoginDocumentView")
    @Autowired
    private ControllersConfig.ViewHolder noLoginDocumentView;

    @Qualifier("noLoginEmployeeView")
    @Autowired
    private ControllersConfig.ViewHolder noLoginEmployeeView;



    @FXML
    private void click(ActionEvent event) throws Exception {
        if(MainMenuController.isLogin) {
            isCreateEmployee = isCreateStage(employeeView, isCreateEmployee, employeeButton);
        } else {
            isCreateNoEmployee = isCreateStage(noLoginEmployeeView, isCreateNoEmployee, employeeButton);
        }

    }
    @FXML
    private void clickDocument(ActionEvent event) throws Exception{
        if(MainMenuController.isLogin) {
           isCreateDocument =  isCreateStage(documentView, isCreateDocument, documentButton);
        } else {
           isCreateNoDocument = isCreateStage(noLoginDocumentView, isCreateNoDocument, documentButton);
        }
    }

    @FXML
    private void clickChildren(ActionEvent event) throws  Exception {
        if(MainMenuController.isLogin) {
            isCreateChildren = isCreateStage(childrenView, isCreateChildren, childrenButton);
        } else {
            isCreateNoChildren = isCreateStage(noLoginChildrenView, isCreateNoChildren, childrenButton);
        }

    }
    @FXML
    private  void clickExitButton(ActionEvent event) throws Exception{
        MainMenuController.isLogin = false;
        getNextStage(exitButton,mainMenuView);
        }

    /*
        event - событие. НАши методы реагируют на како-либо1 событие.
        Например, нажатие кнопки (это событиые). Когда ты нажимаешь кнопку "расписание",
        происходит событие, программа отлавливает событие и смотреит с каким элементов
        (в нашем случае, с кнопкой timetableButton) это произошло и вызывает его. Следовательно иы переходим в другое окно.
        В нашем файле .fxml  в параметрах кнопки написано onAction, в нем мы указывает название метод,
        которое должно выполниться при каком-то действии с этим элементом.
    */

}
