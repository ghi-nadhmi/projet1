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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class FXMLProfController implements Initializable {

   @FXML
    private TextField uID;

    @FXML
    private PasswordField uname;

    @FXML
    private Button btnlog;
    Connection con ;
    PreparedStatement pst ;
    ResultSet rs ;

    @FXML
    void login(ActionEvent event) throws IOException {
  String nom = uname.getText();
      String ID = uID.getText();
      if (nom.equals("")&& ID.equals(""))
      {
       JOptionPane.showMessageDialog(null,"Username or Password Blank");
      }
      else
      {   try {
          Class.forName("com.mysql.jdbc.Driver");
           con = (Connection) DriverManager.getConnection( "jdbc:mysql://localhost/gestion_fac","root","");
           pst= (PreparedStatement) con.prepareStatement("select * from  professeur where ID=? and nom=? ") ;
           pst.setString(1,ID );
           pst.setString(2, nom);
           rs= pst.executeQuery() ;
           if (rs.next())
           {   Stage stage =new Stage();
                
               Parent root=FXMLLoader.load(getClass().getResource("FXMLProf2.fxml"));
               Scene scene =new Scene(root);
               stage.setScene(scene);
               stage.setTitle("Professeur");
               stage.show();
           // JOptionPane.showMessageDialog(null, "login success");
           }
           else { 
                 JOptionPane.showMessageDialog(null, "login false");
           
                 uname.setText("");
                 uID.setText("");
                 uname.requestFocus();
           
           
                  }
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
          } }}
      
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
