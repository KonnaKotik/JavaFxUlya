package com.example.project.controller.document;
import com.example.project.ControllersConfig;
import com.example.project.controller.AbstractController;
import com.example.project.controller.MainMenuController;
import com.example.project.dto.document.PrikazDto;
import com.example.project.dto.document.SostavGekDto;
import com.example.project.dto.document.SrokiDto;
import com.example.project.dto.document.VkrDto;
import com.example.project.servise.PrikazService;
import com.example.project.servise.VkrService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.LinkedList;
import java.util.List;

@Controller
public class VkrController extends AbstractController {


    @Autowired
    private VkrService vkrService;


    @FXML
    private TableColumn<String, VkrDto> number;

    @FXML
    private TableColumn<String,VkrDto>  group ;

    @FXML
    private TableColumn<String, VkrDto>  napravlenie;

    @FXML
    private TableColumn<String,VkrDto> fio;

    @FXML
    private TableColumn<String,VkrDto>  tema;

    @FXML
    private TableColumn<String, VkrDto> ruk ;

    @FXML
    private TableColumn<String, VkrDto> year ;

    @FXML
    private TableView<VkrDto> table;

    @FXML
    private Button exitButton;

    @FXML
    private Button loadButton;

    @FXML
    private TextField rukField;

    @FXML
    private TextField numberField;

    @FXML
    private TextField groupField;

    @FXML
    private TextField fioField;

    @FXML
    private TextField temaField;

    @FXML
    private TextField yearField;

    @FXML
    private TextField naprField;

    private List<VkrDto> vkrDtoList;

    @Qualifier("DocumentView")
    @Autowired
    private ControllersConfig.ViewHolder documenView;

    @Qualifier("noLoginDocumentView")
    @Autowired
    private ControllersConfig.ViewHolder noLoginDocumentView;

    public void initialize() {
        number.setCellValueFactory(new PropertyValueFactory<>("number"));
        group.setCellValueFactory(new PropertyValueFactory<>("group"));
        napravlenie.setCellValueFactory(new PropertyValueFactory<>("napravlenie"));
        fio.setCellValueFactory(new PropertyValueFactory<>("fio"));
        tema.setCellValueFactory(new PropertyValueFactory<>("tema"));
        ruk.setCellValueFactory(new PropertyValueFactory<>("ruk"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));

    }

    @FXML
    private void clickLoadButton(ActionEvent event) {
       vkrDtoList = vkrService.getAllVkr();
        table.setItems(FXCollections.observableArrayList(vkrDtoList));
    }

    @FXML
    private void clickExitButton(ActionEvent event) throws Exception {
        if (MainMenuController.isLogin) {
            getNextStage(exitButton, documenView);
        } else {
            getNextStage(exitButton, noLoginDocumentView);
        }
    }

    private void setTable(List<VkrDto> vkrDtos) {
        table.setItems(FXCollections.observableArrayList(vkrDtos));
    }

    @FXML
    private void clickFindRuk(ActionEvent event) {
        String ruk = rukField.getText();
        List<VkrDto> vkrDtos = vkrService.getAllByRuk(ruk);
        if(!vkrDtos.isEmpty()) {
            setTable(vkrDtos);
        } else {

        }
    }

    @FXML
    private void clickFindNumber(ActionEvent event) {
        String number = numberField.getText();
        VkrDto vkrDto = vkrService.getVkrByNumber(number);
        if(vkrDto != null) {
            List<VkrDto> vkrDtoList = new LinkedList<>();
            vkrDtoList.add(vkrDto);
            setTable(vkrDtoList);
        } else {

        }
    }

    @FXML
    private void clickFindGroup(ActionEvent event) {
        String group = groupField.getText();
        List<VkrDto> vkrDtoList = vkrService.getAllByGroup(group);
        if(!vkrDtoList.isEmpty()) {
            setTable(vkrDtoList);
        }
    }

    @FXML
    private void clickFindFio(ActionEvent event) {
        String fio = fioField.getText();
        List<VkrDto> vkrDtoList = vkrService.getAllByFio(fio);
        if (!vkrDtoList.isEmpty()) {
            setTable(vkrDtoList);
        }
    }

    @FXML
    private void clickFindTema(ActionEvent event) {
        String tema = temaField.getText();
        List<VkrDto> vkrDtoList = vkrService.getAllByTema(tema);
        if(!vkrDtoList.isEmpty()) {
            setTable(vkrDtoList);
        }
    }

    @FXML
    private void clickFindYear(ActionEvent event) {
        String year = yearField.getText();
        List<VkrDto> vkrDtoList = vkrService.getAllByYear(year);
        if(!vkrDtoList.isEmpty()) {
            setTable(vkrDtoList);
        }
    }

    @FXML
    private void clickFindNapr(ActionEvent actionEvent) {
        String napr = naprField.getText();
        List<VkrDto> vkrDtoList = vkrService.getAllByNapr(napr);
        if(!vkrDtoList.isEmpty()) {
            setTable(vkrDtoList);
        }
    }
}
