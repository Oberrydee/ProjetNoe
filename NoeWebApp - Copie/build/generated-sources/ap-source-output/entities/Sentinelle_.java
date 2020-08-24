package entities;

import entities.Alerte;
import entities.Salarié;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-24T12:35:33")
@StaticMetamodel(Sentinelle.class)
public class Sentinelle_ { 

    public static volatile ListAttribute<Sentinelle, Alerte> alerteList;
    public static volatile SingularAttribute<Sentinelle, Integer> idsentinelle;
    public static volatile SingularAttribute<Sentinelle, Salarié> salariéidSalarié;

}