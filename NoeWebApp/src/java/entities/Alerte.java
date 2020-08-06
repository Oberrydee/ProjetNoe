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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADZOH-VINYO DIANA
 */
@Entity
@Table(name = "alerte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alerte.findAll", query = "SELECT a FROM Alerte a")
    , @NamedQuery(name = "Alerte.findByIdalerte", query = "SELECT a FROM Alerte a WHERE a.idalerte = :idalerte")
    , @NamedQuery(name = "Alerte.findByUrgence", query = "SELECT a FROM Alerte a WHERE a.urgence = :urgence")})
public class Alerte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idalerte")
    private Integer idalerte;
    @Column(name = "urgence")
    private Integer urgence;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alerte")
    private List<Projet> projetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alerteIdalerte")
    private List<Espece> especeList;
    @JoinColumns({
        @JoinColumn(name = "espece_idespece", referencedColumnName = "idespece")
        , @JoinColumn(name = "espece_semence_idsemence", referencedColumnName = "semence_idsemence")})
    @ManyToOne(optional = false)
    private Espece espece;

    public Alerte() {
    }

    public Alerte(Integer idalerte) {
        this.idalerte = idalerte;
    }

    public Integer getIdalerte() {
        return idalerte;
    }

    public void setIdalerte(Integer idalerte) {
        this.idalerte = idalerte;
    }

    public Integer getUrgence() {
        return urgence;
    }

    public void setUrgence(Integer urgence) {
        this.urgence = urgence;
    }

    @XmlTransient
    public List<Projet> getProjetList() {
        return projetList;
    }

    public void setProjetList(List<Projet> projetList) {
        this.projetList = projetList;
    }

    @XmlTransient
    public List<Espece> getEspeceList() {
        return especeList;
    }

    public void setEspeceList(List<Espece> especeList) {
        this.especeList = especeList;
    }

    public Espece getEspece() {
        return espece;
    }

    public void setEspece(Espece espece) {
        this.espece = espece;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idalerte != null ? idalerte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alerte)) {
            return false;
        }
        Alerte other = (Alerte) object;
        if ((this.idalerte == null && other.idalerte != null) || (this.idalerte != null && !this.idalerte.equals(other.idalerte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Alerte[ idalerte=" + idalerte + " ]";
    }
    
}
