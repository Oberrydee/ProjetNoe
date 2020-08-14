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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADZOH-VINYO DIANA
 */
@Entity
@Table(name = "codePourConfirmation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CodePourConfirmation.findAll", query = "SELECT c FROM CodePourConfirmation c")
    , @NamedQuery(name = "CodePourConfirmation.findByIdcodePourConfirmation", query = "SELECT c FROM CodePourConfirmation c WHERE c.idcodePourConfirmation = :idcodePourConfirmation")
    , @NamedQuery(name = "CodePourConfirmation.findByNomcodePourConfirmation", query = "SELECT c FROM CodePourConfirmation c WHERE c.nomcodePourConfirmation = :nomcodePourConfirmation")})
public class CodePourConfirmation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "idcodePourConfirmation")
    private String idcodePourConfirmation;
    @Size(max = 45)
    @Column(name = "nomcodePourConfirmation")
    private String nomcodePourConfirmation;

    public CodePourConfirmation() {
    }

    public CodePourConfirmation(String idcodePourConfirmation) {
        this.idcodePourConfirmation = idcodePourConfirmation;
    }

    public String getIdcodePourConfirmation() {
        return idcodePourConfirmation;
    }

    public void setIdcodePourConfirmation(String idcodePourConfirmation) {
        this.idcodePourConfirmation = idcodePourConfirmation;
    }

    public String getNomcodePourConfirmation() {
        return nomcodePourConfirmation;
    }

    public void setNomcodePourConfirmation(String nomcodePourConfirmation) {
        this.nomcodePourConfirmation = nomcodePourConfirmation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcodePourConfirmation != null ? idcodePourConfirmation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CodePourConfirmation)) {
            return false;
        }
        CodePourConfirmation other = (CodePourConfirmation) object;
        if ((this.idcodePourConfirmation == null && other.idcodePourConfirmation != null) || (this.idcodePourConfirmation != null && !this.idcodePourConfirmation.equals(other.idcodePourConfirmation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CodePourConfirmation[ idcodePourConfirmation=" + idcodePourConfirmation + " ]";
    }
    
}
