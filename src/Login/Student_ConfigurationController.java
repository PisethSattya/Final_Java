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
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class Student_ConfigurationController implements Initializable {

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
    private Button btnSearch;
    @FXML
    private TextField id;
    @FXML
    private TextField gender;
    /**
     * Initializes the controller class.
     */
   // Import java.sql.connection    
    Connection conn = null;
   // Import java.sql.Statement    
    Statement stmt = null;
  // Import java.sql.ResultSet    
    ResultSet rs = null;
    @FXML
    private Button Delete;
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    // Button Updated
    @FXML
    private void btnSubmit(ActionEvent event)
    {
      try{
          conn = database_Connection.connection();
          stmt = conn.createStatement();
          
         if(id.getText().equals(""))
           {
               JOptionPane.showMessageDialog(null,"Please Enter ID and Change Data before Update!");
                  Scene_Loader sceneLoader = new Scene_Loader();
                   sceneLoader.loadScene(event, "Student_Config.fxml");
                 stmt.close();
                 
           }
        else
         {
              int stdId = Integer.parseInt(id.getText());
          String stdName = name.getText();
          String stdGender = gender.getText();
          String stdGuardianName = GuardianName.getText();
          String stdCity = city.getText();
          String stdPhone = phone.getText();
          String stdClass = stdclass.getText();
          
          String sql = "Update STUDENT SET stdName = '"+stdName+"',stdFatherName = '"+stdGuardianName+"',stdGender = '"+stdGender+"',stdPhone = '"+stdPhone+"',stdCity = '"+stdCity+"',class = '"+stdClass+"' WHERE ID = '"+stdId+"'";
          
          stmt.executeUpdate(sql);
         JOptionPane.showMessageDialog(null, "Data is successfully Updated");
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

    @FXML
    private void btnSearch(ActionEvent event) 
    {
           try
        {
           conn = database_Connection.connection();
           stmt = conn.createStatement();
           if(id.getText().equals(""))
           {
               JOptionPane.showMessageDialog(null,"Please Enter ID before Search!");
                 stmt.close();
           }
           else
           {
                 int stdId = Integer.parseInt(id.getText());
           
           String sql = "SELECT * FROM STUDENT WHERE id = '"+stdId+"'";
           
           rs = stmt.executeQuery(sql);
           
           if(rs.next())
           {
               name.setText(rs.getString("stdName"));
               GuardianName.setText(rs.getString("stdFathername"));
               city.setText(rs.getString("stdCity"));
               phone.setText(rs.getString("stdPhone"));
               stdclass.setText(rs.getString("class"));
               gender.setText(rs.getString("stdGender"));
           }
     
           else
           {
               JOptionPane.showMessageDialog(null,"Record Not found!");
                // can chage 'home object = new home();'   
                  Scene_Loader sceneLoader = new Scene_Loader();
                   sceneLoader.loadScene(event, "Student_Config.fxml");
                   stmt.close();
           }
        
           
           }
         
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }

    @FXML
    private void btnDelete(ActionEvent event)
    {
        try{
     
            conn = database_Connection.connection();
            stmt = conn.createStatement();
            
             if(id.getText().equals(""))
           {
               JOptionPane.showMessageDialog(null,"Please Enter ID before Delete!");
                 stmt.close();
           }
             else
             {
                   int stdId = Integer.parseInt(id.getText());
            String sql = "DELETE FROM student WHERE id = '"+stdId+"' ";
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data is Deleted successfully!");
             
            Scene_Loader sceneLoader = new Scene_Loader();
           sceneLoader.loadScene(event, "showStudent.fxml");
            
             }
          
        }catch(Exception e)
        {
             JOptionPane.showMessageDialog(null,e);
        }
    }

    
}
