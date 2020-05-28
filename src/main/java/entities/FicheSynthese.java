/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author valo
 */
@Entity
public class FicheSynthese implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    public String nomPage;
    
    public String text;
    
    @ManyToOne(fetch = FetchType.EAGER)
    public Etudiant etudiant;

    public FicheSynthese() {
    }

    public FicheSynthese(String nomPage, String text, Etudiant etudiant) {
        this.nomPage = nomPage;
        this.text = text;
        this.etudiant = etudiant;
    }

    public String getNomPage() {
        return nomPage;
    }

    public void setNomPage(String nom) {
        this.nomPage = nom;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant auteur) {
        this.etudiant = auteur;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FicheSynthese)) {
            return false;
        }
        FicheSynthese other = (FicheSynthese) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.FicheSynthese[ id=" + id + " ]";
    }
    
}
