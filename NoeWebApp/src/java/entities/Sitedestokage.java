/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADZOH-VINYO DIANA
 */
@Entity
@Table(name = "sitedestokage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sitedestokage.findAll", query = "SELECT s FROM Sitedestokage s")
    , @NamedQuery(name = "Sitedestokage.findByIdSiteDeStokage", query = "SELECT s FROM Sitedestokage s WHERE s.idSiteDeStokage = :idSiteDeStokage")
    , @NamedQuery(name = "Sitedestokage.findBySalle", query = "SELECT s FROM Sitedestokage s WHERE s.salle = :salle")
    , @NamedQuery(name = "Sitedestokage.findByLocalisation", query = "SELECT s FROM Sitedestokage s WHERE s.localisation = :localisation")})
public class Sitedestokage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSiteDeStokage")
    private Integer idSiteDeStokage;
    @Column(name = "salle")
    private Integer salle;
    @Size(max = 45)
    @Column(name = "localisation")
    private String localisation;
    @ManyToMany(mappedBy = "sitedestokageList")
    private List<Salarié> salariéList;
    @JoinColumn(name = "LotDeSemence_idLotDeSemence", referencedColumnName = "idLotDeSemence")
    @ManyToOne(optional = false)
    private Lotdesemence lotDeSemenceidLotDeSemence;

    public Sitedestokage() {
    }

    public Sitedestokage(Integer idSiteDeStokage) {
        this.idSiteDeStokage = idSiteDeStokage;
    }

    public Integer getIdSiteDeStokage() {
        return idSiteDeStokage;
    }

    public void setIdSiteDeStokage(Integer idSiteDeStokage) {
        this.idSiteDeStokage = idSiteDeStokage;
    }

    public Integer getSalle() {
        return salle;
    }

    public void setSalle(Integer salle) {
        this.salle = salle;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    @XmlTransient
    public List<Salarié> getSalariéList() {
        return salariéList;
    }

    public void setSalariéList(List<Salarié> salariéList) {
        this.salariéList = salariéList;
    }

    public Lotdesemence getLotDeSemenceidLotDeSemence() {
        return lotDeSemenceidLotDeSemence;
    }

    public void setLotDeSemenceidLotDeSemence(Lotdesemence lotDeSemenceidLotDeSemence) {
        this.lotDeSemenceidLotDeSemence = lotDeSemenceidLotDeSemence;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSiteDeStokage != null ? idSiteDeStokage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sitedestokage)) {
            return false;
        }
        Sitedestokage other = (Sitedestokage) object;
        if ((this.idSiteDeStokage == null && other.idSiteDeStokage != null) || (this.idSiteDeStokage != null && !this.idSiteDeStokage.equals(other.idSiteDeStokage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Sitedestokage[ idSiteDeStokage=" + idSiteDeStokage + " ]";
    }
    
}
