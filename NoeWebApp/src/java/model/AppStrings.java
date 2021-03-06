/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ADZOH-VINYO DIANA
 */
public class AppStrings {
    
    public static final String ETAT_A_INITIER = "A initier"; 
    public static final String ETAT_EN_COURS = "En cours"; 
    public static final String ETAT_TERMINE = "Terminé"; 
    public static final String ETAT_SUSPENDU = "Suspendu"; 
    public static final String ETAT_ANNULE = "Annulé"; 
    
    public static final String SESSION_ATTRIBUTE_EMAIL = "session_email";
    public static final String SESSION_ATTRIBUTE_MDP = "session_mdp";
    public static final String SESSION_ATTRIBUTE_ROLE = "ambpambp";
    public static final String SESSION_ATTRIBUTE_NOM = "session_nom";
    public static final String SESSION_ATTRIBUTE_PRENOM = "session_prenom";
    public static final String SESSION_ATTRIBUTE_TEXT_ERROR = "textError"; 
    public static final String SESSION_ATTRIBUTE_SESSION_CONNECTED = "sessionConnected";
    
    public static final String NOM_ROLE_ABONNE = "abonne"; 
    public static final String NOM_ROLE_EMPLOYE = "employe"; 
    public static final String NOM_ROLE_RH = "RH"; 
    public static final String NOM_ROLE_RECHERCHE_ET_DEVELOPPEMENT = "R&D"; 
    public static final String NOM_ROLE_dIRECTEUR_DE_PRODUCTION = "directeur_de_production"; 
    public static final String NOM_ROLE_PERSONNEL_SITE_DE_STOCKAGE = "personnel_site_stockage"; 
    public static final String NOM_ROLE_SENTINELLE = "sentinelle"; 
    public static final String NOM_ROLE_ITSM = "ITSM"; 
    public static final String NOM_ROLE_NARRATEUR = "narrateur"; 
    public static final String NOM_ROLE_CHEF_DE_PROJET = "abchet_de_projetonne"; 
    
    
    public static final String NOM_DROIT_AFFICHAGE_lot_de_semence = "lot_de_semence_read"; 
    public static final String NOM_DROIT_ECRITURE_lot_de_semence = "lot_de_semence_write"; 
    public static final String NOM_DROIT_AFFICHAGE_taxinomie = "taxinomie_read"; 
    public static final String NOM_DROIT_ECRITURE_taxinomie = "taxinomie_write"; 
    public static final String NOM_DROIT_AFFICHAGE_salaries = "salaries_read"; 
    public static final String NOM_DROIT_ECRITURE_salaries = "salaries_write"; 
    public static final String NOM_DROIT_AFFICHAGE_abonnes = "abonnes_read"; 
    public static final String NOM_DROIT_ECRITURE_abonnes = "abonnes_write"; 
    public static final String NOM_DROIT_AFFICHAGE_alertes = "alertes_read"; 
    public static final String NOM_DROIT_ECRITURE_alertes = "alertes_write"; 
    public static final String NOM_DROIT_AFFICHAGE_projets = "projets_read"; 
    public static final String NOM_DROIT_ECRITURE_projets = "projets_write"; 
    public static final String NOM_DROIT_AFFICHAGE_taches = "taches_read"; 
    public static final String NOM_DROIT_ECRITURE_taches = "taches_write"; 
    public static final String NOM_DROIT_AFFICHAGE_livre_de_sauvetage = "lot_de_semence_read"; 
    public static final String NOM_DROIT_ECRITURE_livre_de_sauvetage = "lot_de_semence_write"; 
    public static final String NOM_DROIT_AFFICHAGE_site_de_stockage = "site_de_stockage_read"; 
    public static final String NOM_DROIT_ECRITURE_site_de_stockage = "site_de_stockage_write"; 
    public static final String emailRegEx = "^\\S+@\\S+\\.\\S+$";
    //String REGEX_PHONE_NUMBER = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";
    public static final String REGEX_PHONE_NUMBER = "((?:\\+|00)[17](?: |\\-)?|(?:\\+|00)[1-9]\\d{0,2}(?: |\\-)?|(?:\\+|00)1\\-\\d{3}(?: |\\-)?)?(0\\d|\\([0-9]{3}\\)|[1-9]{0,3})(?:((?: |\\-)[0-9]{2}){4}|((?:[0-9]{2}){4})|((?: |\\-)[0-9]{3}(?: |\\-)[0-9]{4})|([0-9]{7}))";        
    public static final String REGEX_PASSWORD = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^,\"\'&*-]).{8,}$"; 
    public static final String REGEX_CODE_POSTAL = "\\d{2}[ ]?\\d{3}"; 
    public static final String REGEX_NUMbER = "^\\d+$" ;
    
    public static final String PASSWORD_REQUIERMENTS = 
                "Le mot de passe doit avoir: "
                 +  "        au moins une lettre majuscule,\n" +
                    "        au moins une lettre minuscule,\n" +
                    "        au moins un chiffre,\n" +
                    "        au moins un caractère spécial,\n" +
                    "        au  moins 8 caractères "; 
    public static final String PASSWORD_DONT_MATCH = "Confirmation de mot de passe incorrecte";
    public static  String INVALID_PARAM_DISP (String param) {
        return param +" invalide";
    }
}
