package com.example.project.controller.document;
import com.example.project.ControllersConfig;
import com.example.project.controller.AbstractController;
import com.example.project.controller.MainMenuController;
import com.example.project.dto.document.PrikazDto;
import com.example.project.dto.document.SostavGekDto;
import com.example.project.dto.document.SrokiDto;
import com.example.project.servise.PrikazService;
import com.example.project.servise.SrokiService;
import com.example.project.servise.ZhurnalVhodDocService;
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
public class SrokiController extends AbstractController {


    @Autowired
    private SrokiService srokiService;

    @FXML
    private TableColumn<String, SrokiDto> institute;

    @FXML
    private TableColumn<String,SrokiDto>  numberGroup ;

    @FXML
    private TableColumn<String, SrokiDto>  napravlenie;

    @FXML
    private TableColumn<String,SrokiDto> data;

    @FXML
    private TableColumn<String,SrokiDto>  start;

    @FXML
    private TableColumn<String, SrokiDto> numberAudit ;

    @FXML
    private TableColumn<String, SrokiDto> formaOb ;




    @FXML
    private TableView<SrokiDto> table;

    @FXML
    private Button exitButton;

    @FXML
    private Button loadButton;

    private List<SrokiDto> srokiDtoList;

    @Qualifier("DocumentView")
    @Autowired
    private ControllersConfig.ViewHolder documenView;

    @Qualifier("noLoginDocumentView")
    @Autowired
    private ControllersConfig.ViewHolder noLoginDocumentView;



    public void initialize() {
        institute.setCellValueFactory(new PropertyValueFactory<>("institute"));
        numberGroup.setCellValueFactory(new PropertyValueFactory<>("numberGroup"));
        napravlenie.setCellValueFactory(new PropertyValueFactory<>("napravlenie"));
        data.setCellValueFactory(new PropertyValueFactory<>("data"));
        start.setCellValueFactory(new PropertyValueFactory<>("start"));
        numberAudit.setCellValueFactory(new PropertyValueFactory<>("numberAudit"));
        formaOb.setCellValueFactory(new PropertyValueFactory<>("formaOb"));

    }

    @FXML
    private void clickLoadButton(ActionEvent event) {
        srokiDtoList = srokiService.getAllSroki();
        table.setItems(FXCollections.observableArrayList(srokiDtoList));
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
