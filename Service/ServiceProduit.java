/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Produit;
import InterfaceService.IServiceProduit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import nawara.MyConnection;

/**
 *
 * @author Mohamed Bousselmi
 */
public class ServiceProduit implements IServiceProduit{
     Connection cn = MyConnection.getInstance().getConnection();
    Statement st;
    PreparedStatement pst;
     private ResultSet rs; 
    
     @Override
     public Produit findById(int id_produit)throws SQLException{ 
        {
            Produit a = new Produit();
            String requete="select * from produit where id ='"+id_produit+"';";
           pst=cn.prepareStatement(requete);
           rs=pst.executeQuery(requete); 
            while(rs.next())
            {
                a=new Produit(rs.getInt(1), rs.getString(2));
                
            }
            
           return a;   
        }
     }
     
       @Override
    public List<Produit> getAll() {
      List<Produit> Listp = new ArrayList<>();
        String req = "select * from produit ";
        PreparedStatement ps ;
        try{
            ps=cn.prepareStatement(req);
            ResultSet result = ps.executeQuery();
            
            while(result.next()){
                Produit p = new Produit(result.getInt(1),result.getString(2));
                Listp.add(p);
            }
        }catch (SQLException e)
        { e.printStackTrace();}
        
        return Listp;
        
    }
    
}
