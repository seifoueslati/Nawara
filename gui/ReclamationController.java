/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Produit;
import Service.ServiceReclamation;
import Entity.Reclamation;
import Service.ServiceProduit;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Mohamed Bousselmi
 */
public class ReclamationController implements Initializable {
    
     @FXML
    private Button valider;
    @FXML
    private Button Supprimer;
    @FXML
    private Button Modifier;
    @FXML
    private Button ajouter;
    @FXML
    private Button rech;
    @FXML
    private Button enregistrer_modification;
     @FXML
    private Button Annuler_fomulaire;
     
    @FXML
    private Button Annuler;
   
    @FXML
    private TabPane tab;
    
    @FXML 
    private TextArea descript;
    
    @FXML 
    private TextField titre;
    
    @FXML
     private ChoiceBox produit;
     @FXML
     private ChoiceBox id_produit;
     @FXML
    private TextField rechercher;
    @FXML
    private TableView<Reclamation> reclamation;
    @FXML
    private TableColumn<Reclamation, String> sujet;
    @FXML
    private TableColumn<Reclamation, String> description;
    @FXML
    private TableColumn<Reclamation, Date> date_reclamation;
    @FXML
    private TableColumn<Reclamation, String> nom_produit;
    @FXML
    private TableColumn<Reclamation, String> etat_reclamation;

