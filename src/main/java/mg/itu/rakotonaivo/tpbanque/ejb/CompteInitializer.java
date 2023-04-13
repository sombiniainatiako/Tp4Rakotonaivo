/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.rakotonaivo.tpbanque.ejb;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;
import mg.itu.rakotonaivo.tpbanque.entities.CompteBancaire;

@Startup
@Singleton
public class CompteInitializer {
    @PersistenceContext(unitName = "banquePU")
    private EntityManager em;
    
    @EJB
    private GestionnaireCompte gc;
    
    @PostConstruct
    public void initCompte(){
        List<CompteBancaire> list = gc.getAllComptes();
        if(list.isEmpty()){
            CompteBancaire c1= new CompteBancaire("John Lennon",150000);
            CompteBancaire c2= new CompteBancaire("Paul McCartney",950000);
            CompteBancaire c3= new CompteBancaire("Ringo Starr",20000);
            CompteBancaire c4 = new CompteBancaire("Georges Harrisson",100000);
            em.persist(c1);
            em.persist(c2);
            em.persist(c3);
            em.persist(c4);
        }
    }
}
