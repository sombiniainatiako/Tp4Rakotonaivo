/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.rakotonaivo.tpbanque.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import mg.itu.rakotonaivo.tpbanque.ejb.GestionnaireCompte;
import mg.itu.rakotonaivo.tpbanque.entities.CompteBancaire;

/**
 *
 * @author Administrator
 */
@Named(value = "listeOperations")
@RequestScoped
public class ListeOperations {

    @EJB
    private GestionnaireCompte compteManager;
    private Long id;
    private CompteBancaire compte;
    
    public ListeOperations() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public CompteBancaire getCompte() {
        return compte;
    }

    public void loadCompte() {
        compte = compteManager.findById(id);
    }
    
}
