/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.CompteUtilisateur;
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

/**
 *
 * @author ADZOH-VINYO DIANA
 */
@WebServlet(name = "Home", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

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
            out.println("<title>Servlet Home</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Home at " + request.getContextPath() + "</h1>");
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
        
        //session
        HttpSession session = request.getSession();
        session.setAttribute("textError", "" );
        RequestDispatcher pageToDisplay; 
        pageToDisplay = request.getRequestDispatcher("/WEB-INF/index.jsp");
        if(session.getAttribute("session_email")!=null &&session.getAttribute("session_mdp")!=null){
            
            //getting parameters
            String session_email = session.getAttribute("session_email").toString(); 
            String session_mdp = session.getAttribute("session_mdp").toString();
            List<CompteUtilisateur> listeUtilisateurs = AccessBD.selectAllCompteutilisateurs(); 
            Boolean userExists = false; 
            Boolean psswdIsCorrect = false; 
            for (CompteUtilisateur cpt : listeUtilisateurs){
                
                if (cpt.getEmailPerso().equals(session_email))userExists = true; 
                else userExists = false; 
                
                if (cpt.getMdp().equals(session_mdp)) psswdIsCorrect = true;
                else psswdIsCorrect = false; 
                
                if(userExists && psswdIsCorrect) break;
            }
            if (!userExists || !psswdIsCorrect)
                pageToDisplay = request.getRequestDispatcher("/WEB-INF/index.jsp");
            else {
                session.setAttribute("textError", "Good" );
                //user interface page prep
                //pageToDisplay = request.getRequestDispatcher("/WEB-INF/?.jsp"); 
                pageToDisplay = request.getRequestDispatcher("/signin"); 

            }
        }
        pageToDisplay.forward(request, response);
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
        processRequest(request, response);
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
