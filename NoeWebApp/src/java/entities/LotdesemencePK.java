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
public class LotdesemencePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idLotDeSemence")
    private int idLotDeSemence;
    @Basic(optional = false)
    @NotNull
    @Column(name = "semence_idsemence")
    private int semenceIdsemence;

    public LotdesemencePK() {
    }

    public LotdesemencePK(int idLotDeSemence, int semenceIdsemence) {
        this.idLotDeSemence = idLotDeSemence;
        this.semenceIdsemence = semenceIdsemence;
    }

    public int getIdLotDeSemence() {
        return idLotDeSemence;
    }

    public void setIdLotDeSemence(int idLotDeSemence) {
        this.idLotDeSemence = idLotDeSemence;
    }

    public int getSemenceIdsemence() {
        return semenceIdsemence;
    }

    public void setSemenceIdsemence(int semenceIdsemence) {
        this.semenceIdsemence = semenceIdsemence;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idLotDeSemence;
        hash += (int) semenceIdsemence;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LotdesemencePK)) {
            return false;
        }
        LotdesemencePK other = (LotdesemencePK) object;
        if (this.idLotDeSemence != other.idLotDeSemence) {
            return false;
        }
        if (this.semenceIdsemence != other.semenceIdsemence) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LotdesemencePK[ idLotDeSemence=" + idLotDeSemence + ", semenceIdsemence=" + semenceIdsemence + " ]";
    }
    
}
