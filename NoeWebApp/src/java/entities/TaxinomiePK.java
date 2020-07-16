/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ADZOH-VINYO DIANA
 */
@Embeddable
public class TaxinomiePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idtaxinomie")
    private int idtaxinomie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Famille_idFamille")
    private int familleidFamille;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Famille_classe_idclasse")
    private int familleclasseidclasse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Famille_classe_ordre_idordre")
    private int familleclasseordreidordre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Famille_classe_ordre_regne_idregne")
    private int familleclasseordreregneidregne;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Famille_classe_ordre_regne_embranchement_idembranchement")
    private int familleclasseordreregneembranchementidembranchement;
    @Basic(optional = false)
    @NotNull
    @Column(name = "espece_idespece")
    private int especeIdespece;
    @Basic(optional = false)
    @NotNull
    @Column(name = "espece_semence_idsemence")
    private int especeSemenceIdsemence;
    @Basic(optional = false)
    @NotNull
    @Column(name = "espece_alerte_idalerte")
    private int especeAlerteIdalerte;

    public TaxinomiePK() {
    }

    public TaxinomiePK(int idtaxinomie, int familleidFamille, int familleclasseidclasse, int familleclasseordreidordre, int familleclasseordreregneidregne, int familleclasseordreregneembranchementidembranchement, int especeIdespece, int especeSemenceIdsemence, int especeAlerteIdalerte) {
        this.idtaxinomie = idtaxinomie;
        this.familleidFamille = familleidFamille;
        this.familleclasseidclasse = familleclasseidclasse;
        this.familleclasseordreidordre = familleclasseordreidordre;
        this.familleclasseordreregneidregne = familleclasseordreregneidregne;
        this.familleclasseordreregneembranchementidembranchement = familleclasseordreregneembranchementidembranchement;
        this.especeIdespece = especeIdespece;
        this.especeSemenceIdsemence = especeSemenceIdsemence;
        this.especeAlerteIdalerte = especeAlerteIdalerte;
    }

    public int getIdtaxinomie() {
        return idtaxinomie;
    }

    public void setIdtaxinomie(int idtaxinomie) {
        this.idtaxinomie = idtaxinomie;
    }

    public int getFamilleidFamille() {
        return familleidFamille;
    }

    public void setFamilleidFamille(int familleidFamille) {
        this.familleidFamille = familleidFamille;
    }

    public int getFamilleclasseidclasse() {
        return familleclasseidclasse;
    }

    public void setFamilleclasseidclasse(int familleclasseidclasse) {
        this.familleclasseidclasse = familleclasseidclasse;
    }

    public int getFamilleclasseordreidordre() {
        return familleclasseordreidordre;
    }

    public void setFamilleclasseordreidordre(int familleclasseordreidordre) {
        this.familleclasseordreidordre = familleclasseordreidordre;
    }

    public int getFamilleclasseordreregneidregne() {
        return familleclasseordreregneidregne;
    }

    public void setFamilleclasseordreregneidregne(int familleclasseordreregneidregne) {
        this.familleclasseordreregneidregne = familleclasseordreregneidregne;
    }

    public int getFamilleclasseordreregneembranchementidembranchement() {
        return familleclasseordreregneembranchementidembranchement;
    }

    public void setFamilleclasseordreregneembranchementidembranchement(int familleclasseordreregneembranchementidembranchement) {
        this.familleclasseordreregneembranchementidembranchement = familleclasseordreregneembranchementidembranchement;
    }

    public int getEspeceIdespece() {
        return especeIdespece;
    }

    public void setEspeceIdespece(int especeIdespece) {
        this.especeIdespece = especeIdespece;
    }

    public int getEspeceSemenceIdsemence() {
        return especeSemenceIdsemence;
    }

    public void setEspeceSemenceIdsemence(int especeSemenceIdsemence) {
        this.especeSemenceIdsemence = especeSemenceIdsemence;
    }

    public int getEspeceAlerteIdalerte() {
        return especeAlerteIdalerte;
    }

    public void setEspeceAlerteIdalerte(int especeAlerteIdalerte) {
        this.especeAlerteIdalerte = especeAlerteIdalerte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idtaxinomie;
        hash += (int) familleidFamille;
        hash += (int) familleclasseidclasse;
        hash += (int) familleclasseordreidordre;
        hash += (int) familleclasseordreregneidregne;
        hash += (int) familleclasseordreregneembranchementidembranchement;
        hash += (int) especeIdespece;
        hash += (int) especeSemenceIdsemence;
        hash += (int) especeAlerteIdalerte;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxinomiePK)) {
            return false;
        }
        TaxinomiePK other = (TaxinomiePK) object;
        if (this.idtaxinomie != other.idtaxinomie) {
            return false;
        }
        if (this.familleidFamille != other.familleidFamille) {
            return false;
        }
        if (this.familleclasseidclasse != other.familleclasseidclasse) {
            return false;
        }
        if (this.familleclasseordreidordre != other.familleclasseordreidordre) {
            return false;
        }
        if (this.familleclasseordreregneidregne != other.familleclasseordreregneidregne) {
            return false;
        }
        if (this.familleclasseordreregneembranchementidembranchement != other.familleclasseordreregneembranchementidembranchement) {
            return false;
        }
        if (this.especeIdespece != other.especeIdespece) {
            return false;
        }
        if (this.especeSemenceIdsemence != other.especeSemenceIdsemence) {
            return false;
        }
        if (this.especeAlerteIdalerte != other.especeAlerteIdalerte) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TaxinomiePK[ idtaxinomie=" + idtaxinomie + ", familleidFamille=" + familleidFamille + ", familleclasseidclasse=" + familleclasseidclasse + ", familleclasseordreidordre=" + familleclasseordreidordre + ", familleclasseordreregneidregne=" + familleclasseordreregneidregne + ", familleclasseordreregneembranchementidembranchement=" + familleclasseordreregneembranchementidembranchement + ", especeIdespece=" + especeIdespece + ", especeSemenceIdsemence=" + especeSemenceIdsemence + ", especeAlerteIdalerte=" + especeAlerteIdalerte + " ]";
    }
    
}
