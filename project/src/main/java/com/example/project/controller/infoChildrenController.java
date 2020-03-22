package com.example.project.controller;

import com.example.project.mapper.ChildrenMapper;
import com.example.project.model.Children;
import com.example.project.model.Employee;
import com.example.project.model.dto.ChildrenDto;
import com.example.project.model.dto.EmployeeDto;
import com.example.project.servise.ChildrenService;
import com.example.project.servise.EmployeeService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.LinkedList;
import java.util.List;

@Controller
public class infoChildrenController extends AbstractController {
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
    private  TableColumn<String, ChildrenDto> parents;

    @FXML
    private TableView<ChildrenDto> childrenTable;

   private List<ChildrenDto> childrenDtoList;
   private List<Employee> employeeList;

    public void initialize() {
        fio.setCellValueFactory(new PropertyValueFactory<>("fio"));
        data.setCellValueFactory(new PropertyValueFactory<>("data"));
        parents.setCellValueFactory(new PropertyValueFactory<>("parents"));
    }

    @FXML
    private void clickLoadButton(ActionEvent event) {
        childrenDtoList  = childrenService.getAllChildren();
        setParents();
        childrenTable.setItems(FXCollections.observableArrayList(childrenDtoList));
    }

    private void setParents() {
        for (ChildrenDto childrenDto: childrenDtoList) {
            List<Children> childrens = new LinkedList<>();
            Children children = childrenMapper.convertDtoToModel(childrenDto);
            childrens.add(children);
            employeeList = employeeService.getAllByChildren(childrens);
            childrenDto.setParents(childrenService.listToString(employeeList));
        }
    }






    @FXML
    private void clickExitButton (ActionEvent event) throws  Exception{
        //getNextStage(exitButton,"/fxml/children.fxml");
    }
}
