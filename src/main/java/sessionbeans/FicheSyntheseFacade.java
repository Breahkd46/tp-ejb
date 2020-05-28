/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Etudiant;
import entities.FicheSynthese;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author valo
 */
@Stateless
public class FicheSyntheseFacade extends AbstractFacade<FicheSynthese> implements FicheSyntheseFacadeLocal {

    @PersistenceContext(unitName = "tp-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FicheSyntheseFacade() {
        super(FicheSynthese.class);
    }

    @Override
    public FicheSynthese getByEtudiantAndByNomPage(Etudiant etudiant, String nomPage) {
        try {
            return em.createQuery("SELECT Object(f) " +
                    "FROM FicheSynthese f " +
                    "WHERE f.etudiant=?1 " +
                    "AND f.nomPage=?2", FicheSynthese.class)
                    .setParameter(1, etudiant)
                    .setParameter(2, nomPage)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
