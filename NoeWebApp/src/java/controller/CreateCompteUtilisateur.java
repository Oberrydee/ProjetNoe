/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.CompteUtilisateur;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CreateCompteUtilisateur", urlPatterns = {"/newuser"})
public class CreateCompteUtilisateur extends HttpServlet {

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
            out.println("<title>Servlet CreateCompteUtilisateur</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateCompteUtilisateur at " + request.getContextPath() + "</h1>");
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
        
        //getting all parameters        
        String nom = request.getParameter("nom"); 
        String prenom = request.getParameter("prenom"); 
        String email = request.getParameter("email"); 
        String tel = request.getParameter("tel"); 
        String mdp = request.getParameter("mdp"); 
        
        CompteUtilisateur newUser = new CompteUtilisateur(); 
        newUser.setIdcompteUtilisateur(newUser.hashCode());
        newUser.setNomUtilisateur(nom+"_"+prenom);
        newUser.setNom(nom);
        newUser.setPrenom(prenom);
        newUser.setEmailPerso(email);
        newUser.setNuméroTelephone(tel);
        newUser.setMdp(mdp);
              
        AccessBD.persist(newUser);

        RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/confirmationinscription.jsp"); 
        disp.forward(request, response);
        
/*
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateCompteUtilisateur</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateCompteUtilisateur at " + newUser.getNom() +" "
                                                                   + newUser.getPrenom()+" "
                                                                   + newUser.getEmailPerso()+" "
                                                                   + newUser.getNuméroTelephone()+" "
                                                                   + newUser.getIdcompteUtilisateur()+" "
                                                                   + newUser.getMdp() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        */
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
