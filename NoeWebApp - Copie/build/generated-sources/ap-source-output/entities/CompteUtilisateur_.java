package entities;

import entities.Salarié;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-24T12:35:33")
@StaticMetamodel(CompteUtilisateur.class)
public class CompteUtilisateur_ { 

    public static volatile SingularAttribute<CompteUtilisateur, String> emailPerso;
    public static volatile ListAttribute<CompteUtilisateur, Salarié> salariéList;
    public static volatile SingularAttribute<CompteUtilisateur, String> nomUtilisateur;
    public static volatile SingularAttribute<CompteUtilisateur, String> mdp;
    public static volatile SingularAttribute<CompteUtilisateur, String> numéroTelephone;
    public static volatile SingularAttribute<CompteUtilisateur, String> nom;
    public static volatile SingularAttribute<CompteUtilisateur, String> prenom;
    public static volatile SingularAttribute<CompteUtilisateur, Integer> idcompteUtilisateur;

}