/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Accountstobeconfirmed;
import entities.Compteutilisateur;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AccessBD;

/**
 *
 * @author ADZOH-VINYO DIANA
 */
@WebServlet(name = "CreateCompteutilisateur", urlPatterns = {"/newuser"})
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
            out.println("<title>Servlet CreateCompteutilisateur</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateCompteutilisateur at " + request.getContextPath() + "</h1>");
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
        String codeId = request.getParameter("code"); 
        
        
        RequestDispatcher disp
             = request.getRequestDispatcher("/WEB-INF/Error.html");  
        
        if (AccessBD.selectAccountstobeconfirmedBycode(codeId)!=null){
            Accountstobeconfirmed code = (Accountstobeconfirmed) AccessBD.selectAccountstobeconfirmedBycode(codeId); 

            Compteutilisateur newUser = new Compteutilisateur(); 
            newUser.setIdcompteUtilisateur(newUser.hashCode());
            newUser.setNomUtilisateur(code.getNomAconf()+"_"+code.getPrenomAconf());
            newUser.setNom(code.getNomAconf());
            newUser.setPrenom(code.getPrenomAconf());
            newUser.setEmailPerso(code.getEmailPersoAconf());
            newUser.setNuméroTelephone(code.getNuméroTelephoneAconf());
            newUser.setMdp(code.getMdpAconf());

            if(AccessBD.persist(newUser)) {
                if (!(Boolean)AccessBD.deleteAccounttobeconfirmed(code)) 
                    System.out.println("AccountToBeConfirmed code failed to be deleted");
                else disp = request.getRequestDispatcher("/WEB-INF/confirmationinscription.jsp"); 
            }
        }
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
