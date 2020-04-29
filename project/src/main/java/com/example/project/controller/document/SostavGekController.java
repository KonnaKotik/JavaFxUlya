package com.example.project.controller.document;
import com.example.project.ControllersConfig;
import com.example.project.controller.AbstractController;
import com.example.project.controller.MainMenuController;
import com.example.project.dto.document.PrikazDto;
import com.example.project.dto.document.SostavGekDto;
import com.example.project.servise.PrikazService;
import com.example.project.servise.SostavGekService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    private TableColumn<String,SostavGekDto>  napravlenie;

    @FXML
    private TableColumn<String, SostavGekDto>  profil;

    @FXML
    private TableColumn<String,SostavGekDto> pred;

    @FXML
    private TableColumn<String, SostavGekDto>  zam;

    @FXML
    private TableColumn<String, SostavGekDto> komissia ;

    @FXML
    private TableColumn<String, SostavGekDto> forma ;

    @FXML
    private TableColumn<String, SostavGekDto>  sekretar;


    @FXML
    private TableView<SostavGekDto> table;

    @FXML
    private Button exitButton;

    @FXML
    private Button loadButton;

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

}
