package entities;

import entities.Espece;
import entities.LotDeSemence;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-24T12:35:33")
@StaticMetamodel(Semence.class)
public class Semence_ { 

    public static volatile SingularAttribute<Semence, Integer> idsemence;
    public static volatile SingularAttribute<Semence, Espece> especeIdespece;
    public static volatile SingularAttribute<Semence, LotDeSemence> lotDeSemenceidLotDeSemence;

}