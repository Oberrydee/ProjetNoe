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
    public static Object getAccountstobeconfirmedBycode(String code) {
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
    
    public static Object getCoderesetpasswordByID(String id) {
        
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
    
    public static Object getCompteUtilisateurByEmail(String email) {
        
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

}