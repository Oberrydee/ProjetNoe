/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADZOH-VINYO DIANA
 */
@Entity
@Table(name = "taxinomie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Taxinomie.findAll", query = "SELECT t FROM Taxinomie t")
    , @NamedQuery(name = "Taxinomie.findByIdtaxinomie", query = "SELECT t FROM Taxinomie t WHERE t.taxinomiePK.idtaxinomie = :idtaxinomie")
    , @NamedQuery(name = "Taxinomie.findByNom", query = "SELECT t FROM Taxinomie t WHERE t.nom = :nom")
    , @NamedQuery(name = "Taxinomie.findByFamilleidFamille", query = "SELECT t FROM Taxinomie t WHERE t.taxinomiePK.familleidFamille = :familleidFamille")
    , @NamedQuery(name = "Taxinomie.findByFamilleclasseidclasse", query = "SELECT t FROM Taxinomie t WHERE t.taxinomiePK.familleclasseidclasse = :familleclasseidclasse")
    , @NamedQuery(name = "Taxinomie.findByFamilleclasseordreidordre", query = "SELECT t FROM Taxinomie t WHERE t.taxinomiePK.familleclasseordreidordre = :familleclasseordreidordre")
    , @NamedQuery(name = "Taxinomie.findByFamilleclasseordreregneidregne", query = "SELECT t FROM Taxinomie t WHERE t.taxinomiePK.familleclasseordreregneidregne = :familleclasseordreregneidregne")
    , @NamedQuery(name = "Taxinomie.findByFamilleclasseordreregneembranchementidembranchement", query = "SELECT t FROM Taxinomie t WHERE t.taxinomiePK.familleclasseordreregneembranchementidembranchement = :familleclasseordreregneembranchementidembranchement")
    , @NamedQuery(name = "Taxinomie.findByEspeceIdespece", query = "SELECT t FROM Taxinomie t WHERE t.taxinomiePK.especeIdespece = :especeIdespece")
    , @NamedQuery(name = "Taxinomie.findByEspeceSemenceIdsemence", query = "SELECT t FROM Taxinomie t WHERE t.taxinomiePK.especeSemenceIdsemence = :especeSemenceIdsemence")
    , @NamedQuery(name = "Taxinomie.findByEspeceAlerteIdalerte", query = "SELECT t FROM Taxinomie t WHERE t.taxinomiePK.especeAlerteIdalerte = :especeAlerteIdalerte")})
public class Taxinomie implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TaxinomiePK taxinomiePK;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @JoinColumns({
        @JoinColumn(name = "Famille_idFamille", referencedColumnName = "idFamille", insertable = false, updatable = false)
        , @JoinColumn(name = "Famille_classe_idclasse", referencedColumnName = "classe_idclasse", insertable = false, updatable = false)
        , @JoinColumn(name = "Famille_classe_ordre_idordre", referencedColumnName = "classe_ordre_idordre", insertable = false, updatable = false)
        , @JoinColumn(name = "Famille_classe_ordre_regne_idregne", referencedColumnName = "classe_ordre_regne_idregne", insertable = false, updatable = false)
        , @JoinColumn(name = "Famille_classe_ordre_regne_embranchement_idembranchement", referencedColumnName = "classe_ordre_regne_embranchement_idembranchement", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Famille famille;
    @JoinColumns({
        @JoinColumn(name = "espece_idespece", referencedColumnName = "idespece", insertable = false, updatable = false)
        , @JoinColumn(name = "espece_semence_idsemence", referencedColumnName = "semence_idsemence", insertable = false, updatable = false)
        , @JoinColumn(name = "espece_alerte_idalerte", referencedColumnName = "alerte_idalerte", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Espece espece;

    public Taxinomie() {
    }

    public Taxinomie(TaxinomiePK taxinomiePK) {
        this.taxinomiePK = taxinomiePK;
    }

    public Taxinomie(int idtaxinomie, int familleidFamille, int familleclasseidclasse, int familleclasseordreidordre, int familleclasseordreregneidregne, int familleclasseordreregneembranchementidembranchement, int especeIdespece, int especeSemenceIdsemence, int especeAlerteIdalerte) {
        this.taxinomiePK = new TaxinomiePK(idtaxinomie, familleidFamille, familleclasseidclasse, familleclasseordreidordre, familleclasseordreregneidregne, familleclasseordreregneembranchementidembranchement, especeIdespece, especeSemenceIdsemence, especeAlerteIdalerte);
    }

    public TaxinomiePK getTaxinomiePK() {
        return taxinomiePK;
    }

    public void setTaxinomiePK(TaxinomiePK taxinomiePK) {
        this.taxinomiePK = taxinomiePK;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Famille getFamille() {
        return famille;
    }

    public void setFamille(Famille famille) {
        this.famille = famille;
    }

    public Espece getEspece() {
        return espece;
    }

    public void setEspece(Espece espece) {
        this.espece = espece;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxinomiePK != null ? taxinomiePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Taxinomie)) {
            return false;
        }
        Taxinomie other = (Taxinomie) object;
        if ((this.taxinomiePK == null && other.taxinomiePK != null) || (this.taxinomiePK != null && !this.taxinomiePK.equals(other.taxinomiePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Taxinomie[ taxinomiePK=" + taxinomiePK + " ]";
    }
    
}
