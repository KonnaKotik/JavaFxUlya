package com.example.project.controller;

import com.example.project.ControllersConfig;
import com.example.project.mapper.ChildrenMapper;
import com.example.project.model.Employee;
import com.example.project.dto.ChildrenDto;
import com.example.project.servise.ChildrenService;
import com.example.project.servise.EmployeeService;
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
public class InfoChildrenController extends AbstractController {
    @Autowired
    private ChildrenService childrenService;


    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ChildrenMapper childrenMapper;

    @FXML
    private Button loadButton;

    @FXML
    private Button exitButton;
    @FXML
    private TableColumn<String, ChildrenDto>  fio;

    @FXML
    private TableColumn<String,ChildrenDto> data;

    @FXML
    private  TableColumn<String, ChildrenDto> nameParents;

    @FXML
    private TableView<ChildrenDto> childrenTable;

   private List<ChildrenDto> childrenDtoList;
   private List<Employee> employeeList;

   @Qualifier("ChildrenView")
   @Autowired
   private ControllersConfig.ViewHolder childrenView;

   @Qualifier("noLoginChildrenView")
   @Autowired
   private ControllersConfig.ViewHolder noLoginChildrenView;



    public void initialize() {
        fio.setCellValueFactory(new PropertyValueFactory<>("fio"));
        data.setCellValueFactory(new PropertyValueFactory<>("data"));
        nameParents.setCellValueFactory(new PropertyValueFactory<>("nameParents"));
    }

    @FXML
    private void clickLoadButton(ActionEvent event) {
        childrenDtoList  = childrenService.getAllChildren();
        childrenTable.setItems(FXCollections.observableArrayList(childrenDtoList));
    }


    @FXML
    private void clickExitButton (ActionEvent event) throws  Exception{
        if(MainMenuController.isLogin){
            getNextStage(exitButton,childrenView);
        }else{
            getNextStage(exitButton,noLoginChildrenView);
        }
    }
}
