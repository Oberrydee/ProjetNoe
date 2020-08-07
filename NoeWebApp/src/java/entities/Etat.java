/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADZOH-VINYO DIANA
 */
@Entity
@Table(name = "etat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etat.findAll", query = "SELECT e FROM Etat e")
    , @NamedQuery(name = "Etat.findByIdetat", query = "SELECT e FROM Etat e WHERE e.idetat = :idetat")
    , @NamedQuery(name = "Etat.findByDescription", query = "SELECT e FROM Etat e WHERE e.description = :description")})
public class Etat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idetat")
    private Integer idetat;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etatIdetat")
    private List<Projet> projetList;

    public Etat() {
    }

    public Etat(Integer idetat) {
        this.idetat = idetat;
    }

    public Integer getIdetat() {
        return idetat;
    }

    public void setIdetat(Integer idetat) {
        this.idetat = idetat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Projet> getProjetList() {
        return projetList;
    }

    public void setProjetList(List<Projet> projetList) {
        this.projetList = projetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idetat != null ? idetat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etat)) {
            return false;
        }
        Etat other = (Etat) object;
        if ((this.idetat == null && other.idetat != null) || (this.idetat != null && !this.idetat.equals(other.idetat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Etat[ idetat=" + idetat + " ]";
    }
    
}
