/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.rakotonaivo.tpbanque.jsf;

import jakarta.annotation.ManagedBean;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import mg.itu.rakotonaivo.tpbanque.ejb.GestionnaireCompte;
import mg.itu.rakotonaivo.tpbanque.entities.CompteBancaire;

/**
 *
 * @author Administrator
 */
@Named(value = "transfer")
@ViewScoped
public class Transfer implements Serializable {

    private long idSource;
    private long idDestination;
    private int montant;
    
    @EJB
    GestionnaireCompte compteManager;
    
    public Transfer() {
    }

    public long getIdSource() {
        return idSource;
    }

    public void setIdSource(long idSource) {
        this.idSource = idSource;
    }

    public long getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(long idDestination) {
        this.idDestination = idDestination;
    }

    public int getMontant() {
        return montant;
    }
    

    public void setMontant(int montant) {
        this.montant = montant;
    }
    
    public String doTransfer(){
        CompteBancaire source = compteManager.findById(idSource);
        CompteBancaire destination = compteManager.findById(idDestination);
        compteManager.transferer(source, destination, montant);
        return "listeComptes?&amp;faces-redirect=true";
    }
}
