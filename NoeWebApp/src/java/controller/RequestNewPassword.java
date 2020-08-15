/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Coderesetpassword;
import entities.Compteutilisateur;
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
import model.Functions;

/**
 *
 * @author ADZOH-VINYO DIANA
 */
@WebServlet(name = "RequestNewPassword", urlPatterns = {"/request-new-password"})
public class RequestNewPassword extends HttpServlet {

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
            out.println("<title>Servlet RequestNewPassword</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RequestNewPassword at " + request.getContextPath() + "</h1>");
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
        RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/request-new-password.jsp"); 
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
        RequestDispatcher pageToDisplay; 
        
        HttpSession session = request.getSession(); 
        session.setAttribute("textError", "");
        pageToDisplay = request.getRequestDispatcher("/WEB-INF/request-new-password.jsp"); 
        
        String email = request.getParameter("email"); 
        
        if (email!=null && !email.isEmpty()){
            if(AccessBD.getCompteUtilisateurByEmail(email)!=null){
                //todo: random code
                Coderesetpassword code = new Coderesetpassword(); 
                code.setIdCodeResetPassword(Functions.generateCodeResetPasswordUUID()); 
                code.setIdCompteUtilisateur((Compteutilisateur)AccessBD.getCompteUtilisateurByEmail(email));
                code.setNomCodeResetPassword(null);
                if(AccessBD.persist(code)){
                    Functions.sendCodeToResetPassword(email, code.getIdCodeResetPassword()); 
                    pageToDisplay = request.getRequestDispatcher("/WEB-INF/confirmation-password-requested.jsp");                     
                }
                else{
                    pageToDisplay = request.getRequestDispatcher("/WEB-INF/Error.html");   
                }
            }
            else {
                session.setAttribute("textError", "Email invalide");
            }
        } else{
            session.setAttribute("textError", "Champ vide");
        }
        pageToDisplay.forward(request, response);

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
