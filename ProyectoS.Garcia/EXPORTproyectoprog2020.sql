/*
SQLyog Ultimate v9.02 
MySQL - 8.0.18 : Database - proyectoprog2020
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`proyectoprog2020` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `proyectoprog2020`;

/*Table structure for table `alumno` */

DROP TABLE IF EXISTS `alumno`;

CREATE TABLE `alumno` (
  `alu_dni` bigint(10) unsigned NOT NULL,
  `alu_nombre` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `alu_apellido` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `alu_fec_nac` date DEFAULT NULL,
  `alu_domicilio` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `alu_telefono` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `alu_insc_cod` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`alu_dni`),
  KEY `FK_alumno` (`alu_insc_cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `alumno` */

insert  into `alumno`(`alu_dni`,`alu_nombre`,`alu_apellido`,`alu_fec_nac`,`alu_domicilio`,`alu_telefono`,`alu_insc_cod`) values (30000000,'JOSE','LOPEZ','2020-10-01','MENDOZA','2810000000',1);

/*Table structure for table `carrera` */

DROP TABLE IF EXISTS `carrera`;

CREATE TABLE `carrera` (
  `car_cod` bigint(10) unsigned NOT NULL,
  `car_nombre` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `car_duracion` bigint(10) NOT NULL,
  PRIMARY KEY (`car_cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `carrera` */

insert  into `carrera`(`car_cod`,`car_nombre`,`car_duracion`) values (1,'Tecn. Programacion',2);

/*Table structure for table `cursado` */

DROP TABLE IF EXISTS `cursado`;

CREATE TABLE `cursado` (
  `cur_alu_dni` bigint(10) unsigned NOT NULL,
  `cur_mat_cod` bigint(10) unsigned NOT NULL,
  `cur_nota` bigint(10) NOT NULL,
  PRIMARY KEY (`cur_alu_dni`,`cur_mat_cod`),
  KEY `FK_cursado1` (`cur_mat_cod`),
  CONSTRAINT `FK_cursado` FOREIGN KEY (`cur_alu_dni`) REFERENCES `alumno` (`alu_dni`),
  CONSTRAINT `FK_cursado1` FOREIGN KEY (`cur_mat_cod`) REFERENCES `materia` (`mat_cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `cursado` */

insert  into `cursado`(`cur_alu_dni`,`cur_mat_cod`,`cur_nota`) values (30000000,1,9);

/*Table structure for table `inscripcion` */

DROP TABLE IF EXISTS `inscripcion`;

CREATE TABLE `inscripcion` (
  `insc_cod` bigint(10) unsigned NOT NULL,
  `insc_nombre` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `insc_fecha` date DEFAULT NULL,
  `insc_car_cod` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`insc_cod`),
  KEY `FK_inscripcion` (`insc_car_cod`),
  CONSTRAINT `FK_inscripcion` FOREIGN KEY (`insc_car_cod`) REFERENCES `carrera` (`car_cod`),
  CONSTRAINT `FK_inscripcion1` FOREIGN KEY (`insc_cod`) REFERENCES `alumno` (`alu_insc_cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `inscripcion` */

insert  into `inscripcion`(`insc_cod`,`insc_nombre`,`insc_fecha`,`insc_car_cod`) values (1,'insc','2020-06-01',1);

/*Table structure for table `materia` */

DROP TABLE IF EXISTS `materia`;

CREATE TABLE `materia` (
  `mat_cod` bigint(10) unsigned NOT NULL,
  `mat_nombre` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `mat_prof_dni` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`mat_cod`),
  KEY `FK_materia` (`mat_prof_dni`),
  CONSTRAINT `FK_materia` FOREIGN KEY (`mat_prof_dni`) REFERENCES `profesor` (`prof_dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `materia` */

insert  into `materia`(`mat_cod`,`mat_nombre`,`mat_prof_dni`) values (1,'Programacion',25000000);

/*Table structure for table `profesor` */

DROP TABLE IF EXISTS `profesor`;

CREATE TABLE `profesor` (
  `prof_dni` bigint(10) unsigned NOT NULL,
  `prof_nombre` bigint(30) NOT NULL,
  `prof_apellido` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `prof_fec_nac` date NOT NULL,
  `prof_domicilio` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `prof_telefono` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`prof_dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

/*Data for the table `profesor` */

insert  into `profesor`(`prof_dni`,`prof_nombre`,`prof_apellido`,`prof_fec_nac`,`prof_domicilio`,`prof_telefono`) values (25000000,0,'Perez','1980-01-01','Godoy Cruz','2610001111');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
