/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.projet;

import entities.Alerte;
import entities.CompteUtilisateur;
import entities.Equipe;
import entities.Espece;
import entities.Etat;
import entities.Projet;
import entities.Salarié;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AccessBD;
import model.AppStrings;

/**
 *
 * @author ADZOH-VINYO DIANA
 */
@WebServlet(name = "CreateProjectServlet", urlPatterns = {"/create-project"})
public class CreateProjectServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateProjectServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateProjectServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(); 
        session.setAttribute("textError", "");
        RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/create-project.jsp"); 
        disp.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/create-project.jsp"); 

        Boolean creationPossible = false; 
        
        HttpSession session = request.getSession(); 
        session.setAttribute("textError", "");
        //ID
        Projet projet = new Projet(0); 
        //alerte associée
        Alerte alerte = AccessBD.selectALertsById(Integer.parseInt(request.getParameter("alerte"))); 
        projet.setAlerteIdalerte(alerte);
        //etat
        Etat etat = AccessBD.selectEtatByDescription(request.getParameter("etat"));
            projet.setEtatIdetat(etat);
         
        
        //demandeur
        Salarié demandeur = AccessBD.selectSalariéByIdCompteUtilisateur(
                    ((CompteUtilisateur)AccessBD.selectCompteUtilisateurByEmail(
                            session.getAttribute(AppStrings.SESSION_ATTRIBUTE_EMAIL).toString()))
            .getIdcompteUtilisateur()); 
        projet.setDemandeurIdsalarie(demandeur);
        
        //nom
        if (request.getParameter("nom_projet") != null && !request.getParameter("nom_projet").isEmpty()){
            projet.setNom(request.getParameter("nom_projet"));
        }else {
            session.setAttribute("textError", "Veuillez renseigner le nom du projet");
        }    
        //narrteur
        if(request.getParameter("email_narrateur") != null && !request.getParameter("email_narrateur").isEmpty()){
            String email = request.getParameter("email_narrateur");   
            CompteUtilisateur cpt = ((CompteUtilisateur)AccessBD.selectCompteUtilisateurByEmail(email));
            if (cpt != null) {
                int id = cpt.getIdcompteUtilisateur();
                Salarié narrateur = AccessBD.selectSalariéByIdCompteUtilisateur(id); 
                projet.setNarrateurIdsalarie(narrateur);
            }else{
                projet.setNarrateurIdsalarie(null);
            }

        }else{
            session.setAttribute("textError", "Narrateur invalide");
        }
        
        //date debut
        if (request.getAttribute("date_debut_projet") != null){
            Date dateDebut = (Date)request.getAttribute("date_debut_projet");
            projet.setDateDebut(dateDebut);
        } else {
            session.setAttribute("textError", "Veuillez renseigner la date du projet");
        }
        
        // Tests finaux
        if (projet.getNarrateurIdsalarie() == null){
            session.setAttribute("textError", "Narrateur invalide");            
        }
        else if(projet.getDateDebut() != null){
            session.setAttribute("textError", "Veuillez renseigner la date du projet");            
        }
        else{
            
            Boolean projetAssociéExistant = false; 
            for (Projet p : AccessBD.selectAllProjets()){
                if(projet.getAlerteIdalerte().equals(p.getAlerteIdalerte())){
                    projetAssociéExistant = true; 
                    session.setAttribute("textError", "Il existe dejà un projet associé à cette alerte");   
                    break; 
                }
            }
            if(!projetAssociéExistant){
                session.setAttribute("textError", "");
                Equipe equipe = new Equipe(0); 
                equipe.setNom("Equipe projet "+projet.getNom());
                projet.setEquipeIdequipe(equipe);

                if(AccessBD.persist(equipe)) {
                    creationPossible = true;
                }
            }
        }
        
        if(creationPossible){
            if(AccessBD.persist(projet)) 
                disp = request.getRequestDispatcher("/WEB-INF/confirmation-creation-projet.jsp");
        }
        disp.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
