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
public class SessionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idsession")
    private int idsession;
    @Basic(optional = false)
    @NotNull
    @Column(name = "compteUtilisateur_idcompteUtilisateur")
    private int compteUtilisateuridcompteUtilisateur;

    public SessionPK() {
    }

    public SessionPK(int idsession, int compteUtilisateuridcompteUtilisateur) {
        this.idsession = idsession;
        this.compteUtilisateuridcompteUtilisateur = compteUtilisateuridcompteUtilisateur;
    }

    public int getIdsession() {
        return idsession;
    }

    public void setIdsession(int idsession) {
        this.idsession = idsession;
    }

    public int getCompteUtilisateuridcompteUtilisateur() {
        return compteUtilisateuridcompteUtilisateur;
    }

    public void setCompteUtilisateuridcompteUtilisateur(int compteUtilisateuridcompteUtilisateur) {
        this.compteUtilisateuridcompteUtilisateur = compteUtilisateuridcompteUtilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idsession;
        hash += (int) compteUtilisateuridcompteUtilisateur;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SessionPK)) {
            return false;
        }
        SessionPK other = (SessionPK) object;
        if (this.idsession != other.idsession) {
            return false;
        }
        if (this.compteUtilisateuridcompteUtilisateur != other.compteUtilisateuridcompteUtilisateur) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SessionPK[ idsession=" + idsession + ", compteUtilisateuridcompteUtilisateur=" + compteUtilisateuridcompteUtilisateur + " ]";
    }
    
}
