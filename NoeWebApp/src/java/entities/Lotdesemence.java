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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADZOH-VINYO DIANA
 */
@Entity
@Table(name = "lotdesemence")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lotdesemence.findAll", query = "SELECT l FROM Lotdesemence l")
    , @NamedQuery(name = "Lotdesemence.findByIdLotDeSemence", query = "SELECT l FROM Lotdesemence l WHERE l.lotdesemencePK.idLotDeSemence = :idLotDeSemence")
    , @NamedQuery(name = "Lotdesemence.findByQuantiteEnNbDeCaiseses", query = "SELECT l FROM Lotdesemence l WHERE l.quantiteEnNbDeCaiseses = :quantiteEnNbDeCaiseses")
    , @NamedQuery(name = "Lotdesemence.findBySemenceIdsemence", query = "SELECT l FROM Lotdesemence l WHERE l.lotdesemencePK.semenceIdsemence = :semenceIdsemence")})
public class Lotdesemence implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LotdesemencePK lotdesemencePK;
    @Column(name = "quantiteEnNbDeCaiseses")
    private Integer quantiteEnNbDeCaiseses;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lotDeSemenceidLotDeSemence")
    private List<Sitedestokage> sitedestokageList;
    @JoinColumn(name = "semence_idsemence", referencedColumnName = "idsemence", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Semence semence;

    public Lotdesemence() {
    }

    public Lotdesemence(LotdesemencePK lotdesemencePK) {
        this.lotdesemencePK = lotdesemencePK;
    }

    public Lotdesemence(int idLotDeSemence, int semenceIdsemence) {
        this.lotdesemencePK = new LotdesemencePK(idLotDeSemence, semenceIdsemence);
    }

    public LotdesemencePK getLotdesemencePK() {
        return lotdesemencePK;
    }

    public void setLotdesemencePK(LotdesemencePK lotdesemencePK) {
        this.lotdesemencePK = lotdesemencePK;
    }

    public Integer getQuantiteEnNbDeCaiseses() {
        return quantiteEnNbDeCaiseses;
    }

    public void setQuantiteEnNbDeCaiseses(Integer quantiteEnNbDeCaiseses) {
        this.quantiteEnNbDeCaiseses = quantiteEnNbDeCaiseses;
    }

    @XmlTransient
    public List<Sitedestokage> getSitedestokageList() {
        return sitedestokageList;
    }

    public void setSitedestokageList(List<Sitedestokage> sitedestokageList) {
        this.sitedestokageList = sitedestokageList;
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
        hash += (lotdesemencePK != null ? lotdesemencePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lotdesemence)) {
            return false;
        }
        Lotdesemence other = (Lotdesemence) object;
        if ((this.lotdesemencePK == null && other.lotdesemencePK != null) || (this.lotdesemencePK != null && !this.lotdesemencePK.equals(other.lotdesemencePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Lotdesemence[ lotdesemencePK=" + lotdesemencePK + " ]";
    }
    
}
