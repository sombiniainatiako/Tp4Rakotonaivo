/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.rakotonaivo.tpbanque.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import mg.itu.rakotonaivo.tpbanque.ejb.GestionnaireCompte;
import mg.itu.rakotonaivo.tpbanque.entities.CompteBancaire;
import mg.itu.rakotonaivo.tpbanque.jsf.util.Util;

/**
 *
 * @author Administrator
 */
@Named(value = "changerNom")
@ViewScoped
public class changerNom implements Serializable {

    @EJB
    private GestionnaireCompte compteManager;
    private Long id;
    private CompteBancaire compte;

    public changerNom() {
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
    
    public String save() {
    compteManager.update(compte);
    Util.addFlashInfoMessage("Modification de nom réussi en" + compte.getNom());
    return "listeComptes?faces-redirect=true";
  }

}
