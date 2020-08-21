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
@Table(name = "Salari\u00e9")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salari\u00e9.findAll", query = "SELECT s FROM Salari\u00e9 s")
    , @NamedQuery(name = "Salari\u00e9.findByIdSalari\u00e9", query = "SELECT s FROM Salari\u00e9 s WHERE s.idSalari\u00e9 = :idSalari\u00e9")
    , @NamedQuery(name = "Salari\u00e9.findByEmailPro", query = "SELECT s FROM Salari\u00e9 s WHERE s.emailPro = :emailPro")
    , @NamedQuery(name = "Salari\u00e9.findBySite", query = "SELECT s FROM Salari\u00e9 s WHERE s.site = :site")
    , @NamedQuery(name = "Salari\u00e9.findByNumeroBatiment", query = "SELECT s FROM Salari\u00e9 s WHERE s.numeroBatiment = :numeroBatiment")
    , @NamedQuery(name = "Salari\u00e9.findByRue", query = "SELECT s FROM Salari\u00e9 s WHERE s.rue = :rue")
    , @NamedQuery(name = "Salari\u00e9.findByVille", query = "SELECT s FROM Salari\u00e9 s WHERE s.ville = :ville")
    , @NamedQuery(name = "Salari\u00e9.findByCodePostal", query = "SELECT s FROM Salari\u00e9 s WHERE s.codePostal = :codePostal")
    , @NamedQuery(name = "Salari\u00e9.findByNom", query = "SELECT s FROM Salari\u00e9 s WHERE s.nom = :nom")
    , @NamedQuery(name = "Salari\u00e9.findByPr\u00e9nom", query = "SELECT s FROM Salari\u00e9 s WHERE s.pr\u00e9nom = :pr\u00e9nom")})
public class Salarié implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSalari\u00e9")
    private Integer idSalarié;
    @Size(max = 45)
    @Column(name = "emailPro")
    private String emailPro;
    @Size(max = 45)
    @Column(name = "site")
    private String site;
    @Size(max = 45)
    @Column(name = "numeroBatiment")
    private String numeroBatiment;
    @Size(max = 45)
    @Column(name = "rue")
    private String rue;
    @Size(max = 45)
    @Column(name = "ville")
    private String ville;
    @Column(name = "codePostal")
    private Integer codePostal;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @Size(max = 45)
    @Column(name = "pr\u00e9nom")
    private String prénom;
    @JoinColumn(name = "compteUtilisateur_idcompteUtilisateur", referencedColumnName = "idcompteUtilisateur")
    @ManyToOne(optional = false)
    private CompteUtilisateur compteUtilisateuridcompteUtilisateur;
    @JoinColumn(name = "Role_id_Role", referencedColumnName = "idRole")
    @ManyToOne(optional = false)
    private Role roleidRole;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "narrateurIdsalarie")
    private List<Projet> projetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "demandeurIdsalarie")
    private List<Projet> projetList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salari\u00e9idSalari\u00e9")
    private List<Sentinelle> sentinelleList;

    public Salarié() {
    }

    public Salarié(Integer idSalarié) {
        this.idSalarié = idSalarié;
    }

    public Integer getIdSalarié() {
        return idSalarié;
    }

    public void setIdSalarié(Integer idSalarié) {
        this.idSalarié = idSalarié;
    }

    public String getEmailPro() {
        return emailPro;
    }

    public void setEmailPro(String emailPro) {
        this.emailPro = emailPro;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getNumeroBatiment() {
        return numeroBatiment;
    }

    public void setNumeroBatiment(String numeroBatiment) {
        this.numeroBatiment = numeroBatiment;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Integer getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrénom() {
        return prénom;
    }

    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }

    public CompteUtilisateur getCompteUtilisateuridcompteUtilisateur() {
        return compteUtilisateuridcompteUtilisateur;
    }

    public void setCompteUtilisateuridcompteUtilisateur(CompteUtilisateur compteUtilisateuridcompteUtilisateur) {
        this.compteUtilisateuridcompteUtilisateur = compteUtilisateuridcompteUtilisateur;
    }

    public Role getRoleidRole() {
        return roleidRole;
    }

    public void setRoleidRole(Role roleidRole) {
        this.roleidRole = roleidRole;
    }

    @XmlTransient
    public List<Projet> getProjetList() {
        return projetList;
    }

    public void setProjetList(List<Projet> projetList) {
        this.projetList = projetList;
    }

    @XmlTransient
    public List<Projet> getProjetList1() {
        return projetList1;
    }

    public void setProjetList1(List<Projet> projetList1) {
        this.projetList1 = projetList1;
    }

    @XmlTransient
    public List<Sentinelle> getSentinelleList() {
        return sentinelleList;
    }

    public void setSentinelleList(List<Sentinelle> sentinelleList) {
        this.sentinelleList = sentinelleList;
    }
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salarié)) {
            return false;
        }
        Salarié other = (Salarié) object;
        if ((this.idSalarié == null && other.idSalarié != null) || (this.idSalarié != null && !this.idSalarié.equals(other.idSalarié))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Salari\u00e9[ idSalari\u00e9=" + idSalarié + " ]";
    }
    
}
