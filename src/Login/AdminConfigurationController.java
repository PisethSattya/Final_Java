/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class AdminConfigurationController implements Initializable {

    @FXML
    private Button submit;
    @FXML
    private Button back;
    @FXML
    private TextField name;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private Button btnSearch;
    @FXML
    private TextField id;
    @FXML
    private Button Delete;

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
    }    

    @FXML
    private void btnupdate(ActionEvent event) 
    {
        try{
            conn = database_Connection.connection();
           stmt = conn.createStatement();
           if(id.getText().equals(""))
           {
               JOptionPane.showMessageDialog(null,"Please Enter ID and Change Data before Update!");
                 stmt.close();
           }
           else
           {
               int stdId = Integer.parseInt(id.getText());
               String stdName = name.getText();
               String stdemail = email.getText();
               String stdpassword = password.getText();
               
                String sql = "Update Admin SET mail = '"+stdemail+"', password = '"+stdpassword+"', name = '"+stdName+"' WHERE id = '"+stdId+"' ";
          
                stmt.executeUpdate(sql);
             JOptionPane.showMessageDialog(null, "Data is successfully Updated");
           
           }
        }
        catch(Exception e)
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
                 
                  String sql = "SELECT * FROM ADMIN WHERE id = '"+stdId+"'";
                   rs = stmt.executeQuery(sql);
                   
           if(rs.next())
           {
             name.setText(rs.getString("name"));
             email.setText(rs.getString("mail"));
             password.setText(rs.getString("password"));
           }
           else
           {
               JOptionPane.showMessageDialog(null,"Record Not found!");
                 Scene_Loader sceneLoader = new Scene_Loader();
                   sceneLoader.loadScene(event, "AdminConfiguration.fxml");
                   stmt.close();
           }
          }
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null,e);
        }
    }

    @FXML
    private void btnDelete(ActionEvent event) 
    {
        try
        {
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
                String sql = "DELETE FROM ADMIN WHERE id = '"+stdId+"' ";
                
                 stmt.executeUpdate(sql);
              JOptionPane.showMessageDialog(null, "Data is Deleted successfully!");
             
                  Scene_Loader sceneLoader = new Scene_Loader();
                  sceneLoader.loadScene(event, "Show Admins.fxml");
                      
             }
             
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
}
