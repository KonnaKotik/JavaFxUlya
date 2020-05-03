package com.example.project.controller.document;

import com.example.project.ControllersConfig;
import com.example.project.controller.AbstractController;
import com.example.project.controller.MainMenuController;
import com.example.project.dto.document.RecenzentDto;
import com.example.project.model.document.Recenzent;
import com.example.project.model.document.SostavGek;
import com.example.project.servise.RecenzentService;
import javafx.scene.control.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import com.example.project.dto.document.PrikazDto;
import com.example.project.servise.PrikazService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.LinkedList;
import java.util.List;

@Controller
public class RecenzentController extends AbstractController {

    @Autowired
    private RecenzentService recenzentService;

    @FXML
    private TableColumn<String, RecenzentDto> number;

    @FXML
    private TableColumn<String,RecenzentDto> fio;

    @FXML
    private TableColumn<String, RecenzentDto>  post;

    @FXML
    private TableColumn<String,RecenzentDto> year;


    @FXML
    private TableView<RecenzentDto> table;

    @FXML
    private Button exitButton;

    @FXML
    private Button loadButton;

    @FXML
    private TextField numberField;

    @FXML
    private TextField fioField;

    @FXML
    private TextField postField;

    @FXML
    private TextField yearField;
    @FXML
    private Label errorMessage;

    private List<RecenzentDto> recenzentDtoList;

    @Qualifier("DocumentView")
    @Autowired
    private ControllersConfig.ViewHolder documenView;

    @Qualifier("noLoginDocumentView")
    @Autowired
    private ControllersConfig.ViewHolder noLoginDocumentView;




    public void initialize() {
        number.setCellValueFactory(new PropertyValueFactory<>("number"));
        fio.setCellValueFactory(new PropertyValueFactory<>("fio"));
        post.setCellValueFactory(new PropertyValueFactory<>("post"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        setNullField();
    }

    @FXML
    private void clickLoadButton(ActionEvent event) {
        recenzentDtoList = recenzentService.getAllRecenzent();
        table.setItems(FXCollections.observableArrayList(recenzentDtoList));
    }


    @FXML
    private void clickExitButton(ActionEvent event) throws Exception {
        if (MainMenuController.isLogin) {
            getNextStage(exitButton, documenView);
        } else {
            getNextStage(exitButton, noLoginDocumentView);
        }

    }

    private void setTable(List<RecenzentDto> recenzentDtos) {
        table.setItems(FXCollections.observableArrayList(recenzentDtos));
    }

    @FXML
    private void clickFindNumber(ActionEvent event) {
        String number = numberField.getText();
        RecenzentDto recenzentDto = recenzentService.getRecenzentByNumber(number);
        if (recenzentDto != null) {
            List<RecenzentDto> recenzentDtos = new LinkedList<>();
            recenzentDtos.add(recenzentDto);
            setTable(recenzentDtos);
        }else {
            errorMessage.setText("Данные не найдены");
        }
        setNullField();
    }
    @FXML
    private void clickFindFio(ActionEvent event) {
        String fio = fioField.getText();
        List<RecenzentDto> recenzentDtos = recenzentService.getAllByFio(fio);
        if(!recenzentDtos.isEmpty()) {
            setTable(recenzentDtos);
        }else {
            errorMessage.setText("Данные не найдены");
        }
        setNullField();

    }
    @FXML
    private void clickFindPost(ActionEvent event) {
        String post = postField.getText();
        List<RecenzentDto> recenzentDtos = recenzentService.getAllByPost(post);
        if(!recenzentDtos.isEmpty()) {
            setTable(recenzentDtos);
        }else {
            errorMessage.setText("Данные не найдены");
        }
        setNullField();

    }
    @FXML
    private void clickFindYear(ActionEvent event) {
        String year = yearField.getText();
        List<RecenzentDto> recenzentDtos = recenzentService.getAllByYear(year);
        if(!recenzentDtos.isEmpty()) {
            setTable(recenzentDtos);
        }else {
            errorMessage.setText("Данные не найдены");
        }
        setNullField();

    }


    @FXML
    private void clickAddRecenzent(ActionEvent event) {
        if (numberField.getText() == null || fioField.getText() == null || postField.getText() == null || yearField.getText() == null) {
            errorMessage.setText("Не все поля заполнены");
        } else {
            Recenzent recenzent = new Recenzent(numberField.getText(), fioField.getText(), postField.getText(), yearField.getText());
            recenzentService.addNewRecenzent(recenzent);
            recenzentDtoList = recenzentService.getAllRecenzent();
            table.setItems(FXCollections.observableArrayList(recenzentDtoList));
            setNullField();
        }
        setNullField();

    }

    private void setNullField() {
        numberField.setText(null);
        fioField.setText(null);
        postField.setText(null);
        yearField.setText(null);
    }
}

