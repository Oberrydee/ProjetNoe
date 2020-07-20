/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADZOH-VINYO DIANA
 */
@Entity
@Table(name = "session")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Session.findAll", query = "SELECT s FROM Session s")
    , @NamedQuery(name = "Session.findByIdsession", query = "SELECT s FROM Session s WHERE s.sessionPK.idsession = :idsession")
    , @NamedQuery(name = "Session.findByAttribute", query = "SELECT s FROM Session s WHERE s.attribute = :attribute")
    , @NamedQuery(name = "Session.findByCompteUtilisateuridcompteUtilisateur", query = "SELECT s FROM Session s WHERE s.sessionPK.compteUtilisateuridcompteUtilisateur = :compteUtilisateuridcompteUtilisateur")})
public class Session implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SessionPK sessionPK;
    @Size(max = 45)
    @Column(name = "attribute")
    private String attribute;
    @JoinColumn(name = "compteUtilisateur_idcompteUtilisateur", referencedColumnName = "idcompteUtilisateur", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Compteutilisateur compteutilisateur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "session")
    private List<Contact> contactList;

    public Session() {
    }

    public Session(SessionPK sessionPK) {
        this.sessionPK = sessionPK;
    }

    public Session(int idsession, int compteUtilisateuridcompteUtilisateur) {
        this.sessionPK = new SessionPK(idsession, compteUtilisateuridcompteUtilisateur);
    }

    public SessionPK getSessionPK() {
        return sessionPK;
    }

    public void setSessionPK(SessionPK sessionPK) {
        this.sessionPK = sessionPK;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public Compteutilisateur getCompteutilisateur() {
        return compteutilisateur;
    }

    public void setCompteutilisateur(Compteutilisateur compteutilisateur) {
        this.compteutilisateur = compteutilisateur;
    }

    @XmlTransient
    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sessionPK != null ? sessionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Session)) {
            return false;
        }
        Session other = (Session) object;
        if ((this.sessionPK == null && other.sessionPK != null) || (this.sessionPK != null && !this.sessionPK.equals(other.sessionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Session[ sessionPK=" + sessionPK + " ]";
    }
    
}
