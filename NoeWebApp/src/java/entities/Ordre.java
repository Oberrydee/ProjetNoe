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
    , @NamedQuery(name = "Ordre.findByIdordre", query = "SELECT o FROM Ordre o WHERE o.idordre = :idordre")
    , @NamedQuery(name = "Ordre.findByNom", query = "SELECT o FROM Ordre o WHERE o.nom = :nom")})
public class Ordre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idordre")
    private Integer idordre;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @JoinColumn(name = "Famille_idFamille", referencedColumnName = "idFamille")
    @ManyToOne(optional = false)
    private Famille familleidFamille;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordreIdordre")
    private List<Classe> classeList;

    public Ordre() {
    }

    public Ordre(Integer idordre) {
        this.idordre = idordre;
    }

    public Integer getIdordre() {
        return idordre;
    }

    public void setIdordre(Integer idordre) {
        this.idordre = idordre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Famille getFamilleidFamille() {
        return familleidFamille;
    }

    public void setFamilleidFamille(Famille familleidFamille) {
        this.familleidFamille = familleidFamille;
    }

    @XmlTransient
    public List<Classe> getClasseList() {
        return classeList;
    }

    public void setClasseList(List<Classe> classeList) {
        this.classeList = classeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idordre != null ? idordre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordre)) {
            return false;
        }
        Ordre other = (Ordre) object;
        if ((this.idordre == null && other.idordre != null) || (this.idordre != null && !this.idordre.equals(other.idordre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ordre[ idordre=" + idordre + " ]";
    }
    
}
