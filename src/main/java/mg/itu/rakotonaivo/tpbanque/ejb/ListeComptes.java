/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.rakotonaivo.tpbanque.ejb;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import mg.itu.rakotonaivo.tpbanque.ejb.GestionnaireCompte;
import mg.itu.rakotonaivo.tpbanque.entities.CompteBancaire;
import mg.itu.rakotonaivo.tpbanque.jsf.util.Util;

/**
 *
 * @author Administrator
 */
@Named(value = "listeComptes")
@ViewScoped
public class ListeComptes implements Serializable {

    @EJB
    GestionnaireCompte compteManager;

    public ListeComptes() {
    }

    public List<CompteBancaire> getAllComptes() {
        return compteManager.getAllComptes();
    }

    public String supprimerCompte(CompteBancaire compteBancaire) {
        compteManager.supprimerCompte(compteBancaire);
        Util.addFlashInfoMessage("Compte de " + compteBancaire.getNom() + " supprimé");
        return "listeComptes?faces-redirect=true";
    }
}
