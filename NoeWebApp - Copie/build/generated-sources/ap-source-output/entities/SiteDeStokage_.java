package entities;

import entities.LotDeSemence;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-24T12:35:33")
@StaticMetamodel(SiteDeStokage.class)
public class SiteDeStokage_ { 

    public static volatile SingularAttribute<SiteDeStokage, Integer> idSiteDeStokage;
    public static volatile SingularAttribute<SiteDeStokage, String> localisation;
    public static volatile ListAttribute<SiteDeStokage, LotDeSemence> lotDeSemenceList;

}