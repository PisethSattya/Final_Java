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
public class ShowStudentController implements Initializable {

    @FXML
    private TableView<Customer> tableshow;
    @FXML
    private TableColumn<Customer,Integer> tbl_id;
    @FXML
    private TableColumn<Customer, String> tbl_name;
    @FXML
    private TableColumn<Customer, String> tbl_guardianname;
    @FXML
    private TableColumn<Customer, String> tbl_gender;
    @FXML
    private TableColumn<Customer, String> tbl_phonenumber;
    @FXML
    private TableColumn<Customer, String> tbl_city;
    @FXML
    private TableColumn<Customer, String> tbl_class;
    @FXML
    private Button back;

    
    // Import java.sql.connection    
    Connection conn = null;
   // Import java.sql.Statement    
    Statement stmt = null;
  // Import java.sql.ResultSet    
    ResultSet rs = null;
    /**
     * Initializes the controller class.
     */
    ObservableList<Customer> oblist = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        try {
            conn = database_Connection.connection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM STUDENT";
            ResultSet res = stmt.executeQuery(sql);
            
        while(res.next())
        {
            oblist.add(new Customer(res.getInt(1),res.getString(2),res.getString(3), res.getString(4),res.getString(5), res.getString(6), res.getString(7)));
        }
        } catch (SQLException ex) {
            Logger.getLogger(ShowStudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        // TODO
            tbl_id.setCellValueFactory(new PropertyValueFactory<Customer,Integer>("ID"));
            tbl_name.setCellValueFactory(new PropertyValueFactory<Customer,String>("name"));
            tbl_guardianname.setCellValueFactory(new PropertyValueFactory<Customer,String>("GuardianName"));
            tbl_gender.setCellValueFactory(new PropertyValueFactory<Customer,String>("Gender"));
            tbl_phonenumber.setCellValueFactory(new PropertyValueFactory<Customer,String>("Phone"));
            tbl_city.setCellValueFactory(new PropertyValueFactory<Customer,String>("City"));
            tbl_class.setCellValueFactory(new PropertyValueFactory<Customer,String>("CLass"));
            
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
