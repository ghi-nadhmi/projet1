/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionfac;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class FXMLmenuController implements Initializable {

      @FXML
    private Button BtnAd;
       @FXML
    private Button btnProf;

    @FXML
    private Button btnEtud;

    @FXML
    void Administrateur(ActionEvent event) throws IOException {
        Stage stage =new Stage();
         Parent root=FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                
         Scene scene = new Scene(root);
        
          stage.setScene(scene);
               stage.setTitle("Responsable");
               stage.show();
               
     }
      @FXML
    void Etudiant(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("FXMLEtud.fxml"));
           Stage stage =new Stage();   
           Scene scene = new Scene(root);
        
           stage.setScene(scene);
               stage.setTitle("Etudiant");
               stage.show();
        

    }

    @FXML
    void Professeur(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("FXMLProf.fxml"));
           Stage stage =new Stage();   
           Scene scene = new Scene(root);
        
           stage.setScene(scene);
               stage.setTitle("Professeur");
               stage.show();
        

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    
    
}
