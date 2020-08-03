/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "famille")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Famille.findAll", query = "SELECT f FROM Famille f")
    , @NamedQuery(name = "Famille.findByIdFamille", query = "SELECT f FROM Famille f WHERE f.idFamille = :idFamille")
    , @NamedQuery(name = "Famille.findByNom", query = "SELECT f FROM Famille f WHERE f.nom = :nom")})
public class Famille implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFamille")
    private Integer idFamille;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "familleidFamille")
    private List<Ordre> ordreList;
    @JoinColumn(name = "tribu_idtribu", referencedColumnName = "idtribu")
    @ManyToOne(optional = false)
    private Tribu tribuIdtribu;

    public Famille() {
    }

    public Famille(Integer idFamille) {
        this.idFamille = idFamille;
    }

    public Integer getIdFamille() {
        return idFamille;
    }

    public void setIdFamille(Integer idFamille) {
        this.idFamille = idFamille;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlTransient
    public List<Ordre> getOrdreList() {
        return ordreList;
    }

    public void setOrdreList(List<Ordre> ordreList) {
        this.ordreList = ordreList;
    }

    public Tribu getTribuIdtribu() {
        return tribuIdtribu;
    }

    public void setTribuIdtribu(Tribu tribuIdtribu) {
        this.tribuIdtribu = tribuIdtribu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFamille != null ? idFamille.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Famille)) {
            return false;
        }
        Famille other = (Famille) object;
        if ((this.idFamille == null && other.idFamille != null) || (this.idFamille != null && !this.idFamille.equals(other.idFamille))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Famille[ idFamille=" + idFamille + " ]";
    }
    
}