    private ObservableList<Reclamation> ListReclamation = FXCollections.observableArrayList();
    Reclamation r = new Reclamation(); 
     ServiceReclamation Rs = new ServiceReclamation();
     ServiceProduit Ps= new ServiceProduit();
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        
        List<Produit> list = Ps.getAll();
             id_produit.setVisible(false);
              
              
             for (int i=0; i< list.size();i++)
                     {
                         produit.getItems().add(list.get(i));
                         id_produit.getItems().add(list.get(i).getId());
                         
                     }
               produit.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
      @Override
      public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
        id_produit.getSelectionModel().select( produit.getSelectionModel().getSelectedIndex());
          
      }
    });
        
        Afficher();
         Supprimer.setVisible(false);
         Modifier.setVisible(false);
         enregistrer_modification.setVisible(false);
         
         Annuler.setVisible(false);
         ajouter.setVisible(true);
        
         rechercher.textProperty().addListener(new ChangeListener<String>() {
    @Override
    public void changed(ObservableValue<? extends String> observable,
            String oldValue, String newValue) {

       recherche();
    }
    } );
    
    }
    
    void recherche ()
{
 if(rechercher.getText().equals(""))
     {
         Afficher();
     }
     else {
      ListReclamation = FXCollections.observableArrayList(Rs.rechercherReclamation(rechercher.getText()));
       sujet.setCellValueFactory(new PropertyValueFactory<>("sujet"));
        sujet.cellFactoryProperty();
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        description.cellFactoryProperty();
        date_reclamation.setCellValueFactory(new PropertyValueFactory<>("dateReclamation"));
        date_reclamation.cellFactoryProperty();
        nom_produit.setCellValueFactory(new PropertyValueFactory<>("produit"));
        nom_produit.cellFactoryProperty();
        
        etat_reclamation.setCellValueFactory(new PropertyValueFactory<>("etat"));
        etat_reclamation.cellFactoryProperty();
         
           reclamation.setItems(ListReclamation);
     }
    }
    void Afficher()
    {
        ListReclamation = FXCollections.observableArrayList(Rs.getAll());
        sujet.setCellValueFactory(new PropertyValueFactory<>("sujet"));
        sujet.cellFactoryProperty();
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        description.cellFactoryProperty();
        date_reclamation.setCellValueFactory(new PropertyValueFactory<>("dateReclamation"));
        date_reclamation.cellFactoryProperty();
        nom_produit.setCellValueFactory(new PropertyValueFactory<>("produit"));
        nom_produit.cellFactoryProperty();
        
        etat_reclamation.setCellValueFactory(new PropertyValueFactory<>("etat"));
        etat_reclamation.cellFactoryProperty();
         
           reclamation.setItems(ListReclamation);
    }
    @FXML
    private void Enregistrer_Ajout(ActionEvent event)
    {
        int i=(int)id_produit.getValue();
        Reclamation r = new Reclamation(descript.getText(), titre.getText(),i); 
        ServiceReclamation Rs = new ServiceReclamation();
       Rs.ajouterPersonne(r);
        Afficher();
        titre.setText("");
        descript.setText("");
        tab.getSelectionModel().select(0);
        id_produit.getSelectionModel().select(0);
         produit.getSelectionModel().select(0);
    }
    
    @FXML
    private void table_clicked(MouseEvent event)
    {
     
      Supprimer.setVisible(true);
      Modifier.setVisible(true);
            Annuler.setVisible(true);
            ajouter.setVisible(false);
    }
     @FXML
    private void afficher_formulaire_ajout(ActionEvent event)
    {
     
     tab.getSelectionModel().select(1);
    }
     @FXML
     private void Annuler_selection(ActionEvent event)
    {
     Supprimer.setVisible(false);
            Modifier.setVisible(false);
            Annuler.setVisible(false);
            ajouter.setVisible(true);
     
    }
     
    @FXML
     private void supprimer_Modification(ActionEvent event)
     {
         if (!reclamation.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("suppression d'une catégorie d'event");
            alert.setHeaderText("Etes-vous sur de vouloir  supprimer   "
                    + reclamation.getSelectionModel().getSelectedItem().getSujet()+ "?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
               ServiceReclamation Rs = new ServiceReclamation();
               
               Rs.supprimerReclamation(reclamation.getSelectionModel().getSelectedItem().getId());
              
                Afficher();
                
                
            }
            Supprimer.setVisible(false);
            Modifier.setVisible(false);
            Annuler.setVisible(false);
            ajouter.setVisible(true);
        }
     }
     
      @FXML
     private void afficher_formulaire_modifier(ActionEvent event)
     {
         titre.setText(reclamation.getSelectionModel().getSelectedItem().getSujet());
         descript.setText(reclamation.getSelectionModel().getSelectedItem().getDescription());
         do
         {  
           if( reclamation.getSelectionModel().getSelectedItem().getProduit().getId()!=1)
           {id_produit.getSelectionModel().selectNext();
            produit.getSelectionModel().selectNext();}
         }
         while(reclamation.getSelectionModel().getSelectedItem().getProduit().getId()!=(int)id_produit.getValue());
          enregistrer_modification.setVisible(true);
         
         valider.setVisible(false);
        tab.getSelectionModel().select(1);
         Supprimer.setVisible(false);
            Modifier.setVisible(false);
            Annuler.setVisible(false);
            ajouter.setVisible(true);
     }
     
        @FXML
     private void annuler_formulaire(ActionEvent event)
             
     {
         titre.setText("");
         descript.setText("");
         enregistrer_modification.setVisible(false);
         id_produit.getSelectionModel().select(0);
         produit.getSelectionModel().select(0);
            
         valider.setVisible(true);
         tab.getSelectionModel().select(0);
         
     }
     
     @FXML
     private void Enregistrer_modification(ActionEvent event)
     {
      if (!reclamation.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("suppression d'une catégorie d'event");
            alert.setHeaderText("Etes-vous sur de vouloir  modifier   "
                    + reclamation.getSelectionModel().getSelectedItem().getSujet()+ "?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {    
               ServiceReclamation Rs = new ServiceReclamation();
               Reclamation R = new Reclamation(reclamation.getSelectionModel().getSelectedItem().getId(),descript.getText(),titre.getText());
                System.out.println(R);
               Rs.modifierReclamation(R);
              
                Afficher();
                
                
            }
            
            titre.setText("");
            description.setText("");
            enregistrer_modification.setVisible(false);
         
         id_produit.getSelectionModel().select(0);
         produit.getSelectionModel().select(0);
         valider.setVisible(true);
         tab.getSelectionModel().select(0);
         
     }
     }
     
   
    
      @FXML
     private void reche(ActionEvent event){
     recherche();
     }
}
