use mydb; 

-- insertion données droit
insert into droit values (101010, 'lot_de_semence_read', 'lot_de_semence', 'read');		
insert into droit values (101011, 'lot_de_semence_write', 'lot_de_semence', 'write');		
insert into droit values (101020, 'taxinomie_read', 'taxinomie', 'read');		
insert into droit values (101021, 'taxinomie_write', 'taxinomie', 'write');		
insert into droit values (101030, 'site_de_stockage_read', 'site_de_stockage', 'read');		
insert into droit values (101031, 'site_de_stockage_write', 'site_de_stockage', 'write');		
insert into droit values (101040, 'salaries_read', 'salaries', 'read');		
insert into droit values (101041, 'salaries_write', 'salaries', 'write');		
insert into droit values (101050, 'abonnes_read', 'abonnes', 'read');		
insert into droit values (101051, 'labonnese_write', 'abonnes', 'write');		
insert into droit values (101060, 'alertes_read', 'alertes', 'read');		
insert into droit values (101061, 'alertes_write', 'alertes', 'write');		
insert into droit values (101070, 'projets_read', 'projets', 'read');		
insert into droit values (101071, 'projets_write', 'projets', 'write');		
insert into droit values (101080, 'taches_read', 'taches', 'read');		
insert into droit values (101081, 'taches_write', 'taches', 'write');		
insert into droit values (101090, 'livre_de_sauvetage_read', 'livre_de_sauvetage', 'read');		
insert into droit values (101091, 'livre_de_sauvetage_write', 'livre_de_sauvetage', 'write');
UPDATE `droit` SET `nomDroit` = 'abonnes_write' WHERE `droit`.`idDroit` = 101051;


-- insertion donnees role
insert into role values (202010, 'abonne'); 		
insert into role values (202011, 'employe'); 		
insert into role values (202013, 'RH'); 		
insert into role values (202014, 'R&D'); 		
insert into role values (202015, 'directeur_de_production'); 		
insert into role values (202016, 'personnel_site_stockage'); 		
insert into role values (202017, 'sentinelle'); 		
insert into role values (202018, 'ITSM'); 		
insert into role values (202019, 'narrateur'); 		
insert into role values (202020, 'chet_de_projet'); 		


-- insertion donnees role_has_droit
insert into role_has_droit values (202010, 101020); 	
insert into role_has_droit values (202010, 101070); 	
insert into role_has_droit values (202010, 101090); 	
insert into role_has_droit values (202011, 101030); 	
insert into role_has_droit values (202011, 101010); 	
insert into role_has_droit values (202011, 101060); 	
insert into role_has_droit values (202013, 101030); 	
insert into role_has_droit values (202013, 101010); 	
insert into role_has_droit values (202013, 101060); 	
insert into role_has_droit values (202014, 101021); 	
insert into role_has_droit values (202014, 101020); 	
insert into role_has_droit values (202014, 101070); 	
insert into role_has_droit values (202014, 101090); 
insert into role_has_droit values (202015, 101020); 
insert into role_has_droit values (202015, 101090); 	
insert into role_has_droit values (202015, 101061); 	
insert into role_has_droit values (202018, 101030); 	
insert into role_has_droit values (202018, 101010); 	
insert into role_has_droit values (202018, 101060); 	
insert into role_has_droit values (202018, 101031); 	
insert into role_has_droit values (202018, 101070); 	
insert into role_has_droit values (202018, 101071); 	
insert into role_has_droit values (202019, 101090); 	
insert into role_has_droit values (202019, 101091); 	
insert into role_has_droit values (202016, 101020); 	
insert into role_has_droit values (202016, 101070); 	
insert into role_has_droit values (202016, 101090); 	
insert into role_has_droit values (202013, 101041); 	
insert into role_has_droit values (202017, 101030); 	
insert into role_has_droit values (202017, 101010); 	
insert into role_has_droit values (202017, 101060); 	
insert into role_has_droit values (202017, 101061); 
insert into role_has_droit values (202020, 101080); 
insert into role_has_droit values (202011, 101020); 	
insert into role_has_droit values (202011, 101070); 	
insert into role_has_droit values (202011, 101090); 	
insert into role_has_droit values (202013, 101020); 	
insert into role_has_droit values (202013, 101070); 	
insert into role_has_droit values (202013, 101090); 	
insert into role_has_droit values (202013, 101040); 	
insert into role_has_droit values (202013, 101031); 	
insert into role_has_droit values (202014, 101030); 	
insert into role_has_droit values (202014, 101010); 	
insert into role_has_droit values (202014, 101060); 	
insert into role_has_droit values (202014, 101031); 	
insert into role_has_droit values (202015, 101030); 	
insert into role_has_droit values (202015, 101010); 	
insert into role_has_droit values (202015, 101060); 	
insert into role_has_droit values (202015, 101031); 	
insert into role_has_droit values (202015, 101070); 	
insert into role_has_droit values (202015, 101071); 
insert into role_has_droit values (202018, 101020); 
insert into role_has_droit values (202018, 101090); 	
insert into role_has_droit values (202018, 101061); 	
insert into role_has_droit values (202018, 101040); 	
insert into role_has_droit values (202018, 101031); 	
insert into role_has_droit values (202016, 101030); 	
insert into role_has_droit values (202016, 101010); 	
insert into role_has_droit values (202016, 101060); 	
insert into role_has_droit values (202016, 101010); 	
insert into role_has_droit values (202016, 101011); 	
insert into role_has_droit values (202017, 101020); 	
insert into role_has_droit values (202017, 101070); 	
insert into role_has_droit values (202017, 101090); 
insert into role_has_droit values (202017, 101071); 	
insert into role_has_droit values (202020, 101081); 		

-- ex insertion salarié -- 
-- insert into salarié values (1,(select emailperso from compteutilisateur where idcompteutilisateur=318480966), null, null, null, null, null, (select nom from compteutilisateur where idcompteutilisateur = 318480966),(select prenom from compteutilisateur where idcompteutilisateur = 318480966),318480966,202018); 
                            

commit; 
