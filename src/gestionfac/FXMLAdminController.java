/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionfac;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 * FXML Controller class
 *
 * @author HP
 */
public class FXMLAdminController implements Initializable {
    @FXML
    private TextField uid;

    @FXML
    private TextField unom;

    @FXML
    private TextField uprenom;

    @FXML
    private ComboBox<?> udep;
    
    @FXML
    private Button ajP;

    @FXML
    private Button ModP;

    @FXML
    private Button SupP;
    @FXML
    private TableView<professeur> tabE;
      @FXML
    private TableColumn<professeur,Integer> colID;

    @FXML
    private TableColumn<professeur, String> Colnom;

    @FXML
    private TableColumn<professeur, String> colPre;

    @FXML
    private TableColumn<professeur, String> colDep;

 public ObservableList<professeur> data = FXCollections.observableArrayList();
   

    @FXML
    void AjouterP(ActionEvent event)    {
      /*  String nom1 = unom.getText();
        String prenom1 = uprenom.getText();
        String id1 = uid.getText();
         String output =  udep.getValue().toString();*/
        
          String url = "jdbc:mysql://localhost/gestion_fac"; 
         com.mysql.jdbc.Connection con;
        
        try {
         // Class.forName("com.mysql.jdbc.Driver");
          // con = (Connection) DriverManager.getConnection( "jdbc:mysql://localhost/gestion_fac","root","");
          org.gjt.mm.mysql.Driver mySQLDriver = new org.gjt.mm.mysql.Driver();
          con = (com.mysql.jdbc.Connection) DriverManager.getConnection(url,"root" ,"" );
	  //con = (Connection) DriverManager.getConnection(url,"root" ,"" );
          String query ="INSERT INTO professeur (ID,nom,prenom,section) "+"VALUES ( ?,?,?,?)" ;
           
           PreparedStatement St= (PreparedStatement) con.prepareStatement(query) ;
             St.setString(1,uid.getText() );
             St.setString(2,unom.getText());
             St.setString(3,uprenom.getText());
             St.setString(4, udep.getValue().toString());
            St.executeUpdate(); 
          String query2 = "Select * from professeur " ;
          PreparedStatement St2= (PreparedStatement) con.prepareStatement(query2) ;
          ResultSet rs = St2.executeQuery() ;
           if (rs.next()){
           data.add(new professeur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
           System.out.println(data.size()+"****************");
            
            }
            
             colID.setCellValueFactory(new PropertyValueFactory<professeur,Integer>("id"));
             Colnom.setCellValueFactory(new PropertyValueFactory<professeur,String>("nom"));
             colPre.setCellValueFactory(new PropertyValueFactory<professeur,String>("prenom"));
             colDep.setCellValueFactory(new PropertyValueFactory<professeur,String>("secteur"));
             tabE.setItems(data);
             
        }
        catch (Exception ex) {
             // Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
          }
     
    }

    @FXML
    void Modidier(ActionEvent event) {

    }

    @FXML
    void SupprimerP(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<String> list = new ArrayList<String>();
        list.add("Informatique");
        list.add("Mecatronique");
        list.add("GSIl");
        ObservableList obList = FXCollections.observableList(list);
        udep.getItems().clear();
        udep.setItems(obList);
        
    }    
    
}
