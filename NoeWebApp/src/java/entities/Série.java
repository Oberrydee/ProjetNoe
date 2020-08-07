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
@Table(name = "s\u00e9rie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "S\u00e9rie.findAll", query = "SELECT s FROM S\u00e9rie s")
    , @NamedQuery(name = "S\u00e9rie.findByIds\u00e9rie", query = "SELECT s FROM S\u00e9rie s WHERE s.ids\u00e9rie = :ids\u00e9rie")
    , @NamedQuery(name = "S\u00e9rie.findByNom", query = "SELECT s FROM S\u00e9rie s WHERE s.nom = :nom")})
public class Série implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ids\u00e9rie")
    private Integer idsérie;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;

    public Série() {
    }

    public Série(Integer idsérie) {
        this.idsérie = idsérie;
    }

    public Integer getIdsérie() {
        return idsérie;
    }

    public void setIdsérie(Integer idsérie) {
        this.idsérie = idsérie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsérie != null ? idsérie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Série)) {
            return false;
        }
        Série other = (Série) object;
        if ((this.idsérie == null && other.idsérie != null) || (this.idsérie != null && !this.idsérie.equals(other.idsérie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.S\u00e9rie[ ids\u00e9rie=" + idsérie + " ]";
    }
    
}
