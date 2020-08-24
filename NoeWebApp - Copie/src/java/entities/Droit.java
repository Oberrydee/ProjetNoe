/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADZOH-VINYO DIANA
 */
@Entity
@Table(name = "Droit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Droit.findAll", query = "SELECT d FROM Droit d")
    , @NamedQuery(name = "Droit.findByIdDroit", query = "SELECT d FROM Droit d WHERE d.idDroit = :idDroit")
    , @NamedQuery(name = "Droit.findByNomDroit", query = "SELECT d FROM Droit d WHERE d.nomDroit = :nomDroit")
    , @NamedQuery(name = "Droit.findByInformation", query = "SELECT d FROM Droit d WHERE d.information = :information")
    , @NamedQuery(name = "Droit.findByDroit", query = "SELECT d FROM Droit d WHERE d.droit = :droit")})
public class Droit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDroit")
    private Integer idDroit;
    @Size(max = 45)
    @Column(name = "nomDroit")
    private String nomDroit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "information")
    private String information;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Droit")
    private String droit;
    @JoinTable(name = "Role_has_Droit", joinColumns = {
        @JoinColumn(name = "Droit_idDroit", referencedColumnName = "idDroit")}, inverseJoinColumns = {
        @JoinColumn(name = "Role_idRole", referencedColumnName = "idRole")})
    @ManyToMany
    private List<Role> roleList;

    public Droit() {
    }

    public Droit(Integer idDroit) {
        this.idDroit = idDroit;
    }

    public Droit(Integer idDroit, String information, String droit) {
        this.idDroit = idDroit;
        this.information = information;
        this.droit = droit;
    }

    public Integer getIdDroit() {
        return idDroit;
    }

    public void setIdDroit(Integer idDroit) {
        this.idDroit = idDroit;
    }

    public String getNomDroit() {
        return nomDroit;
    }

    public void setNomDroit(String nomDroit) {
        this.nomDroit = nomDroit;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getDroit() {
        return droit;
    }

    public void setDroit(String droit) {
        this.droit = droit;
    }

    @XmlTransient
    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDroit != null ? idDroit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Droit)) {
            return false;
        }
        Droit other = (Droit) object;
        if ((this.idDroit == null && other.idDroit != null) || (this.idDroit != null && !this.idDroit.equals(other.idDroit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Droit[ idDroit=" + idDroit + " ]";
    }
    
}
