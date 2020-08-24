/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.salarié;

import entities.CompteUtilisateur;
import entities.Salarié;
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
@WebServlet(name = "CreateNewSalarieServlet", urlPatterns = {"/create-salarie"})
public class CreateNewSalarieServlet extends HttpServlet {

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
            out.println("<title>Servlet CreateNewSalarieServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Don't forget to check if compte utilisateur pas deja associé à qqun</h1>");
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
        RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/create-salarie.jsp"); 
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
        HttpSession session = request.getSession(); 
            session.setAttribute("textError", "test" ); 
        RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/create-salarie.jsp"); 
        
        
        Salarié salarié = new Salarié(0); 
        
        String nom = request.getParameter("nom");    
        String prenom = request.getParameter("prenom");    
        String email = request.getParameter("email");    
        String numero_de_telephone = request.getParameter("numero_de_telephone");
        String numero_de_batiment = request.getParameter("numero_de_batiment");  
        //pzs de condtion non null sur la rue
        String rue = request.getParameter("rue");    
        String ville = request.getParameter("ville");    
        String code_postal = request.getParameter("code_postal");    
        String site = request.getParameter("site");    
        String role = request.getParameter("role");    
        
        if(nom == null || prenom == null || email == null || numero_de_telephone == null ||
                numero_de_batiment == null || ville == null || 
                code_postal == null || site == null || role == null ){
            session.setAttribute("textError", "Veuillez remplir tous les champs" );            
        }
        else if(!Functions.checkRegEx(numero_de_telephone, AppStrings.REGEX_PHONE_NUMBER)){
            session.setAttribute("textError", AppStrings.INVALID_PARAM_DISP("Numero de telephone") );
        }
        else{
        
            CompteUtilisateur cpt = ((CompteUtilisateur)AccessBD.selectCompteUtilisateurByEmail(email));
            if (cpt != null) {
                int id = cpt.getIdcompteUtilisateur();
                Salarié tmp = AccessBD.selectSalariéByIdCompteUtilisateur(id);
                // il y en a un associé, stop process
                if (tmp.getRoleidRole().getNomRole().equals(AppStrings.NOM_ROLE_ABONNE)){
                session.setAttribute("textError", "Il existe deja un compte utilisateur abonné associé à cette adresse. "
                        + "Veillez à le supprimer avant de continuer.");
                }
                else{
                session.setAttribute("textError", "Il existe deja un Salarié associé à cette adresse. "
                        + "Veillez à le supprimer avant de continuer.");                
                }
            }else{
                //il n'y en a pas, on en cree un 
                CompteUtilisateur compte = new CompteUtilisateur(0);
                compte.setEmailPerso(email);
                compte.setMdp(Functions.generatePassword());
                compte.setNom(nom);
                compte.setPrenom(prenom);
                compte.setNomUtilisateur(nom+" "+prenom);
                compte.setNuméroTelephone(numero_de_telephone);
                if(AccessBD.persist(compte)){
                    salarié.setCompteUtilisateuridcompteUtilisateur(compte);
                    salarié.setEmailPro(email);
                    salarié.setNom(nom);
                    salarié.setPrénom(prenom);
                    salarié.setNumeroBatiment(numero_de_batiment);
                    salarié.setRue(rue);
                    salarié.setVille(numero_de_batiment);
                    salarié.setCodePostal(Integer.parseInt(code_postal));
                    salarié.setSite(numero_de_batiment);
                    salarié.setRoleidRole(AccessBD.selectRoleByName(role));
                    
                    if(AccessBD.persist(salarié)){
                        disp = request.getRequestDispatcher("/WEB-INF/confirmation-creation-employe.jsp"); 
                    }
                }

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
