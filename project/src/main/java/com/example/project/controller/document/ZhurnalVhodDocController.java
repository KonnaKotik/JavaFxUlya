package com.example.project.controller.document;
import com.example.project.ControllersConfig;
import com.example.project.controller.AbstractController;
import com.example.project.controller.MainMenuController;
import com.example.project.dto.document.*;
import com.example.project.servise.PrikazService;
import com.example.project.servise.ZhurnalVhodDocService;
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
public class ZhurnalVhodDocController extends AbstractController {


    @Autowired
    private ZhurnalVhodDocService zhurnalVhodDocService;


    @FXML
    private TableColumn<String, ZhurnalVhodDocDto> number;

    @FXML
    private TableColumn<String,ZhurnalVhodDocDto>  data ;

    @FXML
    private TableColumn<String, ZhurnalVhodDocDto>  tip;

    @FXML
    private TableColumn<String,ZhurnalVhodDocDto> soder;

    @FXML
    private TableColumn<String,ZhurnalVhodDocDto>  kod;

    @FXML
    private TableColumn<String, ZhurnalVhodDocDto> isp ;




    @FXML
    private TableView<ZhurnalVhodDocDto> table;

    @FXML
    private Button exitButton;

    @FXML
    private Button loadButton;

    @FXML
    private TextField numberField;

    @FXML
    private TextField dataField;

    @FXML
    private TextField tipField;

    @FXML
    private TextField soderField;

    @FXML
    private TextField kodField;

    @FXML
    private TextField ispField;

    @FXML
    private Label errorMessage;

    private List<ZhurnalVhodDocDto> zhurnalVhodDocDtoList;

    @Qualifier("DocumentView")
    @Autowired
    private ControllersConfig.ViewHolder documentView;

    @Qualifier("noLoginDocumentView")
    @Autowired
    private ControllersConfig.ViewHolder noLoginDocumentView;


    public void initialize() {
        number.setCellValueFactory(new PropertyValueFactory<>("number"));
        data.setCellValueFactory(new PropertyValueFactory<>("data"));
        tip.setCellValueFactory(new PropertyValueFactory<>("tip"));
        soder.setCellValueFactory(new PropertyValueFactory<>("soder"));
        kod.setCellValueFactory(new PropertyValueFactory<>("kod"));
        isp.setCellValueFactory(new PropertyValueFactory<>("isp"));


    }
    @FXML
    private void clickLoadButton(ActionEvent event) {
        zhurnalVhodDocDtoList = zhurnalVhodDocService.getAllZhurnalVhodDoc();
        table.setItems(FXCollections.observableArrayList(zhurnalVhodDocDtoList));
    }

    @FXML
    private void clickExitButton(ActionEvent event) throws Exception {
        if (MainMenuController.isLogin) {
            getNextStage(exitButton, documentView);
        } else {
            getNextStage(exitButton, noLoginDocumentView);
        }

    }

    private void setTable(List<ZhurnalVhodDocDto> zhurnalVhodDocDtos) {
        table.setItems(FXCollections.observableArrayList(zhurnalVhodDocDtos));
    }

    @FXML
    private void clickFindNumber(ActionEvent event) {
        String number = numberField.getText();
        ZhurnalVhodDocDto zhurnalVhodDocDto = zhurnalVhodDocService.getZhurnalVhodDocByNumber(number);
        if (zhurnalVhodDocDto != null) {
            List<ZhurnalVhodDocDto> zhurnalVhodDocDtos = new LinkedList<>();
            zhurnalVhodDocDtos.add(zhurnalVhodDocDto);
            setTable(zhurnalVhodDocDtos);
        }else {
            errorMessage.setText("Данные не найдены");
        }
    }

    @FXML
    private void clickFindData(ActionEvent event) {
        String data = dataField.getText();
        List<ZhurnalVhodDocDto> zhurnalVhodDocDtos = zhurnalVhodDocService.getAllByData(data);
        if(!zhurnalVhodDocDtos.isEmpty()) {
            setTable(zhurnalVhodDocDtos);
        }else {
            errorMessage.setText("Данные не найдены");
        }
    }

    @FXML
    private void clickFindTip(ActionEvent event) {
        String tip = tipField.getText();
        List<ZhurnalVhodDocDto> zhurnalVhodDocDtos = zhurnalVhodDocService.getAllByTip(tip);
        if(!zhurnalVhodDocDtos.isEmpty()) {
            setTable(zhurnalVhodDocDtos);
        }else {
            errorMessage.setText("Данные не найдены");
        }
    }

    @FXML
    private void clickFindSoder(ActionEvent event) {
        String soder = soderField.getText();
        List<ZhurnalVhodDocDto> zhurnalVhodDocDtos = zhurnalVhodDocService.getAllBySoder(soder);
        if(!zhurnalVhodDocDtos.isEmpty()) {
            setTable(zhurnalVhodDocDtos);
        }else {
            errorMessage.setText("Данные не найдены");
        }
    }

    @FXML
    private void clickFindKod(ActionEvent event) {
        String kod = kodField.getText();
        List<ZhurnalVhodDocDto> zhurnalVhodDocDtos = zhurnalVhodDocService.getAllByKod(kod);
        if(!zhurnalVhodDocDtos.isEmpty()) {
            setTable(zhurnalVhodDocDtos);
        }else {
            errorMessage.setText("Данные не найдены");
        }
    }


    @FXML
    private void clickFindIsp(ActionEvent event) {
        String isp = ispField.getText();
        List<ZhurnalVhodDocDto> zhurnalVhodDocDtos = zhurnalVhodDocService.getAllByIsp(isp);
        if(!zhurnalVhodDocDtos.isEmpty()) {
            setTable(zhurnalVhodDocDtos);
        }else {
            errorMessage.setText("Данные не найдены");
        }

    }


}
