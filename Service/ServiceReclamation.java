/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Reclamation;
import Entity.Session;
import InterfaceService.IServiceReclamation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import nawara.MyConnection;

/**
 *
 * @author Mohamed Bousselmi
 */
public class ServiceReclamation implements IServiceReclamation{
      Connection cn = MyConnection.getInstance().getConnection();
    Statement st;
    PreparedStatement pst;
    
    @Override
    public void ajouterPersonne(Reclamation r) {
       String req=null;
       DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
       Date d=new Date();
          try {
              req = "INSERT INTO reclamation(description,sujet,dateReclamation,User_id,Produit_id,etat) VALUES ('"+r.getDescription()+"','"+r.getSujet()+"','"+dateFormat.format(d)+"','"+Session.getCurrentSession()+"','"+r.getProduit_id()+"','0');";
          } catch (Exception ex) {
              Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
          }
       try{
           st=cn.createStatement();
           st.executeUpdate(req);
           System.out.println("Reclamation ajoutée");
       }catch(SQLException e){
           System.out.println("error");
       }
    
     }  
    
    
       
    
    @Override
    public List<Reclamation> getAll() {
      List<Reclamation> Listp = new ArrayList<>();
        String req=null;
          try {
              req = "select * from reclamation where User_id='"+Session.getCurrentSession()+"' ";
          } catch (Exception ex) {
              Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
          }
        PreparedStatement ps ;
        try{
            ps=cn.prepareStatement(req);
            ResultSet result = ps.executeQuery();
            
            while(result.next()){
                if (result.getInt(7)==0)
                {
                    Reclamation r = new Reclamation(result.getInt(1),result.getString(2),result.getString(3),result.getDate(4),result.getInt(5),new ServiceProduit().findById(result.getInt(6)),"     Votre Réclamation est sous\n                   traitance");
                Listp.add(r);
                }
                else
                {
                Reclamation r = new Reclamation(result.getInt(1),result.getString(2),result.getString(3),result.getDate(4),result.getInt(5),new ServiceProduit().findById(result.getInt(6)),"    Votre Réclamation est traité \nveuiller consulter votre e-mail");
                Listp.add(r);
                }
            }
        }catch (SQLException e)
        { e.printStackTrace();}
        
        return Listp;
        
    }
    
     @Override
    public void supprimerReclamation(int id) {
       String req = "DELETE FROM reclamation where id ='"+id+"';";
       try{
           st=cn.createStatement();
           st.executeUpdate(req);
          
       }catch(SQLException e){
           System.out.println("error");
       }
    }
     @Override
    public void modifierReclamation(Reclamation r) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
       Date d=new Date();
       String req = "UPDATE  reclamation SET description='"+r.getDescription()+"' ,sujet='"+r.getSujet()+"',dateReclamation='"+dateFormat.format(d)+"' where id ='"+r.getId()+"';";
       try{
           st=cn.createStatement();
           st.executeUpdate(req);
          
       }catch(SQLException e){
           System.out.println("error");
       }
    }
    
     @Override
     public List<Reclamation> rechercherReclamation(String x) {
      List<Reclamation> Listp = new ArrayList<>();
        String req = "select * from reclamation where sujet like '"+x+"%' or description like'"+x+"%' or dateReclamation like'"+x+"%';";
        PreparedStatement ps ;
        try{
            ps=cn.prepareStatement(req);
            ResultSet result = ps.executeQuery();
            
            while(result.next()){
                if (result.getInt(7)==0)
                {
                    Reclamation r = new Reclamation(result.getInt(1),result.getString(2),result.getString(3),result.getDate(4),result.getInt(5),new ServiceProduit().findById(result.getInt(6)),"     Votre Réclamation est sous\n                   traitance");
                Listp.add(r);
                }
                else
                {
                Reclamation r = new Reclamation(result.getInt(1),result.getString(2),result.getString(3),result.getDate(4),result.getInt(5),new ServiceProduit().findById(result.getInt(6)),"    Votre Réclamation est traité \nveuiller consulter votre e-mail");
                Listp.add(r);
                }
            }
        }catch (SQLException e)
        { e.printStackTrace();}
        
        return Listp;
        
    }
    
}
