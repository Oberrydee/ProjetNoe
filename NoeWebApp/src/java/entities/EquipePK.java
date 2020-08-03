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
public class EquipePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idequipe")
    private int idequipe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Salari\u00e9_idSalari\u00e9")
    private int salariéidSalarié;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Salari\u00e9_compteUtilisateur_idcompteUtilisateur")
    private int salariécompteUtilisateuridcompteUtilisateur;

    public EquipePK() {
    }

    public EquipePK(int idequipe, int salariéidSalarié, int salariécompteUtilisateuridcompteUtilisateur) {
        this.idequipe = idequipe;
        this.salariéidSalarié = salariéidSalarié;
        this.salariécompteUtilisateuridcompteUtilisateur = salariécompteUtilisateuridcompteUtilisateur;
    }

    public int getIdequipe() {
        return idequipe;
    }

    public void setIdequipe(int idequipe) {
        this.idequipe = idequipe;
    }

    public int getSalariéidSalarié() {
        return salariéidSalarié;
    }

    public void setSalariéidSalarié(int salariéidSalarié) {
        this.salariéidSalarié = salariéidSalarié;
    }

    public int getSalariécompteUtilisateuridcompteUtilisateur() {
        return salariécompteUtilisateuridcompteUtilisateur;
    }

    public void setSalariécompteUtilisateuridcompteUtilisateur(int salariécompteUtilisateuridcompteUtilisateur) {
        this.salariécompteUtilisateuridcompteUtilisateur = salariécompteUtilisateuridcompteUtilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idequipe;
        hash += (int) salariéidSalarié;
        hash += (int) salariécompteUtilisateuridcompteUtilisateur;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipePK)) {
            return false;
        }
        EquipePK other = (EquipePK) object;
        if (this.idequipe != other.idequipe) {
            return false;
        }
        if (this.salariéidSalarié != other.salariéidSalarié) {
            return false;
        }
        if (this.salariécompteUtilisateuridcompteUtilisateur != other.salariécompteUtilisateuridcompteUtilisateur) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.EquipePK[ idequipe=" + idequipe + ", salari\u00e9idSalari\u00e9=" + salariéidSalarié + ", salari\u00e9compteUtilisateuridcompteUtilisateur=" + salariécompteUtilisateuridcompteUtilisateur + " ]";
    }
    
}
