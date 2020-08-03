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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADZOH-VINYO DIANA
 */
@Entity
@Table(name = "semence")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Semence.findAll", query = "SELECT s FROM Semence s")
    , @NamedQuery(name = "Semence.findByIdsemence", query = "SELECT s FROM Semence s WHERE s.idsemence = :idsemence")})
public class Semence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsemence")
    private Integer idsemence;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "semence")
    private List<Espece> especeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "semence")
    private List<Lotdesemence> lotdesemenceList;

    public Semence() {
    }

    public Semence(Integer idsemence) {
        this.idsemence = idsemence;
    }

    public Integer getIdsemence() {
        return idsemence;
    }

    public void setIdsemence(Integer idsemence) {
        this.idsemence = idsemence;
    }

    @XmlTransient
    public List<Espece> getEspeceList() {
        return especeList;
    }

    public void setEspeceList(List<Espece> especeList) {
        this.especeList = especeList;
    }

    @XmlTransient
    public List<Lotdesemence> getLotdesemenceList() {
        return lotdesemenceList;
    }

    public void setLotdesemenceList(List<Lotdesemence> lotdesemenceList) {
        this.lotdesemenceList = lotdesemenceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsemence != null ? idsemence.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Semence)) {
            return false;
        }
        Semence other = (Semence) object;
        if ((this.idsemence == null && other.idsemence != null) || (this.idsemence != null && !this.idsemence.equals(other.idsemence))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Semence[ idsemence=" + idsemence + " ]";
    }
    
}
