/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Login;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class ShowAdminsController implements Initializable {

    @FXML
    private TableView<Admin> tableshow;
    @FXML
    private TableColumn<Admin, Integer> tbl_id;
    @FXML
    private TableColumn<Admin, String> tbl_name;
    @FXML
    private Button back;
    @FXML
    private TableColumn<Admin, String> tbl_password;
    @FXML
    private TableColumn<Admin, String> tbl_email;
    // Import java.sql.connection    
    Connection conn = null;
   // Import java.sql.Statement    
    Statement stmt = null;
  // Import java.sql.ResultSet    
    ResultSet rs = null;
    
    /**
     * Initializes the controller class.
     */
     ObservableList<Admin> oblist = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
        try{
            conn = database_Connection.connection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM ADMIN";
            ResultSet res = stmt.executeQuery(sql);
            
          while(res.next())
        {
           oblist.add(new Admin(res.getInt(1),res.getString(4),res.getString(2),res.getString(3)));
        }    
        }catch(SQLException ex)
        {
             Logger.getLogger(ShowStudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tbl_id.setCellValueFactory(new PropertyValueFactory<Admin,Integer>("ID"));
        tbl_name.setCellValueFactory(new PropertyValueFactory<Admin,String>("name"));
        tbl_email.setCellValueFactory(new PropertyValueFactory<Admin,String>("email"));
        tbl_password.setCellValueFactory(new PropertyValueFactory<Admin,String>("password"));

        tableshow.setItems(oblist);
    }    

    @FXML
    private void MenuItem_home(ActionEvent event) {
    }

    @FXML
    private void MenuItem_Logout(ActionEvent event) {
    }

    @FXML
    private void MenuItem_about(ActionEvent event) {
    }

    @FXML
    private void btnback(ActionEvent event) 
    {
        Scene_Loader sceneLoader = new Scene_Loader();
        sceneLoader.loadScene(event, "Home.fxml");
    }
    
}
