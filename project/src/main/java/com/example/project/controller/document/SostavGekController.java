package com.example.project.controller.document;
import com.example.project.ControllersConfig;
import com.example.project.controller.AbstractController;
import com.example.project.controller.MainMenuController;
import com.example.project.dto.document.PrikazDto;
import com.example.project.dto.document.RecenzentDto;
import com.example.project.dto.document.SostavGekDto;
import com.example.project.servise.PrikazService;
import com.example.project.servise.SostavGekService;
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
public class SostavGekController extends AbstractController {


    @Autowired
    private SostavGekService sostavGekService;

    @FXML
    private TableColumn<String, SostavGekDto> year;

    @FXML
    private TableColumn<String, SostavGekDto> napravlenie;

    @FXML
    private TableColumn<String, SostavGekDto> profil;

    @FXML
    private TableColumn<String, SostavGekDto> pred;

    @FXML
    private TableColumn<String, SostavGekDto> zam;

    @FXML
    private TableColumn<String, SostavGekDto> komissia;

    @FXML
    private TableColumn<String, SostavGekDto> forma;

    @FXML
    private TableColumn<String, SostavGekDto> sekretar;


    @FXML
    private TableView<SostavGekDto> table;

    @FXML
    private Button exitButton;

    @FXML
    private Button loadButton;

    @FXML
    private TextField yearField;
    @FXML
    private TextField naprField;
    @FXML
    private TextField profilField;
    @FXML
    private TextField predField;
    @FXML
    private TextField zamField;
    @FXML
    private TextField komField;
    @FXML
    private TextField formaField;
    @FXML
    private TextField sekField;
    @FXML
    private Label errorMessage;


    private List<SostavGekDto> sostavGekDtoList;

    @Qualifier("DocumentView")
    @Autowired
    private ControllersConfig.ViewHolder documenView;

    @Qualifier("noLoginDocumentView")
    @Autowired
    private ControllersConfig.ViewHolder noLoginDocumentView;

    public void initialize() {
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        napravlenie.setCellValueFactory(new PropertyValueFactory<>("napravlenie"));
        profil.setCellValueFactory(new PropertyValueFactory<>("profil"));
        pred.setCellValueFactory(new PropertyValueFactory<>("pred"));
        zam.setCellValueFactory(new PropertyValueFactory<>("zam"));
        komissia.setCellValueFactory(new PropertyValueFactory<>("komissia"));
        forma.setCellValueFactory(new PropertyValueFactory<>("forma"));
        sekretar.setCellValueFactory(new PropertyValueFactory<>("sekretar"));
    }

    @FXML
    private void clickLoadButton(ActionEvent event) {
        sostavGekDtoList = sostavGekService.getAllSostavGek();
        table.setItems(FXCollections.observableArrayList(sostavGekDtoList));
    }

    @FXML
    private void clickExitButton(ActionEvent event) throws Exception {
        if (MainMenuController.isLogin) {
            getNextStage(exitButton, documenView);
        } else {
            getNextStage(exitButton, noLoginDocumentView);
        }


    }

    private void setTable(List<SostavGekDto> sostavGekDtos) {
        table.setItems(FXCollections.observableArrayList(sostavGekDtos));
    }

    @FXML
    private void clickFindYear(ActionEvent event) {
        String year = yearField.getText();
        List<SostavGekDto> sostavGekDtos = sostavGekService.getAllByYear(year);
        if (!sostavGekDtos.isEmpty()) {
            setTable(sostavGekDtos);
        } else {
            errorMessage.setText("Данные не найдены");
        }
    }

    @FXML
    private void clickFindNapr(ActionEvent event) {
        String napr = naprField.getText();
        List<SostavGekDto> sostavGekDtos = sostavGekService.getAllByNapr(napr);
        if (!sostavGekDtos.isEmpty()) {
            setTable(sostavGekDtos);
        } else {
            errorMessage.setText("Данные не найдены");
        }
    }

    @FXML
    private void clickFindProfil(ActionEvent event) {
        String profil = profilField.getText();
        List<SostavGekDto> sostavGekDtos = sostavGekService.getAllByProfil(profil);
        if (!sostavGekDtos.isEmpty()) {
            setTable(sostavGekDtos);
        } else {
            errorMessage.setText("Данные не найдены");
        }
    }

    @FXML
    private void clickFindPred(ActionEvent event) {
        String pred = predField.getText();
        List<SostavGekDto> sostavGekDtos = sostavGekService.getAllByPred(pred);
        if (!sostavGekDtos.isEmpty()) {
            setTable(sostavGekDtos);
        } else {
            errorMessage.setText("Данные не найдены");
        }
    }

    @FXML
    private void clickFindZam(ActionEvent event) {
        String zam = zamField.getText();
        List<SostavGekDto> sostavGekDtos = sostavGekService.getAllByZam(zam);
        if (!sostavGekDtos.isEmpty()) {
            setTable(sostavGekDtos);
        } else {
            errorMessage.setText("Данные не найдены");
        }
    }

    @FXML
    private void clickFindKom(ActionEvent event) {
        String kom = komField.getText();
        List<SostavGekDto> sostavGekDtos = sostavGekService.getAllByKom(kom);
        if (!sostavGekDtos.isEmpty()) {
            setTable(sostavGekDtos);
        } else {
            errorMessage.setText("Данные не найдены");
        }
    }

    @FXML
    private void clickFindForma(ActionEvent event) {
        String forma = formaField.getText();
        List<SostavGekDto> sostavGekDtos = sostavGekService.getAllByForma(forma);
        if (!sostavGekDtos.isEmpty()) {
            setTable(sostavGekDtos);
        } else {
            errorMessage.setText("Данные не найдены");
        }
    }

    @FXML
    private void clickFindSek(ActionEvent event) {
        String sek = sekField.getText();
        List<SostavGekDto> sostavGekDtos = sostavGekService.getAllBySek(sek);
        if (!sostavGekDtos.isEmpty()) {
            setTable(sostavGekDtos);
        } else {
            errorMessage.setText("Данные не найдены");
        }
    }
}



