/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Login;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class Add_adminController implements Initializable {

    @FXML
    private Label login;
    @FXML
    private TextField mail;
    @FXML
    private PasswordField password;
    @FXML
    private Button btnsubmit;
    @FXML
    private Button btnback;
    @FXML
    private TextField field_email;

    /**
     * Initializes the controller class.
     */
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
    private void Submit(ActionEvent event) 
    {
        try{
            conn = database_Connection.connection();
            stmt = conn.createStatement();
            String Nameadmin = mail.getText();
            String emailadmin = field_email.getText();
            String passwordemail = password.getText();
             // MSG BOX for alert!! ==> default response value = 0 , and  JOptionPane.YES_NO_OPTION (default) = 0
       int response = JOptionPane.showConfirmDialog(null,"Do you want to add Admin?", "Add Admins",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
       
          // Now Display responese result
         if(response == JOptionPane.YES_OPTION)
         {
              Scene_Loader sceneLoader = new Scene_Loader();
             sceneLoader.loadScene(event, "Add_admin.fxml");
              //cannot use null because name is String if not null in name variable have "";
             // because Gender.getValue() return null this condition must user enter Name and gender, because if user enter either one this statement always true to return stmt.close
             
             if(Nameadmin.equals("") || passwordemail.equals("") || emailadmin.equals(""))
             {
                 JOptionPane.showMessageDialog(null,"Please Enter All Fields before Submit!");
                 stmt.close();
                 
             }
             else
             {
            //   String sql = "INSERT INTO STUDENT(stdName,stdFatherName,stdGender,stdCity,stdPhone,class) VALUES('"+stdName+"', '"+stdGuardian+"', '"+stdgender+"', '"+stdCity+"', '"+stdphone+"', '"+stdClass+"')";
                 
                // Prepare Statement protect SQL Injection 
                  String sql = "INSERT INTO ADMIN (mail,password,name) VALUES(?,?,?)" ;
            PreparedStatement stmt = conn.prepareStatement(sql);
         
            stmt.setString(1, emailadmin);
            stmt.setString(2, passwordemail);
            stmt.setString(3,Nameadmin);
               
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data is successfully inserted");
             }
         }
         else if(response == JOptionPane.NO_OPTION)
         {
               Scene_Loader sceneLoader = new Scene_Loader();
               sceneLoader.loadScene(event, "Add_admin.fxml");
               stmt.close();
         }
            else if(response == JOptionPane.CLOSED_OPTION)
                 { 
               Scene_Loader sceneLoader = new Scene_Loader();
               sceneLoader.loadScene(event, "Add_admin.fxml");
               stmt.close();
                 }           
       
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
           
    }

    @FXML
    private void back(ActionEvent event) 
    {
         Scene_Loader sceneLoader = new Scene_Loader();
         sceneLoader.loadScene(event, "Home.fxml");
    }
    
}
