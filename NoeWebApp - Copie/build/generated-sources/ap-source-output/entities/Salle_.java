package entities;

import entities.LotDeSemence;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-24T12:35:33")
@StaticMetamodel(Salle.class)
public class Salle_ { 

    public static volatile ListAttribute<Salle, LotDeSemence> lotDeSemenceList;
    public static volatile SingularAttribute<Salle, String> description;
    public static volatile SingularAttribute<Salle, Integer> idSalle;

}