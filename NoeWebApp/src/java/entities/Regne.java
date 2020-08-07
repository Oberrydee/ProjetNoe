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
@Table(name = "regne")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regne.findAll", query = "SELECT r FROM Regne r")
    , @NamedQuery(name = "Regne.findByIdregne", query = "SELECT r FROM Regne r WHERE r.idregne = :idregne")
    , @NamedQuery(name = "Regne.findByNom", query = "SELECT r FROM Regne r WHERE r.nom = :nom")})
public class Regne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idregne")
    private Integer idregne;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regneIdregne")
    private List<Taxinomie> taxinomieList;

    public Regne() {
    }

    public Regne(Integer idregne) {
        this.idregne = idregne;
    }

    public Integer getIdregne() {
        return idregne;
    }

    public void setIdregne(Integer idregne) {
        this.idregne = idregne;
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
        hash += (idregne != null ? idregne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regne)) {
            return false;
        }
        Regne other = (Regne) object;
        if ((this.idregne == null && other.idregne != null) || (this.idregne != null && !this.idregne.equals(other.idregne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Regne[ idregne=" + idregne + " ]";
    }
    
}
