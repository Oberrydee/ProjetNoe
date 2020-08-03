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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADZOH-VINYO DIANA
 */
@Entity
@Table(name = "esp\u00e8ce(taxinomie)")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Esp\u00e8ceTaxinomie.findAll", query = "SELECT e FROM Esp\u00e8ceTaxinomie e")
    , @NamedQuery(name = "Esp\u00e8ceTaxinomie.findByIdesp\u00e8ceTaxinomie", query = "SELECT e FROM Esp\u00e8ceTaxinomie e WHERE e.idesp\u00e8ceTaxinomie = :idesp\u00e8ceTaxinomie")
    , @NamedQuery(name = "Esp\u00e8ceTaxinomie.findByNom", query = "SELECT e FROM Esp\u00e8ceTaxinomie e WHERE e.nom = :nom")
    , @NamedQuery(name = "Esp\u00e8ceTaxinomie.findByVari\u00e9t\u00e9Idvari\u00e9t\u00e9", query = "SELECT e FROM Esp\u00e8ceTaxinomie e WHERE e.vari\u00e9t\u00e9Idvari\u00e9t\u00e9 = :vari\u00e9t\u00e9Idvari\u00e9t\u00e9")})
public class EspèceTaxinomie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idesp\u00e8ce(Taxinomie)")
    private Integer idespèceTaxinomie;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vari\u00e9t\u00e9_idvari\u00e9t\u00e9")
    private int variétéIdvariété;

    public EspèceTaxinomie() {
    }

    public EspèceTaxinomie(Integer idespèceTaxinomie) {
        this.idespèceTaxinomie = idespèceTaxinomie;
    }

    public EspèceTaxinomie(Integer idespèceTaxinomie, int variétéIdvariété) {
        this.idespèceTaxinomie = idespèceTaxinomie;
        this.variétéIdvariété = variétéIdvariété;
    }

    public Integer getIdespèceTaxinomie() {
        return idespèceTaxinomie;
    }

    public void setIdespèceTaxinomie(Integer idespèceTaxinomie) {
        this.idespèceTaxinomie = idespèceTaxinomie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getVariétéIdvariété() {
        return variétéIdvariété;
    }

    public void setVariétéIdvariété(int variétéIdvariété) {
        this.variétéIdvariété = variétéIdvariété;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idespèceTaxinomie != null ? idespèceTaxinomie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EspèceTaxinomie)) {
            return false;
        }
        EspèceTaxinomie other = (EspèceTaxinomie) object;
        if ((this.idespèceTaxinomie == null && other.idespèceTaxinomie != null) || (this.idespèceTaxinomie != null && !this.idespèceTaxinomie.equals(other.idespèceTaxinomie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Esp\u00e8ceTaxinomie[ idesp\u00e8ceTaxinomie=" + idespèceTaxinomie + " ]";
    }
    
}
