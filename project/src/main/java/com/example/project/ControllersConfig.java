package com.example.project;

import com.example.project.controller.*;
import com.sun.org.apache.bcel.internal.generic.ARETURN;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.text.View;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class ControllersConfig {

    @Bean(name="AddChildrenView")
    public ViewHolder getAddChildrenView() throws IOException{
        return  loadView("fxml/addChildren.fxml");
    }

    @Bean(name="InfoChildrenView")
    public  ViewHolder getInfoChildrenView() throws IOException{
        return loadView("fxml/infoChildren.fxml");
    }
    @Bean(name="ChildrenView")
    public  ViewHolder getChildrenView() throws IOException{
        return  loadView("fxml/children.fxml");
    }

   /* @Bean(name="MenuView")
    public ViewHolder getMenuView() throws IOException{
        return loadView("fxml/employee.fxml");
    }*/

    @Bean (name="InfoView")
    public ViewHolder getInfoView() throws IOException{
        return loadView("fxml/infoEmployee.fxml");
    }

    @Bean(name= "AddEmployeeView")
    public ViewHolder getAddEmployeeView() throws IOException{
        return loadView("fxml/addEmployee.fxml");
    }

    @Bean(name="DocumentView")
    public ViewHolder getDocumentView() throws IOException{
        return loadView("fxml/document.fxml");
    }

    @Bean(name="EmployeeView")
    public  ViewHolder getEmployeeView() throws IOException{
        return  loadView("fxml/employee.fxml");
    }

    @Bean(name = "loginView") // название бина
    public ViewHolder getLoginView() throws IOException {
        return loadView("fxml/login.fxml");//загружаем
    }

    @Bean(name = "noLoginInfoEmployeeView")
    public ViewHolder getNoLoginInfoEmployeeView() throws IOException {
        return loadView("fxml/noLoginInfoEmployee.fxml");
    }

    @Bean(name = "MainMenuView")
    public ViewHolder getMainMenuView() throws IOException {
        return loadView("fxml/menuNo.fxml");
    }

    @Bean(name = "MenuMenuView")
    public ViewHolder getMenuView() throws IOException {
        return loadView("fxml/menu.fxml");
    }

    // бины для незарегистрированного пользователя

    @Bean(name = "noLoginChildrenView")
    public ViewHolder getNoLoginChildrenView() throws IOException {
        return loadView("fxml/noLoginChildren.fxml");
    }

    @Bean(name = "noLoginDocumentView")
    public ViewHolder getNoLoginDocumentView() throws IOException {
        return loadView("fxml/noLoginDocument.fxml");
    }

    @Bean(name = "noLoginEmployeeView")
    public ViewHolder getNoLoginEmployeeView() throws IOException {
        return loadView("fxml/noLoginEmployee.fxml");
    }

    @Bean(name="noLoginInfoChildrenView")
    public  ViewHolder getNoLoginInfoChildrenView() throws IOException {
        return loadView("fxml/noLoginInfoChildren.fxml");
    }

    @Bean(name = "noLoginMenuMenuView")
    public ViewHolder getNoLoginMenuView() throws IOException {
        return loadView("fxml/noLoginMenuMenu.fxml");
    }

    @Bean
    public NoLoginInfoEmployeeController getNoLoginIfoEmplController() throws IOException {
        return (NoLoginInfoEmployeeController) getNoLoginInfoEmployeeView().getController();
    }

    @Bean
    public MenuController getNoMenuController() throws IOException {
        return (MenuController) getNoLoginMenuView().getController();
    }

    @Bean
    public ChildrenController getNoLoginChildrenController() throws IOException {
        return (ChildrenController) getNoLoginChildrenView().getController();
    }

    @Bean
    public DocumentController getNoLoginDocumentController() throws IOException {
        return (DocumentController) getNoLoginDocumentView().getController();
    }

    @Bean
    public EmployeeController getNoLoginEmployeeController() throws IOException {
        return (EmployeeController) getNoLoginEmployeeView().getController();
    }

    @Bean
    public InfoChildrenController getNoLoginInfoChildren() throws IOException {
        return (InfoChildrenController) getNoLoginInfoChildrenView().getController();
    }



    @Bean
    public ChildrenController getChildrenController() throws IOException{
        return (ChildrenController) getChildrenView().getController();
    }

   @Bean
   public InfoChildrenController getInfoChildrenController() throws IOException{
       return (InfoChildrenController) getInfoChildrenView().getController();
   }
   @Bean
   public InfoEmployeeController getInfoController() throws IOException{
       return(InfoEmployeeController) getInfoView().getController();
   }

  @Bean
  public AddChildrenController getAddChildrenController() throws IOException{
      return (AddChildrenController) getAddChildrenView().getController();
  }

  @Bean
  public AddEmpController getAddEmpCont() throws IOException{
        return (AddEmpController) getAddEmployeeView().getController();
  }

    @Bean
    public DocumentController getDocumentController() throws IOException{
        return (DocumentController) getDocumentView().getController();
    }

    @Bean
    public EmployeeController getEmployeeController() throws  IOException{
        return (EmployeeController) getEmployeeView().getController();

    }

    @Bean
    public MenuController getMenuController() throws IOException{
        return (MenuController) getMenuView().getController();
    }

    @Bean
    public UserController getUserController() throws IOException{
        return (UserController) getLoginView().getController();
    }

    @Bean
    public MainMenuController getMainMenuController() throws  IOException {
        return (MainMenuController) getMainMenuView().getController();
    }




    protected ViewHolder loadView(String url) throws IOException{
        InputStream fxmlStream = null;
        try {
            fxmlStream = getClass().getClassLoader().getResourceAsStream(url);
            FXMLLoader loader = new FXMLLoader();
            loader.load(fxmlStream);
            return new ViewHolder(loader.getRoot(), loader.getController());
        } finally {
            if(fxmlStream != null) {
                fxmlStream.close();
            }
        }
    }



    //созданный класс
    @Data
    public class ViewHolder{
        private Parent view; // окно fxml
        private Object controller; // контроллер для fxml

        public ViewHolder(Parent view, Object controller) {
            this.view = view;
            this.controller = controller;
        }
    }
}
