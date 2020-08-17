/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Accountstobeconfirmed;
import entities.Alerte;
import entities.Classe;
import entities.Coderesetpassword;
import entities.Compteutilisateur;
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
            //}
        }
        catch(Exception e){
            e.printStackTrace();
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
        }
        finally{
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
        
        Query q = em.createNamedQuery("Accountstobeconfirmed.findByCode"); 
        q.setParameter("code", code); 
        try{
        Accountstobeconfirmed al = (Accountstobeconfirmed)q.getSingleResult(); 
        em.close(); 
            return al; 
        } catch(NoResultException e) {
            em.close(); 
            return null;
        }        
    }
    public static Object deleteAccounttobeconfirmed(Accountstobeconfirmed act){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NoeWebAppPU");
        EntityManager em = emf.createEntityManager();
        String QueryStr = "DELETE From Accountstobeconfirmed where code ='" + act.getCode()+"'";

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
        q.setParameter("id", id); 
        
        Alerte al = (Alerte)q.getSingleResult(); 
        em.close(); 
        return al; 
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
     
    
    public static List<Coderesetpassword> selectAllCodeResetPassword(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Coderesetpassword.findAll"); 
        
        List<Coderesetpassword> liste = (List<Coderesetpassword>)q.getResultList(); 
        
        for (Coderesetpassword a: liste){
            System.out.println(a.toString());
        }
        em.close(); 
        return liste; 
    }
    
    public static void deleteCoderesetpassword(Coderesetpassword reset) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NoeWebAppPU");
        EntityManager em = emf.createEntityManager();
        String QueryStr = "DELETE From Coderesetpassword WHERE idCodeResetPassword = '" + reset.getIdCodeResetPassword() +"'";

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
        
        Query q = em.createNamedQuery("Coderesetpassword.findByIdCodeResetPassword"); 
        q.setParameter("idCodeResetPassword", id); 
        try{
            Coderesetpassword cpt = (Coderesetpassword)q.getSingleResult(); 
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
     
    
    public static List<Compteutilisateur> selectAllCompteutilisateurs(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Compteutilisateur.findAll"); 
        
        List<Compteutilisateur> liste = (List<Compteutilisateur>)q.getResultList(); 
        
        for (Compteutilisateur a: liste){
            System.out.println(a.toString());
        }
        em.close(); 
        return liste; 
    }
    
    public static Object selectCompteUtilisateurByEmail(String email) {
        
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Compteutilisateur.findByEmailPerso"); 
        q.setParameter("emailPerso", email); 
        try{
            Compteutilisateur cpt = (Compteutilisateur)q.getSingleResult(); 
            em.close(); 
            return cpt; 
        } catch(NoResultException e) {
            em.close(); 
            return null;
        }        
    }
        public static void deleteCompteutilisateur(Compteutilisateur emp)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NoeWebAppPU");
        EntityManager em = emf.createEntityManager();
        String QueryStr = "DELETE From Compteutilisateur WHERE idcompteUtilisateur = " + emp.getIdcompteUtilisateur();

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
        System.out.println("::::!!!!!!!!::::::::::: liste salaries by compte utilisateur"+liste);

        for(Salarié sal : liste){
            System.out.println("::::!!!!!!!!:::::::::::"+sal.getCompteUtilisateuridcompteUtilisateur().getIdcompteUtilisateur());

            if (sal.getCompteUtilisateuridcompteUtilisateur().getIdcompteUtilisateur()
                    .equals(idCompteUtilisateur))return sal; 
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
}