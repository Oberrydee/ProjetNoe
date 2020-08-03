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
@Table(name = "genre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Genre.findAll", query = "SELECT g FROM Genre g")
    , @NamedQuery(name = "Genre.findByIdgenre", query = "SELECT g FROM Genre g WHERE g.idgenre = :idgenre")
    , @NamedQuery(name = "Genre.findByNom", query = "SELECT g FROM Genre g WHERE g.nom = :nom")})
public class Genre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgenre")
    private Integer idgenre;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @JoinColumn(name = "section_idsection", referencedColumnName = "idsection")
    @ManyToOne(optional = false)
    private Section sectionIdsection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genreIdgenre")
    private List<Tribu> tribuList;

    public Genre() {
    }

    public Genre(Integer idgenre) {
        this.idgenre = idgenre;
    }

    public Integer getIdgenre() {
        return idgenre;
    }

    public void setIdgenre(Integer idgenre) {
        this.idgenre = idgenre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Section getSectionIdsection() {
        return sectionIdsection;
    }

    public void setSectionIdsection(Section sectionIdsection) {
        this.sectionIdsection = sectionIdsection;
    }

    @XmlTransient
    public List<Tribu> getTribuList() {
        return tribuList;
    }

    public void setTribuList(List<Tribu> tribuList) {
        this.tribuList = tribuList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgenre != null ? idgenre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genre)) {
            return false;
        }
        Genre other = (Genre) object;
        if ((this.idgenre == null && other.idgenre != null) || (this.idgenre != null && !this.idgenre.equals(other.idgenre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Genre[ idgenre=" + idgenre + " ]";
    }
    
}
