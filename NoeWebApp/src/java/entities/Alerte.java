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
    , @NamedQuery(name = "Alerte.findByIdalerte", query = "SELECT a FROM Alerte a WHERE a.alertePK.idalerte = :idalerte")
    , @NamedQuery(name = "Alerte.findByUrgence", query = "SELECT a FROM Alerte a WHERE a.urgence = :urgence")
    , @NamedQuery(name = "Alerte.findByEspeceIdespece", query = "SELECT a FROM Alerte a WHERE a.alertePK.especeIdespece = :especeIdespece")
    , @NamedQuery(name = "Alerte.findByEspeceSemenceIdsemence", query = "SELECT a FROM Alerte a WHERE a.alertePK.especeSemenceIdsemence = :especeSemenceIdsemence")
    , @NamedQuery(name = "Alerte.findByEspeceAlerteIdalerte", query = "SELECT a FROM Alerte a WHERE a.alertePK.especeAlerteIdalerte = :especeAlerteIdalerte")})
public class Alerte implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlertePK alertePK;
    @Column(name = "urgence")
    private Integer urgence;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alerte")
    private List<Projet> projetList;
    @JoinColumns({
        @JoinColumn(name = "espece_idespece", referencedColumnName = "idespece", insertable = false, updatable = false)
        , @JoinColumn(name = "espece_semence_idsemence", referencedColumnName = "semence_idsemence", insertable = false, updatable = false)
        , @JoinColumn(name = "espece_alerte_idalerte", referencedColumnName = "alerte_idalerte", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Espece espece;

    public Alerte() {
    }

    public Alerte(AlertePK alertePK) {
        this.alertePK = alertePK;
    }

    public Alerte(int idalerte, int especeIdespece, int especeSemenceIdsemence, int especeAlerteIdalerte) {
        this.alertePK = new AlertePK(idalerte, especeIdespece, especeSemenceIdsemence, especeAlerteIdalerte);
    }

    public AlertePK getAlertePK() {
        return alertePK;
    }

    public void setAlertePK(AlertePK alertePK) {
        this.alertePK = alertePK;
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

    public Espece getEspece() {
        return espece;
    }

    public void setEspece(Espece espece) {
        this.espece = espece;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alertePK != null ? alertePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alerte)) {
            return false;
        }
        Alerte other = (Alerte) object;
        if ((this.alertePK == null && other.alertePK != null) || (this.alertePK != null && !this.alertePK.equals(other.alertePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Alerte[ alertePK=" + alertePK + " ]";
    }
    
}
