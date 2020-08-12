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
@Table(name = "SiteDeStokage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteDeStokage.findAll", query = "SELECT s FROM SiteDeStokage s")
    , @NamedQuery(name = "SiteDeStokage.findByIdSiteDeStokage", query = "SELECT s FROM SiteDeStokage s WHERE s.idSiteDeStokage = :idSiteDeStokage")
    , @NamedQuery(name = "SiteDeStokage.findByLocalisation", query = "SELECT s FROM SiteDeStokage s WHERE s.localisation = :localisation")})
public class SiteDeStokage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSiteDeStokage")
    private Integer idSiteDeStokage;
    @Size(max = 45)
    @Column(name = "localisation")
    private String localisation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "siteDeStockageSiteDeStockage")
    private List<LotDeSemence> lotDeSemenceList;

    public SiteDeStokage() {
    }

    public SiteDeStokage(Integer idSiteDeStokage) {
        this.idSiteDeStokage = idSiteDeStokage;
    }

    public Integer getIdSiteDeStokage() {
        return idSiteDeStokage;
    }

    public void setIdSiteDeStokage(Integer idSiteDeStokage) {
        this.idSiteDeStokage = idSiteDeStokage;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    @XmlTransient
    public List<LotDeSemence> getLotDeSemenceList() {
        return lotDeSemenceList;
    }

    public void setLotDeSemenceList(List<LotDeSemence> lotDeSemenceList) {
        this.lotDeSemenceList = lotDeSemenceList;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SiteDeStokage)) {
            return false;
        }
        SiteDeStokage other = (SiteDeStokage) object;
        if ((this.idSiteDeStokage == null && other.idSiteDeStokage != null) || (this.idSiteDeStokage != null && !this.idSiteDeStokage.equals(other.idSiteDeStokage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SiteDeStokage[ idSiteDeStokage=" + idSiteDeStokage + " ]";
    }
    
}
