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
@Table(name = "famille")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Famille.findAll", query = "SELECT f FROM Famille f")
    , @NamedQuery(name = "Famille.findByIdfamille", query = "SELECT f FROM Famille f WHERE f.idfamille = :idfamille")
    , @NamedQuery(name = "Famille.findByNom", query = "SELECT f FROM Famille f WHERE f.nom = :nom")})
public class Famille implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfamille")
    private Integer idfamille;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "familleIdfamille")
    private List<Taxinomie> taxinomieList;

    public Famille() {
    }

    public Famille(Integer idfamille) {
        this.idfamille = idfamille;
    }

    public Integer getIdfamille() {
        return idfamille;
    }

    public void setIdfamille(Integer idfamille) {
        this.idfamille = idfamille;
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
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Famille)) {
            return false;
        }
        Famille other = (Famille) object;
        if ((this.idfamille == null && other.idfamille != null) || (this.idfamille != null && !this.idfamille.equals(other.idfamille))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Famille[ idfamille=" + idfamille + " ]";
    }
    
}
