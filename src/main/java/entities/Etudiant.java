/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author valo
 */
@Entity
public class Etudiant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    public String nom;
    
    public String prenom;
    
    public String login;
    
    public String password;
    
    public int age;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "etudiant", cascade ={CascadeType.MERGE, CascadeType.PERSIST})
    public Set<FicheSynthese> fiches;

    public Etudiant() {
    }

    public Etudiant(String nom, String prenom, String login, String password, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.age = age;
        this.fiches = new HashSet<>();
    }
    
    

    public Set<FicheSynthese> getFiches() {
        return fiches;
    }

    public void setFiches(Set<FicheSynthese> fiches) {
        this.fiches = fiches;
    }
    
    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
        if (!(object instanceof Etudiant)) {
            return false;
        }
        Etudiant other = (Etudiant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Etudiant[ id=" + id + " ]";
    }
    
}
