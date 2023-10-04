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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class AddStudentController implements Initializable {

    @FXML
    private Button submit;
    @FXML
    private Button back;
    @FXML
    private TextField name;
    @FXML
    private TextField GuardianName;
    @FXML
    private TextField city;
    @FXML
    private TextField phone;
    @FXML
    private TextField stdclass;
    @FXML
    private ComboBox<String> Gender;

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
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> list = FXCollections.observableArrayList("Male","Female");
        Gender.setItems(list);
        
    }    

    @FXML
    private void btnSubmit(ActionEvent event) 
    {
         conn = database_Connection.connection();
        try
        {
            stmt = conn.createStatement();
            String stdName = name.getText();
            // Do not use .getitems because it's  ObservableList. If we use this we recieve all result [male,female]. cannot get a choicebox if you selected.
            // if u choose getvalue. if user selected another one in Combobox we can get this result.
             String stdgender = Gender.getValue();
              String stdGuardian = GuardianName.getText();
               String stdCity = city.getText();
                String stdphone = phone.getText();
                 String stdClass = stdclass.getText();
                 
                       //'"+variable+"'
            
    // MSG BOX for alert!! ==> default response value = 0 , and  JOptionPane.YES_NO_OPTION (default) = 0
       int response = JOptionPane.showConfirmDialog(null,"Do you want to add Students?", "Add Students",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
       // Now Display responese result
       
         if(response == JOptionPane.YES_OPTION)
       {
          
             Scene_Loader sceneLoader = new Scene_Loader();
             sceneLoader.loadScene(event, "AddStudent.fxml");
             //cannot use null because name is String if not null in name variable have "";
             // because Gender.getValue() return null this condition must user enter Name and gender, because if user enter either one this statement always true to return stmt.close
             
             if(name.getText().equals("") || Gender.getValue() == null)
             {
                 JOptionPane.showMessageDialog(null,"Please Enter Name Student & Gender before Submit!");
                 stmt.close();
                 
             }
            else
             {
            //   String sql = "INSERT INTO STUDENT(stdName,stdFatherName,stdGender,stdCity,stdPhone,class) VALUES('"+stdName+"', '"+stdGuardian+"', '"+stdgender+"', '"+stdCity+"', '"+stdphone+"', '"+stdClass+"')";
                 
                // Prepare Statement protect SQL Injection 
                 String sql = "INSERT INTO STUDENT(stdName,stdFatherName,stdGender,stdCity,stdPhone,class) VALUES(?, ?, ?, ?, ?, ?)";
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 stmt.setString(1, stdName);
                 stmt.setString(2, stdGuardian);
                 stmt.setString(3, stdgender);
                 stmt.setString(4, stdCity);
                 stmt.setString(5, stdphone);
                 stmt.setString(6, stdClass);
                 
            // stmt.executeUpdate(sql);
               stmt.executeUpdate();
               JOptionPane.showMessageDialog(null, "Data is successfully inserted");
             }
       }
           else if(response == JOptionPane.NO_OPTION)
               {
                // can chage 'home object = new home();'   
                  Scene_Loader sceneLoader = new Scene_Loader();
                   sceneLoader.loadScene(event, "AddStudent.fxml");
                   stmt.close();
                
               }
             else if(response == JOptionPane.CLOSED_OPTION)
                 {
                       // can chage 'home object = new home();'   
                         Scene_Loader sceneLoader = new Scene_Loader();
                          sceneLoader.loadScene(event, "AddStudent.fxml");
                          stmt.close();
                 }           
       
        }catch(Exception e)
        {
             JOptionPane.showMessageDialog(null,e);
        }
    }

    @FXML
    private void btnback(ActionEvent event)
    {
        Scene_Loader sceneLoader = new Scene_Loader();
        sceneLoader.loadScene(event, "Home.fxml");
    }

    
}
