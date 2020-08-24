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
import model.Functions;

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
        signinServeletFunction(request, response); 
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
        
    }
 protected static void signinServeletFunction(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
     //session
        HttpSession session = request.getSession();
        session.setAttribute("textError", "" );
        //getting parameters
        String email = request.getParameter("session_email"); 
        String mdp = request.getParameter("session_mdp");
        
        //error page prep
        RequestDispatcher pageToDisplay = 
                Functions.connection(email, mdp, request, response, session); 
        if (pageToDisplay != null) pageToDisplay.forward(request, response);
             
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
