/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Compteutilisateur;
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
import model.Functions;

/**
 *
 * @author ADZOH-VINYO DIANA
 */
@WebServlet(name = "SignUpServlet", urlPatterns = {"/signup"})
public class SignUpServlet extends HttpServlet {

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
            out.println("<title>Servlet SignUpServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignUpServlet at " + request.getContextPath() + "</h1>");
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
        session.setAttribute("textError", "" );
        RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/signup.jsp"); 
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
        session.setAttribute("textError", "" );
        
        //ajout compte utilisateur
        //getting all parameters        
        String nom = request.getParameter("attemptnom"); 
        String prenom = request.getParameter("attemptprenom"); 
        String email = request.getParameter("attemptemail"); 
        String tel = request.getParameter("attempttel"); 
        String mdp = request.getParameter("attemptpassword"); 
        String mdp_conf = request.getParameter("attemptconf_password"); 
        
        //
        session.setAttribute("attemptnom", nom);
        session.setAttribute("attemptprenom", prenom );
        session.setAttribute("attemptemail", email );
        session.setAttribute("attempttel", tel );
        session.setAttribute("textError", "" );
        
        String emailRegEx = "^\\S+@\\S+\\.\\S+$";
        //String phoneRegEx = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";
        String phoneRegEx = "((?:\\+|00)[17](?: |\\-)?|(?:\\+|00)[1-9]\\d{0,2}(?: |\\-)?|(?:\\+|00)1\\-\\d{3}(?: |\\-)?)?(0\\d|\\([0-9]{3}\\)|[1-9]{0,3})(?:((?: |\\-)[0-9]{2}){4}|((?:[0-9]{2}){4})|((?: |\\-)[0-9]{3}(?: |\\-)[0-9]{4})|([0-9]{7}))";        String passwordRegEx = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^,\"\'&*-]).{8,}$"; 
        
        //^\+(?:[0-9] ?){6,14}[0-9]$
        //((?:\+|00)[17](?: |\-)?|(?:\+|00)[1-9]\d{0,2}(?: |\-)?|(?:\+|00)1\-\d{3}(?: |\-)?)?(0\d|\([0-9]{3}\)|[1-9]{0,3})(?:((?: |\-)[0-9]{2}){4}|((?:[0-9]{2}){4})|((?: |\-)[0-9]{3}(?: |\-)[0-9]{4})|([0-9]{7}))
        
        // Initializing page to display 
        RequestDispatcher pageToDisplay;      
        //default page if anything goes wrong   
        pageToDisplay = request.getRequestDispatcher("/WEB-INF/signup.jsp"); 
        
        if(!Functions.checkRegEx(tel, phoneRegEx)){
            session.setAttribute("textError", "Numero de telephone invalide" );
        }
        else if(!Functions.checkRegEx(email, emailRegEx))    
        {
            session.setAttribute("textError", "Addresse email invalide" );            
        }        
        else if (!Functions.checkRegEx(mdp, passwordRegEx)){
            session.setAttribute("textError", 
                    "Le mot de passe doit avoir: "
                     +  "        au moins une elettre majuscule,\n" +
                        "        au moins une elettre minuscule,\n" +
                        "        au moins un chiffre,\n" +
                        "        au moins un caractère spécial,\n" +
                        "        au  moins 8 caractères " );            
        }
        else if(!mdp.equals(null) 
                && mdp.isEmpty()==false && !mdp.equals(mdp_conf)){
            session.setAttribute("textError", "Confirmation de mot de passe incorrecte" );            
        }
        else {            
            String checked = (String)request.getParameter("termes_et_conditions");
            if(checked==(null)){
                session.setAttribute("textError", "Veuilez cocher la case \"J'ai bien lu les termes et conditions\""); 
            }
            else { 
                Boolean emailExistant=false; 
                //check database for same email
                List<Compteutilisateur> listeDesComptesUtilisateurs = 
                        AccessBD.selectAllCompteUtilisateurs();
                for (Compteutilisateur cpt : listeDesComptesUtilisateurs){
                    if (cpt.getEmailPerso().equals(email)){
                        session.setAttribute("textError", "Il existe un compte associé à cette adresse email"); 
                        emailExistant = true; 
                    }
                }
                if (!emailExistant){
                    //confirmation for email sent page    
                    Functions.sendConfirmaitonEmail(email, nom, prenom, email, tel, mdp, null);  
                    pageToDisplay = request.getRequestDispatcher("/WEB-INF/inscriptionEmailSent.jsp");           
                }
            }
            
        }
        //create new object 
        
        //- username: id objet
        //- add field phone number
        //- regex for phone number
        //- check for existing email
        //- send confirmation email 
        //- link containing infos to insert into database
        
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
