package entities;

import entities.Classe;
import entities.Embranchement;
import entities.Espece;
import entities.Famille;
import entities.Forme;
import entities.Genre;
import entities.Ordre;
import entities.Regne;
import entities.Section;
import entities.Tribu;
import entities.Variété;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-24T12:35:33")
@StaticMetamodel(Taxinomie.class)
public class Taxinomie_ { 

    public static volatile SingularAttribute<Taxinomie, Integer> idtaxinomie;
    public static volatile SingularAttribute<Taxinomie, Famille> familleIdfamille;
    public static volatile SingularAttribute<Taxinomie, Variété> variétéIdvariété;
    public static volatile SingularAttribute<Taxinomie, Regne> regneIdregne;
    public static volatile SingularAttribute<Taxinomie, String> nom;
    public static volatile SingularAttribute<Taxinomie, Tribu> tribuIdtribu;
    public static volatile ListAttribute<Taxinomie, Espece> especeList;
    public static volatile SingularAttribute<Taxinomie, Embranchement> embranchementIdembranchement;
    public static volatile SingularAttribute<Taxinomie, Forme> formeIdforme;
    public static volatile SingularAttribute<Taxinomie, Classe> classeIdclasse;
    public static volatile SingularAttribute<Taxinomie, Genre> genreIdgenre;
    public static volatile SingularAttribute<Taxinomie, Section> sectionIdsection;
    public static volatile SingularAttribute<Taxinomie, Ordre> ordreIdordre;

}