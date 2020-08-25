/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.CompteUtilisateur;
import entities.Role;
import entities.Salarié;
import java.io.IOException;
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
@WebServlet(name = "InterfaceAbonneServlet", urlPatterns = {"/home-a"})
public class InterfaceServlet extends HttpServlet {

    private Role role; 
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
        displaySessionHomePage(request, response);
     
    }
    private void displaySessionHomePage(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException{
        try{            
            RequestDispatcher pageToDisplay; 
            HttpSession session = request.getSession();
            
            Salarié salarié = AccessBD.selectSalariéByIdCompteUtilisateur((
                    (CompteUtilisateur)AccessBD.selectCompteUtilisateurByEmail(
                            session.getAttribute(AppStrings.SESSION_ATTRIBUTE_EMAIL).toString()))
                    .getIdcompteUtilisateur()
                    ); 
            session.setAttribute(
                    AppStrings.SESSION_ATTRIBUTE_NOM, 
                    salarié.getNom()
                            .toUpperCase());
            session.setAttribute(AppStrings.SESSION_ATTRIBUTE_PRENOM, salarié.getPrénom().toUpperCase());
            
            Role role = AccessBD.selectRoleByID((int) session.getAttribute("ambpambp")); 
           

            if (session != null && session.getAttribute("sessionConnected") != null &&
                        (Boolean)(session.getAttribute("sessionConnected"))){
                //test droits
                pageToDisplay = Functions.afficherInterface(role, request);
            }
            else {
                pageToDisplay = request.getRequestDispatcher("/WEB-INF/signin.jsp"); 
            }
            pageToDisplay.forward(request, response);
        }
        catch (Exception e){
            e.printStackTrace();
            RequestDispatcher pageToDisplay = request.getRequestDispatcher("/WEB-INF/Error.html");
            pageToDisplay.forward(request, response);
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
        displaySessionHomePage(request, response);
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
        SingInServlet.signinServeletFunction(request, response);
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
