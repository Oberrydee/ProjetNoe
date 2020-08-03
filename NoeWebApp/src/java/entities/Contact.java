/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADZOH-VINYO DIANA
 */
@Entity
@Table(name = "contact")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c")
    , @NamedQuery(name = "Contact.findByIdcontact", query = "SELECT c FROM Contact c WHERE c.contactPK.idcontact = :idcontact")
    , @NamedQuery(name = "Contact.findByNom", query = "SELECT c FROM Contact c WHERE c.nom = :nom")
    , @NamedQuery(name = "Contact.findByPr\u00e9nom", query = "SELECT c FROM Contact c WHERE c.pr\u00e9nom = :pr\u00e9nom")
    , @NamedQuery(name = "Contact.findByEmail", query = "SELECT c FROM Contact c WHERE c.email = :email")
    , @NamedQuery(name = "Contact.findByNum\u00e9roTelephone", query = "SELECT c FROM Contact c WHERE c.num\u00e9roTelephone = :num\u00e9roTelephone")
    , @NamedQuery(name = "Contact.findByMessage", query = "SELECT c FROM Contact c WHERE c.message = :message")
    , @NamedQuery(name = "Contact.findByNewsletter", query = "SELECT c FROM Contact c WHERE c.newsletter = :newsletter")
    , @NamedQuery(name = "Contact.findBySessionIdsession", query = "SELECT c FROM Contact c WHERE c.contactPK.sessionIdsession = :sessionIdsession")
    , @NamedQuery(name = "Contact.findBySessioncompteUtilisateuridcompteUtilisateur", query = "SELECT c FROM Contact c WHERE c.contactPK.sessioncompteUtilisateuridcompteUtilisateur = :sessioncompteUtilisateuridcompteUtilisateur")})
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ContactPK contactPK;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @Size(max = 45)
    @Column(name = "pr\u00e9nom")
    private String prénom;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "num\u00e9roTelephone")
    private String numéroTelephone;
    @Size(max = 45)
    @Column(name = "message")
    private String message;
    @Size(max = 45)
    @Column(name = "newsletter")
    private String newsletter;
    @JoinColumns({
        @JoinColumn(name = "session_idsession", referencedColumnName = "idsession", insertable = false, updatable = false)
        , @JoinColumn(name = "session_compteUtilisateur_idcompteUtilisateur", referencedColumnName = "compteUtilisateur_idcompteUtilisateur", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Session session;

    public Contact() {
    }

    public Contact(ContactPK contactPK) {
        this.contactPK = contactPK;
    }

    public Contact(int idcontact, int sessionIdsession, int sessioncompteUtilisateuridcompteUtilisateur) {
        this.contactPK = new ContactPK(idcontact, sessionIdsession, sessioncompteUtilisateuridcompteUtilisateur);
    }

    public ContactPK getContactPK() {
        return contactPK;
    }

    public void setContactPK(ContactPK contactPK) {
        this.contactPK = contactPK;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrénom() {
        return prénom;
    }

    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNuméroTelephone() {
        return numéroTelephone;
    }

    public void setNuméroTelephone(String numéroTelephone) {
        this.numéroTelephone = numéroTelephone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(String newsletter) {
        this.newsletter = newsletter;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactPK != null ? contactPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) object;
        if ((this.contactPK == null && other.contactPK != null) || (this.contactPK != null && !this.contactPK.equals(other.contactPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Contact[ contactPK=" + contactPK + " ]";
    }
    
}
