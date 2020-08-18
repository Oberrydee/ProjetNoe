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

-- ex insertion salarié -- 
-- insert into salarié values (1,(select emailperso from compteutilisateur where idcompteutilisateur=318480966), null, null, null, null, null, (select nom from compteutilisateur where idcompteutilisateur = 318480966),(select prenom from compteutilisateur where idcompteutilisateur = 318480966),318480966,202018); 
-- insert into table (1, test, test, votre email, votre num, test test);                             

commit; 

		
