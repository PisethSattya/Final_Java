/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package Login;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 *
 * @author ADMIN
 */
public class FXMLDocumentController implements Initializable {
    
   
    @FXML
    private Label login;
    @FXML
    private TextField mail;
    @FXML
    private TextField password;
    @FXML
    private Button btnlogin;
    @FXML
    private Button btncancel;

    // Import java.sql.connection    
    Connection conn = null;
   // Import java.sql.Statement    
    Statement stmt = null;
  // Import java.sql.ResultSet    
    ResultSet rs = null;
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
        
    }    

    @FXML
    private void usercancel(ActionEvent event) 
    {
        System.exit(0);
    }

      
    @FXML
    private void userlogin(ActionEvent event) 
    {
       
        conn = database_Connection.connection();
         try{
             stmt = conn.createStatement();
            final String userEmail = mail.getText();
            final String userPass = password.getText();
           String sql = "SELECT * FROM admin WHERE (mail='"+userEmail+"' || name='"+userEmail+"') && password = '"+userPass+"'";

        
        rs = stmt.executeQuery(sql);
            
             if(rs.next())
             {
                 // this statement of row 181 is solution to solve retrive id data from phpmyadmin to javafinalproject
           //     final int id = rs.getInt("ID");
           //     JOptionPane.showMessageDialog(null,"Welcome UserID : "+id);
            
            // this statement of row 186 is solution to solve retrive name data from phpmyadmin to javafinalproject
                final String username = rs.getString("name");
                JOptionPane.showMessageDialog(null,"Welcome ADMIN "+username);
                
                
                Scene_Loader sceneLoader = new Scene_Loader();
                sceneLoader.loadScene(event, "Home.fxml");
                
                // setVisible(false);
                // home object = new home();
                // object.setVisible(true);
                 
             }
             else
             {
                 JOptionPane.showMessageDialog(null,"Password or mail is invalid");
             }
        }catch(HeadlessException | SQLException e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }

}
