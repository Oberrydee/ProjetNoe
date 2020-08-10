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
@Table(name = "Salle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salle.findAll", query = "SELECT s FROM Salle s")
    , @NamedQuery(name = "Salle.findByIdSalle", query = "SELECT s FROM Salle s WHERE s.idSalle = :idSalle")
    , @NamedQuery(name = "Salle.findByDescription", query = "SELECT s FROM Salle s WHERE s.description = :description")})
public class Salle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSalle")
    private Integer idSalle;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "salleidSalle")
    private List<LotDeSemence> lotDeSemenceList;

    public Salle() {
    }

    public Salle(Integer idSalle) {
        this.idSalle = idSalle;
    }

    public Integer getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(Integer idSalle) {
        this.idSalle = idSalle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<LotDeSemence> getLotDeSemenceList() {
        return lotDeSemenceList;
    }

    public void setLotDeSemenceList(List<LotDeSemence> lotDeSemenceList) {
        this.lotDeSemenceList = lotDeSemenceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSalle != null ? idSalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salle)) {
            return false;
        }
        Salle other = (Salle) object;
        if ((this.idSalle == null && other.idSalle != null) || (this.idSalle != null && !this.idSalle.equals(other.idSalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Salle[ idSalle=" + idSalle + " ]";
    }
    
}
