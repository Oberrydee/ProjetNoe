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
    @Basic(optional = false)
    @NotNull
    @Column(name = "alerte_idalerte")
    private int alerteIdalerte;

    public EspecePK() {
    }

    public EspecePK(int idespece, int semenceIdsemence, int alerteIdalerte) {
        this.idespece = idespece;
        this.semenceIdsemence = semenceIdsemence;
        this.alerteIdalerte = alerteIdalerte;
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

    public int getAlerteIdalerte() {
        return alerteIdalerte;
    }

    public void setAlerteIdalerte(int alerteIdalerte) {
        this.alerteIdalerte = alerteIdalerte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idespece;
        hash += (int) semenceIdsemence;
        hash += (int) alerteIdalerte;
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
        if (this.alerteIdalerte != other.alerteIdalerte) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.EspecePK[ idespece=" + idespece + ", semenceIdsemence=" + semenceIdsemence + ", alerteIdalerte=" + alerteIdalerte + " ]";
    }
    
}
