/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Etudiant;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author valo
 */
@Stateless
public class AuthSessionBean {
    @PersistenceContext(unitName = "tp-ejbPU")
    private EntityManager em;

    public boolean checkLoginPassword(String login, String password) {
        return em.createQuery("select Object(e) "
                + "FROM Etudiant e "
                + "WHERE e.login=?1 "
                + "AND e.password=?2", Etudiant.class)
                .setParameter(1, login)
                .setParameter(2, password).getResultList().size() == 1;
    }
    
    public Etudiant getEtudiantByLogin(String login) {
        return em.createQuery("SELECT Object(e) "
                + "FROM Etudiant e WHERE e.login=?1", Etudiant.class).setParameter(1, login).getSingleResult();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
