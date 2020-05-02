package com.example.project.controller.document;


import com.example.project.ControllersConfig;
import com.example.project.controller.AbstractController;
import com.example.project.controller.MainMenuController;
import com.example.project.dto.document.PrikazDto;
import com.example.project.servise.PrikazService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.LinkedList;
import java.util.List;


@Controller
public class PrikazController extends AbstractController {

    @Autowired
    private PrikazService prikazService;

    @FXML
    private TableColumn<String, PrikazDto> fio;

    @FXML
    private TableColumn<String, PrikazDto> data;

    @FXML
    private TableColumn<String, PrikazDto> number;

    @FXML
    private TableColumn<String, PrikazDto> description;

    @FXML
    private TableColumn<String, PrikazDto> post;

    @FXML
    private TableView<PrikazDto> table;

    @FXML
    private Button exitButton;

    @FXML
    private Button loadButton;

    @FXML
    private TextField numberField;

    @FXML
    private Button numberButton;

    @FXML
    private TextField dataField;

    @FXML
    private TextField postField;

    @FXML
    private TextField prikazField;

    @FXML
    private TextField fioField;

    private List<PrikazDto> prikazDtoList;

    @FXML
    private Label errorMessage;

    @Qualifier("DocumentView")
    @Autowired
    private ControllersConfig.ViewHolder documenView;

    @Qualifier("noLoginDocumentView")
    @Autowired
    private ControllersConfig.ViewHolder noLoginDocumentView;

    public void initialize() {
        number.setCellValueFactory(new PropertyValueFactory<>("number"));
        data.setCellValueFactory(new PropertyValueFactory<>("data"));
        fio.setCellValueFactory(new PropertyValueFactory<>("fio"));
        post.setCellValueFactory(new PropertyValueFactory<>("post"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
    }

    @FXML
    private void clickLoadButton(ActionEvent event) {
        prikazDtoList = prikazService.getAllPrikaz();
        table.setItems(FXCollections.observableArrayList(prikazDtoList));
    }

    @FXML
    private void clickExitButton(ActionEvent event) throws Exception {
        if (MainMenuController.isLogin) {
            getNextStage(exitButton, documenView);
        } else {
            getNextStage(exitButton, noLoginDocumentView);
        }
    }
    private void setTable(List<PrikazDto> prikazDtos) {
        table.setItems(FXCollections.observableArrayList(prikazDtos));
    }

    @FXML
    private void clickFindNum(ActionEvent event) {
        String num = numberField.getText();
        PrikazDto prikazDto = prikazService.getPrikazByNum(num);
        if (prikazDto != null) {
            List<PrikazDto> prikazDtos = new LinkedList<>();
            prikazDtos.add(prikazDto);
            setTable(prikazDtos);
        }else {
            errorMessage.setText("Данные не найдены");
        }
    }

    @FXML
    private void clickFindData(ActionEvent event) {
        String data = dataField.getText();
        List<PrikazDto> prikazDtos = prikazService.getAllByData(data);
        if(!prikazDtos.isEmpty()) {
            setTable(prikazDtos);
        }else {
            errorMessage.setText("Данные не найдены");
        }

    }

    @FXML
    private void clickFindPost(ActionEvent event) {
        String post = postField.getText();
        List<PrikazDto> prikazDtos = prikazService.getAllByPost(post);
        if(!prikazDtos.isEmpty()) {
            setTable(prikazDtos);
        }else {
            errorMessage.setText("Данные не найдены");
        }

    }

    @FXML
    private void clickFindDescription(ActionEvent event) {
        String description = prikazField.getText();
        List<PrikazDto> prikazDtos = prikazService.getAllByDescription(description);
        if(!prikazDtos.isEmpty()){
            setTable(prikazDtos);
        }else {
            errorMessage.setText("Данные не найдены");
        }

    }

    @FXML
    private void clickFindEmployee(ActionEvent event) {
        String employeeFio = fioField.getText();
        List<PrikazDto> prikazDtos = prikazService.getAllByEmployee(employeeFio);
        if(!prikazDtos.isEmpty()) {
            setTable(prikazDtos);
        }else {
            errorMessage.setText("Данные не найдены");
        }

    }






}
