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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADZOH-VINYO DIANA
 */
@Entity
@Table(name = "ordre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordre.findAll", query = "SELECT o FROM Ordre o")
    , @NamedQuery(name = "Ordre.findByIdordre", query = "SELECT o FROM Ordre o WHERE o.ordrePK.idordre = :idordre")
    , @NamedQuery(name = "Ordre.findByNom", query = "SELECT o FROM Ordre o WHERE o.nom = :nom")
    , @NamedQuery(name = "Ordre.findByOrdrecol", query = "SELECT o FROM Ordre o WHERE o.ordrecol = :ordrecol")
    , @NamedQuery(name = "Ordre.findByRegneIdregne", query = "SELECT o FROM Ordre o WHERE o.ordrePK.regneIdregne = :regneIdregne")
    , @NamedQuery(name = "Ordre.findByRegneEmbranchementIdembranchement", query = "SELECT o FROM Ordre o WHERE o.ordrePK.regneEmbranchementIdembranchement = :regneEmbranchementIdembranchement")})
public class Ordre implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrdrePK ordrePK;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @Size(max = 45)
    @Column(name = "ordrecol")
    private String ordrecol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordre")
    private List<Classe> classeList;
    @JoinColumns({
        @JoinColumn(name = "regne_idregne", referencedColumnName = "idregne", insertable = false, updatable = false)
        , @JoinColumn(name = "regne_embranchement_idembranchement", referencedColumnName = "embranchement_idembranchement", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Regne regne;

    public Ordre() {
    }

    public Ordre(OrdrePK ordrePK) {
        this.ordrePK = ordrePK;
    }

    public Ordre(int idordre, int regneIdregne, int regneEmbranchementIdembranchement) {
        this.ordrePK = new OrdrePK(idordre, regneIdregne, regneEmbranchementIdembranchement);
    }

    public OrdrePK getOrdrePK() {
        return ordrePK;
    }

    public void setOrdrePK(OrdrePK ordrePK) {
        this.ordrePK = ordrePK;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getOrdrecol() {
        return ordrecol;
    }

    public void setOrdrecol(String ordrecol) {
        this.ordrecol = ordrecol;
    }

    @XmlTransient
    public List<Classe> getClasseList() {
        return classeList;
    }

    public void setClasseList(List<Classe> classeList) {
        this.classeList = classeList;
    }

    public Regne getRegne() {
        return regne;
    }

    public void setRegne(Regne regne) {
        this.regne = regne;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordrePK != null ? ordrePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordre)) {
            return false;
        }
        Ordre other = (Ordre) object;
        if ((this.ordrePK == null && other.ordrePK != null) || (this.ordrePK != null && !this.ordrePK.equals(other.ordrePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ordre[ ordrePK=" + ordrePK + " ]";
    }
    
}
