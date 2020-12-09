/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceService;

import Entity.Produit;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Mohamed Bousselmi
 */
public interface IServiceProduit {
    
     public Produit findById(int id_produit)throws SQLException;
     public List<Produit> getAll() ;
    
}
