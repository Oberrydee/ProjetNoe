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
public class AlertePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idalerte")
    private int idalerte;
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

    public AlertePK() {
    }

    public AlertePK(int idalerte, int especeIdespece, int especeSemenceIdsemence, int especeAlerteIdalerte) {
        this.idalerte = idalerte;
        this.especeIdespece = especeIdespece;
        this.especeSemenceIdsemence = especeSemenceIdsemence;
        this.especeAlerteIdalerte = especeAlerteIdalerte;
    }

    public int getIdalerte() {
        return idalerte;
    }

    public void setIdalerte(int idalerte) {
        this.idalerte = idalerte;
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
        hash += (int) idalerte;
        hash += (int) especeIdespece;
        hash += (int) especeSemenceIdsemence;
        hash += (int) especeAlerteIdalerte;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlertePK)) {
            return false;
        }
        AlertePK other = (AlertePK) object;
        if (this.idalerte != other.idalerte) {
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
        return "entities.AlertePK[ idalerte=" + idalerte + ", especeIdespece=" + especeIdespece + ", especeSemenceIdsemence=" + especeSemenceIdsemence + ", especeAlerteIdalerte=" + especeAlerteIdalerte + " ]";
    }
    
}
