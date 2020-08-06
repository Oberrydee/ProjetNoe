/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 *
 * @author ADZOH-VINYO DIANA
 */
public class Functions {
   
    public static boolean checkRegEx(String expression, String regEx){
        Pattern pattern = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        
        //think this is for pphone number
        //Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);       

        Matcher matcher = pattern.matcher(expression);
        return matcher.find();
    }
    
    public static String sendConfirmaitonEmail(
            String to, 
            String nom, 
            String prenom, 
            String email, 
            String tel, 
            String mdp){

        final String username = Email.ARCHE_EMAIL;
        final String password = Email.ARCHE_PASSWORD;
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
                }
          });
      try {
         // Create a default MimeMessage object.
         Message message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(Email.ARCHE_EMAIL));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("Confirmation de votre email!");

         // Send the actual HTML message, as big as you like
         
         message.setContent(Email.createAccountConfirmationEmail(
                 "http://localhost:8080/association-arche/newuser?nom="+nom
                         +"&prenom="+prenom
                         +"&tel="+tel
                         +"&email="+email
                         +"&mdp="+mdp
                         ), "text/html");

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      } catch (MessagingException mex) {
         mex.printStackTrace();
      }
      
      return null;
    }
}
