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
    , @NamedQuery(name = "Lotdesemence.findByIdLotDeSemence", query = "SELECT l FROM Lotdesemence l WHERE l.idLotDeSemence = :idLotDeSemence")
    , @NamedQuery(name = "Lotdesemence.findByQuantiteEnNbDeCaisses", query = "SELECT l FROM Lotdesemence l WHERE l.quantiteEnNbDeCaisses = :quantiteEnNbDeCaisses")
    , @NamedQuery(name = "Lotdesemence.findByDisponibiliteEnStock", query = "SELECT l FROM Lotdesemence l WHERE l.disponibiliteEnStock = :disponibiliteEnStock")
    , @NamedQuery(name = "Lotdesemence.findByDureeDeStockageEnMois", query = "SELECT l FROM Lotdesemence l WHERE l.dureeDeStockageEnMois = :dureeDeStockageEnMois")})
public class Lotdesemence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLotDeSemence")
    private Integer idLotDeSemence;
    @Column(name = "quantiteEnNbDeCaisses")
    private Integer quantiteEnNbDeCaisses;
    @Column(name = "disponibiliteEnStock")
    private Integer disponibiliteEnStock;
    @Column(name = "dureeDeStockageEnMois")
    private Integer dureeDeStockageEnMois;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lotDeSemenceidLotDeSemence")
    private List<Semence> semenceList;
    @JoinColumn(name = "Salle_idSalle", referencedColumnName = "idSalle")
    @ManyToOne
    private Salle salleidSalle;
    @JoinColumn(name = "SiteDeStockage_SiteDeStockage", referencedColumnName = "idSiteDeStokage")
    @ManyToOne(optional = false)
    private Sitedestokage siteDeStockageSiteDeStockage;

    public Lotdesemence() {
    }

    public Lotdesemence(Integer idLotDeSemence) {
        this.idLotDeSemence = idLotDeSemence;
    }

    public Integer getIdLotDeSemence() {
        return idLotDeSemence;
    }

    public void setIdLotDeSemence(Integer idLotDeSemence) {
        this.idLotDeSemence = idLotDeSemence;
    }

    public Integer getQuantiteEnNbDeCaisses() {
        return quantiteEnNbDeCaisses;
    }

    public void setQuantiteEnNbDeCaisses(Integer quantiteEnNbDeCaisses) {
        this.quantiteEnNbDeCaisses = quantiteEnNbDeCaisses;
    }

    public Integer getDisponibiliteEnStock() {
        return disponibiliteEnStock;
    }

    public void setDisponibiliteEnStock(Integer disponibiliteEnStock) {
        this.disponibiliteEnStock = disponibiliteEnStock;
    }

    public Integer getDureeDeStockageEnMois() {
        return dureeDeStockageEnMois;
    }

    public void setDureeDeStockageEnMois(Integer dureeDeStockageEnMois) {
        this.dureeDeStockageEnMois = dureeDeStockageEnMois;
    }

    @XmlTransient
    public List<Semence> getSemenceList() {
        return semenceList;
    }

    public void setSemenceList(List<Semence> semenceList) {
        this.semenceList = semenceList;
    }

    public Salle getSalleidSalle() {
        return salleidSalle;
    }

    public void setSalleidSalle(Salle salleidSalle) {
        this.salleidSalle = salleidSalle;
    }

    public Sitedestokage getSiteDeStockageSiteDeStockage() {
        return siteDeStockageSiteDeStockage;
    }

    public void setSiteDeStockageSiteDeStockage(Sitedestokage siteDeStockageSiteDeStockage) {
        this.siteDeStockageSiteDeStockage = siteDeStockageSiteDeStockage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLotDeSemence != null ? idLotDeSemence.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lotdesemence)) {
            return false;
        }
        Lotdesemence other = (Lotdesemence) object;
        if ((this.idLotDeSemence == null && other.idLotDeSemence != null) || (this.idLotDeSemence != null && !this.idLotDeSemence.equals(other.idLotDeSemence))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Lotdesemence[ idLotDeSemence=" + idLotDeSemence + " ]";
    }
    
}
