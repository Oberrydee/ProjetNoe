/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.alerte;

import entities.Alerte;
import entities.CompteUtilisateur;
import entities.Embranchement;
import entities.Espece;
import entities.Regne;
import entities.Salarié;
import entities.Sentinelle;
import entities.Taxinomie;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "CreateAlerteServlet", urlPatterns = {"/create-alert"})
public class CreateAlerteServlet extends HttpServlet {

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
            out.println("<title>Servlet CreateAlerteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateAlerteServlet at " + request.getContextPath() + "</h1>");
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
            throws ServletException, IOException {   HttpSession session = request.getSession(); 
        
        session.setAttribute("textError", "");
        RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/create-alert.jsp"); 
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
        RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/confirmation-creation-alerte.jsp");
        HttpSession session = request.getSession(); 
        
        String nom_espece = request.getParameter("espece"); 
        Espece espece = AccessBD.selectEspeceByName(nom_espece); 
        
        Alerte alerte = new Alerte();         
        alerte.setIdalerte(alerte.hashCode());
        alerte.setEspeceIdespece(espece);         
        alerte.setUrgence(Integer.parseInt(request.getParameter("urgence")));
        List <Sentinelle> list = AccessBD.selectAllSentinelles(); 
        Sentinelle sentinelle = null; 
        for (Sentinelle s : list){
            Salarié salarié = AccessBD.selectSalariéByIdCompteUtilisateur(
                    ((CompteUtilisateur)AccessBD.selectCompteUtilisateurByEmail(
                            session.getAttribute(AppStrings.SESSION_ATTRIBUTE_EMAIL).toString()))
            .getIdcompteUtilisateur());
            System.out.println("Role salarie : " +s.getSalariéidSalarié().getRoleidRole().getNomRole()); 
            System.out.println("role session : " +salarié.getRoleidRole().getNomRole()); 
            System.out.println("Salarié email : " +s.getSalariéidSalarié().getEmailPro()); 
            System.out.println("session email : " +session.getAttribute(AppStrings.SESSION_ATTRIBUTE_EMAIL).toString()); 
            if (s.getSalariéidSalarié().getRoleidRole().getNomRole().equals(AppStrings.NOM_ROLE_SENTINELLE)){
                sentinelle = s; 
                break; 
            }
        }
        if (sentinelle == null){
            disp = request.getRequestDispatcher("/WEB-INF/Error_access_denied.html"); 
        }
        else{
            alerte.setSentinelleIdsentinelle(sentinelle);
            if (!AccessBD.persist(alerte)){
            disp = request.getRequestDispatcher("/WEB-INF/Error.html"); 
            }
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
