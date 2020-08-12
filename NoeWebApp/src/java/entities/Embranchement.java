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
@Table(name = "embranchement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Embranchement.findAll", query = "SELECT e FROM Embranchement e")
    , @NamedQuery(name = "Embranchement.findByIdembranchement", query = "SELECT e FROM Embranchement e WHERE e.idembranchement = :idembranchement")
    , @NamedQuery(name = "Embranchement.findByNom", query = "SELECT e FROM Embranchement e WHERE e.nom = :nom")})
public class Embranchement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idembranchement")
    private Integer idembranchement;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "embranchementIdembranchement")
    private List<Taxinomie> taxinomieList;

    public Embranchement() {
    }

    public Embranchement(Integer idembranchement) {
        this.idembranchement = idembranchement;
    }

    public Integer getIdembranchement() {
        return idembranchement;
    }

    public void setIdembranchement(Integer idembranchement) {
        this.idembranchement = idembranchement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlTransient
    public List<Taxinomie> getTaxinomieList() {
        return taxinomieList;
    }

    public void setTaxinomieList(List<Taxinomie> taxinomieList) {
        this.taxinomieList = taxinomieList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idembranchement != null ? idembranchement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Embranchement)) {
            return false;
        }
        Embranchement other = (Embranchement) object;
        if ((this.idembranchement == null && other.idembranchement != null) || (this.idembranchement != null && !this.idembranchement.equals(other.idembranchement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Embranchement[ idembranchement=" + idembranchement + " ]";
    }
    
}
