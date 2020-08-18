/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.CompteUtilisateur;
import entities.Droit;
import entities.Role;
import entities.Salarié;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "SingInServlet", urlPatterns = {"/signin"})
public class SingInServlet extends HttpServlet {

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
            out.println("<title>Servlet SingInServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SingInServlet at " + request.getContextPath() + "</h1>");
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
        RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/signin.jsp"); 
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
        //error page prep
        RequestDispatcher pageToDisplay = request.getRequestDispatcher("/WEB-INF/signin.jsp"); 
        
        //session
        HttpSession session = request.getSession();
        session.setAttribute("textError", "" );
        //getting parameters
        String email = request.getParameter("session_email"); 
        String mdp = request.getParameter("session_mdp");
        
        if (email!=null && mdp != null){
            //getting users list
            List<CompteUtilisateur> listeUsers = AccessBD.selectAllCompteutilisateurs(); 

            Boolean userExists = false; 
            Boolean psswdIsCorrect = false; 
            for (CompteUtilisateur cpt : listeUsers){
                if (cpt.getEmailPerso().equals(email)){
                    userExists = true;                 
                }
                if (cpt.getMdp().equals(mdp)){
                    psswdIsCorrect = true;
                }
                if(userExists && psswdIsCorrect) break;
            }
            if (!userExists)session.setAttribute("textError", "Email invalide" );
            else if (userExists && !psswdIsCorrect)
                session.setAttribute("textError", "Mot de passe Incorrect" );
            else {                
                session.setAttribute("session_email", email);
                session.setAttribute("session_mdp", mdp);
                session.setAttribute("ambpambp", mdp);
                //getting rights
                CompteUtilisateur cpt = (CompteUtilisateur) AccessBD.selectCompteUtilisateurByEmail(email); 
                System.out.println("::::!!!!!!!!:::::::::::"+cpt.getIdcompteUtilisateur());
                Salarié salarié = AccessBD.selectSalariéByIdCompteUtilisateur(cpt.getIdcompteUtilisateur());
                System.out.println("::::!!!!!!!!:::::::::::"+salarié);

                if(salarié == null) {
                    Role role = AccessBD.selectRoleByName(AppStrings.NOM_ROLE_ABONNE); 
                    session.setAttribute("ambpambp", role.getIdRole());
                session.setAttribute("textError", role.getNomRole() );
                }else{
                    session.setAttribute("ambpambp", salarié.getRoleidRole().getIdRole());  
                session.setAttribute("textError", salarié.getRoleidRole().getNomRole() );                  
                }
                
                //user interface page prep
                //pageToDisplay = request.getRequestDispatcher("/WEB-INF/?.jsp"); 
            }
            pageToDisplay.forward(request, response);
            }
        else{
            session.setAttribute("textError", "Veuillez entrer toutes les informations" );
        }

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
