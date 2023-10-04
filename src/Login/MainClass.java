/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package Login;

import java.awt.HeadlessException;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */


public class MainClass extends Application {

  private static Stage stg;
    @Override
    public void start(Stage stage) throws IOException {
        
       try
       {
          
           Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument01.fxml"));
               Scene scene = new Scene(root);
            
             stage.setTitle("Student Management System");
       //     stage.getIcons().add(new Image("C:\\Documents\\NetBeansProjects\\JavaFX_Final_Java\\src\\Login\\project Image\\Logo02.jpg"));
             stage.setScene(scene);
             stage.show();
        
             
       }
       catch(HeadlessException e)
       {
           JOptionPane.showMessageDialog(null,e);
       }
       
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
      
        launch(args);
     
    }
  
}
