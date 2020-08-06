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
public class EspecePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idespece")
    private int idespece;
    @Basic(optional = false)
    @NotNull
    @Column(name = "semence_idsemence")
    private int semenceIdsemence;

    public EspecePK() {
    }

    public EspecePK(int idespece, int semenceIdsemence) {
        this.idespece = idespece;
        this.semenceIdsemence = semenceIdsemence;
    }

    public int getIdespece() {
        return idespece;
    }

    public void setIdespece(int idespece) {
        this.idespece = idespece;
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
        hash += (int) idespece;
        hash += (int) semenceIdsemence;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EspecePK)) {
            return false;
        }
        EspecePK other = (EspecePK) object;
        if (this.idespece != other.idespece) {
            return false;
        }
        if (this.semenceIdsemence != other.semenceIdsemence) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.EspecePK[ idespece=" + idespece + ", semenceIdsemence=" + semenceIdsemence + " ]";
    }
    
}
