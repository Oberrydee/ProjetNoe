/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.AccountsToBeConfirmed;
import entities.Alerte;
import entities.Classe;
import entities.CodeResetPassword;
import entities.CompteUtilisateur;
import entities.Droit;
import entities.Equipe;
import entities.Espece;
import entities.Etat;
import entities.Famille;
import entities.Forme;
import entities.Genre;
import entities.LotDeSemence;
import entities.Ordre;
import entities.Projet;
import entities.Regne;
import entities.Role;
import entities.Salarié;
import entities.Salle;
import entities.Section;
import entities.Semence;
import entities.Sentinelle;
import entities.SiteDeStokage;
import entities.Série;
import entities.Taxinomie;
import entities.Tribu;
import entities.Variété;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author ADZOH-VINYO DIANA
 */
public class AccessBD {       
    
    //////////////////////////////////////////////////////////////////////////////////////
    //                               GENERAL FUNCTIONS                                  //
    //////////////////////////////////////////////////////////////////////////////////////
    
      public static Boolean persist(Object object){
        Boolean success = false;
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
          EntityTransaction t = em.getTransaction(); 
          t.begin();
        
        try{
            //if(!em.contains(object)){
                em.persist(object); 
                t.commit(); 
                success = true;
                em.close();
            //}
        }
        catch(Exception e){
            e.printStackTrace();
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
            em.close(); 
        }
        return success; 
    }
   
      
    /////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////  Accountstobeconfirmed  ///////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    public static Object selectAccountstobeconfirmedBycode(String code) {
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("AccountsToBeConfirmed.findByCode"); 
        q.setParameter("code", code); 
        try{
        AccountsToBeConfirmed al = (AccountsToBeConfirmed)q.getSingleResult(); 
        em.close(); 
            return al; 
        } catch(NoResultException e) {
            em.close(); 
            return null;
        }        
    }
    public static Object deleteAccounttobeconfirmed(AccountsToBeConfirmed act){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NoeWebAppPU");
        EntityManager em = emf.createEntityManager();
        String QueryStr = "DELETE From AccountsToBeConfirmed where code ='" + act.getCode()+"'";

        Boolean success = false; 
        
        EntityTransaction t = em.getTransaction(); 
        t.begin();
        try {
            Query q = em.createQuery(QueryStr);
            int updateCount = q.executeUpdate();
            t.commit();
            success = true; 
        } catch (Exception e) {
            e.printStackTrace();
            t.rollback();
            
        } finally {
            em.close();
        }  
        return success; 
    }
    
    /////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////  Alerte  ///////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
    
    public static List<Alerte> selectAllALerts(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Alerte.findAll"); 
        
        List<Alerte> liste = (List<Alerte>)q.getResultList(); 
        
        for (Alerte a: liste){
            System.out.println(a.toString());
        }
        em.close(); 
        return liste; 
    }       
    public static Alerte selectALertsById(int id){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Alerte.findByIdalerte"); 
        q.setParameter("idalerte", id); 
        try{
        Alerte al = (Alerte)q.getSingleResult(); 
        em.close(); 
        return al; 
        }
        catch(NoResultException e){
            e.printStackTrace();
            em.close(); 
            return null; 
        }
    }       
    public static Boolean deleteALert(Alerte alerte){
        Boolean success = false; 
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        String QueryStr = "delete from Alerte where idalerte = '"+alerte.getIdalerte()+"'"; 
        
        em.getTransaction().begin();
        try{
            Query q = em.createQuery(QueryStr); 
            int updateCount = q.executeUpdate(); 
            em.getTransaction().commit();
            success = true;
            em.close();
        }
        catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
            em.close();
        }
        return success; 
    }
    public static Boolean modifyAlert(Alerte alerte){
        Boolean success = false; 
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        if(deleteALert(alerte)){
            if(persist(alerte)) success = true; 
        }       
        
        return success; 
    }
    /////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////// Classe /////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
    
    public static List<Classe> selectAllClasses(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Classe.findAll"); 
        
        List<Classe> liste = (List<Classe>)q.getResultList(); 
        
        for (Classe a: liste){
            System.out.println(a.toString());
        }
        em.close(); 
        return liste; 
    }       
    
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////// Compteutilisateur ///////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
    
    public static List<CodeResetPassword> selectAllCodeResetPassword(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("CodeResetPassword.findAll"); 
        
        List<CodeResetPassword> liste = (List<CodeResetPassword>)q.getResultList(); 
        
        for (CodeResetPassword a: liste){
            System.out.println(a.toString());
        }
        em.close(); 
        return liste; 
    }
    
    public static void deleteCoderesetpassword(CodeResetPassword reset) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NoeWebAppPU");
        EntityManager em = emf.createEntityManager();
        String QueryStr = "DELETE From CodeResetPassword WHERE idCodeResetPassword = '" + reset.getIdCodeResetPassword() +"'";

        EntityTransaction t = em.getTransaction(); 
        t.begin();
        try {
            Query q = em.createQuery(QueryStr);
            int updateCount = q.executeUpdate();
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
            t.rollback();
        } finally {
            em.close();
        }    
        
    }
    
    public static Object selectCoderesetpasswordByID(String id) {
        
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("CodeResetPassword.findByIdCodeResetPassword"); 
        q.setParameter("idCodeResetPassword", id); 
        try{
            CodeResetPassword cpt = (CodeResetPassword)q.getSingleResult(); 
            em.close(); 
            return cpt; 
        } catch(NoResultException e) {
            em.close(); 
            return null;
        }
        
    }
    
       /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////// Compteutilisateur ///////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
    
    public static List<CompteUtilisateur> selectAllCompteutilisateurs(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("CompteUtilisateur.findAll"); 
        
        List<CompteUtilisateur> liste = (List<CompteUtilisateur>)q.getResultList(); 
        
        for (CompteUtilisateur a: liste){
            System.out.println(a.toString());
        }
        em.close(); 
        return liste; 
    }
    
    public static Object selectCompteUtilisateurByEmail(String email) {
        
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("CompteUtilisateur.findByEmailPerso"); 
        System.out.println("(AccessBD.selectCptUByEmail) Query = "+q);
        q.setParameter("emailPerso", email); 
        System.out.println("(AccessBD.selectCptUByEmail) Query + parameter = "+q.getParameterValue("emailPerso"));
        try{
            CompteUtilisateur cpt = (CompteUtilisateur)q.getSingleResult(); 
            em.close(); 
            return cpt; 
        } catch(NoResultException e) {
            em.close(); 
            return null;
        }        
    }
    
    
    public static CompteUtilisateur selectCompteUtilisateurByID(int idCompteUtilisateur) {   
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("CompteUtilisateur.findByIdcompteUtilisateur"); 
        q.setParameter("idcompteUtilisateur", idCompteUtilisateur); 
        try{
            CompteUtilisateur cpt = (CompteUtilisateur)q.getSingleResult(); 
            em.close(); 
            return cpt; 
        } catch(NoResultException e) {
            em.close(); 
            return null;
        }          
    }
        public static void deleteCompteutilisateur(CompteUtilisateur emp)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NoeWebAppPU");
        EntityManager em = emf.createEntityManager();
        String QueryStr = "DELETE From CompteUtilisateur WHERE idcompteUtilisateur = " + emp.getIdcompteUtilisateur();

        EntityTransaction t = em.getTransaction(); 
        t.begin();
        try {
            Query q = em.createQuery(QueryStr);
            int updateCount = q.executeUpdate();
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
            t.rollback();
        } finally {
            em.close();
        }
    } 
     
    /////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////// Salarié /////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
     
    public static List<Salarié> selectAllSalariés(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Salari\u00e9.findAll"); 
        
        List<Salarié> liste = (List<Salarié>)q.getResultList(); 
        
        for (Salarié a: liste){
            System.out.println(a.toString());
        }
        em.close(); 
        return liste; 
    } 
    public static Salarié selectSalariéByIdCompteUtilisateur(int idCompteUtilisateur){        
        List<Salarié> liste = AccessBD.selectAllSalariés(); 

        for(Salarié sal : liste){
           // System.out.println("::::!!!!!!!!:::::::::::"+sal.getCompteUtilisateuridcompteUtilisateur().getIdcompteUtilisateur());
            if (sal.getCompteUtilisateuridcompteUtilisateur().getIdcompteUtilisateur()
                     == idCompteUtilisateur)return sal; 
        }
        return null; 
    }
        
    /////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////// Role /////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
    
    public static List<Role> selectAllRoles(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Role.findAll"); 
        
        List<Role> liste = (List<Role>)q.getResultList(); 
        
        for (Role a: liste){
            System.out.println(a.toString());
        }
        em.close(); 
        return liste; 
    } 
    
    public static Role selectRoleByID(int id) {
        
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Role.findByIdRole"); 
        q.setParameter("idRole", id); 
        try{
            Role role = (Role)q.getSingleResult(); 
            em.close(); 
            return role; 
        } catch(NoResultException e) {
            em.close(); 
            return null;
        }        
    }
    public static Role selectRoleByName(String nom) {
        
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Role.findByNomRole"); 
        q.setParameter("nomRole", nom); 
        try{
            Role role = (Role)q.getSingleResult(); 
            em.close(); 
            return role; 
        } catch(NoResultException e) {
            em.close(); 
            return null;
        }        
    }
     
    /////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////// Droit /////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
    
    public static List<Droit> selectAllDroits(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Droit.findAll"); 
        
        List<Droit> liste = (List<Droit>)q.getResultList(); 
        
        for (Droit a: liste){
            System.out.println(a.toString());
        }
        em.close(); 
        return liste; 
    }     
    public static Droit selectDroitByName(String nomDroit){
            
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Droit.findByNomDroit"); 
        q.setParameter("nomDroit", nomDroit); 
        try{
            Droit droit = (Droit)q.getSingleResult(); 
            em.close(); 
            return droit; 
        } catch(NoResultException e) {
            em.close(); 
            return null;
        }        
    }
    /////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////// role_has_droit /////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     /*
    table has two columns: Role_idRole, Droit_idDroit , both values used for primary key. 
    */
    
    public static List<Droit> selectAllDroitsByRole(Role role){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery(
                "select * from role_has_droit where role_idrole = "+role.getIdRole()); 
        
        List<Droit> liste = (List<Droit>)q.getResultList(); 
        
        for (Droit a: liste){
            System.out.println(a.toString());
        }
        em.close(); 
        return liste; 
    } 
    
    public static List<Role> selectAllRolesByDroit(Droit droit){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery(
                "select * from role_has_droit where droit_iddroit = "+droit.getIdDroit()); 
        
        List<Role> liste = (List<Role>)q.getResultList(); 
        
        for (Role a: liste){
            System.out.println(a.toString());
        }
        em.close(); 
        return liste; 
    } 
    
    public static Boolean roleHasDroit(Role role, String droit){
        List <Droit> liste = selectAllDroitsByRole(role); 
        System.out.println("DDDDDDDDDDD Liste droits DDDDDDDDDD : "+ liste);
        
        for (Droit d : liste){
            if(d.getNomDroit() != null && d.getNomDroit().equals(droit))return true; 
        }
        return false; 
    }
    
    /////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////  Alerte  ///////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
    
    public static List<Projet> selectAllProjets(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Projet.findAll"); 
        
        List<Projet> liste = (List<Projet>)q.getResultList(); 
        
        for (Projet a: liste){
            System.out.println(a.toString());
        }
        em.close(); 
        return liste; 
    }       
    public static Projet selectProjetById(int id){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Projet.findByIdprojet"); 
        q.setParameter("idprojet", id); 
        try{
        Projet al = (Projet)q.getSingleResult(); 
        em.close(); 
        return al; }
        catch(NoResultException e){
            e.printStackTrace();
            em.close();
            return null; 
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////
    //              Espece
    ////////////////////////////////////////////////////////////////////////////////////
    
     public static List<Espece> selectAllEspeces(){
                EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Espece.findAll"); 
        
        List<Espece> liste = (List<Espece>)q.getResultList(); 
        
        for (Espece a: liste){
            System.out.println(a.toString());
        }
        em.close(); 
        return liste; 
    }
    public static Espece selectEspeceByID(int idespece) {
            EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Espece.findByIdespece"); 
        q.setParameter("idespece", idespece); 
        
        try{
            Espece al = (Espece)q.getSingleResult(); 
            em.close(); 
            return al;
        }
        catch(NoResultException e){
            em.close();
            e.printStackTrace();
            return null;
        }
    
    }
    public static Espece selectEspeceByName(String nom_espece) {
            EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Espece.findByNom"); 
        q.setParameter("nom", nom_espece); 
        
        try{
            Espece al = (Espece)q.getSingleResult(); 
            em.close(); 
            return al; 
        }
        catch(NoResultException e){
            em.close();
            e.printStackTrace();
            return null;
        }
    
    }
    ////////////////////////////////////////////////////////////////////////////////////
    //              Etat
    ////////////////////////////////////////////////////////////////////////////////////
    public static Etat selectEtatByDescription(String description) {
            EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Etat.findByDescription"); 
        q.setParameter("description", description); 
        
        try{
        Etat al = (Etat)q.getSingleResult(); 
            em.close(); 
            return al; 
        }
        catch(NoResultException e){
            em.close();
            e.printStackTrace();
            return null;
        }
    
    }

    ////////////////////////////////////////////////////////////////////////////////////
    //              Taxinomie
    ////////////////////////////////////////////////////////////////////////////////////
    
    public static Taxinomie selectTaxinomieByName(String nomTaxinomie) {
                EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Taxinomie.findByNom"); 
        q.setParameter("nom", nomTaxinomie); 
        
        try{
        Taxinomie al = (Taxinomie)q.getSingleResult(); 
            em.close(); 
            return al; 
        }
        catch(NoResultException e){
            em.close();
            e.printStackTrace();
            return null;
        }
    
    }

    ////////////////////////////////////////////////////////////////////////////////////
    //              SiteDeStokage
    ////////////////////////////////////////////////////////////////////////////////////
    
    public static List<SiteDeStokage> selectAllSiteDeStokages(){
                EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("SiteDeStokage.findAll"); 
        
        List<SiteDeStokage> liste = (List<SiteDeStokage>)q.getResultList(); 
        
        for (SiteDeStokage a: liste){
            System.out.println(a.toString());
        }
        em.close(); 
        return liste; 
    }
    
    public static SiteDeStokage selectSiteDeStokageByID(int idSiteDeStokage) {
            EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("SiteDeStokage.findByIdSiteDeStokage"); 
        q.setParameter("idSiteDeStokage", idSiteDeStokage); 
        
        try{
            SiteDeStokage al = (SiteDeStokage)q.getSingleResult(); 
            em.close(); 
            return al;
        }
        catch(NoResultException e){
            em.close();
            e.printStackTrace();
            return null;
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////////////
    //              LotDeSemence
    ////////////////////////////////////////////////////////////////////////////////////
    
    public static List<LotDeSemence> selectAllLotsDeSemences(){
                EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("LotDeSemence.findAll"); 
        
        List<LotDeSemence> liste = (List<LotDeSemence>)q.getResultList(); 
        
        for (LotDeSemence a: liste){
            System.out.println(a.toString());
        }
        em.close(); 
        return liste; 
    }
    
    ////////////////////////////////////////////////////////////////////////////////////
    //              LotDeSemence
    ////////////////////////////////////////////////////////////////////////////////////
    
    public static List<Taxinomie> selectAllTaxinomies(){
                EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Taxinomie.findAll"); 
        
        List<Taxinomie> liste = (List<Taxinomie>)q.getResultList(); 
        
        for (Taxinomie a: liste){
            System.out.println(a.toString());
        }
        em.close(); 
        return liste; 
    }
////////////////////////////////////////////////////////////////////////////////////
    //              sentinelle
    ////////////////////////////////////////////////////////////////////////////////////
    
    public static List<Sentinelle> selectAllSentinelles() {
         EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Sentinelle.findAll"); 
        
        List<Sentinelle> liste = (List<Sentinelle>)q.getResultList(); 
        
        for (Sentinelle a: liste){
            System.out.println(a.toString());
        }
        em.close(); 
        return liste; 
    }
////////////////////////////////////////////////////////////////////////////////////
    //              Etat
    ////////////////////////////////////////////////////////////////////////////////////
    
    public static List<Etat> selectAllEtats() {
         EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Etat.findAll"); 
        
        List<Etat> liste = (List<Etat>)q.getResultList(); 
        
        for (Etat a: liste){
            System.out.println(a.toString());
        }
        em.close(); 
        return liste; 
    }
   
////////////////////////////////////////////////////////////////////////////////////
    //              Salle
    ////////////////////////////////////////////////////////////////////////////////////
    
    public static List<Salle> selectAllSalles(){
         EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Salle.findAll"); 
        
        List<Salle> liste = (List<Salle>)q.getResultList(); 
        
        for (Salle a: liste){
            System.out.println(a.toString());
        }
        em.close(); 
        return liste;         
    }
    
    public static Salle selectSalleByID(int idSalle) {
            EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Salle.findByIdSalle"); 
        q.setParameter("idSalle", idSalle); 
        
        try{
            Salle al = (Salle)q.getSingleResult(); 
            em.close(); 
            return al;
        }
        catch(NoResultException e){
            em.close();
            e.printStackTrace();
            return null;
        }
    
    }
    
    ///////////////////////////////////////////////////////
    // Semences
    ///////////////////////////////////////////////////////////
    public static List<Semence> selectAllsSemences(){
         EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Semence.findAll"); 
        
        List<Semence> liste = (List<Semence>)q.getResultList(); 
        
        for (Semence a: liste){
            System.out.println(a.toString());
        }
        em.close(); 
        return liste;           
    }
    
    public static Semence selectSemenceByID(int idsemence) {
            EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Semence.findByIdsemence"); 
        q.setParameter("idsemence", idsemence); 
        
        try{
            Semence al = (Semence)q.getSingleResult(); 
            em.close(); 
            return al;
        }
        catch(NoResultException e){
            em.close();
            e.printStackTrace();
            return null;
        }
    }
}