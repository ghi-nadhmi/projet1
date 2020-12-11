/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionfac;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class FXMLDocumentController implements Initializable {
    
    
     
    @FXML
    private TextField uname;

    @FXML
    private PasswordField upassword;

    @FXML
    private Button btnok;
    Connection con ;
    PreparedStatement pst ;
    ResultSet rs ;
    
    
    

    @FXML
    void Login(ActionEvent event) throws IOException {
      String nom = uname.getText();
      String passw = upassword.getText();
      if (nom.equals("")&& passw.equals(""))
      {
       JOptionPane.showMessageDialog(null,"Username or Password Blank");
      }
      else
      {   try {
          Class.forName("com.mysql.jdbc.Driver");
           con = (Connection) DriverManager.getConnection( "jdbc:mysql://localhost/gestion_fac","root","");
           pst= (PreparedStatement) con.prepareStatement("select * from administrateur where name=? and pass=? ") ;
           pst.setString(1, nom);
           pst.setString(2, passw);
           rs= pst.executeQuery() ;
           if (rs.next())
           {   Stage stage =new Stage();
                
               Parent root=FXMLLoader.load(getClass().getResource("FXMLAdmin.fxml"));
               Scene scene =new Scene(root);
               stage.setScene(scene);
               stage.setTitle("Responsable");
               stage.show();
           // JOptionPane.showMessageDialog(null, "login success");
           }
           else { 
                 JOptionPane.showMessageDialog(null, "login false");
           
                 uname.setText("");
                 upassword.setText("");
                 uname.requestFocus();
           
           
                  }
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
          }
      
      }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
