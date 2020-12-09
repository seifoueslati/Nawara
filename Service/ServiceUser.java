/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Utilisateur;
import InterfaceService.IServiceUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import nawara.MyConnection;
import org.mindrot.jbcrypt.BCrypt;
/**
 *
 * @author Mohamed Bousselmi
 */
public class ServiceUser implements IServiceUser{
    Connection cn = MyConnection.getInstance().getConnection();
    ResultSet rs;  
    PreparedStatement pst;

    

    @Override
    public  boolean testMotDePasse(String motDePasseGUI, String motDePasseBD) {
        boolean password_verified = false;

        if (null == motDePasseBD) {
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
        }

        // en remplaçant 2y par 2a le cryptage on obtient le cryptage par defaut pour que la methode checkpw puisse comparer
        password_verified = BCrypt.checkpw(motDePasseGUI, motDePasseBD.replaceFirst("2y", "2a"));

        return (password_verified);
    }

    @Override
    public  List<Utilisateur> getTtUtilisateur() {
        List<Utilisateur> list = new ArrayList<Utilisateur>();
        Connection cn =  MyConnection.getInstance().getConnection();
        PreparedStatement pt;
        try {
            String sql = "select * from user ";
            pt = cn.prepareStatement(sql);
            ResultSet resultSet = pt.executeQuery();
            while (resultSet.next()) {
                Utilisateur utilisateur = new Utilisateur();

                utilisateur.setUsername(resultSet.getString("username"));
                utilisateur.setPassword(resultSet.getString("password"));
                utilisateur.setRoles(resultSet.getString("roles"));
                list.add(utilisateur);
            }
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return list;
    }

    
    
    @Override
    public Utilisateur login(Utilisateur u) {

        try {
            Connection cn = MyConnection.getInstance().getConnection();
            String loginQry = "SELECT * FROM user WHERE username = ? ";
            PreparedStatement ste = cn.prepareStatement(loginQry);
            ste.setString(1, u.getUsername());
            ResultSet rs = ste.executeQuery();

            while (rs.next()) {
                u.setRoles(rs.getString("roles"));
                u.setPassword(rs.getString("password"));
                u.setId(rs.getInt(1));
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public int getLastId(){
        int id = 0;
        String sqlGetLastId= "SELECT MAX(id) FROM user";
        try {
            Connection cnLastId =  MyConnection.getInstance().getConnection();
            Statement st;
            st =  cnLastId.createStatement();
            id = st.executeUpdate(sqlGetLastId);
            cnLastId.close();
            return id;
        } catch (SQLException e) {
             e.printStackTrace();
        } 
        return id;
    }
    
     
    @Override
     public Utilisateur findById(int id_user)throws SQLException{ 
        {
            Utilisateur u = new Utilisateur();
            String requete="select * from user where id ='"+id_user+"';";
           pst=cn.prepareStatement(requete);
           rs=pst.executeQuery(requete); 
            while(rs.next())
            {
                u=new Utilisateur(rs.getInt(1), rs.getString(3));
            }
            
           return u;   
        }}
}
