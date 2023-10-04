/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */

public class database_Connection
{
     final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final static String DB_URL = "jdbc:mysql://localhost:3308/student?verifyServerCertificate=false&useSSL=true";
    
    final static String USER = "root";
    final static String PASS = "";
    
    public static Connection connection ()
    {
        try{
            
            Class.forName(JDBC_DRIVER);
            
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            return conn;
        
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
      
    }
}
