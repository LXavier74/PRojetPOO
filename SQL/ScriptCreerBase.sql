drop  database IF EXISTS  bddprojetfilerouge;

CREATE DATABASE IF NOT EXISTS bddProjetFileRouge;

USE bddProjetFileRouge;


CREATE TABLE `employe` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `mdp` varchar(100) NOT NULL,
  `nomCompte` varchar(100) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `profil` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `libelle` varchar(100) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `profilEmploye` (
    idEmploye int NOT NULL ,
    idProfil int NOT NULL,
    FOREIGN KEY (idEmploye) REFERENCES employe(id),
	FOREIGN KEY (idProfil) REFERENCES profil(id)
	)ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `typeClient` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `libelle` varchar(100) NOT NULL

)
ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `client` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `ville` varchar(100) NOT NULL,
  `codePostal` varchar(100) NOT NULL,
  `telephone` varchar(100) NOT NULL,
  `mobile` varchar(100) NOT NULL
)
ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `fiche` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 idClient int NOT NULL,
 etat BIT default 0,
 dateCreation date,
 dateCloture date default null,
   `idCreateur` int(100) NOT NULL,
   FOREIGN KEY (idCreateur) REFERENCES employe(id),
    FOREIGN KEY (idClient) REFERENCES client(id)
)
ENGINE=InnoDB DEFAULT CHARSET=latin1;



CREATE TABLE `factureFiche` (
    id int NOT NULL ,
    idFiche int NOT NULL,
	prixHT float(11) NOT NULL,
	prixTTC float(11) NOT NULL,
	dateCreation DATE,
	 FOREIGN KEY (idFiche) REFERENCES fiche(id)
)
ENGINE=InnoDB DEFAULT CHARSET=latin1;



CREATE TABLE `pieces` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `libelle` varchar(100) NOT NULL,
    `qte` int(11) NOT NULL,
	  `dateFiche` DATE
)
ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `taches` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `idEmploye` int NOT NULL,
  `description` varchar(100) NOT NULL,
  etat varchar(100) NOT NULL,
  	FOREIGN KEY (idEmploye) REFERENCES employe(id)
)
ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `priorite` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  idTache int not null,
  `libelle` varchar(100) NOT NULL,
    	FOREIGN KEY (idTache) REFERENCES taches(id)
)
ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `devis` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `idCommercial` int NOT NULL,
  `idClient` int NOT NULL,
  `valide` bit default 0,
  `dateCreation` date,
  	FOREIGN KEY (idCommercial) REFERENCES employe(id)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `facturedevis` (
    id int NOT NULL ,
    idDevis int NOT NULL,
	prixHT float(11) NOT NULL,
	prixTTC float(11) NOT NULL,
	dateCreation DATE,
	 FOREIGN KEY (idDevis) REFERENCES devis(id)
)
ENGINE=InnoDB DEFAULT CHARSET=latin1;



CREATE TABLE `Commande` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `idDevis` int NOT NULL,
  `etat` bit default 0,
  	FOREIGN KEY (idDevis) REFERENCES devis(id)
)
ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `Vehicule` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `qte` int NOT NULL,
  `prix` float not null
)
ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `DevisVehicule` (
    idDevis int NOT NULL ,
    idVehicule int NOT NULL,
    FOREIGN KEY (idDevis) REFERENCES devis(id),
	FOREIGN KEY (idVehicule) REFERENCES vehicule(id)

)
ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `CommandeVehicule` (
    idCommande int NOT NULL ,
    idVehicule int NOT NULL,
	qte int not null,
	prixHT float not null,
	prixTTC float not null,
    FOREIGN KEY (idCommande) REFERENCES commande(id),
	FOREIGN KEY (idVehicule) REFERENCES vehicule(id)

)
ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `UtilisationPiece` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    idPiece int NOT NULL,
	idTache int not null,
	qte int not null,
    FOREIGN KEY (idPiece) REFERENCES pieces(id),
	FOREIGN KEY (idTache) REFERENCES taches(id)

)
ENGINE=InnoDB DEFAULT CHARSET=latin1;

