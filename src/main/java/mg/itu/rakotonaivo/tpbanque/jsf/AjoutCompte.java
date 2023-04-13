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
import mg.itu.rakotonaivo.tpbanque.jsf.util.Util;

/**
 *
 * @author Administrator
 */
@Named(value = "ajoutCompte")
@RequestScoped
public class AjoutCompte {

    String nom;
    int solde;

    @EJB
    GestionnaireCompte compteManager;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public String creer(){
        boolean erreur = false;
        if(solde < 0){
            Util.messageErreur("Solde doit être positif", "Solde doit être positif", "form:solde");
            erreur = true;
        }
        if(erreur){
            return null;
        }
        compteManager.creerCompte(new CompteBancaire(nom,solde));
        Util.addFlashInfoMessage("Insertion correctement effectué");
        return "listeComptes?&amp;faces-redirect=true";
    }
}
