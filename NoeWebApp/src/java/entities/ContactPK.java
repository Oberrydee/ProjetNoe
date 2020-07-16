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
public class ContactPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idcontact")
    private int idcontact;
    @Basic(optional = false)
    @NotNull
    @Column(name = "session_idsession")
    private int sessionIdsession;
    @Basic(optional = false)
    @NotNull
    @Column(name = "session_compteUtilisateur_idcompteUtilisateur")
    private int sessioncompteUtilisateuridcompteUtilisateur;

    public ContactPK() {
    }

    public ContactPK(int idcontact, int sessionIdsession, int sessioncompteUtilisateuridcompteUtilisateur) {
        this.idcontact = idcontact;
        this.sessionIdsession = sessionIdsession;
        this.sessioncompteUtilisateuridcompteUtilisateur = sessioncompteUtilisateuridcompteUtilisateur;
    }

    public int getIdcontact() {
        return idcontact;
    }

    public void setIdcontact(int idcontact) {
        this.idcontact = idcontact;
    }

    public int getSessionIdsession() {
        return sessionIdsession;
    }

    public void setSessionIdsession(int sessionIdsession) {
        this.sessionIdsession = sessionIdsession;
    }

    public int getSessioncompteUtilisateuridcompteUtilisateur() {
        return sessioncompteUtilisateuridcompteUtilisateur;
    }

    public void setSessioncompteUtilisateuridcompteUtilisateur(int sessioncompteUtilisateuridcompteUtilisateur) {
        this.sessioncompteUtilisateuridcompteUtilisateur = sessioncompteUtilisateuridcompteUtilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idcontact;
        hash += (int) sessionIdsession;
        hash += (int) sessioncompteUtilisateuridcompteUtilisateur;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactPK)) {
            return false;
        }
        ContactPK other = (ContactPK) object;
        if (this.idcontact != other.idcontact) {
            return false;
        }
        if (this.sessionIdsession != other.sessionIdsession) {
            return false;
        }
        if (this.sessioncompteUtilisateuridcompteUtilisateur != other.sessioncompteUtilisateuridcompteUtilisateur) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ContactPK[ idcontact=" + idcontact + ", sessionIdsession=" + sessionIdsession + ", sessioncompteUtilisateuridcompteUtilisateur=" + sessioncompteUtilisateuridcompteUtilisateur + " ]";
    }
    
}
