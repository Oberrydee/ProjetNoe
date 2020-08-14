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
public class Email {    
    
    //psswd: associationArcheMSIA19
    //email: association.arche.msia19@gmail.com
    public static final String ARCHE_EMAIL = "association.arche.msia19@gmail.com";
    public static final String ARCHE_PASSWORD = "associationArcheMSIA19";
    
    public static String CODE_RESET_EMAIL_CONTENT = ""; 
    public static String ACCOUNT_CONFIRMATION_EMAIL_CONTENT = ""; 
    
    public static String PASSWORD_FORGOTTEN_CODE = "TNYQ:Yc>;m7k)PF4oLu9!$d(H$LVZ;RKp`ur&=7d=8[,{B76G{rNH5_d`qEhTZQbC?Fzna~cc+xL9;YorC^r9sfd.`pZ&u&mS7tQEubBnGm[B`pi/.v/[WT75KHLu,`GJ?&jKQ9S/s8Vd`w3vhRu4RyPXJd[8XK@oU^_F`BQ*NW$>qVvC@hoMKytVw#P*p4~@qT*tH7p##+(E>#UUR]gpgbJ~}f6Z[,e+}bZ>o3!D@7?-s*zV^x8+>x8f6A_+#u&2k8-@EZcc^asby{_jtR.D?fwFMk;kx:heZC?+;(7f`My.:/%eYy{pHgvC8N9(%NU5Men!!e_:R.~6P9_W}W*`o/KZmw%ZdM7cR[vm>[P2U=n%{h-ts{&2!7Y*;t-7>2^qk>Q}-p?)$J4McK*EZ>L4z4{s~i;~GoiRDG,^%y#=Ca#v-iJ>k!)CpTY(tB=jS$+fPZ]27JF=::(EPfHdpo,v$$@]tm+*/~Df8gyeGp%9^NVG6=a_qs96BXynBpvf:g-HRU[Dr?sHJ835cJjZ%A.#u*-nZxuj_M7ko.CU?=njh/?D!BGnMN-`w[pm_zQLoo6o}Mci3`B{+TDzA#W4Y]Z^.LLjH4w(L5Fs]`>7FCmxqsL;Pry~)Td,&EiCi.5*;$:dw@+4vLPa:_bd}}QMEdpE@TJ}pR?T8QT[-etkPue6U?YpVU[s-F@NRvd;;dxd4F3xa;=fyyt2b+&qUT[+t8;$qpiGteAY?]_#(UgKWy,k_U$Fvjb]5%q4[9W[&F8a_YPR*uN/d)U=%rw^>G;&N,TG,$@U8:Pd%:Wp~FW%C^$sCP#BD*5_p4G:k#z[/J*N@nVGpH[A{zz:JGCG/3[v-t,*77pBSx5ps=_T;m-&XaPYg7Km9vP8_p^26b*uK+WncP{!EY*&}D8PEkvje(Na#ou=U@nUbJeq6!R)_9tc,_],[jQ3{V+S5*NDbSvYgfJ/z:h%+6]c/2hm:C>G@->QhK~4&+3k2J{$?9U`S,a-s^{FH4LCWw5x[-kt}/oCc(;9JXGYqP~os]E4EkKzeDmW?;iM*q)EQ}&c~j)pJCWaJDnT=q.J22BEUwo$8&b~C%aJ@=gMV6`,E6LyxYfYJ{uc29a,Kf+jG}+rb9*M=L.cH#E/Kgg/JwyLEb9[Q?K>[Ts^zts.ZZ}](RUU2Yd*iyn}VeF8+tj5qwr,DpE+QwRE";
    public static String createAccountConfirmationEmail(String confirmLink){
        ACCOUNT_CONFIRMATION_EMAIL_CONTENT = "<!DOCTYPE html>\n" +
"<html>\n" +
"\n" +
"<head>\n" +
"    <title></title>\n" +
"    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
"    <style type=\"text/css\">\n" +
"        @media screen {\n" +
"            @font-face {\n" +
"                font-family: 'Lato';\n" +
"                font-style: normal;\n" +
"                font-weight: 400;\n" +
"                src: local('Lato Regular'), local('Lato-Regular'), url(https://fonts.gstatic.com/s/lato/v11/qIIYRU-oROkIk8vfvxw6QvesZW2xOQ-xsNqO47m55DA.woff) format('woff');\n" +
"            }\n" +
"\n" +
"            @font-face {\n" +
"                font-family: 'Lato';\n" +
"                font-style: normal;\n" +
"                font-weight: 700;\n" +
"                src: local('Lato Bold'), local('Lato-Bold'), url(https://fonts.gstatic.com/s/lato/v11/qdgUG4U09HnJwhYI-uK18wLUuEpTyoUstqEm5AMlJo4.woff) format('woff');\n" +
"            }\n" +
"\n" +
"            @font-face {\n" +
"                font-family: 'Lato';\n" +
"                font-style: italic;\n" +
"                font-weight: 400;\n" +
"                src: local('Lato Italic'), local('Lato-Italic'), url(https://fonts.gstatic.com/s/lato/v11/RYyZNoeFgb0l7W3Vu1aSWOvvDin1pK8aKteLpeZ5c0A.woff) format('woff');\n" +
"            }\n" +
"\n" +
"            @font-face {\n" +
"                font-family: 'Lato';\n" +
"                font-style: italic;\n" +
"                font-weight: 700;\n" +
"                src: local('Lato Bold Italic'), local('Lato-BoldItalic'), url(https://fonts.gstatic.com/s/lato/v11/HkF_qI1x_noxlxhrhMQYELO3LdcAZYWl9Si6vvxL-qU.woff) format('woff');\n" +
"            }\n" +
"        }\n" +
"\n" +
"        /* CLIENT-SPECIFIC STYLES */\n" +
"        body,\n" +
"        table,\n" +
"        td,\n" +
"        a {\n" +
"            -webkit-text-size-adjust: 100%;\n" +
"            -ms-text-size-adjust: 100%;\n" +
"        }\n" +
"\n" +
"        table,\n" +
"        td {\n" +
"            mso-table-lspace: 0pt;\n" +
"            mso-table-rspace: 0pt;\n" +
"        }\n" +
"\n" +
"        img {\n" +
"            -ms-interpolation-mode: bicubic;\n" +
"        }\n" +
"\n" +
"        /* RESET STYLES */\n" +
"        img {\n" +
"            border: 0;\n" +
"            height: auto;\n" +
"            line-height: 100%;\n" +
"            outline: none;\n" +
"            text-decoration: none;\n" +
"        }\n" +
"\n" +
"        table {\n" +
"            border-collapse: collapse !important;\n" +
"        }\n" +
"\n" +
"        body {\n" +
"            height: 100% !important;\n" +
"            margin: 0 !important;\n" +
"            padding: 0 !important;\n" +
"            width: 100% !important;\n" +
"        }\n" +
"\n" +
"        /* iOS BLUE LINKS */\n" +
"        a[x-apple-data-detectors] {\n" +
"            color: inherit !important;\n" +
"            text-decoration: none !important;\n" +
"            font-size: inherit !important;\n" +
"            font-family: inherit !important;\n" +
"            font-weight: inherit !important;\n" +
"            line-height: inherit !important;\n" +
"        }\n" +
"\n" +
"        /* MOBILE STYLES */\n" +
"        @media screen and (max-width:600px) {\n" +
"            h1 {\n" +
"                font-size: 32px !important;\n" +
"                line-height: 32px !important;\n" +
"            }\n" +
"        }\n" +
"\n" +
"        /* ANDROID CENTER FIX */\n" +
"        div[style*=\"margin: 16px 0;\"] {\n" +
"            margin: 0 !important;\n" +
"        }\n" +
"    </style>\n" +
"</head>\n" +
"\n" +
"<body style=\"background-color: #f4f4f4; margin: 0 !important; padding: 0 !important;\">\n" +
"    <!-- HIDDEN PREHEADER TEXT -->\n" +
"    <div style=\"display: none; font-size: 1px; color: #fefefe; line-height: 1px; font-family: 'Lato', Helvetica, Arial, sans-serif; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden;\"> "
                + "Nous sommes heureux de vous compter parmi nous. Tout d'abord, vous devez confirmer votre compte. </div>\n" +
"    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
"        <!-- LOGO -->\n" +
"        <tr>\n" +
"            <td bgcolor=\"#FFA73B\" align=\"center\">\n" +
"                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\n" +
"                    <tr>\n" +
"                        <td align=\"center\" valign=\"top\" style=\"padding: 40px 10px 40px 10px;\"> </td>\n" +
"                    </tr>\n" +
"                </table>\n" +
"            </td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td bgcolor=\"#FFA73B\" align=\"center\" style=\"padding: 0px 10px 0px 10px;\">\n" +
"                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\n" +
"                    <tr>\n" +
"                        <td bgcolor=\"#ffffff\" align=\"center\" valign=\"top\" style=\"padding: 40px 20px 20px 20px; border-radius: 4px 4px 0px 0px; color: #111111; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 48px; font-weight: 400; letter-spacing: 4px; line-height: 48px;\">\n" +
"                            <h1 style=\"font-size: 48px; font-weight: 400; margin: 2;\">Bienvenue!</h1> <img src=\" https://img.icons8.com/clouds/100/000000/handshake.png\" width=\"125\" height=\"120\" style=\"display: block; border: 0px;\" />\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                </table>\n" +
"            </td>\n" +
"        </tr>\n" +
"        <tr>\n" +
"            <td bgcolor=\"#f4f4f4\" align=\"center\" style=\"padding: 0px 10px 0px 10px;\">\n" +
"                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\n" +
"                    <tr>\n" +
"                        <td bgcolor=\"#ffffff\" align=\"left\" style=\"padding: 20px 30px 40px 30px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;\">\n" +
"                            <p style=\"margin: 0;\">Nous sommes heureux de vous compter parmi nous. Tout d'abord, vous devez confirmer votre compte. Veuillez cliquer sur le botuon ci-dessous.</p>\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td bgcolor=\"#ffffff\" align=\"left\">\n" +
"                            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"                                <tr>\n" +
"                                    <td bgcolor=\"#ffffff\" align=\"center\" style=\"padding: 20px 30px 60px 30px;\">\n" +
"                                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"                                            <tr>\n" +
"                                                <td align=\"center\" style=\"border-radius: 3px;\" bgcolor=\"#FFA73B\"><a href=\""+confirmLink+"\" target=\"_blank\" style=\"font-size: 20px; font-family: Helvetica, Arial, sans-serif; color: #ffffff; text-decoration: none; color: #ffffff; text-decoration: none; padding: 15px 25px; border-radius: 2px; border: 1px solid #FFA73B; display: inline-block;\">Confirm Account</a></td>\n" +
"                                            </tr>\n" +
"                                        </table>\n" +
"                                    </td>\n" +
"                                </tr>\n" +
"                            </table>\n" +
"                        </td>\n" +
"                    </tr> <!-- COPY -->\n" +
"                    <tr>\n" +
"                        <td bgcolor=\"#ffffff\" align=\"left\" style=\"padding: 0px 30px 0px 30px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;\">\n" +
"                            <p style=\"margin: 0;\">Si cela ne marche pas, veuillez copier et coller le lien suivant dans votre navigateur:</p>\n" +
"                        </td>\n" +
"                    </tr> <!-- COPY -->\n" +
"                    <tr>\n" +
"                        <td bgcolor=\"#ffffff\" align=\"left\" style=\"padding: 20px 30px 20px 30px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;\">\n" +
"                            <p style=\"margin: 0;\"><a href=\"#\" target=\"_blank\" style=\"color: #FFA73B;\">"+confirmLink+"</a></p>\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td bgcolor=\"#ffffff\" align=\"left\" style=\"padding: 0px 30px 40px 30px; border-radius: 0px 0px 4px 4px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;\">\n" +
"                            <p style=\"margin: 0;\">À bientôt!<br></p>\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                </table>\n" +
"            </td>\n" +
"        </tr>\n" +
"    </table>\n" +
"</body>\n" +
"\n" +
"</html>";
        
        
        return ACCOUNT_CONFIRMATION_EMAIL_CONTENT;
    }
    public static String createPasswordResetEmail(){
        CODE_RESET_EMAIL_CONTENT = "<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"\n" +
"  <meta charset=\"utf-8\">\n" +
"  <meta http-equiv=\"x-ua-compatible\" content=\"ie=edge\">\n" +
"  <title>Password Reset</title>\n" +
"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"  <style type=\"text/css\">\n" +
"  /**\n" +
"   * Google webfonts. Recommended to include the .woff version for cross-client compatibility.\n" +
"   */\n" +
"  @media screen {\n" +
"    @font-face {\n" +
"      font-family: 'Source Sans Pro';\n" +
"      font-style: normal;\n" +
"      font-weight: 400;\n" +
"      src: local('Source Sans Pro Regular'), local('SourceSansPro-Regular'), url(https://fonts.gstatic.com/s/sourcesanspro/v10/ODelI1aHBYDBqgeIAH2zlBM0YzuT7MdOe03otPbuUS0.woff) format('woff');\n" +
"    }\n" +
"\n" +
"    @font-face {\n" +
"      font-family: 'Source Sans Pro';\n" +
"      font-style: normal;\n" +
"      font-weight: 700;\n" +
"      src: local('Source Sans Pro Bold'), local('SourceSansPro-Bold'), url(https://fonts.gstatic.com/s/sourcesanspro/v10/toadOcfmlt9b38dHJxOBGFkQc6VGVFSmCnC_l7QZG60.woff) format('woff');\n" +
"    }\n" +
"  }\n" +
"\n" +
"  /**\n" +
"   * Avoid browser level font resizing.\n" +
"   * 1. Windows Mobile\n" +
"   * 2. iOS / OSX\n" +
"   */\n" +
"  body,\n" +
"  table,\n" +
"  td,\n" +
"  a {\n" +
"    -ms-text-size-adjust: 100%; /* 1 */\n" +
"    -webkit-text-size-adjust: 100%; /* 2 */\n" +
"  }\n" +
"\n" +
"  /**\n" +
"   * Remove extra space added to tables and cells in Outlook.\n" +
"   */\n" +
"  table,\n" +
"  td {\n" +
"    mso-table-rspace: 0pt;\n" +
"    mso-table-lspace: 0pt;\n" +
"  }\n" +
"\n" +
"  /**\n" +
"   * Better fluid images in Internet Explorer.\n" +
"   */\n" +
"  img {\n" +
"    -ms-interpolation-mode: bicubic;\n" +
"  }\n" +
"\n" +
"  /**\n" +
"   * Remove blue links for iOS devices.\n" +
"   */\n" +
"  a[x-apple-data-detectors] {\n" +
"    font-family: inherit !important;\n" +
"    font-size: inherit !important;\n" +
"    font-weight: inherit !important;\n" +
"    line-height: inherit !important;\n" +
"    color: inherit !important;\n" +
"    text-decoration: none !important;\n" +
"  }\n" +
"\n" +
"  /**\n" +
"   * Fix centering issues in Android 4.4.\n" +
"   */\n" +
"  div[style*=\"margin: 16px 0;\"] {\n" +
"    margin: 0 !important;\n" +
"  }\n" +
"\n" +
"  body {\n" +
"    width: 100% !important;\n" +
"    height: 100% !important;\n" +
"    padding: 0 !important;\n" +
"    margin: 0 !important;\n" +
"  }\n" +
"\n" +
"  /**\n" +
"   * Collapse table borders to avoid space between cells.\n" +
"   */\n" +
"  table {\n" +
"    border-collapse: collapse !important;\n" +
"  }\n" +
"\n" +
"  a {\n" +
"    color: #1a82e2;\n" +
"  }\n" +
"\n" +
"  img {\n" +
"    height: auto;\n" +
"    line-height: 100%;\n" +
"    text-decoration: none;\n" +
"    border: 0;\n" +
"    outline: none;\n" +
"  }\n" +
"  </style>\n" +
"\n" +
"</head>\n" +
"<body style=\"background-color: #e9ecef;\">\n" +
"\n" +
"  <!-- start preheader -->\n" +
"  <div class=\"preheader\" style=\"display: none; max-width: 0; max-height: 0; overflow: hidden; font-size: 1px; line-height: 1px; color: #fff; opacity: 0;\">\n" +
"    A preheader is the short summary text that follows the subject line when an email is viewed in the inbox.\n" +
"  </div>\n" +
"  <!-- end preheader -->\n" +
"\n" +
"  <!-- start body -->\n" +
"  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
"\n" +
"    <!-- start logo -->\n" +
"    <tr>\n" +
"      <td align=\"center\" bgcolor=\"#e9ecef\">\n" +
"        <!--[if (gte mso 9)|(IE)]>\n" +
"        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\">\n" +
"        <tr>\n" +
"        <td align=\"center\" valign=\"top\" width=\"600\">\n" +
"        <![endif]-->\n" +
"        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\n" +
"          <tr>\n" +
"            <td align=\"center\" valign=\"top\" style=\"padding: 36px 24px;\">\n" +
"              <a href=\"https://sendgrid.com\" target=\"_blank\" style=\"display: inline-block;\">\n" +
"                <img src=\"./img/paste-logo-light@2x.png\" alt=\"Logo\" border=\"0\" width=\"48\" style=\"display: block; width: 48px; max-width: 48px; min-width: 48px;\">\n" +
"              </a>\n" +
"            </td>\n" +
"          </tr>\n" +
"        </table>\n" +
"        <!--[if (gte mso 9)|(IE)]>\n" +
"        </td>\n" +
"        </tr>\n" +
"        </table>\n" +
"        <![endif]-->\n" +
"      </td>\n" +
"    </tr>\n" +
"    <!-- end logo -->\n" +
"\n" +
"    <!-- start hero -->\n" +
"    <tr>\n" +
"      <td align=\"center\" bgcolor=\"#e9ecef\">\n" +
"        <!--[if (gte mso 9)|(IE)]>\n" +
"        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\">\n" +
"        <tr>\n" +
"        <td align=\"center\" valign=\"top\" width=\"600\">\n" +
"        <![endif]-->\n" +
"        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\n" +
"          <tr>\n" +
"            <td align=\"left\" bgcolor=\"#ffffff\" style=\"padding: 36px 24px 0; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; border-top: 3px solid #d4dadf;\">\n" +
"              <h1 style=\"margin: 0; font-size: 32px; font-weight: 700; letter-spacing: -1px; line-height: 48px;\">rRéinitialisez votre mot de passe</h1>\n" +
"            </td>\n" +
"          </tr>\n" +
"        </table>\n" +
"        <!--[if (gte mso 9)|(IE)]>\n" +
"        </td>\n" +
"        </tr>\n" +
"        </table>\n" +
"        <![endif]-->\n" +
"      </td>\n" +
"    </tr>\n" +
"    <!-- end hero -->\n" +
"\n" +
"    <!-- start copy block -->\n" +
"    <tr>\n" +
"      <td align=\"center\" bgcolor=\"#e9ecef\">\n" +
"        <!--[if (gte mso 9)|(IE)]>\n" +
"        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\">\n" +
"        <tr>\n" +
"        <td align=\"center\" valign=\"top\" width=\"600\">\n" +
"        <![endif]-->\n" +
"        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\n" +
"\n" +
"          <!-- start copy -->\n" +
"          <tr>\n" +
"            <td align=\"left\" bgcolor=\"#ffffff\" style=\"padding: 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; line-height: 24px;\">\n" +
"              <p style=\"margin: 0;\">Cliquez sur le bouton ci-dessous pour renouveler votre mot de passe. Si vous n'êtes pas à l'origine de cette demande, vous pouvez supprimer cet email.</p>\n" +
"            </td>\n" +
"          </tr>\n" +
"          <!-- end copy -->\n" +
"\n" +
"          <!-- start button -->\n" +
"          <tr>\n" +
"            <td align=\"left\" bgcolor=\"#ffffff\">\n" +
"              <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
"                <tr>\n" +
"                  <td align=\"center\" bgcolor=\"#ffffff\" style=\"padding: 12px;\">\n" +
"                    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
"                      <tr>\n" +
"                        <td align=\"center\" bgcolor=\"#1a82e2\" style=\"border-radius: 6px;\">\n" +
"                          <a href=\""+PASSWORD_FORGOTTEN_CODE+"\" target=\"_blank\" style=\"display: inline-block; padding: 16px 36px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; color: #ffffff; text-decoration: none; border-radius: 6px;\">Réinitialiser</a>\n" +
"                        </td>\n" +
"                      </tr>\n" +
"                    </table>\n" +
"                  </td>\n" +
"                </tr>\n" +
"              </table>\n" +
"            </td>\n" +
"          </tr>\n" +
"          <!-- end button -->\n" +
"\n" +
"          <!-- start copy -->\n" +
"          <tr>\n" +
"            <td align=\"left\" bgcolor=\"#ffffff\" style=\"padding: 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; line-height: 24px;\">\n" +
"              <p style=\"margin: 0;\">Si cele ne marche pas, veuillez copier ce lien dans votre navigateur:</p>\n" +
"              <p style=\"margin: 0;\"><a href=\"https://sendgrid.com\" target=\"_blank\">https://same-link-as-button.url/xxx-xxx-xxxx</a></p>\n" +
"            </td>\n" +
"          </tr>\n" +
"          <!-- end copy -->\n" +
"\n" +
"          <!-- start copy -->\n" +
"          <tr>\n" +
"            <td align=\"left\" bgcolor=\"#ffffff\" style=\"padding: 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; line-height: 24px; border-bottom: 3px solid #d4dadf\">\n" +
"              <p style=\"margin: 0;\">À bientôt.<br> </p>\n" +
"            </td>\n" +
"          </tr>\n" +
"          <!-- end copy -->\n" +
"\n" +
"        </table>\n" +
"        <!--[if (gte mso 9)|(IE)]>\n" +
"        </td>\n" +
"        </tr>\n" +
"        </table>\n" +
"        <![endif]-->\n" +
"      </td>\n" +
"    </tr>\n" +
"    <!-- end copy block -->\n" +
"\n" +
"    <!-- start footer -->\n" +
"    <tr>\n" +
"      <td align=\"center\" bgcolor=\"#e9ecef\" style=\"padding: 24px;\">\n" +
"        <!--[if (gte mso 9)|(IE)]>\n" +
"        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\">\n" +
"        <tr>\n" +
"        <td align=\"center\" valign=\"top\" width=\"600\">\n" +
"        <![endif]-->\n" +
"        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\n" +
"\n" +
"          <!-- start permission -->\n" +
"          <tr>\n" +
"            <td align=\"center\" bgcolor=\"#e9ecef\" style=\"padding: 12px 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 20px; color: #666;\">\n" +
"              </td>\n" +
"          </tr>\n" +
"          <!-- end permission -->\n" +
"\n" +
"          <!-- start unsubscribe -->\n" +
"          <tr>\n" +
"            <td align=\"center\" bgcolor=\"#e9ecef\" style=\"padding: 12px 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 20px; color: #666;\">\n" +
"             </td>\n" +
"          </tr>\n" +
"          <!-- end unsubscribe -->\n" +
"\n" +
"        </table>\n" +
"        <!--[if (gte mso 9)|(IE)]>\n" +
"        </td>\n" +
"        </tr>\n" +
"        </table>\n" +
"        <![endif]-->\n" +
"      </td>\n" +
"    </tr>\n" +
"    <!-- end footer -->\n" +
"\n" +
"  </table>\n" +
"  <!-- end body -->\n" +
"\n" +
"</body>\n" +
"</html>";
                
        return CODE_RESET_EMAIL_CONTENT;
    }
}

