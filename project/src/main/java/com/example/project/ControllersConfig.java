package com.example.project;

import com.example.project.controller.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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


    @Bean(name = "MainMenuView")
    public ViewHolder getMainMenuView() throws IOException {
        return loadView("fxml/menuNo.fxml");
    }

    @Bean(name = "MenuMenuView")
    public ViewHolder getMenuView() throws IOException {
        return loadView("fxml/menu.fxml");
    }



    @Bean ChildrenController getChildrenController() throws IOException{
        return (ChildrenController) getChildrenView().getController();
    }

   @Bean
   public  infoChildrenController getInfoChildrenController() throws IOException{
       return (infoChildrenController) getInfoChildrenView().getController();
   }
   @Bean
   public infoController getInfoController() throws IOException{
       return(infoController) getInfoView().getController();
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
