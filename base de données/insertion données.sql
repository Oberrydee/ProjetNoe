use mydb; 

-- insertion données Droit
insert into Droit values (101010, 'lot_de_semence_read', 'lot_de_semence', 'read');		
insert into Droit values (101011, 'lot_de_semence_write', 'lot_de_semence', 'write');		
insert into Droit values (101020, 'taxinomie_read', 'taxinomie', 'read');		
insert into Droit values (101021, 'taxinomie_write', 'taxinomie', 'write');		
insert into Droit values (101030, 'site_de_stockage_read', 'site_de_stockage', 'read');		
insert into Droit values (101031, 'site_de_stockage_write', 'site_de_stockage', 'write');		
insert into Droit values (101040, 'salaries_read', 'salaries', 'read');		
insert into Droit values (101041, 'salaries_write', 'salaries', 'write');		
insert into Droit values (101050, 'abonnes_read', 'abonnes', 'read');		
insert into Droit values (101051, 'labonnese_write', 'abonnes', 'write');		
insert into Droit values (101060, 'alertes_read', 'alertes', 'read');		
insert into Droit values (101061, 'alertes_write', 'alertes', 'write');		
insert into Droit values (101070, 'projets_read', 'projets', 'read');		
insert into Droit values (101071, 'projets_write', 'projets', 'write');		
insert into Droit values (101080, 'taches_read', 'taches', 'read');		
insert into Droit values (101081, 'taches_write', 'taches', 'write');		
insert into Droit values (101090, 'livre_de_sauvetage_read', 'livre_de_sauvetage', 'read');		
insert into Droit values (101091, 'livre_de_sauvetage_write', 'livre_de_sauvetage', 'write');
UPDATE `Droit` SET `nomDroit` = 'abonnes_write' WHERE `Droit`.`idDroit` = 101051;


-- insertion donnees Role
insert into Role values (202010, 'abonne'); 		
insert into Role values (202011, 'employe'); 		
insert into Role values (202013, 'RH'); 		
insert into Role values (202014, 'R&D'); 		
insert into Role values (202015, 'directeur_de_production'); 		
insert into Role values (202016, 'personnel_site_stockage'); 		
insert into Role values (202017, 'sentinelle'); 		
insert into Role values (202018, 'ITSM'); 		
insert into Role values (202019, 'narrateur'); 		
insert into Role values (202020, 'chet_de_projet'); 		


-- insertion donnees Role_has_Droit
insert into Role_has_Droit values (202010, 101020); 	
insert into Role_has_Droit values (202010, 101070); 	
insert into Role_has_Droit values (202010, 101090); 	
insert into Role_has_Droit values (202011, 101030); 	
insert into Role_has_Droit values (202011, 101010); 	
insert into Role_has_Droit values (202011, 101060); 	
insert into Role_has_Droit values (202013, 101030); 	
insert into Role_has_Droit values (202013, 101010); 	
insert into Role_has_Droit values (202013, 101060); 	
insert into Role_has_Droit values (202014, 101021); 	
insert into Role_has_Droit values (202014, 101020); 	
insert into Role_has_Droit values (202014, 101070); 	
insert into Role_has_Droit values (202014, 101090); 
insert into Role_has_Droit values (202015, 101020); 
insert into Role_has_Droit values (202015, 101090); 	
insert into Role_has_Droit values (202015, 101061); 	
insert into Role_has_Droit values (202018, 101030); 	
insert into Role_has_Droit values (202018, 101010); 	
insert into Role_has_Droit values (202018, 101060); 	
insert into Role_has_Droit values (202018, 101070); 	
insert into Role_has_Droit values (202018, 101071); 	
insert into Role_has_Droit values (202019, 101090); 	
insert into Role_has_Droit values (202019, 101091); 	
insert into Role_has_Droit values (202016, 101020); 	
insert into Role_has_Droit values (202016, 101070); 	
insert into Role_has_Droit values (202016, 101090); 	
insert into Role_has_Droit values (202013, 101041); 	
insert into Role_has_Droit values (202017, 101030); 	
insert into Role_has_Droit values (202017, 101010); 	
insert into Role_has_Droit values (202017, 101060); 	
insert into Role_has_Droit values (202017, 101061); 
insert into Role_has_Droit values (202020, 101080); 
insert into Role_has_Droit values (202011, 101020); 	
insert into Role_has_Droit values (202011, 101070); 	
insert into Role_has_Droit values (202011, 101090); 	
insert into Role_has_Droit values (202013, 101020); 	
insert into Role_has_Droit values (202013, 101070); 	
insert into Role_has_Droit values (202013, 101090); 	
insert into Role_has_Droit values (202013, 101040); 	
insert into Role_has_Droit values (202013, 101031); 	
insert into Role_has_Droit values (202014, 101030); 	
insert into Role_has_Droit values (202014, 101010); 	
insert into Role_has_Droit values (202014, 101060); 	
insert into Role_has_Droit values (202014, 101031); 	
insert into Role_has_Droit values (202015, 101030); 	
insert into Role_has_Droit values (202015, 101010); 	
insert into Role_has_Droit values (202015, 101060); 	
insert into Role_has_Droit values (202015, 101031); 	
insert into Role_has_Droit values (202015, 101070); 	
insert into Role_has_Droit values (202015, 101071); 
insert into Role_has_Droit values (202018, 101020); 
insert into Role_has_Droit values (202018, 101090); 	
insert into Role_has_Droit values (202018, 101061); 	
insert into Role_has_Droit values (202018, 101040); 	
insert into Role_has_Droit values (202018, 101031); 	
insert into Role_has_Droit values (202016, 101030); 	
insert into Role_has_Droit values (202017, 101020); 	
insert into Role_has_Droit values (202017, 101070); 	
insert into Role_has_Droit values (202017, 101090); 
insert into Role_has_Droit values (202017, 101071); 	
insert into Role_has_Droit values (202020, 101081); 		

