package entities;

import entities.Alerte;
import entities.Semence;
import entities.Taxinomie;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-24T12:35:33")
@StaticMetamodel(Espece.class)
public class Espece_ { 

    public static volatile ListAttribute<Espece, Alerte> alerteList;
    public static volatile ListAttribute<Espece, Semence> semenceList;
    public static volatile SingularAttribute<Espece, Integer> idespece;
    public static volatile SingularAttribute<Espece, String> nom;
    public static volatile SingularAttribute<Espece, Taxinomie> taxinomieIdtaxinomie;

}