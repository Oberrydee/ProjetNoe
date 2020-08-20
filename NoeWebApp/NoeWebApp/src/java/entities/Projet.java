/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    , @NamedQuery(name = "Projet.findByIdprojet", query = "SELECT p FROM Projet p WHERE p.idprojet = :idprojet")
    , @NamedQuery(name = "Projet.findByNom", query = "SELECT p FROM Projet p WHERE p.nom = :nom")
    , @NamedQuery(name = "Projet.findByDateDebut", query = "SELECT p FROM Projet p WHERE p.dateDebut = :dateDebut")
    , @NamedQuery(name = "Projet.findByDur\u00e9eEnMois", query = "SELECT p FROM Projet p WHERE p.dur\u00e9eEnMois = :dur\u00e9eEnMois")})
public class Projet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprojet")
    private Integer idprojet;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @Column(name = "dateDebut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;
    @Column(name = "dur\u00e9eEnMois")
    private Integer duréeEnMois;
    @JoinColumn(name = "narrateur_idsalarie", referencedColumnName = "idSalari\u00e9")
    @ManyToOne(optional = false)
    private Salarié narrateurIdsalarie;
    @JoinColumn(name = "demandeur_idsalarie", referencedColumnName = "idSalari\u00e9")
    @ManyToOne(optional = false)
    private Salarié demandeurIdsalarie;
    @JoinColumn(name = "alerte_idalerte", referencedColumnName = "idalerte")
    @ManyToOne(optional = false)
    private Alerte alerteIdalerte;
    @JoinColumn(name = "equipe_idequipe", referencedColumnName = "idequipe")
    @ManyToOne(optional = false)
    private Equipe equipeIdequipe;
    @JoinColumn(name = "etat_idetat", referencedColumnName = "idetat")
    @ManyToOne(optional = false)
    private Etat etatIdetat;

    public Projet() {
    }

    public Projet(Integer idprojet) {
        this.idprojet = idprojet;
    }

    public Integer getIdprojet() {
        return idprojet;
    }

    public void setIdprojet(Integer idprojet) {
        this.idprojet = idprojet;
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

    public Integer getDuréeEnMois() {
        return duréeEnMois;
    }

    public void setDuréeEnMois(Integer duréeEnMois) {
        this.duréeEnMois = duréeEnMois;
    }

    public Salarié getNarrateurIdsalarie() {
        return narrateurIdsalarie;
    }

    public void setNarrateurIdsalarie(Salarié narrateurIdsalarie) {
        this.narrateurIdsalarie = narrateurIdsalarie;
    }

    public Salarié getDemandeurIdsalarie() {
        return demandeurIdsalarie;
    }

    public void setDemandeurIdsalarie(Salarié demandeurIdsalarie) {
        this.demandeurIdsalarie = demandeurIdsalarie;
    }

    public Alerte getAlerteIdalerte() {
        return alerteIdalerte;
    }

    public void setAlerteIdalerte(Alerte alerteIdalerte) {
        this.alerteIdalerte = alerteIdalerte;
    }

    public Equipe getEquipeIdequipe() {
        return equipeIdequipe;
    }

    public void setEquipeIdequipe(Equipe equipeIdequipe) {
        this.equipeIdequipe = equipeIdequipe;
    }

    public Etat getEtatIdetat() {
        return etatIdetat;
    }

    public void setEtatIdetat(Etat etatIdetat) {
        this.etatIdetat = etatIdetat;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projet)) {
            return false;
        }
        Projet other = (Projet) object;
        if ((this.idprojet == null && other.idprojet != null) || (this.idprojet != null && !this.idprojet.equals(other.idprojet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Projet[ idprojet=" + idprojet + " ]";
    }
    
}
