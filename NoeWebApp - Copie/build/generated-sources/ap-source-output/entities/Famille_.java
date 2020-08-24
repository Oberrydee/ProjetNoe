package entities;

import entities.Taxinomie;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-24T12:35:33")
@StaticMetamodel(Famille.class)
public class Famille_ { 

    public static volatile SingularAttribute<Famille, Integer> idfamille;
    public static volatile ListAttribute<Famille, Taxinomie> taxinomieList;
    public static volatile SingularAttribute<Famille, String> nom;

}