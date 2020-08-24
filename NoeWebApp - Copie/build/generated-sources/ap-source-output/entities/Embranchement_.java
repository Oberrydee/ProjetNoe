package entities;

import entities.Taxinomie;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-24T12:35:33")
@StaticMetamodel(Embranchement.class)
public class Embranchement_ { 

    public static volatile SingularAttribute<Embranchement, Integer> idembranchement;
    public static volatile ListAttribute<Embranchement, Taxinomie> taxinomieList;
    public static volatile SingularAttribute<Embranchement, String> nom;

}