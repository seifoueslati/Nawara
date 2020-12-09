/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceService;

import Entity.Reclamation;
import java.util.List;

/**
 *
 * @author Mohamed Bousselmi
 */
public interface IServiceReclamation {
 
    public void ajouterPersonne(Reclamation r);
    public void supprimerReclamation(int id);
    public List<Reclamation> getAll();
    public void modifierReclamation(Reclamation r);
    public List<Reclamation> rechercherReclamation(String x);
    
}
