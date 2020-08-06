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
    , @NamedQuery(name = "Espece.findBySemenceIdsemence", query = "SELECT e FROM Espece e WHERE e.especePK.semenceIdsemence = :semenceIdsemence")})
public class Espece implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EspecePK especePK;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @JoinColumn(name = "alerte_idalerte", referencedColumnName = "idalerte")
    @ManyToOne(optional = false)
    private Alerte alerteIdalerte;
    @JoinColumn(name = "regne_idregne", referencedColumnName = "idregne")
    @ManyToOne(optional = false)
    private Regne regneIdregne;
    @JoinColumn(name = "semence_idsemence", referencedColumnName = "idsemence", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Semence semence;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "espece")
    private List<Alerte> alerteList;

    public Espece() {
    }

    public Espece(EspecePK especePK) {
        this.especePK = especePK;
    }

    public Espece(int idespece, int semenceIdsemence) {
        this.especePK = new EspecePK(idespece, semenceIdsemence);
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

    public Alerte getAlerteIdalerte() {
        return alerteIdalerte;
    }

    public void setAlerteIdalerte(Alerte alerteIdalerte) {
        this.alerteIdalerte = alerteIdalerte;
    }

    public Regne getRegneIdregne() {
        return regneIdregne;
    }

    public void setRegneIdregne(Regne regneIdregne) {
        this.regneIdregne = regneIdregne;
    }

    public Semence getSemence() {
        return semence;
    }

    public void setSemence(Semence semence) {
        this.semence = semence;
    }

    @XmlTransient
    public List<Alerte> getAlerteList() {
        return alerteList;
    }

    public void setAlerteList(List<Alerte> alerteList) {
        this.alerteList = alerteList;
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
