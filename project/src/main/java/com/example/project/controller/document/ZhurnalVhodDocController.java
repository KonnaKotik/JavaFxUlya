package com.example.project.controller.document;
import com.example.project.ControllersConfig;
import com.example.project.controller.AbstractController;
import com.example.project.controller.MainMenuController;
import com.example.project.dto.document.*;
import com.example.project.model.document.Sroki;
import com.example.project.model.document.ZhurnalVhodDoc;
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
    private TableColumn<String, ZhurnalVhodDocDto>  tipDoc;

    @FXML
    private TableColumn<String,ZhurnalVhodDocDto> soderzhanie;

    @FXML
    private TableColumn<String,ZhurnalVhodDocDto>  kod;

    @FXML
    private TableColumn<String, ZhurnalVhodDocDto> post ;




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
        tipDoc.setCellValueFactory(new PropertyValueFactory<>("tipDoc"));
        soderzhanie.setCellValueFactory(new PropertyValueFactory<>("soderzhanie"));
        kod.setCellValueFactory(new PropertyValueFactory<>("kod"));
        post.setCellValueFactory(new PropertyValueFactory<>("post"));
        setNullField();


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
        setNullField();
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
        setNullField();
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
        setNullField();
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
        setNullField();
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
        setNullField();
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
        setNullField();

    }

    @FXML
    private void clickAddZhurnalVhodDoc(ActionEvent event) {
        if(numberField.getText() == null || dataField.getText() == null || tipField.getText() == null || soderField.getText() == null || kodField.getText() == null || ispField.getText() == null ) {
            errorMessage.setText("Не все поля заполнены");
        } else {
            ZhurnalVhodDoc zhurnalVhodDoc = new ZhurnalVhodDoc(numberField.getText(), dataField.getText(), tipField.getText(), soderField.getText(),kodField.getText(), ispField.getText());
            zhurnalVhodDocService.addNewZhurnalVhodDoc(zhurnalVhodDoc);
            zhurnalVhodDocDtoList = zhurnalVhodDocService.getAllZhurnalVhodDoc();
            table.setItems(FXCollections.observableArrayList(zhurnalVhodDocDtoList));
            setNullField();
        }

    }
    private void setNullField(){
        numberField.setText(null);
        dataField.setText(null);
        tipField.setText(null);
        soderField.setText(null);
        kodField.setText(null);
        ispField.setText(null);
    }


}
