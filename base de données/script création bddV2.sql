
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION'; 

drop schema if exists mydb;
-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`compteUtilisateur`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`compteUtilisateur` ;

CREATE TABLE IF NOT EXISTS `mydb`.`compteUtilisateur` (  
	`idcompteUtilisateur` INT NOT NULL,  
	`nomUtilisateur` VARCHAR(45) NULL,
  `mdp` VARCHAR(45) NULL,  `emailPerso` VARCHAR(45) NULL,  `numéroTelephone` VARCHAR(45) NULL,
  PRIMARY KEY (`idcompteUtilisateur`))
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `mydb`.`equipe`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`equipe` ;

CREATE TABLE IF NOT EXISTS `mydb`.`equipe` (
  `idequipe` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  PRIMARY KEY (`idequipe`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`Role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Role` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Role` (
  `idRole` INT NOT NULL AUTO_INCREMENT,
  `nomRole` VARCHAR(45) NULL,
  PRIMARY KEY (`idRole`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`forme`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`forme` ;

CREATE TABLE IF NOT EXISTS `mydb`.`forme` (
  `idforme` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  PRIMARY KEY (`idforme`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`variété`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`variété` ;

CREATE TABLE IF NOT EXISTS `mydb`.`variété` (
  `idvariété` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  PRIMARY KEY (`idvariété`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`série`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`série` ;

CREATE TABLE IF NOT EXISTS `mydb`.`série` (
  `idsérie` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  PRIMARY KEY (`idsérie`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`section`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`section` ;

CREATE TABLE IF NOT EXISTS `mydb`.`section` (
  `idsection` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  PRIMARY KEY (`idsection`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`genre`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`genre` ;

CREATE TABLE IF NOT EXISTS `mydb`.`genre` (
  `idgenre` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  PRIMARY KEY (`idgenre`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`tribu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`tribu` ;

CREATE TABLE IF NOT EXISTS `mydb`.`tribu` (
  `idtribu` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  PRIMARY KEY (`idtribu`))
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `mydb`.`ordre`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`ordre` ;

CREATE TABLE IF NOT EXISTS `mydb`.`ordre` (
  `idordre` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  PRIMARY KEY (`idordre`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`classe`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`classe` ;

CREATE TABLE IF NOT EXISTS `mydb`.`classe` (
  `idclasse` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  PRIMARY KEY (`idclasse`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`regne`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`regne` ;

CREATE TABLE IF NOT EXISTS `mydb`.`regne` (
  `idregne` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  PRIMARY KEY (`idregne`))
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `mydb`.`embranchement`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`embranchement` ;

CREATE TABLE IF NOT EXISTS `mydb`.`embranchement` (
  `idembranchement` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  PRIMARY KEY (`idembranchement`))
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `mydb`.`famille`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`famille` ;

CREATE TABLE IF NOT EXISTS `mydb`.`famille` (
  `idfamille` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  PRIMARY KEY (`idfamille`))
ENGINE = InnoDB;


-- Table mydb.taxinomie_idtaxinomie 

DROP TABLE IF EXISTS `mydb`.`taxinomie` ;

CREATE TABLE IF NOT EXISTS `mydb`.`taxinomie` (
  `idtaxinomie` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  `regne_idregne` INT NOT NULL,
  `embranchement_idembranchement` INT NOT NULL,
  `classe_idclasse` INT NOT NULL,
  `ordre_idordre` INT NOT NULL,
  `famille_idfamille` INT NOT NULL,
  `tribu_idtribu` INT NOT NULL,
  `genre_idgenre` INT NOT NULL,
  `section_idsection` INT NOT NULL,
  `variété_idvariété` INT NOT NULL,
  `forme_idforme` INT NOT NULL,
  PRIMARY KEY (`idtaxinomie`),
  CONSTRAINT `fk_taxinomie_regne` FOREIGN KEY (`regne_idregne`) REFERENCES `mydb`.`regne` (`idregne`), 
  CONSTRAINT `fk_taxinomie_embranchement` FOREIGN KEY (`embranchement_idembranchement`) REFERENCES `mydb`.`embranchement` (`idembranchement`), 
  CONSTRAINT `fk_taxinomie_classe` FOREIGN KEY (`classe_idclasse`) REFERENCES `mydb`.`classe` (`idclasse`), 
  CONSTRAINT `fk_taxinomie_ordre` FOREIGN KEY (`ordre_idordre`) REFERENCES `mydb`.`ordre` (`idordre`), 
  CONSTRAINT `fk_taxinomie_famille` FOREIGN KEY (`famille_idfamille`) REFERENCES `mydb`.`famille` (`idfamille`), 
  CONSTRAINT `fk_taxinomie_tribu` FOREIGN KEY (`tribu_idtribu`) REFERENCES `mydb`.`tribu` (`idtribu`), 
  CONSTRAINT `fk_taxinomie_genre` FOREIGN KEY (`genre_idgenre`) REFERENCES `mydb`.`genre` (`idgenre`), 
  CONSTRAINT `fk_taxinomie_section` FOREIGN KEY (`section_idsection`) REFERENCES `mydb`.`section` (`idsection`), 
  CONSTRAINT `fk_taxinomie_variete` FOREIGN KEY (`variété_idvariété`) REFERENCES `mydb`.`variété` (`idvariété`), 
  CONSTRAINT `fk_taxinomie_forme` FOREIGN KEY (`forme_idforme`) REFERENCES `mydb`.`forme` (`idforme`)	
	)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`Salle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Salle` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Salle` (
  `idSalle` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`idSalle`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`SiteDeStokage`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`SiteDeStokage` ;

CREATE TABLE IF NOT EXISTS `mydb`.`SiteDeStokage` (
  `idSiteDeStokage` INT NOT NULL AUTO_INCREMENT,
  `localisation` VARCHAR(45) NULL,
  PRIMARY KEY (`idSiteDeStokage`))
ENGINE = InnoDB;


-- Table `mydb`.`LotDeSemence`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`LotDeSemence` ;

CREATE TABLE IF NOT EXISTS `mydb`.`LotDeSemence` (
  `idLotDeSemence` INT NOT NULL AUTO_INCREMENT,
  `quantiteEnNbDeCaisses` INT default 0,
  `disponibiliteEnStock` INT default 0,
  `dureeDeStockageEnMois` INT default 0,
  `Salle_idSalle` INT,
  `SiteDeStockage_SiteDeStockage` INT NOT NULL,
  PRIMARY KEY (`idLotDeSemence`),
  CONSTRAINT `fk_lotDesemence_SiteDeStockage`
    FOREIGN KEY (`SiteDeStockage_SiteDeStockage`)
    REFERENCES `mydb`.`SiteDeStokage` (`idSiteDeStokage`),
  CONSTRAINT `fk_lotDesemence_Salle`
    FOREIGN KEY (`Salle_idSalle`)
    REFERENCES `mydb`.`Salle` (`idSalle`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`Droit`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Droit` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Droit` (
  `idDroit` INT NOT NULL AUTO_INCREMENT,
  `nomDroit` VARCHAR(45) NULL,
  PRIMARY KEY (`idDroit`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Role_has_Droit`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Role_has_Droit` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Role_has_Droit` (
  `Role_idRole` INT NOT NULL,
  `Droit_idDroit` INT NOT NULL,
  PRIMARY KEY (`Role_idRole`, `Droit_idDroit`),
  CONSTRAINT `fk_Role_has_Droit_ Role1`
    FOREIGN KEY (`Role_idRole`)
    REFERENCES `mydb`.`Role` (`idRole`),
  CONSTRAINT `fk_ Role_has_Droit_Droit1`
    FOREIGN KEY (`Droit_idDroit`)
    REFERENCES `mydb`.`Droit` (`idDroit`))
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `mydb`.`espece`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`espece` ;

CREATE TABLE IF NOT EXISTS `mydb`.`espece` (
  `idespece` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  `taxinomie_idtaxinomie` INT NOT NULL,
  PRIMARY KEY (`idespece`),
  CONSTRAINT `fk_espece_taxinomie`
    FOREIGN KEY (`taxinomie_idtaxinomie`)
    REFERENCES `mydb`.`taxinomie` (`idtaxinomie`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`semence`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`semence` ;

CREATE TABLE IF NOT EXISTS `mydb`.`semence` (
  `idsemence` INT NOT NULL AUTO_INCREMENT,
  `LotDeSemence_idLotDeSemence` int not NULL,
  `espece_idespece` int not NULL,
  PRIMARY KEY (`idsemence`),
  CONSTRAINT `fk_semence_Lotdesemence`
    FOREIGN KEY (`LotDeSemence_idLotDeSemence`)
    REFERENCES `mydb`.`LotDeSemence` (`idLotDeSemence`),
  CONSTRAINT `fk_semence_espece`
    FOREIGN KEY (`espece_idespece`)
    REFERENCES `mydb`.`espece` (`idespece`)  
  )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`alerte`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`alerte` ;

CREATE TABLE IF NOT EXISTS `mydb`.`alerte` (
  `idalerte` INT NOT NULL AUTO_INCREMENT,
  `urgence` INT default 0,
  `espece_idespece` INT NOT NULL,
  PRIMARY KEY (`idalerte`),
  CONSTRAINT `fk_alerte_espece1`
    FOREIGN KEY (`espece_idespece`)
    REFERENCES `mydb`.`espece` (`idespece`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`etat`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`etat` ;

CREATE TABLE IF NOT EXISTS `mydb`.`etat` (
  `idetat` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`idetat`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`projet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`projet` ;

CREATE TABLE IF NOT EXISTS `mydb`.`projet` (
  `idprojet` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  `dateDebut` DATETIME NULL,
  `duréeEnMois` int NULL,
  `alerte_idalerte` INT NOT NULL,
  `etat_idetat` INT NOT NULL,
  `equipe_idequipe` INT NOT NULL,
  PRIMARY KEY (`idprojet`),
  CONSTRAINT `fk_projet_equipe`
    FOREIGN KEY (`equipe_idequipe`)
    REFERENCES `mydb`.`equipe` (`idequipe` ),
  CONSTRAINT `fk_projet_alerte1`
    FOREIGN KEY (`alerte_idalerte`)
    REFERENCES `mydb`.`alerte` (`idalerte`),
  CONSTRAINT `fk_projet_etat1`
    FOREIGN KEY (`etat_idetat`)
    REFERENCES `mydb`.`etat` (`idetat`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`Salarié`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Salarié` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Salarié` (
  `idSalarié` INT NOT NULL AUTO_INCREMENT,
  `emailPro` VARCHAR(45) NULL,
  `site` VARCHAR(45) NULL,
  `numeroBatiment` VARCHAR(45) NULL,
  `rue` VARCHAR(45) NULL,
  `ville` VARCHAR(45) NULL,
  `codePostal` INT NULL,
  `nom` VARCHAR(45) NULL,
  `prénom` VARCHAR(45) NULL,
  `compteUtilisateur_idcompteUtilisateur` INT NOT NULL,
  `Role_id Role` INT NOT NULL,
  
  PRIMARY KEY (`idSalarié`),
  CONSTRAINT `fk_Salarié_compteUtilisateur1`
    FOREIGN KEY (`compteUtilisateur_idcompteUtilisateur`)
    REFERENCES `mydb`.`compteUtilisateur` (`idcompteUtilisateur`),
  CONSTRAINT `fk_Salarié_ Role1`
    FOREIGN KEY (`Role_id Role`)
    REFERENCES `mydb`.`Role` (`idRole`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`Sentinelle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Sentinelle` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Sentinelle` (
  `idsentinelle` INT NOT NULL AUTO_INCREMENT,
  `Salarié_idSalarié` INT NOT NULL,
  PRIMARY KEY (`idsentinelle`),
  CONSTRAINT `fk_sentinelle_Salarié1`
    FOREIGN KEY (`Salarié_idSalarié`)
    REFERENCES `mydb`.`Salarié` (`idSalarié`))
ENGINE = InnoDB;

alter table `compteutilisateur` add COLUMN nom varchar(20); 
alter table `compteutilisateur` add COLUMN prenom varchar(20) ; 
commit; 


-- -----------------------------------------------------
-- Table `mydb`.`AccountsToBeConfirmed`
-- -----------------------------------------------------

drop table if exists mydb.AccountsToBeConfirmed ;
create table mydb.AccountsToBeConfirmed (    
  `code` INT NOT NULL,
  `nomUtilisateurAconf` VARCHAR(45) NULL,
  `mdpAconf` VARCHAR(45) NULL,
  `emailPersoAconf` VARCHAR(45) NULL,
  `numéroTelephoneAconf` VARCHAR(45) NULL,
  `nomAconf` VARCHAR(45) NULL,
  `prenomAconf` VARCHAR(45) NULL,
  PRIMARY KEY (`code`));
  

-- -----------------------------------------------------
-- Table `mydb`.`CodeResetPassword`
-- -----------------------------------------------------
drop table if exists mydb.CodeResetPassword ;
drop table if exists mydb.Codes ;
create table mydb.CodeResetPassword (    
  `idCodeResetPassword` varchar(45) NOT NULL,
  `nomCodeResetPassword` VARCHAR(45) NULL,
  `idCompteUtilisateur` int not NULL,
  PRIMARY KEY (`idCodeResetPassword`)  
  );
  
 alter table `alerte` add COLUMN `sentinelle_idsentinelle` int not null , 
	add constraint `fk_alerte_sentinelle`
    FOREIGN KEY (`sentinelle_idsentinelle`)
    REFERENCES `mydb`.`Sentinelle` (`idsentinelle`); 
  
alter table `projet` add COLUMN `demandeur_idsalarie` int not null, 
	add constraint `fk_alerte_salarie`
    FOREIGN KEY (`demandeur_idsalarie`)
    REFERENCES `mydb`.`Salarié` (`idSalarié`);   
	
alter table `projet` add COLUMN `narrateur_idsalarie` int not null, 
	add constraint `fk_alerte_salarie1`
    FOREIGN KEY (`narrateur_idsalarie`)
    REFERENCES `mydb`.`Salarié` (`idSalarié`); 
	
	
commit; 
  