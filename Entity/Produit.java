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
public class Produit {
    
    private int id;

 
    private String nomProduit;

    private String photoProduit;

    private Date dateProduit;

    
     
    private String reference;

    
    private float prixVente;
    
    private float prixAchat;

  
    private int quantite;

    public Produit() {
    }

    public Produit(int id, String nomProduit) {
        this.id = id;
        this.nomProduit = nomProduit;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getPhotoProduit() {
        return photoProduit;
    }

    public void setPhotoProduit(String photoProduit) {
        this.photoProduit = photoProduit;
    }

    public Date getDateProduit() {
        return dateProduit;
    }

    public void setDateProduit(Date dateProduit) {
        this.dateProduit = dateProduit;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public float getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(float prixVente) {
        this.prixVente = prixVente;
    }

    public float getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(float prixAchat) {
        this.prixAchat = prixAchat;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    
    
      @Override
    public String toString() {
        return ""+nomProduit+"";
    }

    
}
