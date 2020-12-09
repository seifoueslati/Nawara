/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nawara;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Mohamed Bousselmi
 */

public class MyConnection {

   private String url="jdbc:mysql://localhost:3306/nawara";
    private String login ="root";
    private String pwd="";
    private Connection cnx ; 
    private static MyConnection instance;
    private MyConnection()
    {
        try{
            cnx = DriverManager.getConnection(url,login,pwd);
            System.out.println("connexion etablie");
            
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public Connection getConnection()
    {
        return cnx;
    }
    
    public static MyConnection getInstance()
    {
        if(instance==null){
            instance = new MyConnection();
        }
        return instance ; 
    }
}
