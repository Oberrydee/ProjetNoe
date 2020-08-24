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
@Table(name = "Sentinelle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sentinelle.findAll", query = "SELECT s FROM Sentinelle s")
    , @NamedQuery(name = "Sentinelle.findByIdsentinelle", query = "SELECT s FROM Sentinelle s WHERE s.idsentinelle = :idsentinelle")})
public class Sentinelle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsentinelle")
    private Integer idsentinelle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sentinelleIdsentinelle")
    private List<Alerte> alerteList;
    @JoinColumn(name = "Salari\u00e9_idSalari\u00e9", referencedColumnName = "idSalari\u00e9")
    @ManyToOne(optional = false)
    private Salarié salariéidSalarié;

    public Sentinelle() {
    }

    public Sentinelle(Integer idsentinelle) {
        this.idsentinelle = idsentinelle;
    }

    public Integer getIdsentinelle() {
        return idsentinelle;
    }

    public void setIdsentinelle(Integer idsentinelle) {
        this.idsentinelle = idsentinelle;
    }

    @XmlTransient
    public List<Alerte> getAlerteList() {
        return alerteList;
    }

    public void setAlerteList(List<Alerte> alerteList) {
        this.alerteList = alerteList;
    }

    public Salarié getSalariéidSalarié() {
        return salariéidSalarié;
    }

    public void setSalariéidSalarié(Salarié salariéidSalarié) {
        this.salariéidSalarié = salariéidSalarié;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sentinelle)) {
            return false;
        }
        Sentinelle other = (Sentinelle) object;
        if ((this.idsentinelle == null && other.idsentinelle != null) || (this.idsentinelle != null && !this.idsentinelle.equals(other.idsentinelle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Sentinelle[ idsentinelle=" + idsentinelle + " ]";
    }
    
}
