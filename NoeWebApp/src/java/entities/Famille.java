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
@Table(name = "famille")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Famille.findAll", query = "SELECT f FROM Famille f")
    , @NamedQuery(name = "Famille.findByIdFamille", query = "SELECT f FROM Famille f WHERE f.famillePK.idFamille = :idFamille")
    , @NamedQuery(name = "Famille.findByNom", query = "SELECT f FROM Famille f WHERE f.nom = :nom")
    , @NamedQuery(name = "Famille.findByFamillecol", query = "SELECT f FROM Famille f WHERE f.famillecol = :famillecol")
    , @NamedQuery(name = "Famille.findByClasseIdclasse", query = "SELECT f FROM Famille f WHERE f.famillePK.classeIdclasse = :classeIdclasse")
    , @NamedQuery(name = "Famille.findByClasseOrdreIdordre", query = "SELECT f FROM Famille f WHERE f.famillePK.classeOrdreIdordre = :classeOrdreIdordre")
    , @NamedQuery(name = "Famille.findByClasseOrdreRegneIdregne", query = "SELECT f FROM Famille f WHERE f.famillePK.classeOrdreRegneIdregne = :classeOrdreRegneIdregne")
    , @NamedQuery(name = "Famille.findByClasseOrdreRegneEmbranchementIdembranchement", query = "SELECT f FROM Famille f WHERE f.famillePK.classeOrdreRegneEmbranchementIdembranchement = :classeOrdreRegneEmbranchementIdembranchement")})
public class Famille implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FamillePK famillePK;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @Size(max = 45)
    @Column(name = "Famillecol")
    private String famillecol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "famille")
    private List<Taxinomie> taxinomieList;
    @JoinColumns({
        @JoinColumn(name = "classe_idclasse", referencedColumnName = "idclasse", insertable = false, updatable = false)
        , @JoinColumn(name = "classe_ordre_idordre", referencedColumnName = "ordre_idordre", insertable = false, updatable = false)
        , @JoinColumn(name = "classe_ordre_regne_idregne", referencedColumnName = "ordre_regne_idregne", insertable = false, updatable = false)
        , @JoinColumn(name = "classe_ordre_regne_embranchement_idembranchement", referencedColumnName = "ordre_regne_embranchement_idembranchement", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Classe classe;

    public Famille() {
    }

    public Famille(FamillePK famillePK) {
        this.famillePK = famillePK;
    }

    public Famille(int idFamille, int classeIdclasse, int classeOrdreIdordre, int classeOrdreRegneIdregne, int classeOrdreRegneEmbranchementIdembranchement) {
        this.famillePK = new FamillePK(idFamille, classeIdclasse, classeOrdreIdordre, classeOrdreRegneIdregne, classeOrdreRegneEmbranchementIdembranchement);
    }

    public FamillePK getFamillePK() {
        return famillePK;
    }

    public void setFamillePK(FamillePK famillePK) {
        this.famillePK = famillePK;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getFamillecol() {
        return famillecol;
    }

    public void setFamillecol(String famillecol) {
        this.famillecol = famillecol;
    }

    @XmlTransient
    public List<Taxinomie> getTaxinomieList() {
        return taxinomieList;
    }

    public void setTaxinomieList(List<Taxinomie> taxinomieList) {
        this.taxinomieList = taxinomieList;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (famillePK != null ? famillePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Famille)) {
            return false;
        }
        Famille other = (Famille) object;
        if ((this.famillePK == null && other.famillePK != null) || (this.famillePK != null && !this.famillePK.equals(other.famillePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Famille[ famillePK=" + famillePK + " ]";
    }
    
}
