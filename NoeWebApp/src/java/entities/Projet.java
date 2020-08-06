/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADZOH-VINYO DIANA
 */
@Entity
@Table(name = "projet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Projet.findAll", query = "SELECT p FROM Projet p")
    , @NamedQuery(name = "Projet.findByIdprojet", query = "SELECT p FROM Projet p WHERE p.projetPK.idprojet = :idprojet")
    , @NamedQuery(name = "Projet.findByNom", query = "SELECT p FROM Projet p WHERE p.nom = :nom")
    , @NamedQuery(name = "Projet.findByDateDebut", query = "SELECT p FROM Projet p WHERE p.dateDebut = :dateDebut")
    , @NamedQuery(name = "Projet.findByStatus", query = "SELECT p FROM Projet p WHERE p.status = :status")
    , @NamedQuery(name = "Projet.findByDur\u00e9eEnMois", query = "SELECT p FROM Projet p WHERE p.dur\u00e9eEnMois = :dur\u00e9eEnMois")
    , @NamedQuery(name = "Projet.findBySalari\u00e9idSalari\u00e9", query = "SELECT p FROM Projet p WHERE p.projetPK.salari\u00e9idSalari\u00e9 = :salari\u00e9idSalari\u00e9")
    , @NamedQuery(name = "Projet.findBySalari\u00e9compteUtilisateuridcompteUtilisateur", query = "SELECT p FROM Projet p WHERE p.projetPK.salari\u00e9compteUtilisateuridcompteUtilisateur = :salari\u00e9compteUtilisateuridcompteUtilisateur")
    , @NamedQuery(name = "Projet.findByAlerteIdalerte", query = "SELECT p FROM Projet p WHERE p.projetPK.alerteIdalerte = :alerteIdalerte")
    , @NamedQuery(name = "Projet.findByEtatIdetat", query = "SELECT p FROM Projet p WHERE p.projetPK.etatIdetat = :etatIdetat")})
public class Projet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProjetPK projetPK;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @Column(name = "dateDebut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;
    @Size(max = 45)
    @Column(name = "status")
    private String status;
    @Size(max = 45)
    @Column(name = "dur\u00e9eEnMois")
    private String duréeEnMois;
    @JoinColumns({
        @JoinColumn(name = "Salari\u00e9_idSalari\u00e9", referencedColumnName = "idSalari\u00e9", insertable = false, updatable = false)
        , @JoinColumn(name = "Salari\u00e9_compteUtilisateur_idcompteUtilisateur", referencedColumnName = "compteUtilisateur_idcompteUtilisateur", insertable = false, updatable = false)
        , @JoinColumn(name = "Salari\u00e9_Role_id Role", 
                referencedColumnName = "Role_id Role", 
                insertable = false, updatable = false),
    })
    @ManyToOne(optional = false)
    private Salarié salarié;
    
    @JoinColumn(name = "alerte_idalerte", 
            referencedColumnName = "idalerte", 
            insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alerte alerte;
    @JoinColumn(name = "etat_idetat", referencedColumnName = "idetat", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Etat etat;

    public Projet() {
    }

    public Projet(ProjetPK projetPK) {
        this.projetPK = projetPK;
    }

    public Projet(int idprojet, int salariéidSalarié, int salariécompteUtilisateuridcompteUtilisateur, int alerteIdalerte, int etatIdetat) {
        this.projetPK = new ProjetPK(idprojet, salariéidSalarié, salariécompteUtilisateuridcompteUtilisateur, alerteIdalerte, etatIdetat);
    }

    public ProjetPK getProjetPK() {
        return projetPK;
    }

    public void setProjetPK(ProjetPK projetPK) {
        this.projetPK = projetPK;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDuréeEnMois() {
        return duréeEnMois;
    }

    public void setDuréeEnMois(String duréeEnMois) {
        this.duréeEnMois = duréeEnMois;
    }

    public Salarié getSalarié() {
        return salarié;
    }

    public void setSalarié(Salarié salarié) {
        this.salarié = salarié;
    }

    public Alerte getAlerte() {
        return alerte;
    }

    public void setAlerte(Alerte alerte) {
        this.alerte = alerte;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projetPK != null ? projetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projet)) {
            return false;
        }
        Projet other = (Projet) object;
        if ((this.projetPK == null && other.projetPK != null) || (this.projetPK != null && !this.projetPK.equals(other.projetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Projet[ projetPK=" + projetPK + " ]";
    }
    
}
