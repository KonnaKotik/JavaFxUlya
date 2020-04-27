package com.example.project.controller.document;
import com.example.project.controller.AbstractController;
import com.example.project.dto.document.*;
import com.example.project.servise.PrikazService;
import com.example.project.servise.ZhurnalVhodDocService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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

    private List<ZhurnalVhodDocDto> zhurnalVhodDocDtoList;
    public void initialize() {
        number.setCellValueFactory(new PropertyValueFactory<>("number"));
        data.setCellValueFactory(new PropertyValueFactory<>("data"));
        tipDoc.setCellValueFactory(new PropertyValueFactory<>("tipDoc"));
        soderzhanie.setCellValueFactory(new PropertyValueFactory<>("soderzhanie"));
        kod.setCellValueFactory(new PropertyValueFactory<>("kod"));
        post.setCellValueFactory(new PropertyValueFactory<>("post"));


    }

    @FXML
    private void clickLoadButton(ActionEvent event) {
        ZhurnalVhodDocService srokiService;
        zhurnalVhodDocDtoList = zhurnalVhodDocService.getAllZhurnalVhodDoc();
        table.setItems(FXCollections.observableArrayList(zhurnalVhodDocDtoList));
    }
    @FXML
    private void clickMenuButton (ActionEvent event) throws Exception{
        getMenuStage(exitButton);
    }


}
