package entities;

import entities.CompteUtilisateur;
import entities.Projet;
import entities.Role;
import entities.Sentinelle;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-24T12:35:33")
@StaticMetamodel(Salarié.class)
public class Salarié_ { 

    public static volatile SingularAttribute<Salarié, String> ville;
    public static volatile SingularAttribute<Salarié, String> rue;
    public static volatile SingularAttribute<Salarié, Integer> idSalarié;
    public static volatile SingularAttribute<Salarié, Integer> codePostal;
    public static volatile SingularAttribute<Salarié, String> emailPro;
    public static volatile SingularAttribute<Salarié, String> numeroBatiment;
    public static volatile SingularAttribute<Salarié, String> nom;
    public static volatile SingularAttribute<Salarié, Role> roleidRole;
    public static volatile SingularAttribute<Salarié, String> site;
    public static volatile ListAttribute<Salarié, Projet> projetList1;
    public static volatile SingularAttribute<Salarié, String> prénom;
    public static volatile ListAttribute<Salarié, Projet> projetList;
    public static volatile SingularAttribute<Salarié, CompteUtilisateur> compteUtilisateuridcompteUtilisateur;
    public static volatile ListAttribute<Salarié, Sentinelle> sentinelleList;

}