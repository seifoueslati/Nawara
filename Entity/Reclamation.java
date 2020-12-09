/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author Mohamed Bousselmi
 */
public class Reclamation {
    private int id;
    private String description;
    private String sujet;
    private Date   dateReclamation;
    private int user_id;
    private int Produit_id;
    private Produit produit;
    private String etat;

    public Reclamation(String description, String sujet, int Produit_id) {
        this.description = description;
        this.sujet = sujet;
        this.Produit_id = Produit_id;
    }

    public Reclamation(int id, String description, String sujet) {
        this.id = id;
        this.description = description;
        this.sujet = sujet;
    }

    
    
    
    public Reclamation(int id, String description, String sujet, Date dateReclamation, int user_id, int Produit_id, String etat) {
        this.id = id;
        this.description = description;
        this.sujet = sujet;
        this.dateReclamation = dateReclamation;
        this.user_id = user_id;
        this.Produit_id = Produit_id;
        this.etat = etat;
    }

    public Reclamation(int id, String description, String sujet, Date dateReclamation, int user_id, Produit produit, String etat) {
        this.id = id;
        this.description = description;
        this.sujet = sujet;
        this.dateReclamation = dateReclamation;
        this.user_id = user_id;
        this.produit = produit;
        this.etat = etat;
    }
  

    public Reclamation() {
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public Date getDateReclamation() {
        return dateReclamation;
    }

    public void setDateReclamation(Date dateReclamation) {
        this.dateReclamation = dateReclamation;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProduit_id() {
        return Produit_id;
    }

    public void setProduit_id(int Produit_id) {
        this.Produit_id = Produit_id;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", description=" + description + ", sujet=" + sujet + ", dateReclamation=" + dateReclamation + ", user_id=" + user_id + ", Produit_id=" + Produit_id + ", produit=" + produit + ", etat=" + etat + '}';
    }
    
    
    
    
}
