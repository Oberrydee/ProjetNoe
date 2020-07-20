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
public class ClassePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idclasse")
    private int idclasse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ordre_idordre")
    private int ordreIdordre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ordre_regne_idregne")
    private int ordreRegneIdregne;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ordre_regne_embranchement_idembranchement")
    private int ordreRegneEmbranchementIdembranchement;

    public ClassePK() {
    }

    public ClassePK(int idclasse, int ordreIdordre, int ordreRegneIdregne, int ordreRegneEmbranchementIdembranchement) {
        this.idclasse = idclasse;
        this.ordreIdordre = ordreIdordre;
        this.ordreRegneIdregne = ordreRegneIdregne;
        this.ordreRegneEmbranchementIdembranchement = ordreRegneEmbranchementIdembranchement;
    }

    public int getIdclasse() {
        return idclasse;
    }

    public void setIdclasse(int idclasse) {
        this.idclasse = idclasse;
    }

    public int getOrdreIdordre() {
        return ordreIdordre;
    }

    public void setOrdreIdordre(int ordreIdordre) {
        this.ordreIdordre = ordreIdordre;
    }

    public int getOrdreRegneIdregne() {
        return ordreRegneIdregne;
    }

    public void setOrdreRegneIdregne(int ordreRegneIdregne) {
        this.ordreRegneIdregne = ordreRegneIdregne;
    }

    public int getOrdreRegneEmbranchementIdembranchement() {
        return ordreRegneEmbranchementIdembranchement;
    }

    public void setOrdreRegneEmbranchementIdembranchement(int ordreRegneEmbranchementIdembranchement) {
        this.ordreRegneEmbranchementIdembranchement = ordreRegneEmbranchementIdembranchement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idclasse;
        hash += (int) ordreIdordre;
        hash += (int) ordreRegneIdregne;
        hash += (int) ordreRegneEmbranchementIdembranchement;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClassePK)) {
            return false;
        }
        ClassePK other = (ClassePK) object;
        if (this.idclasse != other.idclasse) {
            return false;
        }
        if (this.ordreIdordre != other.ordreIdordre) {
            return false;
        }
        if (this.ordreRegneIdregne != other.ordreRegneIdregne) {
            return false;
        }
        if (this.ordreRegneEmbranchementIdembranchement != other.ordreRegneEmbranchementIdembranchement) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ClassePK[ idclasse=" + idclasse + ", ordreIdordre=" + ordreIdordre + ", ordreRegneIdregne=" + ordreRegneIdregne + ", ordreRegneEmbranchementIdembranchement=" + ordreRegneEmbranchementIdembranchement + " ]";
    }
    
}
