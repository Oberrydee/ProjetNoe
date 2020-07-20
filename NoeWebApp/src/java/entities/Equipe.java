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
@Table(name = "equipe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipe.findAll", query = "SELECT e FROM Equipe e")
    , @NamedQuery(name = "Equipe.findByIdequipe", query = "SELECT e FROM Equipe e WHERE e.equipePK.idequipe = :idequipe")
    , @NamedQuery(name = "Equipe.findByNom", query = "SELECT e FROM Equipe e WHERE e.nom = :nom")
    , @NamedQuery(name = "Equipe.findByNombreDeMembre", query = "SELECT e FROM Equipe e WHERE e.nombreDeMembre = :nombreDeMembre")
    , @NamedQuery(name = "Equipe.findByMembres", query = "SELECT e FROM Equipe e WHERE e.membres = :membres")
    , @NamedQuery(name = "Equipe.findBySalari\u00e9idSalari\u00e9", query = "SELECT e FROM Equipe e WHERE e.equipePK.salari\u00e9idSalari\u00e9 = :salari\u00e9idSalari\u00e9")
    , @NamedQuery(name = "Equipe.findBySalari\u00e9compteUtilisateuridcompteUtilisateur", query = "SELECT e FROM Equipe e WHERE e.equipePK.salari\u00e9compteUtilisateuridcompteUtilisateur = :salari\u00e9compteUtilisateuridcompteUtilisateur")})
public class Equipe implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EquipePK equipePK;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @Size(max = 45)
    @Column(name = "nombreDeMembre")
    private String nombreDeMembre;
    @Size(max = 45)
    @Column(name = "membres")
    private String membres;
    @JoinColumns({
        @JoinColumn(name = "Salari\u00e9_idSalari\u00e9", referencedColumnName = "idSalari\u00e9", insertable = false, updatable = false)
        , @JoinColumn(name = "Salari\u00e9_compteUtilisateur_idcompteUtilisateur", referencedColumnName = "compteUtilisateur_idcompteUtilisateur", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Salarié salarié;

    public Equipe() {
    }

    public Equipe(EquipePK equipePK) {
        this.equipePK = equipePK;
    }

    public Equipe(int idequipe, int salariéidSalarié, int salariécompteUtilisateuridcompteUtilisateur) {
        this.equipePK = new EquipePK(idequipe, salariéidSalarié, salariécompteUtilisateuridcompteUtilisateur);
    }

    public EquipePK getEquipePK() {
        return equipePK;
    }

    public void setEquipePK(EquipePK equipePK) {
        this.equipePK = equipePK;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNombreDeMembre() {
        return nombreDeMembre;
    }

    public void setNombreDeMembre(String nombreDeMembre) {
        this.nombreDeMembre = nombreDeMembre;
    }

    public String getMembres() {
        return membres;
    }

    public void setMembres(String membres) {
        this.membres = membres;
    }

    public Salarié getSalarié() {
        return salarié;
    }

    public void setSalarié(Salarié salarié) {
        this.salarié = salarié;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (equipePK != null ? equipePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipe)) {
            return false;
        }
        Equipe other = (Equipe) object;
        if ((this.equipePK == null && other.equipePK != null) || (this.equipePK != null && !this.equipePK.equals(other.equipePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Equipe[ equipePK=" + equipePK + " ]";
    }
    
}
