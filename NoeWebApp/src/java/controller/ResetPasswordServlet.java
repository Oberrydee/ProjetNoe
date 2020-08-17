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
import model.AppStrings;
import model.Functions;

/**
 *
 * @author ADZOH-VINYO DIANA
 */
@WebServlet(name = "ResetPasswordServlet", urlPatterns = {"/reset-password"})
public class ResetPasswordServlet extends HttpServlet {

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
            out.println("<title>Servlet ResetPasswordServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ResetPasswordServlet at " + request.getContextPath() + "</h1>");
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
        RequestDispatcher pageToDisplay = request.getRequestDispatcher("/WEB-INF/reset-password.jsp"); 
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
        HttpSession session = request.getSession(); 
        session.setAttribute("textError", "");
        
        RequestDispatcher pageToDisplay = request.getRequestDispatcher("/WEB-INF/reset-password.jsp"); 
        
        String code = request.getParameter("code"); 
        String mdp = request.getParameter("mdp"); 
        String mdp_conf = request.getParameter("mdp_conf"); 
        
        if(AccessBD.selectCoderesetpasswordByID(code) != null){
            if(Functions.checkRegEx(mdp, AppStrings.passwordRegEx)){
                if(mdp.equals(mdp_conf)){
                    if(!mdp.equals((((Coderesetpassword)AccessBD.selectCoderesetpasswordByID(code))
                            .getIdCompteUtilisateur()).getMdp())){
                        Coderesetpassword reset = (Coderesetpassword) AccessBD.selectCoderesetpasswordByID(code); 
                        Compteutilisateur cpt = reset.getIdCompteUtilisateur(); 
                        AccessBD.deleteCoderesetpassword(reset);
                        AccessBD.deleteCompteutilisateur(cpt);
                        cpt.setMdp(mdp);
                        if(AccessBD.persist(cpt)) {
                            pageToDisplay = request.getRequestDispatcher("/WEB-INF/confirmation-password-reset.jsp"); 
                        }else{
                            pageToDisplay = request.getRequestDispatcher("Error.html");                         
                        }
                    }
                    else{   
                        session.setAttribute("textError", "Le nouveau mot de passe doit etre différent de l'ancien.");                    
                    }
                }
                else{                    
                    session.setAttribute("textError", AppStrings.PASSWORD_DONT_MATCH); 
                }
            }else{
                session.setAttribute("textError", AppStrings.PASSWORD_REQUIERMENTS);                
            }
        }else{
            session.setAttribute("textError", AppStrings.INVALID_PARAM_DISP("code")); 
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
