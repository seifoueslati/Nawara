/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceService;

import Entity.Utilisateur;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Mohamed Bousselmi
 */
public interface IServiceUser {
     public  boolean testMotDePasse(String motDePasseGUI, String motDePasseBD);
     public  List<Utilisateur> getTtUtilisateur() ;
      public Utilisateur login(Utilisateur u);
       public int getLastId();
        public Utilisateur findById(int id_user)throws SQLException;
}
