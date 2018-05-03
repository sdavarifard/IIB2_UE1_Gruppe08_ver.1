create database iib2_ue1_gruppe08_DB;
use iib2_ue1_gruppe08_DB;

CREATE TABLE `user` (
  `user_id` int(50) NOT NULL AUTO_INCREMENT,
  `user_vorname` varchar(128) NOT NULL,
  `user_nachname` varchar(128) NOT NULL,
  `user_tel` varchar(128) DEFAULT NULL,
  `user_email` varchar(128) NOT NULL,
  `user_username` varchar(128) NOT NULL,
  `user_password` varchar(128) NOT NULL,
  `user_taetigkeit` varchar(128) NOT NULL,
  `user_land` varchar(128) DEFAULT NULL,
  `user_stadt` varchar(128) DEFAULT NULL,
  `user_plz` varchar(128) DEFAULT NULL,
  `user_adresse` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  UNIQUE KEY `user_username_UNIQUE` (`user_username`)
);

INSERT INTO `user` VALUES 
(1,'Jack','Morgen','031256489','j.morgen@xxx.xom','user1','111111','Bauleiter','Deutchland','Dietzenbach','63128','Steinberg 60'),
(2,'Anne','Vidne','01232569','a.vid@test.tes','1','1','Bauleiter','Deutchland','Darmstadt','64287','Franziska-Braun-Straﬂe 10'),
(3,'Herr','Nachtragmanager','08-956524-2','h.manager@herr.man','N.Manager','333333','Nachtragmanager','Deutchland','Frankfurt','60629','Theodor-W.-Adorno-Platz 6'),
(4,'Frau','Nachtragmanager','00528-255256','f.manager@frau.man','Frau.N.Manager','444444','Nachtragmanager','Deutchland','Berlin','10117','Friedrichstraﬂe 43');


CREATE TABLE `project` (
  `project_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(45) NOT NULL,
  `project_anfang` datetime DEFAULT NULL,
  `project_end` datetime DEFAULT NULL,
  `project_land` varchar(20) DEFAULT NULL,
  `project_stadt` varchar(20) DEFAULT NULL,
  `project_plz` int(11) DEFAULT NULL,
  `project_adresse` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`project_id`),
  UNIQUE KEY `project_id_UNIQUE` (`project_id`)
);


INSERT INTO `project` VALUES (1,'100B Hochhaus ','2017-01-01 00:00:00','2020-01-01 00:00:00','Deutchland','Berlin','10117','Friedrichstraﬂe 43'),
(2,'Darmstadt Br¸ckenbau','2016-01-01 00:00:00','2018-01-01 00:00:00','Deutchland','Darmstadt',' 64283','Luisenpl. 5');


CREATE TABLE `user_hat_project` (
  `user_hat_project_id` int(11) NOT NULL,
  `user_hat_project_user_id` int(11) NOT NULL,
  `user_hat_project_project_id` int(11) NOT NULL,
  `user_hat_project_auftragnehmer_name` varchar(45) NOT NULL,
  PRIMARY KEY (`user_hat_project_id`,`user_hat_project_user_id`,`user_hat_project_project_id`),
  UNIQUE KEY `user_hat_project_id_UNIQUE` (`user_hat_project_id`),
  KEY `fk_user_has_project_project1_idx` (`user_hat_project_project_id`),
  KEY `fk_user_has_project_user1_idx` (`user_hat_project_user_id`),
  CONSTRAINT `fk_user_has_project_project1` FOREIGN KEY (`user_hat_project_project_id`) REFERENCES `project` (`project_id`),
  CONSTRAINT `fk_user_has_project_user1` FOREIGN KEY (`user_hat_project_user_id`) REFERENCES `user` (`user_id`)
);
INSERT INTO `user_hat_project` VALUES (1,1,1,'GMC GmbH'),(2,2,1,'GMC GmbH'),
(3,3,2,'Ari Co.'),(4,4,1,'Ari Co.');
CREATE TABLE `position` (
  `position_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `position_name` varchar(45) NOT NULL,
  `position_beschreibung` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`position_id`),
  UNIQUE KEY `project_id_UNIQUE` (`position_id`)
);
INSERT INTO `position` VALUES (1,'1 Geschoss','Teil A'),
(2,'1 Geschoss','Teil A'),
(3,'2 Geschoss','Teil A'),(4,'C.1','West');

CREATE TABLE `bauteil` (
  `bauteil_id` int(11) NOT NULL AUTO_INCREMENT,
  `bauteil_name` varchar(45) NOT NULL,
  `bauteil_project_id` int(11) NOT NULL,
  `bauteil_position_id` int(11) NOT NULL,
  PRIMARY KEY (`bauteil_id`,`bauteil_position_id`),
  UNIQUE KEY `project_id_UNIQUE` (`bauteil_id`),
  KEY `fk_bauteil_project1_idx` (`bauteil_project_id`),
  KEY `fk_bauteil_position1_idx` (`bauteil_position_id`),
  CONSTRAINT `fk_bauteil_position1` FOREIGN KEY (`bauteil_position_id`) REFERENCES `position` (`position_id`),
  CONSTRAINT `fk_bauteil_project1` FOREIGN KEY (`bauteil_project_id`) REFERENCES `project` (`project_id`)
);
INSERT INTO `bauteil` VALUES (1,'Wand',1,1),
(2,'Fenster',1,2),(3,'Dach',1,3),(4,'Stuetz',2,4);



