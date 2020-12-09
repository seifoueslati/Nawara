/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Session;
import Entity.Utilisateur;
import Service.ServiceUser;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mohamed Bousselmi
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txt_user_name;
    @FXML
    private PasswordField txt_password;
    @FXML
    private Button login;
    
    
    
    Stage dialogStage = new Stage();
    Scene scene;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        login.setStyle("-fx-background-color: rgba(255, 255, 255,0);");
        txt_user_name.setStyle("-fx-background-color: rgba(255, 255, 255,0);-fx-border:Opx");
        txt_password.setStyle("-fx-background-color: rgba(255, 255, 255,0);-fx-border:Opx");
        
        txt_user_name.setText("Mohamed Bousselmi");
        txt_password.setText("0000");
       
    }    

    @FXML
    private void connexionUtilisateur(ActionEvent event) throws Exception {
        
         ServiceUser us = new ServiceUser();
        Utilisateur u = new Utilisateur();
        u.setUsername(txt_user_name.getText());
        u.setPassword(txt_password.getText());
        
        if (us.login(u) == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("user inccorrect");
            alert.setContentText("please check your informations!");
            alert.showAndWait();
        } else {
            Session.start(u.getId());
            
            if (us.login(u) != null && us.testMotDePasse(txt_password.getText(),u.getPassword())) {
              
                if (us.login(u).getRoles().contains("ROLE_ADMIN")) {
                    Node node = (Node)event.getSource();
                    dialogStage = (Stage) node.getScene().getWindow();
                    dialogStage.close();
                    scene = new Scene(FXMLLoader.load(getClass().getResource("/gui/reclamation.fxml")));
                    dialogStage.setScene(scene);
                    dialogStage.show();
                } else {
                    Node node = (Node)event.getSource();
                    dialogStage = (Stage) node.getScene().getWindow();
                    dialogStage.close();
                    scene = new Scene(FXMLLoader.load(getClass().getResource("/gui/reclamation.fxml")));
                    dialogStage.setScene(scene);
                    dialogStage.show();
                }

            }

        }

    }
    
}
