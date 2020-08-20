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
@Table(name = "accountstobeconfirmed")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accountstobeconfirmed.findAll", query = "SELECT a FROM Accountstobeconfirmed a")
    , @NamedQuery(name = "Accountstobeconfirmed.findByCode", query = "SELECT a FROM Accountstobeconfirmed a WHERE a.code = :code")
    , @NamedQuery(name = "Accountstobeconfirmed.findByNomUtilisateurAconf", query = "SELECT a FROM Accountstobeconfirmed a WHERE a.nomUtilisateurAconf = :nomUtilisateurAconf")
    , @NamedQuery(name = "Accountstobeconfirmed.findByMdpAconf", query = "SELECT a FROM Accountstobeconfirmed a WHERE a.mdpAconf = :mdpAconf")
    , @NamedQuery(name = "Accountstobeconfirmed.findByEmailPersoAconf", query = "SELECT a FROM Accountstobeconfirmed a WHERE a.emailPersoAconf = :emailPersoAconf")
    , @NamedQuery(name = "Accountstobeconfirmed.findByNum\u00e9roTelephoneAconf", query = "SELECT a FROM Accountstobeconfirmed a WHERE a.num\u00e9roTelephoneAconf = :num\u00e9roTelephoneAconf")
    , @NamedQuery(name = "Accountstobeconfirmed.findByNomAconf", query = "SELECT a FROM Accountstobeconfirmed a WHERE a.nomAconf = :nomAconf")
    , @NamedQuery(name = "Accountstobeconfirmed.findByPrenomAconf", query = "SELECT a FROM Accountstobeconfirmed a WHERE a.prenomAconf = :prenomAconf")})
public class Accountstobeconfirmed implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code")
    private String code;
    @Size(max = 45)
    @Column(name = "nomUtilisateurAconf")
    private String nomUtilisateurAconf;
    @Size(max = 45)
    @Column(name = "mdpAconf")
    private String mdpAconf;
    @Size(max = 45)
    @Column(name = "emailPersoAconf")
    private String emailPersoAconf;
    @Size(max = 45)
    @Column(name = "num\u00e9roTelephoneAconf")
    private String numéroTelephoneAconf;
    @Size(max = 45)
    @Column(name = "nomAconf")
    private String nomAconf;
    @Size(max = 45)
    @Column(name = "prenomAconf")
    private String prenomAconf;

    public Accountstobeconfirmed() {
    }

    public Accountstobeconfirmed(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNomUtilisateurAconf() {
        return nomUtilisateurAconf;
    }

    public void setNomUtilisateurAconf(String nomUtilisateurAconf) {
        this.nomUtilisateurAconf = nomUtilisateurAconf;
    }

    public String getMdpAconf() {
        return mdpAconf;
    }

    public void setMdpAconf(String mdpAconf) {
        this.mdpAconf = mdpAconf;
    }

    public String getEmailPersoAconf() {
        return emailPersoAconf;
    }

    public void setEmailPersoAconf(String emailPersoAconf) {
        this.emailPersoAconf = emailPersoAconf;
    }

    public String getNuméroTelephoneAconf() {
        return numéroTelephoneAconf;
    }

    public void setNuméroTelephoneAconf(String numéroTelephoneAconf) {
        this.numéroTelephoneAconf = numéroTelephoneAconf;
    }

    public String getNomAconf() {
        return nomAconf;
    }

    public void setNomAconf(String nomAconf) {
        this.nomAconf = nomAconf;
    }

    public String getPrenomAconf() {
        return prenomAconf;
    }

    public void setPrenomAconf(String prenomAconf) {
        this.prenomAconf = prenomAconf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accountstobeconfirmed)) {
            return false;
        }
        Accountstobeconfirmed other = (Accountstobeconfirmed) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Accountstobeconfirmed[ code=" + code + " ]";
    }
    
}
