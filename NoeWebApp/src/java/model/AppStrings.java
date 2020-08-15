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
     
    public static final String emailRegEx = "^\\S+@\\S+\\.\\S+$";
    //String phoneRegEx = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";
    public static final String phoneRegEx = "((?:\\+|00)[17](?: |\\-)?|(?:\\+|00)[1-9]\\d{0,2}(?: |\\-)?|(?:\\+|00)1\\-\\d{3}(?: |\\-)?)?(0\\d|\\([0-9]{3}\\)|[1-9]{0,3})(?:((?: |\\-)[0-9]{2}){4}|((?:[0-9]{2}){4})|((?: |\\-)[0-9]{3}(?: |\\-)[0-9]{4})|([0-9]{7}))";        
    public static final String passwordRegEx = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^,\"\'&*-]).{8,}$"; 
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
