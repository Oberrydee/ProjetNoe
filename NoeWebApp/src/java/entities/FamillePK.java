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
public class FamillePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idFamille")
    private int idFamille;
    @Basic(optional = false)
    @NotNull
    @Column(name = "classe_idclasse")
    private int classeIdclasse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "classe_ordre_idordre")
    private int classeOrdreIdordre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "classe_ordre_regne_idregne")
    private int classeOrdreRegneIdregne;
    @Basic(optional = false)
    @NotNull
    @Column(name = "classe_ordre_regne_embranchement_idembranchement")
    private int classeOrdreRegneEmbranchementIdembranchement;

    public FamillePK() {
    }

    public FamillePK(int idFamille, int classeIdclasse, int classeOrdreIdordre, int classeOrdreRegneIdregne, int classeOrdreRegneEmbranchementIdembranchement) {
        this.idFamille = idFamille;
        this.classeIdclasse = classeIdclasse;
        this.classeOrdreIdordre = classeOrdreIdordre;
        this.classeOrdreRegneIdregne = classeOrdreRegneIdregne;
        this.classeOrdreRegneEmbranchementIdembranchement = classeOrdreRegneEmbranchementIdembranchement;
    }

    public int getIdFamille() {
        return idFamille;
    }

    public void setIdFamille(int idFamille) {
        this.idFamille = idFamille;
    }

    public int getClasseIdclasse() {
        return classeIdclasse;
    }

    public void setClasseIdclasse(int classeIdclasse) {
        this.classeIdclasse = classeIdclasse;
    }

    public int getClasseOrdreIdordre() {
        return classeOrdreIdordre;
    }

    public void setClasseOrdreIdordre(int classeOrdreIdordre) {
        this.classeOrdreIdordre = classeOrdreIdordre;
    }

    public int getClasseOrdreRegneIdregne() {
        return classeOrdreRegneIdregne;
    }

    public void setClasseOrdreRegneIdregne(int classeOrdreRegneIdregne) {
        this.classeOrdreRegneIdregne = classeOrdreRegneIdregne;
    }

    public int getClasseOrdreRegneEmbranchementIdembranchement() {
        return classeOrdreRegneEmbranchementIdembranchement;
    }

    public void setClasseOrdreRegneEmbranchementIdembranchement(int classeOrdreRegneEmbranchementIdembranchement) {
        this.classeOrdreRegneEmbranchementIdembranchement = classeOrdreRegneEmbranchementIdembranchement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idFamille;
        hash += (int) classeIdclasse;
        hash += (int) classeOrdreIdordre;
        hash += (int) classeOrdreRegneIdregne;
        hash += (int) classeOrdreRegneEmbranchementIdembranchement;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FamillePK)) {
            return false;
        }
        FamillePK other = (FamillePK) object;
        if (this.idFamille != other.idFamille) {
            return false;
        }
        if (this.classeIdclasse != other.classeIdclasse) {
            return false;
        }
        if (this.classeOrdreIdordre != other.classeOrdreIdordre) {
            return false;
        }
        if (this.classeOrdreRegneIdregne != other.classeOrdreRegneIdregne) {
            return false;
        }
        if (this.classeOrdreRegneEmbranchementIdembranchement != other.classeOrdreRegneEmbranchementIdembranchement) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.FamillePK[ idFamille=" + idFamille + ", classeIdclasse=" + classeIdclasse + ", classeOrdreIdordre=" + classeOrdreIdordre + ", classeOrdreRegneIdregne=" + classeOrdreRegneIdregne + ", classeOrdreRegneEmbranchementIdembranchement=" + classeOrdreRegneEmbranchementIdembranchement + " ]";
    }
    
}
