/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Etudiant;
import entities.FicheSynthese;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author valo
 */
@Local
public interface FicheSyntheseFacadeLocal {

    void create(FicheSynthese ficheSynthese);

    void edit(FicheSynthese ficheSynthese);

    void remove(FicheSynthese ficheSynthese);

    FicheSynthese find(Object id);

    List<FicheSynthese> findAll();

    List<FicheSynthese> findRange(int[] range);

    int count();

    FicheSynthese getByEtudiantAndByNomPage(Etudiant etudiant, String nomPage);

}
