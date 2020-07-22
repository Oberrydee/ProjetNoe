/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Alerte;
import entities.Classe;
import entities.Compteutilisateur;
import entities.Contact;
import entities.Embranchement;
import entities.Equipe;
import entities.Espece;
import entities.Famille;
import entities.Lotdesemence;
import entities.Ordre;
import entities.Projet;
import entities.Regne;
import entities.Salarié;
import entities.Semence;
import entities.Sentinelle;
import entities.Session;
import entities.Sitedestokage;
import entities.Taxinomie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
    
      public static void persist(Object object){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        em.getTransaction().begin();
        
        try{
            em.persist(object); 
            em.getTransaction().commit(); 
        }
        catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        finally{
            em.close(); 
        }
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
        return liste; 
    }       
    public static Alerte selectALertsById(int id){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Alerte.findById"); 
        q.setParameter("id", id); 
        
        Alerte al = (Alerte)q.getSingleResult(); 
        return al; 
    }
    
    public static void deleteAlerte(Alerte emp)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NoeWebAppPU");
        EntityManager em = emf.createEntityManager();
        String QueryStr = "DELETE From Alerte WHERE id =" + emp.getIdalerte();

        em.getTransaction().begin();
        try {
            Query q = em.createQuery(QueryStr);
            int updateCount = q.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
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
        return liste; 
    }       
    
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////// Compteutilisateur ///////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
    
    public static List<Compteutilisateur> selectAllCompteUtilisateurs(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Compteutilisateur.findAll"); 
        
        List<Compteutilisateur> liste = (List<Compteutilisateur>)q.getResultList(); 
        
        for (Compteutilisateur a: liste){
            System.out.println(a.toString());
        }
        return liste; 
    }      
    
         
    public static Compteutilisateur selectCompteUtilisateursByid(int id){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Compteutilisateur.findById"); 
        q.setParameter("id", id); 
        
        Compteutilisateur al = (Compteutilisateur)q.getSingleResult(); 
        return al; 
    }
    
        public static void deleteCompteutilisateur(Compteutilisateur emp)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NoeWebAppPU");
        EntityManager em = emf.createEntityManager();
        String QueryStr = "DELETE From Compteutilisateur WHERE id =" + emp.getIdcompteUtilisateur();

        em.getTransaction().begin();
        try {
            Query q = em.createQuery(QueryStr);
            int updateCount = q.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////// Contact /////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
     
    public static List<Contact> selectAllContacts(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Contact.findAll"); 
        
        List<Contact> liste = (List<Contact>)q.getResultList(); 
        
        for (Contact a: liste){
            System.out.println(a.toString());
        }
        return liste; 
    }       

    /////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////Embranchement/////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
    
    public static List<Embranchement> selectAllEmbranchements(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Embranchement.findAll"); 
        
        List<Embranchement> liste = (List<Embranchement>)q.getResultList(); 
        
        for (Embranchement a: liste){
            System.out.println(a.toString());
        }
        return liste; 
    }       
    
             
    public static Embranchement selectEmbranchementsByid(int id){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Embranchement.findById"); 
        q.setParameter("id", id); 
        
        Embranchement al = (Embranchement)q.getSingleResult(); 
        return al; 
    }
    
    
        public static void deleteEmbranchement(Embranchement emp)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NoeWebAppPU");
        EntityManager em = emf.createEntityManager();
        String QueryStr = "DELETE From Embranchement WHERE id =" + emp.getIdembranchement();

        em.getTransaction().begin();
        try {
            Query q = em.createQuery(QueryStr);
            int updateCount = q.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////    Equipe     ////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
    
    public static List<Equipe> selectAllEquipes(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Equipe.findAll"); 
        
        List<Equipe> liste = (List<Equipe>)q.getResultList(); 
        
        for (Equipe a: liste){
            System.out.println(a.toString());
        }
        return liste; 
    }       
    
    /////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////  Espece       //////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
    
    public static List<Espece> selectAllEspeces(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Espece.findAll"); 
        
        List<Espece> liste = (List<Espece>)q.getResultList(); 
        
        for (Espece a: liste){
            System.out.println(a.toString());
        }
        return liste; 
    }       
    
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////   Famille   ///////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
    
    public static List<Famille> selectAllFamilles(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Famille.findAll"); 
        
        List<Famille> liste = (List<Famille>)q.getResultList(); 
        
        for (Famille a: liste){
            System.out.println(a.toString());
        }
        return liste; 
    }       
    
    /////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////   Lot de semence    /////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
    
    public static List<Lotdesemence> selectAllLotdesemences(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Lotdesemence.findAll"); 
        
        List<Lotdesemence> liste = (List<Lotdesemence>)q.getResultList(); 
        
        for (Lotdesemence a: liste){
            System.out.println(a.toString());
        }
        return liste; 
    }       
    
    /////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////     Ordre      //////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
    
    public static List<Ordre> selectAllOrdres(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Ordre.findAll"); 
        
        List<Ordre> liste = (List<Ordre>)q.getResultList(); 
        
        for (Ordre a: liste){
            System.out.println(a.toString());
        }
        return liste; 
    }    
    
    /////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////   Projet   ///////////////////////////////////
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
        return liste; 
    }       
    
    /////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////    Projet    ////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
    
    public static List<Regne> selectAllRegnes(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Regne.findAll"); 
        
        List<Regne> liste = (List<Regne>)q.getResultList(); 
        
        for (Regne a: liste){
            System.out.println(a.toString());
        }
        return liste; 
    }       
    
    /////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////    Regne   ///////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
    
    public static List<Salarié> selectAllSalariés(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Salarié.findAll"); 
        
        List<Salarié> liste = (List<Salarié>)q.getResultList(); 
        
        for (Salarié a: liste){
            System.out.println(a.toString());
        }
        return liste; 
    }       
    
    /////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////  Salarié  ////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
    
    public static List<Semence> selectAllSemences(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Semence.findAll"); 
        
        List<Semence> liste = (List<Semence>)q.getResultList(); 
        
        for (Semence a: liste){
            System.out.println(a.toString());
        }
        return liste; 
    }       
                 
    public static Semence selectSemenceByid(int id){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Semence.findById"); 
        q.setParameter("id", id); 
        
        Semence al = (Semence)q.getSingleResult(); 
        return al; 
    }
      
        public static void deleteSemence(Semence emp)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NoeWebAppPU");
        EntityManager em = emf.createEntityManager();
        String QueryStr = "DELETE From Semence WHERE id =" + emp.getIdsemence();

        em.getTransaction().begin();
        try {
            Query q = em.createQuery(QueryStr);
            int updateCount = q.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    /////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////   Semence   //////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
    
    public static List<Sentinelle> selectAllSentinelles(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Sentinelle.findAll"); 
        
        List<Sentinelle> liste = (List<Sentinelle>)q.getResultList(); 
        
        for (Sentinelle a: liste){
            System.out.println(a.toString());
        }
        return liste; 
    }       
                 
    public static Sentinelle selectSentinelleByid(int id){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Sentinelle.findById"); 
        q.setParameter("id", id); 
        
        Sentinelle al = (Sentinelle)q.getSingleResult(); 
        return al; 
    }
    
        public static void deleteSentinelle(Sentinelle emp)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NoeWebAppPU");
        EntityManager em = emf.createEntityManager();
        String QueryStr = "DELETE From Sentinelle WHERE id =" + emp.getIdsentinelle();

        em.getTransaction().begin();
        try {
            Query q = em.createQuery(QueryStr);
            int updateCount = q.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    /////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////    Sentinelle  /////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
    
    public static List<Session> selectAllSessions(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Session.findAll"); 
        
        List<Session> liste = (List<Session>)q.getResultList(); 
        
        for (Session a: liste){
            System.out.println(a.toString());
        }
        return liste; 
    }   
    
    /////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////Site de stokage //////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
    public static List<Sitedestokage> selectAllSitedestokages(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Sitedestokage.findAll"); 
        
        List<Sitedestokage> liste = (List<Sitedestokage>)q.getResultList(); 
        
        for (Sitedestokage a: liste){
            System.out.println(a.toString());
        }
        return liste; 
    }    
    
                 
    public static Sitedestokage selectSitedestokageByid(int id){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Sitedestokage.findById"); 
        q.setParameter("id", id); 
        
        Sitedestokage al = (Sitedestokage)q.getSingleResult(); 
        return al; 
    }
            public static void deleteSitedestokage(Sitedestokage emp)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NoeWebAppPU");
        EntityManager em = emf.createEntityManager();
        String QueryStr = "DELETE From Sitedestokage WHERE id =" + emp.getIdSiteDeStokage();

        em.getTransaction().begin();
        try {
            Query q = em.createQuery(QueryStr);
            int updateCount = q.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    /////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////   Taxinomie    ///////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    
    public static List<Taxinomie> selectAllTaxinomies(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Taxinomie.findAll"); 
        
        List<Taxinomie> liste = (List<Taxinomie>)q.getResultList(); 
        
        for (Taxinomie a: liste){
            System.out.println(a.toString());
        }
        return liste; 
    }
    
}
