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
@Table(name = "regne")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regne.findAll", query = "SELECT r FROM Regne r")
    , @NamedQuery(name = "Regne.findByIdregne", query = "SELECT r FROM Regne r WHERE r.regnePK.idregne = :idregne")
    , @NamedQuery(name = "Regne.findByNom", query = "SELECT r FROM Regne r WHERE r.nom = :nom")
    , @NamedQuery(name = "Regne.findByRegnecol", query = "SELECT r FROM Regne r WHERE r.regnecol = :regnecol")
    , @NamedQuery(name = "Regne.findByEmbranchementIdembranchement", query = "SELECT r FROM Regne r WHERE r.regnePK.embranchementIdembranchement = :embranchementIdembranchement")})
public class Regne implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RegnePK regnePK;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @Size(max = 45)
    @Column(name = "regnecol")
    private String regnecol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regne")
    private List<Ordre> ordreList;
    @JoinColumn(name = "embranchement_idembranchement", referencedColumnName = "idembranchement", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Embranchement embranchement;

    public Regne() {
    }

    public Regne(RegnePK regnePK) {
        this.regnePK = regnePK;
    }

    public Regne(int idregne, int embranchementIdembranchement) {
        this.regnePK = new RegnePK(idregne, embranchementIdembranchement);
    }

    public RegnePK getRegnePK() {
        return regnePK;
    }

    public void setRegnePK(RegnePK regnePK) {
        this.regnePK = regnePK;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRegnecol() {
        return regnecol;
    }

    public void setRegnecol(String regnecol) {
        this.regnecol = regnecol;
    }

    @XmlTransient
    public List<Ordre> getOrdreList() {
        return ordreList;
    }

    public void setOrdreList(List<Ordre> ordreList) {
        this.ordreList = ordreList;
    }

    public Embranchement getEmbranchement() {
        return embranchement;
    }

    public void setEmbranchement(Embranchement embranchement) {
        this.embranchement = embranchement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regnePK != null ? regnePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regne)) {
            return false;
        }
        Regne other = (Regne) object;
        if ((this.regnePK == null && other.regnePK != null) || (this.regnePK != null && !this.regnePK.equals(other.regnePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Regne[ regnePK=" + regnePK + " ]";
    }
    
}
