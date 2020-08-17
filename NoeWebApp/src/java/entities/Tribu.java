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
@Table(name = "tribu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tribu.findAll", query = "SELECT t FROM Tribu t")
    , @NamedQuery(name = "Tribu.findByIdtribu", query = "SELECT t FROM Tribu t WHERE t.idtribu = :idtribu")
    , @NamedQuery(name = "Tribu.findByNom", query = "SELECT t FROM Tribu t WHERE t.nom = :nom")})
public class Tribu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtribu")
    private Integer idtribu;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tribuIdtribu")
    private List<Taxinomie> taxinomieList;

    public Tribu() {
    }

    public Tribu(Integer idtribu) {
        this.idtribu = idtribu;
    }

    public Integer getIdtribu() {
        return idtribu;
    }

    public void setIdtribu(Integer idtribu) {
        this.idtribu = idtribu;
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
        if (!(object instanceof Tribu)) {
            return false;
        }
        Tribu other = (Tribu) object;
        if ((this.idtribu == null && other.idtribu != null) || (this.idtribu != null && !this.idtribu.equals(other.idtribu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tribu[ idtribu=" + idtribu + " ]";
    }
    
}
