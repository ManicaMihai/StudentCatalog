-- Dumping database structure for hibernate_db  
CREATE DATABASE IF NOT EXISTS `studentscatalog` /*!40100 DEFAULT CHARACTER SET latin1 */;  
USE `studentscatalog`; 

-- Dumping structure for table studentscatalog.users  
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `isTeacher` bit(1) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ncoa9bfasrql0x4nhmh1plxxy` (`email`),
  UNIQUE KEY `UK_e8pwwyd4x0tdcvbeust6x0pyg` (`phone`),
  UNIQUE KEY `UK_23y4gd49ajvbqgl3psjsvhff6` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping structure for table studentscatalog.courses  
CREATE TABLE IF NOT EXISTS `courses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `teacherId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_tloa6470p15f2vqulhosuuqeh` (`teacherId`),
  CONSTRAINT `FK_tloa6470p15f2vqulhosuuqeh` FOREIGN KEY (`teacherId`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping structure for table studentscatalog.grades  
CREATE TABLE IF NOT EXISTS `grades` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `grade` int(11) DEFAULT NULL,
  `courseId` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_4ylhry31gm70uof0lm9036ki9` (`courseId`),
  UNIQUE KEY `UK_h7n4sxx5bf2kwfusfvgqofe4m` (`studentId`),
  CONSTRAINT `FK_h7n4sxx5bf2kwfusfvgqofe4m` FOREIGN KEY (`studentId`) REFERENCES `users` (`id`),
  CONSTRAINT `FK_4ylhry31gm70uof0lm9036ki9` FOREIGN KEY (`courseId`) REFERENCES `courses` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

