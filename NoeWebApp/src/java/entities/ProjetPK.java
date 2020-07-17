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
public class ProjetPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idprojet")
    private int idprojet;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Salari\u00e9_idSalari\u00e9")
    private int salariéidSalarié;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Salari\u00e9_compteUtilisateur_idcompteUtilisateur")
    private int salariécompteUtilisateuridcompteUtilisateur;
    @Basic(optional = false)
    @NotNull
    @Column(name = "alerte_idalerte")
    private int alerteIdalerte;

    public ProjetPK() {
    }

    public ProjetPK(int idprojet, int salariéidSalarié, int salariécompteUtilisateuridcompteUtilisateur, int alerteIdalerte) {
        this.idprojet = idprojet;
        this.salariéidSalarié = salariéidSalarié;
        this.salariécompteUtilisateuridcompteUtilisateur = salariécompteUtilisateuridcompteUtilisateur;
        this.alerteIdalerte = alerteIdalerte;
    }

    public int getIdprojet() {
        return idprojet;
    }

    public void setIdprojet(int idprojet) {
        this.idprojet = idprojet;
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

    public int getAlerteIdalerte() {
        return alerteIdalerte;
    }

    public void setAlerteIdalerte(int alerteIdalerte) {
        this.alerteIdalerte = alerteIdalerte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idprojet;
        hash += (int) salariéidSalarié;
        hash += (int) salariécompteUtilisateuridcompteUtilisateur;
        hash += (int) alerteIdalerte;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjetPK)) {
            return false;
        }
        ProjetPK other = (ProjetPK) object;
        if (this.idprojet != other.idprojet) {
            return false;
        }
        if (this.salariéidSalarié != other.salariéidSalarié) {
            return false;
        }
        if (this.salariécompteUtilisateuridcompteUtilisateur != other.salariécompteUtilisateuridcompteUtilisateur) {
            return false;
        }
        if (this.alerteIdalerte != other.alerteIdalerte) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ProjetPK[ idprojet=" + idprojet + ", salari\u00e9idSalari\u00e9=" + salariéidSalarié + ", salari\u00e9compteUtilisateuridcompteUtilisateur=" + salariécompteUtilisateuridcompteUtilisateur + ", alerteIdalerte=" + alerteIdalerte + " ]";
    }
    
}
