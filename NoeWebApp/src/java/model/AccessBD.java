/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Alerte;
import entities.Classe;
import entities.CodePourConfirmation;
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
        }
        finally{
            em.close(); 
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////  CodePourCOnfirmation  ///////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
    
    public static List<CodePourConfirmation> selectAllCodePourConfirmations(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("CodePourConfirmation.findAll"); 
        
        List<CodePourConfirmation> liste = (List<CodePourConfirmation>)q.getResultList(); 
        
        for (CodePourConfirmation a: liste){
            System.out.println(a.toString());
        }
        em.close(); 
        return liste; 
    }    
    
    
    public static List<CompteUtilisateur> getCodePourConfirmationByNomCode(String email){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("CompteUtilisateur.findByNomcodePourConfirmation"); 
        List<CompteUtilisateur> cpt = (List<CompteUtilisateur>)q.getResultList(); 
        
        em.close(); 
        return cpt;
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
    /*
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
*/
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
     
    
    public static List<CompteUtilisateur> selectAllCompteUtilisateurs(){
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
    
    public static List<CompteUtilisateur> getCompteUtilisateurByEmail(String email){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("CompteUtilisateur.findByEmailPerso"); 
        List<CompteUtilisateur> cpt = (List<CompteUtilisateur>)q.getResultList(); 
        
        em.close(); 
        return cpt;
    }
    
        public static void deleteCompteutilisateur(CompteUtilisateur emp)
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
    ///////////////////////////////////////Droit/////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
    
    public static List<Droit> selectAllEmbranchements(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Droit.findAll"); 
        
        List<Droit> liste = (List<Droit>)q.getResultList(); 
        
        for (Droit a: liste){
            System.out.println(a.toString());
        }
        return liste; 
    }       
    
             
    public static Droit selectEmbranchementsByid(int id){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Droit.findById"); 
        q.setParameter("id", id); 
        
        Droit al = (Droit)q.getSingleResult(); 
        return al; 
    }
    
    
        public static void deleteEmbranchement(Droit emp)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NoeWebAppPU");
        EntityManager em = emf.createEntityManager();
        String QueryStr = "DELETE From Embranchement WHERE id =" + emp.getIdDroit();

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
    ////////////////////////////////////  Taxinomie     //////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
    
    public static List<Taxinomie> selectAllTaxinomie(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("EspèceTaxinomie.findAll"); 
        
        List<Taxinomie> liste = (List<Taxinomie>)q.getResultList(); 
        
        for (Taxinomie a: liste){
            System.out.println(a.toString());
        }
        return liste; 
    }       
       
        
    /////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////  Etat     //////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
    
    public static List<Etat> selectAllEtats(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Etat.findAll"); 
        
        List<Etat> liste = (List<Etat>)q.getResultList(); 
        
        for (Etat a: liste){
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
    ////////////////////////////////////  Forme     //////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
    
    public static List<Forme> selectAllFormes(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Forme.findAll"); 
        
        List<Forme> liste = (List<Forme>)q.getResultList(); 
        
        for (Forme a: liste){
            System.out.println(a.toString());
        }
        return liste; 
    }       
       
        
    /////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////  Genre     //////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
    
    public static List<Genre> selectAllGenres(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Genre.findAll"); 
        
        List<Genre> liste = (List<Genre>)q.getResultList(); 
        
        for (Genre a: liste){
            System.out.println(a.toString());
        }
        return liste; 
    }       
    
    /////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////   Lot de semence    /////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
    
    public static List<LotDeSemence> selectAllLotdesemences(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Lotdesemence.findAll"); 
        
        List<LotDeSemence> liste = (List<LotDeSemence>)q.getResultList(); 
        
        for (LotDeSemence a: liste){
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
    ///////////////////////////////////////    Regne    ////////////////////////////////
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
    ////////////////////////////////////  Role     //////////////////////////////////
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
        return liste; 
    }    
    
    /////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////    Salarie   ///////////////////////////////
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
    ////////////////////////////////////  Role     //////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
    
    public static List<Section> selectAllSections(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Section.findAll"); 
        
        List<Section> liste = (List<Section>)q.getResultList(); 
        
        for (Section a: liste){
            System.out.println(a.toString());
        }
        return liste; 
    }    
    
    /////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////  Semence  ////////////////////////////
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
    //////////////////////////////////////////////   Sentinelle   //////////////////////////
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
    ///////////////////////////////////////////Site de stokage //////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
    public static List<SiteDeStokage> selectAllSitedestokages(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Sitedestokage.findAll"); 
        
        List<SiteDeStokage> liste = (List<SiteDeStokage>)q.getResultList(); 
        
        for (SiteDeStokage a: liste){
            System.out.println(a.toString());
        }
        return liste; 
    }    
    
                 
    public static SiteDeStokage selectSitedestokageByid(int id){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Sitedestokage.findById"); 
        q.setParameter("id", id); 
        
        SiteDeStokage al = (SiteDeStokage)q.getSingleResult(); 
        return al; 
    }
            public static void deleteSitedestokage(SiteDeStokage emp)
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
    ////////////////////////////////////  Role     //////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
    
    public static List<Série> selectAllSéries(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Série.findAll"); 
        
        List<Série> liste = (List<Série>)q.getResultList(); 
        
        for (Série a: liste){
            System.out.println(a.toString());
        }
        return liste; 
    }    
    /////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////   Tribu    ///////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    
    public static List<Tribu> selectAllTribus(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Tribu.findAll"); 
        
        List<Tribu> liste = (List<Tribu>)q.getResultList(); 
        
        for (Tribu a: liste){
            System.out.println(a.toString());
        }
        return liste; 
    }
    
        
    /////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////  Variété     //////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
     
    
    public static List<Variété> selectAllVariétés(){
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("NoeWebAppPU"); 
        EntityManager em = emf.createEntityManager(); 
        
        Query q = em.createNamedQuery("Variété.findAll"); 
        
        List<Variété> liste = (List<Variété>)q.getResultList(); 
        
        for (Variété a: liste){
            System.out.println(a.toString());
        }
        return liste; 
    }    
    
}
