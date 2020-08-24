package entities;

import entities.Salle;
import entities.Semence;
import entities.SiteDeStokage;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-24T12:35:33")
@StaticMetamodel(LotDeSemence.class)
public class LotDeSemence_ { 

    public static volatile SingularAttribute<LotDeSemence, SiteDeStokage> siteDeStockageSiteDeStockage;
    public static volatile ListAttribute<LotDeSemence, Semence> semenceList;
    public static volatile SingularAttribute<LotDeSemence, Integer> disponibiliteEnStock;
    public static volatile SingularAttribute<LotDeSemence, Integer> dureeDeStockageEnMois;
    public static volatile SingularAttribute<LotDeSemence, Integer> idLotDeSemence;
    public static volatile SingularAttribute<LotDeSemence, Integer> quantiteEnNbDeCaisses;
    public static volatile SingularAttribute<LotDeSemence, Salle> salleidSalle;

}