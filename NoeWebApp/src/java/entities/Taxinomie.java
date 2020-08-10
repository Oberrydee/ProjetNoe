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
@Table(name = "taxinomie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Taxinomie.findAll", query = "SELECT t FROM Taxinomie t")
    , @NamedQuery(name = "Taxinomie.findByIdtaxinomie", query = "SELECT t FROM Taxinomie t WHERE t.idtaxinomie = :idtaxinomie")
    , @NamedQuery(name = "Taxinomie.findByNom", query = "SELECT t FROM Taxinomie t WHERE t.nom = :nom")})
public class Taxinomie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtaxinomie")
    private Integer idtaxinomie;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @JoinColumn(name = "regne_idregne", referencedColumnName = "idregne")
    @ManyToOne(optional = false)
    private Regne regneIdregne;
    @JoinColumn(name = "embranchement_idembranchement", referencedColumnName = "idembranchement")
    @ManyToOne(optional = false)
    private Embranchement embranchementIdembranchement;
    @JoinColumn(name = "classe_idclasse", referencedColumnName = "idclasse")
    @ManyToOne(optional = false)
    private Classe classeIdclasse;
    @JoinColumn(name = "ordre_idordre", referencedColumnName = "idordre")
    @ManyToOne(optional = false)
    private Ordre ordreIdordre;
    @JoinColumn(name = "famille_idfamille", referencedColumnName = "idfamille")
    @ManyToOne(optional = false)
    private Famille familleIdfamille;
    @JoinColumn(name = "tribu_idtribu", referencedColumnName = "idtribu")
    @ManyToOne(optional = false)
    private Tribu tribuIdtribu;
    @JoinColumn(name = "genre_idgenre", referencedColumnName = "idgenre")
    @ManyToOne(optional = false)
    private Genre genreIdgenre;
    @JoinColumn(name = "section_idsection", referencedColumnName = "idsection")
    @ManyToOne(optional = false)
    private Section sectionIdsection;
    @JoinColumn(name = "vari\u00e9t\u00e9_idvari\u00e9t\u00e9", referencedColumnName = "idvari\u00e9t\u00e9")
    @ManyToOne(optional = false)
    private Variété variétéIdvariété;
    @JoinColumn(name = "forme_idforme", referencedColumnName = "idforme")
    @ManyToOne(optional = false)
    private Forme formeIdforme;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taxinomieIdtaxinomie")
    private List<Espece> especeList;

    public Taxinomie() {
    }

    public Taxinomie(Integer idtaxinomie) {
        this.idtaxinomie = idtaxinomie;
    }

    public Integer getIdtaxinomie() {
        return idtaxinomie;
    }

    public void setIdtaxinomie(Integer idtaxinomie) {
        this.idtaxinomie = idtaxinomie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Regne getRegneIdregne() {
        return regneIdregne;
    }

    public void setRegneIdregne(Regne regneIdregne) {
        this.regneIdregne = regneIdregne;
    }

    public Embranchement getEmbranchementIdembranchement() {
        return embranchementIdembranchement;
    }

    public void setEmbranchementIdembranchement(Embranchement embranchementIdembranchement) {
        this.embranchementIdembranchement = embranchementIdembranchement;
    }

    public Classe getClasseIdclasse() {
        return classeIdclasse;
    }

    public void setClasseIdclasse(Classe classeIdclasse) {
        this.classeIdclasse = classeIdclasse;
    }

    public Ordre getOrdreIdordre() {
        return ordreIdordre;
    }

    public void setOrdreIdordre(Ordre ordreIdordre) {
        this.ordreIdordre = ordreIdordre;
    }

    public Famille getFamilleIdfamille() {
        return familleIdfamille;
    }

    public void setFamilleIdfamille(Famille familleIdfamille) {
        this.familleIdfamille = familleIdfamille;
    }

    public Tribu getTribuIdtribu() {
        return tribuIdtribu;
    }

    public void setTribuIdtribu(Tribu tribuIdtribu) {
        this.tribuIdtribu = tribuIdtribu;
    }

    public Genre getGenreIdgenre() {
        return genreIdgenre;
    }

    public void setGenreIdgenre(Genre genreIdgenre) {
        this.genreIdgenre = genreIdgenre;
    }

    public Section getSectionIdsection() {
        return sectionIdsection;
    }

    public void setSectionIdsection(Section sectionIdsection) {
        this.sectionIdsection = sectionIdsection;
    }

    public Variété getVariétéIdvariété() {
        return variétéIdvariété;
    }

    public void setVariétéIdvariété(Variété variétéIdvariété) {
        this.variétéIdvariété = variétéIdvariété;
    }

    public Forme getFormeIdforme() {
        return formeIdforme;
    }

    public void setFormeIdforme(Forme formeIdforme) {
        this.formeIdforme = formeIdforme;
    }

    @XmlTransient
    public List<Espece> getEspeceList() {
        return especeList;
    }

    public void setEspeceList(List<Espece> especeList) {
        this.especeList = especeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtaxinomie != null ? idtaxinomie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Taxinomie)) {
            return false;
        }
        Taxinomie other = (Taxinomie) object;
        if ((this.idtaxinomie == null && other.idtaxinomie != null) || (this.idtaxinomie != null && !this.idtaxinomie.equals(other.idtaxinomie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Taxinomie[ idtaxinomie=" + idtaxinomie + " ]";
    }
    
}
