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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "vari\u00e9t\u00e9")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vari\u00e9t\u00e9.findAll", query = "SELECT v FROM Vari\u00e9t\u00e9 v")
    , @NamedQuery(name = "Vari\u00e9t\u00e9.findByIdvari\u00e9t\u00e9", query = "SELECT v FROM Vari\u00e9t\u00e9 v WHERE v.idvari\u00e9t\u00e9 = :idvari\u00e9t\u00e9")
    , @NamedQuery(name = "Vari\u00e9t\u00e9.findByNom", query = "SELECT v FROM Vari\u00e9t\u00e9 v WHERE v.nom = :nom")})
public class Variété implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvari\u00e9t\u00e9")
    private Integer idvariété;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @JoinColumn(name = "forme_idforme", referencedColumnName = "idforme")
    @ManyToOne(optional = false)
    private Forme formeIdforme;

    public Variété() {
    }

    public Variété(Integer idvariété) {
        this.idvariété = idvariété;
    }

    public Integer getIdvariété() {
        return idvariété;
    }

    public void setIdvariété(Integer idvariété) {
        this.idvariété = idvariété;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Forme getFormeIdforme() {
        return formeIdforme;
    }

    public void setFormeIdforme(Forme formeIdforme) {
        this.formeIdforme = formeIdforme;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvariété != null ? idvariété.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Variété)) {
            return false;
        }
        Variété other = (Variété) object;
        if ((this.idvariété == null && other.idvariété != null) || (this.idvariété != null && !this.idvariété.equals(other.idvariété))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Vari\u00e9t\u00e9[ idvari\u00e9t\u00e9=" + idvariété + " ]";
    }
    
}
