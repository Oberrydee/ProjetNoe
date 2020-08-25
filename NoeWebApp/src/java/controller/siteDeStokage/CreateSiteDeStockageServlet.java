/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.siteDeStokage;

import entities.SiteDeStokage;
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
@WebServlet(name = "CreateSiteDeStockageServlet", urlPatterns = {"/create-site"})
public class CreateSiteDeStockageServlet extends HttpServlet {

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
            out.println("<title>Servlet CreateSiteDeStockageServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateSiteDeStockageServlet at " + request.getContextPath() + "</h1>");
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
        RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/create-site.jsp"); 
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
        RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/create-site.jsp"); 
        
        String localisation = request.getParameter("localisation"); 
        
        Boolean siteExistant = false; 
        
        for (SiteDeStokage site : AccessBD.selectAllSiteDeStokages()){
            if (site.getLocalisation().toLowerCase().equals(localisation.toLowerCase())){
                siteExistant = true; 
            }
        }
        if (siteExistant){
            HttpSession session = request.getSession(); 
            session.setAttribute("textError", "Ce site existe dejà. ");
        }
        else{
            SiteDeStokage site = new SiteDeStokage(); 
            site.setIdSiteDeStokage(0);
            site.setLocalisation(localisation);
            if (AccessBD.persist(site)){
                disp = request.getRequestDispatcher("/WEB-INF/confirmation-creation-site.jsp"); 
            }
            else {
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
