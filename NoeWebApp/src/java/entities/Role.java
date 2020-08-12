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
import javax.persistence.ManyToMany;
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
@Table(name = "Role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
    , @NamedQuery(name = "Role.findByIdRole", query = "SELECT r FROM Role r WHERE r.idRole = :idRole")
    , @NamedQuery(name = "Role.findByNomRole", query = "SELECT r FROM Role r WHERE r.nomRole = :nomRole")})
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRole")
    private Integer idRole;
    @Size(max = 45)
    @Column(name = "nomRole")
    private String nomRole;
    @ManyToMany(mappedBy = "roleList")
    private List<Droit> droitList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleidRole")
    private List<Salarié> salariéList;

    public Role() {
    }

    public Role(Integer idRole) {
        this.idRole = idRole;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getNomRole() {
        return nomRole;
    }

    public void setNomRole(String nomRole) {
        this.nomRole = nomRole;
    }

    @XmlTransient
    public List<Droit> getDroitList() {
        return droitList;
    }

    public void setDroitList(List<Droit> droitList) {
        this.droitList = droitList;
    }

    @XmlTransient
    public List<Salarié> getSalariéList() {
        return salariéList;
    }

    public void setSalariéList(List<Salarié> salariéList) {
        this.salariéList = salariéList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRole != null ? idRole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.idRole == null && other.idRole != null) || (this.idRole != null && !this.idRole.equals(other.idRole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Role[ idRole=" + idRole + " ]";
    }
    
}
