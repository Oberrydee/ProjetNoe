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
public class SalariéPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idSalari\u00e9")
    private int idSalarié;
    @Basic(optional = false)
    @NotNull
    @Column(name = "compteUtilisateur_idcompteUtilisateur")
    private int compteUtilisateuridcompteUtilisateur;

    public SalariéPK() {
    }

    public SalariéPK(int idSalarié, int compteUtilisateuridcompteUtilisateur) {
        this.idSalarié = idSalarié;
        this.compteUtilisateuridcompteUtilisateur = compteUtilisateuridcompteUtilisateur;
    }

    public int getIdSalarié() {
        return idSalarié;
    }

    public void setIdSalarié(int idSalarié) {
        this.idSalarié = idSalarié;
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
        hash += (int) idSalarié;
        hash += (int) compteUtilisateuridcompteUtilisateur;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalariéPK)) {
            return false;
        }
        SalariéPK other = (SalariéPK) object;
        if (this.idSalarié != other.idSalarié) {
            return false;
        }
        if (this.compteUtilisateuridcompteUtilisateur != other.compteUtilisateuridcompteUtilisateur) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Salari\u00e9PK[ idSalari\u00e9=" + idSalarié + ", compteUtilisateuridcompteUtilisateur=" + compteUtilisateuridcompteUtilisateur + " ]";
    }
    
}
