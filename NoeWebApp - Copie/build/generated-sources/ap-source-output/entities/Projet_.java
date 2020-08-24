package entities;

import entities.Alerte;
import entities.Equipe;
import entities.Etat;
import entities.Salarié;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-24T12:35:33")
@StaticMetamodel(Projet.class)
public class Projet_ { 

    public static volatile SingularAttribute<Projet, Integer> idprojet;
    public static volatile SingularAttribute<Projet, Date> dateDebut;
    public static volatile SingularAttribute<Projet, Equipe> equipeIdequipe;
    public static volatile SingularAttribute<Projet, Integer> duréeEnMois;
    public static volatile SingularAttribute<Projet, Alerte> alerteIdalerte;
    public static volatile SingularAttribute<Projet, Etat> etatIdetat;
    public static volatile SingularAttribute<Projet, String> nom;
    public static volatile SingularAttribute<Projet, Salarié> narrateurIdsalarie;
    public static volatile SingularAttribute<Projet, Salarié> demandeurIdsalarie;

}