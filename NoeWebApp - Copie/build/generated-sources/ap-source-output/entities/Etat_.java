package entities;

import entities.Projet;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-24T12:35:33")
@StaticMetamodel(Etat.class)
public class Etat_ { 

    public static volatile SingularAttribute<Etat, Integer> idetat;
    public static volatile ListAttribute<Etat, Projet> projetList;
    public static volatile SingularAttribute<Etat, String> description;

}