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
public class OrdrePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idordre")
    private int idordre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "regne_idregne")
    private int regneIdregne;
    @Basic(optional = false)
    @NotNull
    @Column(name = "regne_embranchement_idembranchement")
    private int regneEmbranchementIdembranchement;

    public OrdrePK() {
    }

    public OrdrePK(int idordre, int regneIdregne, int regneEmbranchementIdembranchement) {
        this.idordre = idordre;
        this.regneIdregne = regneIdregne;
        this.regneEmbranchementIdembranchement = regneEmbranchementIdembranchement;
    }

    public int getIdordre() {
        return idordre;
    }

    public void setIdordre(int idordre) {
        this.idordre = idordre;
    }

    public int getRegneIdregne() {
        return regneIdregne;
    }

    public void setRegneIdregne(int regneIdregne) {
        this.regneIdregne = regneIdregne;
    }

    public int getRegneEmbranchementIdembranchement() {
        return regneEmbranchementIdembranchement;
    }

    public void setRegneEmbranchementIdembranchement(int regneEmbranchementIdembranchement) {
        this.regneEmbranchementIdembranchement = regneEmbranchementIdembranchement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idordre;
        hash += (int) regneIdregne;
        hash += (int) regneEmbranchementIdembranchement;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdrePK)) {
            return false;
        }
        OrdrePK other = (OrdrePK) object;
        if (this.idordre != other.idordre) {
            return false;
        }
        if (this.regneIdregne != other.regneIdregne) {
            return false;
        }
        if (this.regneEmbranchementIdembranchement != other.regneEmbranchementIdembranchement) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OrdrePK[ idordre=" + idordre + ", regneIdregne=" + regneIdregne + ", regneEmbranchementIdembranchement=" + regneEmbranchementIdembranchement + " ]";
    }
    
}
