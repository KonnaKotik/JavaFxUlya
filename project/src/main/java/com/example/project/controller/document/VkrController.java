package com.example.project.controller.document;
import com.example.project.controller.AbstractController;
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
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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

    private List<VkrDto> vkrDtoList;
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
    private void clickMenuButton (ActionEvent event) throws Exception{
        getMenuStage(exitButton);
    }
}
