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
import javax.validation.constraints.NotNull;
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
    , @NamedQuery(name = "Regne.findByIdregne", query = "SELECT r FROM Regne r WHERE r.idregne = :idregne")
    , @NamedQuery(name = "Regne.findByNom", query = "SELECT r FROM Regne r WHERE r.nom = :nom")
    , @NamedQuery(name = "Regne.findByEmbranchement", query = "SELECT r FROM Regne r WHERE r.embranchement = :embranchement")
    , @NamedQuery(name = "Regne.findByDivision", query = "SELECT r FROM Regne r WHERE r.division = :division")
    , @NamedQuery(name = "Regne.findByPhylum", query = "SELECT r FROM Regne r WHERE r.phylum = :phylum")})
public class Regne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idregne")
    private Integer idregne;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "embranchement")
    private String embranchement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "division")
    private String division;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "phylum")
    private String phylum;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regneIdregne")
    private List<Espece> especeList;
    @JoinColumn(name = "classe_idclasse", referencedColumnName = "idclasse")
    @ManyToOne(optional = false)
    private Classe classeIdclasse;

    public Regne() {
    }

    public Regne(Integer idregne) {
        this.idregne = idregne;
    }

    public Regne(Integer idregne, String embranchement, String division, String phylum) {
        this.idregne = idregne;
        this.embranchement = embranchement;
        this.division = division;
        this.phylum = phylum;
    }

    public Integer getIdregne() {
        return idregne;
    }

    public void setIdregne(Integer idregne) {
        this.idregne = idregne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmbranchement() {
        return embranchement;
    }

    public void setEmbranchement(String embranchement) {
        this.embranchement = embranchement;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getPhylum() {
        return phylum;
    }

    public void setPhylum(String phylum) {
        this.phylum = phylum;
    }

    @XmlTransient
    public List<Espece> getEspeceList() {
        return especeList;
    }

    public void setEspeceList(List<Espece> especeList) {
        this.especeList = especeList;
    }

    public Classe getClasseIdclasse() {
        return classeIdclasse;
    }

    public void setClasseIdclasse(Classe classeIdclasse) {
        this.classeIdclasse = classeIdclasse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idregne != null ? idregne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regne)) {
            return false;
        }
        Regne other = (Regne) object;
        if ((this.idregne == null && other.idregne != null) || (this.idregne != null && !this.idregne.equals(other.idregne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Regne[ idregne=" + idregne + " ]";
    }
    
}