-- insertion comptes utilisateurs

insert into compteUtilisateur values(46, 'test', 'test', "RH", "mdpRH", "test", "test");
insert into compteUtilisateur values(47, 'test', 'test', "RD", "mdpRD", "test", "test");
insert into compteUtilisateur values(48, 'test', 'test', "DP", "mdpDP", "test", "test");
insert into compteUtilisateur values(49, 'test', 'test', "employe", "employe", "test", "test");
insert into compteUtilisateur values(50, 'test', 'test', "PST", "mdpPST", "test", "test");
insert into compteUtilisateur values(51, 'test', 'test', "narrateur", "narrateur", "test", "test");
insert into compteUtilisateur values(52, 'test', 'test', "sentinelle", "sentinelle", "test", "test");
insert into compteUtilisateur values(53, 'test', 'test', "CDP", "mdpCDP", "test", "test");
insert into compteUtilisateur values(7536, 'test', 'test', "ITSM", "mdpITSM", "test", "test");  

-- ex insertion salarié -- 
			
insert into Salarié values (49,(select emailperso from compteUtilisateur where idcompteUtilisateur=49), 
	null, null, null, null, null, (select nom from compteUtilisateur where idcompteUtilisateur = 49),
	(select prenom from compteUtilisateur where idcompteUtilisateur = 49),49,202011); 
	
insert into Salarié values (46,(select emailperso from compteUtilisateur where idcompteUtilisateur=46), 
	null, null, null, null, null, (select nom from compteUtilisateur where idcompteUtilisateur = 46),
	(select prenom from compteUtilisateur where idcompteUtilisateur = 46),46,202013); 
                      
insert into Salarié values (47,(select emailperso from compteUtilisateur where idcompteUtilisateur=47), 
	null, null, null, null, null, (select nom from compteUtilisateur where idcompteUtilisateur = 47),
	(select prenom from compteUtilisateur where idcompteUtilisateur = 47),47,202014); 
                      
insert into Salarié values (48,(select emailperso from compteUtilisateur where idcompteUtilisateur=48), 
	null, null, null, null, null, (select nom from compteUtilisateur where idcompteUtilisateur = 48),
	(select prenom from compteUtilisateur where idcompteUtilisateur = 48),48,202015); 
                      
insert into Salarié values (50,(select emailperso from compteUtilisateur where idcompteUtilisateur=50), 
	null, null, null, null, null, (select nom from compteUtilisateur where idcompteUtilisateur = 50),
	(select prenom from compteUtilisateur where idcompteUtilisateur = 50),50,202016);
                      
insert into Salarié values (51,(select emailperso from compteUtilisateur where idcompteUtilisateur=51), 
	null, null, null, null, null, (select nom from compteUtilisateur where idcompteUtilisateur = 51),
	(select prenom from compteUtilisateur where idcompteUtilisateur = 51),51,202019);  
                      
insert into Salarié values (52,(select emailperso from compteUtilisateur where idcompteUtilisateur=52), 
	null, null, null, null, null, (select nom from compteUtilisateur where idcompteUtilisateur = 52),
	(select prenom from compteUtilisateur where idcompteUtilisateur = 52),52,202017); 
                      
insert into Salarié values (53,(select emailperso from compteUtilisateur where idcompteUtilisateur=53), 
	null, null, null, null, null, (select nom from compteUtilisateur where idcompteUtilisateur = 53),
	(select prenom from compteUtilisateur where idcompteUtilisateur = 53),53,202020); 	
	
insert into Salarié values (7536,(select emailperso from compteUtilisateur where idcompteUtilisateur=7536), 
null, null, null, null, null, (select nom from compteUtilisateur where idcompteUtilisateur = 7536),
(select prenom from compteUtilisateur where idcompteUtilisateur = 7536),7536,202018); 


commit; 

		
