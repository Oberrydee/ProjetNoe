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
@Table(name = "section")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Section.findAll", query = "SELECT s FROM Section s")
    , @NamedQuery(name = "Section.findByIdsection", query = "SELECT s FROM Section s WHERE s.idsection = :idsection")
    , @NamedQuery(name = "Section.findByNom", query = "SELECT s FROM Section s WHERE s.nom = :nom")})
public class Section implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsection")
    private Integer idsection;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @JoinColumn(name = "s\u00e9rie_ids\u00e9rie", referencedColumnName = "ids\u00e9rie")
    @ManyToOne(optional = false)
    private Série sérieIdsérie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sectionIdsection")
    private List<Genre> genreList;

    public Section() {
    }

    public Section(Integer idsection) {
        this.idsection = idsection;
    }

    public Integer getIdsection() {
        return idsection;
    }

    public void setIdsection(Integer idsection) {
        this.idsection = idsection;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Série getSérieIdsérie() {
        return sérieIdsérie;
    }

    public void setSérieIdsérie(Série sérieIdsérie) {
        this.sérieIdsérie = sérieIdsérie;
    }

    @XmlTransient
    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsection != null ? idsection.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Section)) {
            return false;
        }
        Section other = (Section) object;
        if ((this.idsection == null && other.idsection != null) || (this.idsection != null && !this.idsection.equals(other.idsection))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Section[ idsection=" + idsection + " ]";
    }
    
}
