package entities;

import entities.Espece;
import entities.Projet;
import entities.Sentinelle;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-24T12:35:33")
@StaticMetamodel(Alerte.class)
public class Alerte_ { 

    public static volatile SingularAttribute<Alerte, Sentinelle> sentinelleIdsentinelle;
    public static volatile SingularAttribute<Alerte, Integer> idalerte;
    public static volatile ListAttribute<Alerte, Projet> projetList;
    public static volatile SingularAttribute<Alerte, Espece> especeIdespece;
    public static volatile SingularAttribute<Alerte, Integer> urgence;

}