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
import javafx.scene.control.*;
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

    @FXML
    private TextField numberField;
    @FXML
    private TextField instituteField;
    @FXML
    private TextField naprField;
    @FXML
    private TextField dataField;
    @FXML
    private TextField startField;
    @FXML
    private TextField auditField;
    @FXML
    private TextField formaField;





    @FXML
    private Label errorMessage;

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

    private void setTable(List<SrokiDto> srokiDtos) {
        table.setItems(FXCollections.observableArrayList(srokiDtos));
    }

    @FXML
    private void clickFindInstitute(ActionEvent event) {
        String institute = instituteField.getText();
        List<SrokiDto> srokiDtos = srokiService.getAllByInstitute(institute);
        if (!srokiDtos.isEmpty()) {
            setTable(srokiDtos);
        } else {
            errorMessage.setText("Данные не найдены");
        }
    }

    @FXML
    private void clickFindNumber(ActionEvent event) {
        String number = numberField.getText();
        List<SrokiDto> srokiDtos = srokiService.getAllByNumber(number);
        if (!srokiDtos.isEmpty()) {
            setTable(srokiDtos);
        } else {
            errorMessage.setText("Данные не найдены");
        }
    }

    @FXML
    private void clickFindNapr(ActionEvent event) {
        String napr = naprField.getText();
        List<SrokiDto> srokiDtos = srokiService.getAllByNapr(napr);
        if (!srokiDtos.isEmpty()) {
            setTable(srokiDtos);
        } else {
            errorMessage.setText("Данные не найдены");
        }
    }

    @FXML
    private void clickFindData(ActionEvent event) {
        String data = dataField.getText();
        List<SrokiDto> srokiDtos = srokiService.getAllByData(data);
        if (!srokiDtos.isEmpty()) {
            setTable(srokiDtos);
        } else {
            errorMessage.setText("Данные не найдены");
        }
    }
    @FXML
    private void clickFindStart(ActionEvent event) {
        String start = startField.getText();
        List<SrokiDto> srokiDtos = srokiService.getAllByStart(start);
        if (!srokiDtos.isEmpty()) {
            setTable(srokiDtos);
        } else {
            errorMessage.setText("Данные не найдены");
        }
    }
    @FXML
    private void clickFindAudit(ActionEvent event) {
        String audit = auditField.getText();
        List<SrokiDto> srokiDtos = srokiService.getAllByAudit(audit);
        if (!srokiDtos.isEmpty()) {
            setTable(srokiDtos);
        } else {
            errorMessage.setText("Данные не найдены");
        }
    }

    @FXML
    private void clickFindForma(ActionEvent event) {
        String forma = formaField.getText();
        List<SrokiDto> srokiDtos = srokiService.getAllByForma(forma);
        if (!srokiDtos.isEmpty()) {
            setTable(srokiDtos);
        } else {
            errorMessage.setText("Данные не найдены");
        }
    }


}
