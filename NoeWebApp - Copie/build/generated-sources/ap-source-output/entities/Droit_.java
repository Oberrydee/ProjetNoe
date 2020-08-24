package entities;

import entities.Role;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-24T12:35:33")
@StaticMetamodel(Droit.class)
public class Droit_ { 

    public static volatile SingularAttribute<Droit, Integer> idDroit;
    public static volatile SingularAttribute<Droit, String> nomDroit;
    public static volatile SingularAttribute<Droit, String> information;
    public static volatile SingularAttribute<Droit, String> droit;
    public static volatile ListAttribute<Droit, Role> roleList;

}