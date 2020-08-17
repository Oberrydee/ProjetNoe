/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADZOH-VINYO DIANA
 */
@Entity
@Table(name = "coderesetpassword")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coderesetpassword.findAll", query = "SELECT c FROM Coderesetpassword c")
    , @NamedQuery(name = "Coderesetpassword.findByIdCodeResetPassword", query = "SELECT c FROM Coderesetpassword c WHERE c.idCodeResetPassword = :idCodeResetPassword")
    , @NamedQuery(name = "Coderesetpassword.findByNomCodeResetPassword", query = "SELECT c FROM Coderesetpassword c WHERE c.nomCodeResetPassword = :nomCodeResetPassword")})
public class Coderesetpassword implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "idCodeResetPassword")
    private String idCodeResetPassword;
    @Size(max = 45)
    @Column(name = "nomCodeResetPassword")
    private String nomCodeResetPassword;
    @JoinColumn(name = "idCompteUtilisateur", referencedColumnName = "idcompteUtilisateur")
    @ManyToOne(optional = false)
    private Compteutilisateur idCompteUtilisateur;

    public Coderesetpassword() {
    }

    public Coderesetpassword(String idCodeResetPassword) {
        this.idCodeResetPassword = idCodeResetPassword;
    }

    public String getIdCodeResetPassword() {
        return idCodeResetPassword;
    }

    public void setIdCodeResetPassword(String idCodeResetPassword) {
        this.idCodeResetPassword = idCodeResetPassword;
    }

    public String getNomCodeResetPassword() {
        return nomCodeResetPassword;
    }

    public void setNomCodeResetPassword(String nomCodeResetPassword) {
        this.nomCodeResetPassword = nomCodeResetPassword;
    }

    public Compteutilisateur getIdCompteUtilisateur() {
        return idCompteUtilisateur;
    }

    public void setIdCompteUtilisateur(Compteutilisateur idCompteUtilisateur) {
        this.idCompteUtilisateur = idCompteUtilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCodeResetPassword != null ? idCodeResetPassword.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coderesetpassword)) {
            return false;
        }
        Coderesetpassword other = (Coderesetpassword) object;
        if ((this.idCodeResetPassword == null && other.idCodeResetPassword != null) || (this.idCodeResetPassword != null && !this.idCodeResetPassword.equals(other.idCodeResetPassword))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Coderesetpassword[ idCodeResetPassword=" + idCodeResetPassword + " ]";
    }
    
}
