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
@Table(name = "compteUtilisateur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompteUtilisateur.findAll", query = "SELECT c FROM CompteUtilisateur c")
    , @NamedQuery(name = "CompteUtilisateur.findByIdcompteUtilisateur", query = "SELECT c FROM CompteUtilisateur c WHERE c.idcompteUtilisateur = :idcompteUtilisateur")
    , @NamedQuery(name = "CompteUtilisateur.findByNomUtilisateur", query = "SELECT c FROM CompteUtilisateur c WHERE c.nomUtilisateur = :nomUtilisateur")
    , @NamedQuery(name = "CompteUtilisateur.findByMdp", query = "SELECT c FROM CompteUtilisateur c WHERE c.mdp = :mdp")
    , @NamedQuery(name = "CompteUtilisateur.findByEmailPerso", query = "SELECT c FROM CompteUtilisateur c WHERE c.emailPerso = :emailPerso")
    , @NamedQuery(name = "CompteUtilisateur.findByNum\u00e9roTelephone", query = "SELECT c FROM CompteUtilisateur c WHERE c.num\u00e9roTelephone = :num\u00e9roTelephone")
    , @NamedQuery(name = "CompteUtilisateur.findByNom", query = "SELECT c FROM CompteUtilisateur c WHERE c.nom = :nom")
    , @NamedQuery(name = "CompteUtilisateur.findByPrenom", query = "SELECT c FROM CompteUtilisateur c WHERE c.prenom = :prenom")})
public class CompteUtilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcompteUtilisateur")
    private Integer idcompteUtilisateur;
    @Size(max = 45)
    @Column(name = "nomUtilisateur")
    private String nomUtilisateur;
    @Size(max = 45)
    @Column(name = "mdp")
    private String mdp;
    @Size(max = 45)
    @Column(name = "emailPerso")
    private String emailPerso;
    @Size(max = 45)
    @Column(name = "num\u00e9roTelephone")
    private String numéroTelephone;
    @Size(max = 20)
    @Column(name = "nom")
    private String nom;
    @Size(max = 20)
    @Column(name = "prenom")
    private String prenom;

    public CompteUtilisateur() {
    }

    public CompteUtilisateur(Integer idcompteUtilisateur) {
        this.idcompteUtilisateur = idcompteUtilisateur;
    }

    public Integer getIdcompteUtilisateur() {
        return idcompteUtilisateur;
    }

    public void setIdcompteUtilisateur(Integer idcompteUtilisateur) {
        this.idcompteUtilisateur = idcompteUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getEmailPerso() {
        return emailPerso;
    }

    public void setEmailPerso(String emailPerso) {
        this.emailPerso = emailPerso;
    }

    public String getNuméroTelephone() {
        return numéroTelephone;
    }

    public void setNuméroTelephone(String numéroTelephone) {
        this.numéroTelephone = numéroTelephone;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcompteUtilisateur != null ? idcompteUtilisateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompteUtilisateur)) {
            return false;
        }
        CompteUtilisateur other = (CompteUtilisateur) object;
        if ((this.idcompteUtilisateur == null && other.idcompteUtilisateur != null) || (this.idcompteUtilisateur != null && !this.idcompteUtilisateur.equals(other.idcompteUtilisateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CompteUtilisateur[ idcompteUtilisateur=" + idcompteUtilisateur + " ]";
    }
    
}
