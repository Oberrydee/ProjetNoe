/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
    , @NamedQuery(name = "Espece.findByIdespece", query = "SELECT e FROM Espece e WHERE e.especePK.idespece = :idespece")
    , @NamedQuery(name = "Espece.findByNom", query = "SELECT e FROM Espece e WHERE e.nom = :nom")
    , @NamedQuery(name = "Espece.findBySemenceIdsemence", query = "SELECT e FROM Espece e WHERE e.especePK.semenceIdsemence = :semenceIdsemence")
    , @NamedQuery(name = "Espece.findByAlerteIdalerte", query = "SELECT e FROM Espece e WHERE e.especePK.alerteIdalerte = :alerteIdalerte")})
public class Espece implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EspecePK especePK;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "espece")
    private List<Taxinomie> taxinomieList;
    @JoinColumn(name = "alerte_idalerte", referencedColumnName = "idalerte", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alerte alerte;
    @JoinColumn(name = "semence_idsemence", referencedColumnName = "idsemence", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Semence semence;

    public Espece() {
    }

    public Espece(EspecePK especePK) {
        this.especePK = especePK;
    }

    public Espece(int idespece, int semenceIdsemence, int alerteIdalerte) {
        this.especePK = new EspecePK(idespece, semenceIdsemence, alerteIdalerte);
    }

    public EspecePK getEspecePK() {
        return especePK;
    }

    public void setEspecePK(EspecePK especePK) {
        this.especePK = especePK;
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

    public Alerte getAlerte() {
        return alerte;
    }

    public void setAlerte(Alerte alerte) {
        this.alerte = alerte;
    }

    public Semence getSemence() {
        return semence;
    }

    public void setSemence(Semence semence) {
        this.semence = semence;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (especePK != null ? especePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Espece)) {
            return false;
        }
        Espece other = (Espece) object;
        if ((this.especePK == null && other.especePK != null) || (this.especePK != null && !this.especePK.equals(other.especePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Espece[ especePK=" + especePK + " ]";
    }
    
}
