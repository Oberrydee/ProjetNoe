package entities;

import entities.Projet;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-24T12:35:33")
@StaticMetamodel(Equipe.class)
public class Equipe_ { 

    public static volatile SingularAttribute<Equipe, Integer> idequipe;
    public static volatile ListAttribute<Equipe, Projet> projetList;
    public static volatile SingularAttribute<Equipe, String> nom;

}