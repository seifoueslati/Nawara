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
public class Utilisateur {
     private int id;
    private String nom;
   
    private String prenom;
  
 private String adresse;
     private String email;
   private String numTel;
    private String username;
   
    private String usernameCanonical;
  

   
    private String emailCanonical;
   
    private boolean enabled;

    private String salt;
 
   
    private String password;
  
    private Date lastLogin;
 
    private String confirmationToken;

    private Date passwordRequestedAt;
   
    private String roles;
  
    
    private String discr ;
    
    private String photo ;

    public Utilisateur() {
    }

    public Utilisateur(int id, String nom, String prenom, String adresse, String email, String numTel, String username, String usernameCanonical, String emailCanonical, boolean enabled, String salt, String password, Date lastLogin, String confirmationToken, Date passwordRequestedAt, String roles, String discr, String photo) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.numTel = numTel;
        this.username = username;
        this.usernameCanonical = usernameCanonical;
        this.emailCanonical = emailCanonical;
        this.enabled = enabled;
        this.salt = salt;
        this.password = password;
        this.lastLogin = lastLogin;
        this.confirmationToken = confirmationToken;
        this.passwordRequestedAt = passwordRequestedAt;
        this.roles = roles;
        this.discr = discr;
        this.photo = photo;
    }

    public Utilisateur(int id, String username) {
        this.id = id;
        this.username = username;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsernameCanonical() {
        return usernameCanonical;
    }

    public void setUsernameCanonical(String usernameCanonical) {
        this.usernameCanonical = usernameCanonical;
    }

    public String getEmailCanonical() {
        return emailCanonical;
    }

    public void setEmailCanonical(String emailCanonical) {
        this.emailCanonical = emailCanonical;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public Date getPasswordRequestedAt() {
        return passwordRequestedAt;
    }

    public void setPasswordRequestedAt(Date passwordRequestedAt) {
        this.passwordRequestedAt = passwordRequestedAt;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getDiscr() {
        return discr;
    }

    public void setDiscr(String discr) {
        this.discr = discr;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    
    @Override
    public String toString() {
        return ""+ username + "";
    }
    
    
    
  
  
    
}
