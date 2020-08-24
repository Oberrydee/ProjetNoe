package entities;

import entities.Taxinomie;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-24T12:35:33")
@StaticMetamodel(Tribu.class)
public class Tribu_ { 

    public static volatile SingularAttribute<Tribu, Integer> idtribu;
    public static volatile ListAttribute<Tribu, Taxinomie> taxinomieList;
    public static volatile SingularAttribute<Tribu, String> nom;

}