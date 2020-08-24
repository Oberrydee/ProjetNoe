package entities;

import entities.Taxinomie;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-24T12:35:33")
@StaticMetamodel(Forme.class)
public class Forme_ { 

    public static volatile SingularAttribute<Forme, Integer> idforme;
    public static volatile ListAttribute<Forme, Taxinomie> taxinomieList;
    public static volatile SingularAttribute<Forme, String> nom;

}