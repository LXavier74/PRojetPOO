USE bddProjetFileRouge;

INSERT INTO `employe` (`nom`, `prenom`, `mdp`, `nomCompte`) VALUES ('Dupont', 'Jacques', '123', 'DJac'), ('Heynckes', 'Jupp', 'BonjourA', 'JHeynck'),('LLoris', 'Hugo', 'Lala', 'IamHugo');
INSERT INTO `profil` (`libelle`) VALUES ('Mecanicien'), ('Administrateur'),('Commercial');
INSERT INTO `profilEmploye` (`idEmploye`, `idProfil`) VALUES ('1','1'), ('2','2'), ('3','3');

INSERT INTO `profilEmploye` (`idEmploye`, `idProfil`) VALUES ('1','1'), ('2','2');
INSERT INTO `typeClient` (`libelle`) VALUES ('Client Atelier'), ('Client Vente');
INSERT INTO `client` (`nom`, `prenom`, `ville`, `codePostal`, `telephone`, `mobile`) VALUES ('Zidane', 'Zinedine', 'Madrid', '74000', '0688787888', '0688787888'), ('Le père', 'Noel', 'Lyon', '47445', '0699878878', '0112459636');

INSERT INTO `fiche` (`idClient`, `dateCreation`, `dateCloture`, `idCreateur`) VALUES ('1', '2018-04-05', '2018-08-04', '2'), ('2', '2019-10-13', '2019-10-17', '2');
INSERT INTO `factureFiche` (`idFiche`, `prixHT`, `prixTTC`, `dateCreation`) VALUES ('1', 60.10 , 999.999, '2019-11-12'), ('2', 41.10 , 49.979, '2');
INSERT INTO `pieces` (`libelle`, `qte`, `dateFiche`) VALUES ('Moteur', 20 , '2019-10-12'), ('Assembleur', 5 , '2016-01-01');

INSERT INTO `taches` (`idEmploye`, description, `etat`) VALUES ('1', 'reparer le moteur' , 'pas fait'), ('2', 'commander des moteurs' , 'fait');
INSERT INTO `priorite` (`idTache`, `libelle`) VALUES ('1', 'Urgent'), ('2', 'normal');
INSERT INTO `devis` (`idCommercial`, `idClient`, `valide`, `dateCreation`) VALUES ('3', '1' , 0, '2018-04-15'), ('3', '2' , 1,'2018-04-09');

INSERT INTO `factureDevis` (`idDevis`, `prixHT`, `prixTTC`, `dateCreation`) VALUES ('1', 192.68 , 200.90, '2019-04-15'), ('2', 120.20 , 138.26,'2019-04-09');
INSERT INTO `commande` (`idDevis`, `etat`) VALUES ('1', 1), ('2', 0);
INSERT INTO `vehicule` (`qte`, `prix`) VALUES (15, 6000.0), (2, 230000.00);

INSERT INTO `devisVehicule` (`idDevis`, `idVehicule`) VALUES ('1','1'), ('2','2');
INSERT INTO `commandeVehicule` (`idCommande`, `idVehicule`, prixHT, `prixTTC`, `qte`) VALUES ('1', '2', 200000.00, 300000.00, 14), ('2','1', 100000.0,200000.0, 28);
INSERT INTO `utilisationPiece` (`idPiece`, `idTache`, `qte`) VALUES ('1', '2',11), ('2', '1', 52);
