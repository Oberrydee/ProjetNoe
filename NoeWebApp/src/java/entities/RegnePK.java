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
public class RegnePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idregne")
    private int idregne;
    @Basic(optional = false)
    @NotNull
    @Column(name = "embranchement_idembranchement")
    private int embranchementIdembranchement;

    public RegnePK() {
    }

    public RegnePK(int idregne, int embranchementIdembranchement) {
        this.idregne = idregne;
        this.embranchementIdembranchement = embranchementIdembranchement;
    }

    public int getIdregne() {
        return idregne;
    }

    public void setIdregne(int idregne) {
        this.idregne = idregne;
    }

    public int getEmbranchementIdembranchement() {
        return embranchementIdembranchement;
    }

    public void setEmbranchementIdembranchement(int embranchementIdembranchement) {
        this.embranchementIdembranchement = embranchementIdembranchement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idregne;
        hash += (int) embranchementIdembranchement;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegnePK)) {
            return false;
        }
        RegnePK other = (RegnePK) object;
        if (this.idregne != other.idregne) {
            return false;
        }
        if (this.embranchementIdembranchement != other.embranchementIdembranchement) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.RegnePK[ idregne=" + idregne + ", embranchementIdembranchement=" + embranchementIdembranchement + " ]";
    }
    
}
