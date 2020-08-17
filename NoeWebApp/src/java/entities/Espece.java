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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "espece")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Espece.findAll", query = "SELECT e FROM Espece e")
    , @NamedQuery(name = "Espece.findByIdespece", query = "SELECT e FROM Espece e WHERE e.idespece = :idespece")
    , @NamedQuery(name = "Espece.findByNom", query = "SELECT e FROM Espece e WHERE e.nom = :nom")})
public class Espece implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idespece")
    private Integer idespece;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "especeIdespece")
    private List<Semence> semenceList;
    @JoinColumn(name = "taxinomie_idtaxinomie", referencedColumnName = "idtaxinomie")
    @ManyToOne(optional = false)
    private Taxinomie taxinomieIdtaxinomie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "especeIdespece")
    private List<Alerte> alerteList;

    public Espece() {
    }

    public Espece(Integer idespece) {
        this.idespece = idespece;
    }

    public Integer getIdespece() {
        return idespece;
    }

    public void setIdespece(Integer idespece) {
        this.idespece = idespece;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlTransient
    public List<Semence> getSemenceList() {
        return semenceList;
    }

    public void setSemenceList(List<Semence> semenceList) {
        this.semenceList = semenceList;
    }

    public Taxinomie getTaxinomieIdtaxinomie() {
        return taxinomieIdtaxinomie;
    }

    public void setTaxinomieIdtaxinomie(Taxinomie taxinomieIdtaxinomie) {
        this.taxinomieIdtaxinomie = taxinomieIdtaxinomie;
    }

    @XmlTransient
    public List<Alerte> getAlerteList() {
        return alerteList;
    }

    public void setAlerteList(List<Alerte> alerteList) {
        this.alerteList = alerteList;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Espece)) {
            return false;
        }
        Espece other = (Espece) object;
        if ((this.idespece == null && other.idespece != null) || (this.idespece != null && !this.idespece.equals(other.idespece))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Espece[ idespece=" + idespece + " ]";
    }
    
}
