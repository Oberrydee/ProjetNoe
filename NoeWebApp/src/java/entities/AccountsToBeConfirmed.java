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
@Table(name = "AccountsToBeConfirmed")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountsToBeConfirmed.findAll", query = "SELECT a FROM AccountsToBeConfirmed a")
    , @NamedQuery(name = "AccountsToBeConfirmed.findByIdcompteaconf", query = "SELECT a FROM AccountsToBeConfirmed a WHERE a.idcompteaconf = :idcompteaconf")
    , @NamedQuery(name = "AccountsToBeConfirmed.findByNomUtilisateuraconf", query = "SELECT a FROM AccountsToBeConfirmed a WHERE a.nomUtilisateuraconf = :nomUtilisateuraconf")
    , @NamedQuery(name = "AccountsToBeConfirmed.findByMdpaconf", query = "SELECT a FROM AccountsToBeConfirmed a WHERE a.mdpaconf = :mdpaconf")
    , @NamedQuery(name = "AccountsToBeConfirmed.findByEmailPersoaconf", query = "SELECT a FROM AccountsToBeConfirmed a WHERE a.emailPersoaconf = :emailPersoaconf")
    , @NamedQuery(name = "AccountsToBeConfirmed.findByNum\u00e9roTelephoneaconf", query = "SELECT a FROM AccountsToBeConfirmed a WHERE a.num\u00e9roTelephoneaconf = :num\u00e9roTelephoneaconf")})
public class AccountsToBeConfirmed implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcompteaconf")
    private Integer idcompteaconf;
    @Size(max = 45)
    @Column(name = "nomUtilisateuraconf")
    private String nomUtilisateuraconf;
    @Size(max = 45)
    @Column(name = "mdpaconf")
    private String mdpaconf;
    @Size(max = 45)
    @Column(name = "emailPersoaconf")
    private String emailPersoaconf;
    @Size(max = 45)
    @Column(name = "num\u00e9roTelephoneaconf")
    private String numéroTelephoneaconf;

    public AccountsToBeConfirmed() {
    }

    public AccountsToBeConfirmed(Integer idcompteaconf) {
        this.idcompteaconf = idcompteaconf;
    }

    public Integer getIdcompteaconf() {
        return idcompteaconf;
    }

    public void setIdcompteaconf(Integer idcompteaconf) {
        this.idcompteaconf = idcompteaconf;
    }

    public String getNomUtilisateuraconf() {
        return nomUtilisateuraconf;
    }

    public void setNomUtilisateuraconf(String nomUtilisateuraconf) {
        this.nomUtilisateuraconf = nomUtilisateuraconf;
    }

    public String getMdpaconf() {
        return mdpaconf;
    }

    public void setMdpaconf(String mdpaconf) {
        this.mdpaconf = mdpaconf;
    }

    public String getEmailPersoaconf() {
        return emailPersoaconf;
    }

    public void setEmailPersoaconf(String emailPersoaconf) {
        this.emailPersoaconf = emailPersoaconf;
    }

    public String getNuméroTelephoneaconf() {
        return numéroTelephoneaconf;
    }

    public void setNuméroTelephoneaconf(String numéroTelephoneaconf) {
        this.numéroTelephoneaconf = numéroTelephoneaconf;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountsToBeConfirmed)) {
            return false;
        }
        AccountsToBeConfirmed other = (AccountsToBeConfirmed) object;
        if ((this.idcompteaconf == null && other.idcompteaconf != null) || (this.idcompteaconf != null && !this.idcompteaconf.equals(other.idcompteaconf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AccountsToBeConfirmed[ idcompteaconf=" + idcompteaconf + " ]";
    }
    
}
