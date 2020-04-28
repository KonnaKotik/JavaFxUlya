package com.example.project.controller.document;

import com.example.project.ControllersConfig;
import com.example.project.controller.AbstractController;
import com.example.project.controller.MainMenuController;
import com.example.project.dto.document.RecenzentDto;
import com.example.project.servise.RecenzentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import com.example.project.dto.document.PrikazDto;
import com.example.project.servise.PrikazService;
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

    private List<RecenzentDto> recenzentDtoList;

    @Qualifier("DocumentView")
    @Autowired
    private ControllersConfig.ViewHolder documentView;




    public void initialize() {
        number.setCellValueFactory(new PropertyValueFactory<>("number"));
        fio.setCellValueFactory(new PropertyValueFactory<>("fio"));
        post.setCellValueFactory(new PropertyValueFactory<>("post"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
    }

    @FXML
    private void clickLoadButton(ActionEvent event) {
        recenzentDtoList = recenzentService.getAllRecenzent();
        table.setItems(FXCollections.observableArrayList(recenzentDtoList));
    }


    @FXML
    private  void clickExitButton(ActionEvent event) throws Exception{
        MainMenuController.isLogin = false;
        getNextStage(exitButton, documentView);
    }
    

}
