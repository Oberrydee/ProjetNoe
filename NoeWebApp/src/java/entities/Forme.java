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
@Table(name = "forme")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Forme.findAll", query = "SELECT f FROM Forme f")
    , @NamedQuery(name = "Forme.findByIdforme", query = "SELECT f FROM Forme f WHERE f.idforme = :idforme")
    , @NamedQuery(name = "Forme.findByNom", query = "SELECT f FROM Forme f WHERE f.nom = :nom")})
public class Forme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idforme")
    private Integer idforme;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formeIdforme")
    private List<Taxinomie> taxinomieList;

    public Forme() {
    }

    public Forme(Integer idforme) {
        this.idforme = idforme;
    }

    public Integer getIdforme() {
        return idforme;
    }

    public void setIdforme(Integer idforme) {
        this.idforme = idforme;
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
        hash += (idforme != null ? idforme.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Forme)) {
            return false;
        }
        Forme other = (Forme) object;
        if ((this.idforme == null && other.idforme != null) || (this.idforme != null && !this.idforme.equals(other.idforme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Forme[ idforme=" + idforme + " ]";
    }
    
}
