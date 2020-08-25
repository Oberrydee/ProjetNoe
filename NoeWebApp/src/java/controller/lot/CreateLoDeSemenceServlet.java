/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.lot;

import entities.LotDeSemence;
import entities.Salle;
import entities.Semence;
import entities.SiteDeStokage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "CreateLoDeSemenceServlet", urlPatterns = {"/create-lot"})
public class CreateLoDeSemenceServlet extends HttpServlet {

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
            out.println("<title>Servlet CreateLoDeSemenceServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateLoDeSemenceServlet at " + request.getContextPath() + "</h1>");
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
        RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/create-lot.jsp"); 
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
        RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/create_lot.jsp"); 
        
        Semence semence = AccessBD.selectSemenceByID(Integer.parseInt(request.getParameter("semence"))); 
        SiteDeStokage site = AccessBD.selectSiteDeStokageByID(Integer.parseInt(request.getParameter("site"))); 
        Salle salle = AccessBD.selectSalleByID(Integer.parseInt(request.getParameter("salle"))); 
        int disponibilite = Integer.parseInt(request.getParameter("disponibilite")); 
        int duree = Integer.parseInt(request.getParameter("duree")); 
        int quantite = Integer.parseInt(request.getParameter("quantite")); 
        
        LotDeSemence lot = new LotDeSemence(); 
        lot.setIdLotDeSemence(lot.hashCode());
        lot.setSemenceList(new ArrayList<>());
        lot.getSemenceList().add(semence); 
        lot.setSiteDeStockageSiteDeStockage(site);
        lot.setSalleidSalle(salle);
        lot.setDisponibiliteEnStock(disponibilite);
        lot.setDureeDeStockageEnMois(duree);
        lot.setQuantiteEnNbDeCaisses(quantite);
        
        if (AccessBD.persist(lot)){
            disp = request.getRequestDispatcher("/WEB-INF/confirmation-creation-lot.jsp"); 
        }
        else {
            disp = request.getRequestDispatcher("/WEB-INF/Error.html");             
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