CREATE TABLE `nachtrag` (
  `nachtrag_id` int(11) NOT NULL AUTO_INCREMENT,
  `nachtrag_titel` varchar(255) NOT NULL,
  `nachtrag_datum` datetime DEFAULT NULL,
  `nachtrag_beschreibung` varchar(100) DEFAULT NULL,
  `nachtrag_vob` varchar(45) DEFAULT NULL,
  `nachtrag_verursacher` varchar(45) DEFAULT NULL,
  `nachtrag_frist` datetime DEFAULT NULL,
  `nachtrag_bauteil_id` int(11) NOT NULL,
  PRIMARY KEY (`nachtrag_id`),
  UNIQUE KEY `nachtrag_id_UNIQUE` (`nachtrag_id`),
  KEY `fk_nachtrag_bauteil1_idx` (`nachtrag_bauteil_id`),
  CONSTRAINT `fk_nachtrag_bauteil1` FOREIGN KEY (`nachtrag_bauteil_id`) REFERENCES `bauteil` (`bauteil_id`)
);

insert into nachtrag values(2,'my Nachtrag','2017-1-1','test Beschreibung','VOB/B-3','AG','2017-1-5',1),
(3,'my Nachtrag','2017-1-1','test Beschreibung2','VOB/B-3','AG','2017-1-5',4);

CREATE TABLE `kalkulation` (
  `kalkulation_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `kalkulation_menge` double DEFAULT NULL,
  `kalkulation_einheit` varchar(8) DEFAULT NULL,
  `kalkulation_preis_einheit` double DEFAULT NULL,
  `kalkulation_preis_gesamt` double DEFAULT NULL,
  `kalkulation_nachtrag_id` int(11) NOT NULL,
  PRIMARY KEY (`kalkulation_id`,`kalkulation_nachtrag_id`),
  UNIQUE KEY `project_id_UNIQUE` (`kalkulation_id`),
  KEY `fk_kalkulation_nachtrag1_idx` (`kalkulation_nachtrag_id`),
  CONSTRAINT `fk_kalkulation_nachtrag1` FOREIGN KEY (`kalkulation_nachtrag_id`) REFERENCES `nachtrag` (`nachtrag_id`)
) ;
INSERT INTO `iib2_ue1_gruppe08_db`.`kalkulation` (`kalkulation_id`, `kalkulation_menge`, `kalkulation_einheit`, `kalkulation_preis_einheit`, `kalkulation_preis_gesamt`, `kalkulation_nachtrag_id`) VALUES ('1', '100', 'm2', '50', '50000', '1');
INSERT INTO `iib2_ue1_gruppe08_db`.`kalkulation` (`kalkulation_id`, `kalkulation_menge`, `kalkulation_einheit`, `kalkulation_preis_einheit`, `kalkulation_preis_gesamt`, `kalkulation_nachtrag_id`) VALUES ('2', '90', 'm3', '100', '90000', '2');
CREATE TABLE `pruefung` (
  `pruefung_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `pruefung_ergebnis` varchar(45) NOT NULL,
  `pruefung_datum` datetime DEFAULT NULL,
  `pruefung_nachtrag_id` int(11) NOT NULL,
  PRIMARY KEY (`pruefung_id`,`pruefung_nachtrag_id`),
  UNIQUE KEY `project_id_UNIQUE` (`pruefung_id`),
  KEY `fk_pruefung_nachtrag1_idx` (`pruefung_nachtrag_id`),
  CONSTRAINT `fk_pruefung_nachtrag1` FOREIGN KEY (`pruefung_nachtrag_id`) REFERENCES `nachtrag` (`nachtrag_id`)
);
INSERT INTO `iib2_ue1_gruppe08_db`.`pruefung` (`pruefung_id`, `pruefung_ergebnis`, `pruefung_datum`, `pruefung_nachtrag_id`) VALUES ('1', 'Accepted', '2017-1-5', '1');
INSERT INTO `iib2_ue1_gruppe08_db`.`pruefung` (`pruefung_id`, `pruefung_ergebnis`, `pruefung_datum`, `pruefung_nachtrag_id`) VALUES ('2', 'Rejected', '2018-2-5', '2');

CREATE TABLE IF NOT EXISTS `iib2_ue1_gruppe08_db`.`inbox` (
  `inbox_id` INT NOT NULL AUTO_INCREMENT,
  `inbox_datum` DATETIME NULL,
  `inbox_text` VARCHAR(1000) NULL,
  `inbox_user_id` INT(50) NOT NULL,
  PRIMARY KEY (`inbox_id`, `inbox_user_id`),
  UNIQUE INDEX `nachricht_id_UNIQUE` (`inbox_id` ASC),
  INDEX `fk_inbox_user1_idx` (`inbox_user_id` ASC),
  CONSTRAINT `fk_inbox_user1`
    FOREIGN KEY (`inbox_user_id`)
    REFERENCES `iib2_ue1_gruppe08_db`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

 CREATE TABLE IF NOT EXISTS `iib2_ue1_gruppe08_db`.`compose` (
  `compose_id` INT NOT NULL AUTO_INCREMENT,
  `compose_datum` DATETIME NULL,
  `compose_text` VARCHAR(1000) NULL,
  `compose_user_id` INT(50) NOT NULL,
  `compose_empfaenger_id` INT(50) NOT NULL,
  PRIMARY KEY (`compose_id`, `compose_empfaenger_id`),
  UNIQUE INDEX `nachricht_id_UNIQUE` (`compose_id` ASC),
  INDEX `fk_compose_user1_idx` (`compose_empfaenger_id` ASC),
  CONSTRAINT `fk_compose_user1`
    FOREIGN KEY (`compose_empfaenger_id`)
    REFERENCES `iib2_ue1_gruppe08_db`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
