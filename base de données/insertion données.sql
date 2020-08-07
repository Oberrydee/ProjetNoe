
-- -----------------------------------------------------
-- Data for table `mydb`.`alerte`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`alerte` (`idalerte`, `urgence`, `espece_idespece`, `espece_semence_idsemence`, 
`espece_alerte_idalerte`) VALUES (NULL, 0, 1, 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`etat`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`etat` (`idetat`, `description`) VALUES (NULL, 'en court');
INSERT INTO `mydb`.`etat` (`idetat`, `description`) VALUES (NULL, 'annuler');
INSERT INTO `mydb`.`etat` (`idetat`, `description`) VALUES (NULL, 'clos');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`projet`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`projet` (`idprojet`, `nom`, `dateDebut`, `status`, `duréeEnMois`, 
`Salarié_idSalarié`, `Salarié_compteUtilisateur_idcompteUtilisateur`, `alerte_idalerte`, `etat_idetat`) 
VALUES (NULL, 'projet1',NULL, 'encour', '6', 1, 1, 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Sentinelle`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Sentinelle` (`idsentinelle`, `Salarié_idSalarié`, 
`Salarié_compteUtilisateur_idcompteUtilisateur`) VALUES (NULL, 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`LotDeSemence`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`LotDeSemence` (`idLotDeSemence`, `quantiteEnNbDeCaiseses`, `semence_idsemence`) 
VALUES (NULL, 2, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`SiteDeStokage`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`SiteDeStokage` (`idSiteDeStokage`, `salle`, `localisation`, 
`LotDeSemence_idLotDeSemence`) VALUES (NULL, 1, 'batiment', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Droit`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Droit` (`idDroit`, `nomDroit`) VALUES (NULL, 'consultation');
INSERT INTO `mydb`.`Droit` (`idDroit`, `nomDroit`) VALUES (NULL, 'modification ');
INSERT INTO `mydb`.`Droit` (`idDroit`, `nomDroit`) VALUES (NULL, 'sup');

COMMIT;

alter table `compteutilisateur` add COLUMN nom varchar(20); 
alter table `compteutilisateur` add COLUMN prenom varchar(20) ; 

INSERT INTO `semence` (`idsemence`) VALUES ('2'), ('3');

commit; 
