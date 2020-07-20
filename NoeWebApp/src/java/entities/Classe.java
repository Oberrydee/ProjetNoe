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
import javax.persistence.JoinColumns;
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
@Table(name = "classe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classe.findAll", query = "SELECT c FROM Classe c")
    , @NamedQuery(name = "Classe.findByIdclasse", query = "SELECT c FROM Classe c WHERE c.classePK.idclasse = :idclasse")
    , @NamedQuery(name = "Classe.findByNom", query = "SELECT c FROM Classe c WHERE c.nom = :nom")
    , @NamedQuery(name = "Classe.findByOrdreIdordre", query = "SELECT c FROM Classe c WHERE c.classePK.ordreIdordre = :ordreIdordre")
    , @NamedQuery(name = "Classe.findByOrdreRegneIdregne", query = "SELECT c FROM Classe c WHERE c.classePK.ordreRegneIdregne = :ordreRegneIdregne")
    , @NamedQuery(name = "Classe.findByOrdreRegneEmbranchementIdembranchement", query = "SELECT c FROM Classe c WHERE c.classePK.ordreRegneEmbranchementIdembranchement = :ordreRegneEmbranchementIdembranchement")})
public class Classe implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClassePK classePK;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @JoinColumns({
        @JoinColumn(name = "ordre_idordre", referencedColumnName = "idordre", insertable = false, updatable = false)
        , @JoinColumn(name = "ordre_regne_idregne", referencedColumnName = "regne_idregne", insertable = false, updatable = false)
        , @JoinColumn(name = "ordre_regne_embranchement_idembranchement", referencedColumnName = "regne_embranchement_idembranchement", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Ordre ordre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classe")
    private List<Famille> familleList;

    public Classe() {
    }

    public Classe(ClassePK classePK) {
        this.classePK = classePK;
    }

    public Classe(int idclasse, int ordreIdordre, int ordreRegneIdregne, int ordreRegneEmbranchementIdembranchement) {
        this.classePK = new ClassePK(idclasse, ordreIdordre, ordreRegneIdregne, ordreRegneEmbranchementIdembranchement);
    }

    public ClassePK getClassePK() {
        return classePK;
    }

    public void setClassePK(ClassePK classePK) {
        this.classePK = classePK;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Ordre getOrdre() {
        return ordre;
    }

    public void setOrdre(Ordre ordre) {
        this.ordre = ordre;
    }

    @XmlTransient
    public List<Famille> getFamilleList() {
        return familleList;
    }

    public void setFamilleList(List<Famille> familleList) {
        this.familleList = familleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (classePK != null ? classePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classe)) {
            return false;
        }
        Classe other = (Classe) object;
        if ((this.classePK == null && other.classePK != null) || (this.classePK != null && !this.classePK.equals(other.classePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Classe[ classePK=" + classePK + " ]";
    }
    
}
