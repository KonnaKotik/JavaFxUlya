package com.example.project.controller;

import com.example.project.ControllersConfig;
import com.example.project.dto.document.RecenzentDto;
import com.example.project.mapper.ChildrenMapper;
import com.example.project.model.Employee;
import com.example.project.dto.ChildrenDto;
import com.example.project.servise.ChildrenService;
import com.example.project.servise.EmployeeService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class InfoChildrenController extends AbstractController {
    @Autowired
    private ChildrenService childrenService;

    @Autowired
    private EmployeeService employeeService;


    @FXML
    private Button loadButton;

    @FXML
    private Button exitButton;
    @FXML
    private TableColumn<String, ChildrenDto>  fio;

    @FXML
    private TableColumn<String,ChildrenDto> data;

    @FXML
    private  TableColumn<String, ChildrenDto> nameParents;

    @FXML
    private TableView<ChildrenDto> childrenTable;
    @FXML
    private TextField fioField;
    @FXML
    private TextField dataField;
    @FXML
    private TextField nameParentsField;
    @FXML
    private Label errorMessage;

    private List<ChildrenDto> childrenDtoList;
    private List<Employee> employeeList;

    @Qualifier("ChildrenView")
    @Autowired
    private ControllersConfig.ViewHolder childrenView;

    @Qualifier("noLoginChildrenView")
    @Autowired
    private ControllersConfig.ViewHolder noLoginChildrenView;

    private void setTable(List<ChildrenDto> childrenDtos) {
        childrenTable.setItems(FXCollections.observableArrayList(childrenDtos));
    }



    public void initialize() {
        fio.setCellValueFactory(new PropertyValueFactory<>("fio"));
        data.setCellValueFactory(new PropertyValueFactory<>("data"));
        nameParents.setCellValueFactory(new PropertyValueFactory<>("nameParents"));
        setNullField();
    }

    @FXML
    private void clickLoadButton(ActionEvent event) {
        childrenDtoList  = childrenService.getAllChildren();
        childrenTable.setItems(FXCollections.observableArrayList(childrenDtoList));
    }


    @FXML
    private void clickExitButton (ActionEvent event) throws  Exception{
        if(MainMenuController.isLogin){
            getNextStage(exitButton,childrenView);
        }else{
            getNextStage(exitButton,noLoginChildrenView);
        }
    }
    @FXML
    private void clickFindFio(ActionEvent event) {
        String fio = fioField.getText();
        List<ChildrenDto> childrenDtos = childrenService.getAllByFio(fio);
        if(!childrenDtos.isEmpty()) {
            setTable(childrenDtos);
        }else {
            errorMessage.setText("Данные не найдены");
        }
        setNullField();
    }
    @FXML
    private void clickFindData(ActionEvent event) {
        String data = dataField.getText();
        List<ChildrenDto> childrenDtos = childrenService.getAllByData(data);
        if (!childrenDtos.isEmpty()) {
            setTable(childrenDtos);
        } else {
            errorMessage.setText("Данные не найдены");
        }
        setNullField();
    }

    @FXML
    private void clickFindParents(ActionEvent event) {
        String fio = nameParentsField.getText();
        List<ChildrenDto> childrenDtos = childrenService.getAllByParents(fio);
        if(!childrenDtos.isEmpty()) {
            setTable(childrenDtos);
        } else {
            errorMessage.setText("Данные не найдены");
        }
    }

    private void setNullField() {
        fioField.setText(null);
        dataField.setText(null);
        nameParentsField.setText(null);
    }
}
