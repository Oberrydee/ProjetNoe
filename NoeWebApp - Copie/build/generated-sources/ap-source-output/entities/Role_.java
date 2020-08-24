package entities;

import entities.Droit;
import entities.Salarié;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-24T12:35:33")
@StaticMetamodel(Role.class)
public class Role_ { 

    public static volatile ListAttribute<Role, Droit> droitList;
    public static volatile SingularAttribute<Role, Integer> idRole;
    public static volatile ListAttribute<Role, Salarié> salariéList;
    public static volatile SingularAttribute<Role, String> nomRole;

}