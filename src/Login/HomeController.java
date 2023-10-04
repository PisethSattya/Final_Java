/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class HomeController implements Initializable {
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    


    @FXML
    private void Button_AddStudent(ActionEvent event) throws IOException 
    {
        Scene_Loader sceneLoader = new Scene_Loader();
        sceneLoader.loadScene(event, "AddStudent.fxml");
    }

    @FXML
    private void Button_ShowStudents(ActionEvent event) 
    {
          Scene_Loader sceneLoader = new Scene_Loader();
        sceneLoader.loadScene(event, "showStudent.fxml");
    }

    @FXML
    private void Button_StudentConfiguration(ActionEvent event) 
    {
        Scene_Loader sceneLoader = new Scene_Loader();
        sceneLoader.loadScene(event, "Student_Config.fxml");
    }

    @FXML
    private void Button_AddAdmin(ActionEvent event) 
    {
        Scene_Loader sceneLoader = new Scene_Loader();
        sceneLoader.loadScene(event, "Add_admin.fxml");
    }

    @FXML
    private void Button_AdminConfiguration(ActionEvent event) 
    {
        Scene_Loader sceneLoader = new Scene_Loader();
                   sceneLoader.loadScene(event, "AdminConfiguration.fxml");
    }

    @FXML
    private void Button_ShowAdmins(ActionEvent event) 
    {
        Scene_Loader sceneLoader = new Scene_Loader();
        sceneLoader.loadScene(event, "Show Admins.fxml");
    }

    @FXML
    private void Bar_refresh(ActionEvent event) 
    {
          
    }

    @FXML
    private void Bar_Close(ActionEvent event) {
    }

    @FXML
    private void Bar_Exit(ActionEvent event) 
    {
        System.exit(0);
    }

   
}
