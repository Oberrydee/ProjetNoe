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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "salari\u00e9")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salari\u00e9.findAll", query = "SELECT s FROM Salari\u00e9 s")
    , @NamedQuery(name = "Salari\u00e9.findByIdSalari\u00e9", query = "SELECT s FROM Salari\u00e9 s WHERE s.salari\u00e9PK.idSalari\u00e9 = :idSalari\u00e9")
    , @NamedQuery(name = "Salari\u00e9.findByEmailPro", query = "SELECT s FROM Salari\u00e9 s WHERE s.emailPro = :emailPro")
    , @NamedQuery(name = "Salari\u00e9.findBySite", query = "SELECT s FROM Salari\u00e9 s WHERE s.site = :site")
    , @NamedQuery(name = "Salari\u00e9.findByDroits", query = "SELECT s FROM Salari\u00e9 s WHERE s.droits = :droits")
    , @NamedQuery(name = "Salari\u00e9.findByNumeroBatiment", query = "SELECT s FROM Salari\u00e9 s WHERE s.numeroBatiment = :numeroBatiment")
    , @NamedQuery(name = "Salari\u00e9.findByRue", query = "SELECT s FROM Salari\u00e9 s WHERE s.rue = :rue")
    , @NamedQuery(name = "Salari\u00e9.findByVille", query = "SELECT s FROM Salari\u00e9 s WHERE s.ville = :ville")
    , @NamedQuery(name = "Salari\u00e9.findByCodePostal", query = "SELECT s FROM Salari\u00e9 s WHERE s.codePostal = :codePostal")
    , @NamedQuery(name = "Salari\u00e9.findByNom", query = "SELECT s FROM Salari\u00e9 s WHERE s.nom = :nom")
    , @NamedQuery(name = "Salari\u00e9.findByPr\u00e9nom", query = "SELECT s FROM Salari\u00e9 s WHERE s.pr\u00e9nom = :pr\u00e9nom")
    , @NamedQuery(name = "Salari\u00e9.findByRole", query = "SELECT s FROM Salari\u00e9 s WHERE s.role = :role")
    , @NamedQuery(name = "Salari\u00e9.findByCompteUtilisateuridcompteUtilisateur", query = "SELECT s FROM Salari\u00e9 s WHERE s.salari\u00e9PK.compteUtilisateuridcompteUtilisateur = :compteUtilisateuridcompteUtilisateur")})
public class Salarié implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SalariéPK salariéPK;
    @Size(max = 45)
    @Column(name = "emailPro")
    private String emailPro;
    @Size(max = 45)
    @Column(name = "site")
    private String site;
    @Size(max = 45)
    @Column(name = "droits")
    private String droits;
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
    @Size(max = 45)
    @Column(name = "role")
    private String role;
    @JoinTable(name = "sitedestokage_has_salari\u00e9", joinColumns = {
        @JoinColumn(name = "Salari\u00e9_idSalari\u00e9", referencedColumnName = "idSalari\u00e9")
        , @JoinColumn(name = "Salari\u00e9_compteUtilisateur_idcompteUtilisateur", referencedColumnName = "compteUtilisateur_idcompteUtilisateur")}, inverseJoinColumns = {
        @JoinColumn(name = "SiteDeStokage_idSiteDeStokage", referencedColumnName = "idSiteDeStokage")})
    @ManyToMany
    private List<Sitedestokage> sitedestokageList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salari\u00e9")
    private List<Sentinelle> sentinelleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salari\u00e9")
    private List<Projet> projetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salari\u00e9")
    private List<Equipe> equipeList;
    @JoinColumn(name = "compteUtilisateur_idcompteUtilisateur", referencedColumnName = "idcompteUtilisateur", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Compteutilisateur compteutilisateur;

    public Salarié() {
    }

    public Salarié(SalariéPK salariéPK) {
        this.salariéPK = salariéPK;
    }

    public Salarié(int idSalarié, int compteUtilisateuridcompteUtilisateur) {
        this.salariéPK = new SalariéPK(idSalarié, compteUtilisateuridcompteUtilisateur);
    }

    public SalariéPK getSalariéPK() {
        return salariéPK;
    }

    public void setSalariéPK(SalariéPK salariéPK) {
        this.salariéPK = salariéPK;
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

    public String getDroits() {
        return droits;
    }

    public void setDroits(String droits) {
        this.droits = droits;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @XmlTransient
    public List<Sitedestokage> getSitedestokageList() {
        return sitedestokageList;
    }

    public void setSitedestokageList(List<Sitedestokage> sitedestokageList) {
        this.sitedestokageList = sitedestokageList;
    }

    @XmlTransient
    public List<Sentinelle> getSentinelleList() {
        return sentinelleList;
    }

    public void setSentinelleList(List<Sentinelle> sentinelleList) {
        this.sentinelleList = sentinelleList;
    }

    @XmlTransient
    public List<Projet> getProjetList() {
        return projetList;
    }

    public void setProjetList(List<Projet> projetList) {
        this.projetList = projetList;
    }

    @XmlTransient
    public List<Equipe> getEquipeList() {
        return equipeList;
    }

    public void setEquipeList(List<Equipe> equipeList) {
        this.equipeList = equipeList;
    }

    public Compteutilisateur getCompteutilisateur() {
        return compteutilisateur;
    }

    public void setCompteutilisateur(Compteutilisateur compteutilisateur) {
        this.compteutilisateur = compteutilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salariéPK != null ? salariéPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salarié)) {
            return false;
        }
        Salarié other = (Salarié) object;
        if ((this.salariéPK == null && other.salariéPK != null) || (this.salariéPK != null && !this.salariéPK.equals(other.salariéPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Salari\u00e9[ salari\u00e9PK=" + salariéPK + " ]";
    }
    
}
