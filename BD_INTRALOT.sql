CREATE DATABASE  IF NOT EXISTS `intralot` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `intralot`;
-- MySQL dump 10.13  Distrib 5.7.32, for Linux (x86_64)
--
-- Host: localhost    Database: intralot
-- ------------------------------------------------------
-- Server version	5.7.32-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_detalle_equipo_jugador`
--

DROP TABLE IF EXISTS `tb_detalle_equipo_jugador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_detalle_equipo_jugador` (
  `idtb_detalle_equipo_jugador` int(11) NOT NULL AUTO_INCREMENT,
  `idtb_jugador` int(11) DEFAULT NULL,
  `idtb_equipo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idtb_detalle_equipo_jugador`),
  KEY `idtb_jugador` (`idtb_jugador`),
  KEY `idtb_equipo` (`idtb_equipo`),
  CONSTRAINT `tb_detalle_equipo_jugador_ibfk_1` FOREIGN KEY (`idtb_jugador`) REFERENCES `tb_jugador` (`idtb_jugador`),
  CONSTRAINT `tb_detalle_equipo_jugador_ibfk_2` FOREIGN KEY (`idtb_equipo`) REFERENCES `tb_equipo` (`idtb_equipo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_detalle_equipo_jugador`
--

LOCK TABLES `tb_detalle_equipo_jugador` WRITE;
/*!40000 ALTER TABLE `tb_detalle_equipo_jugador` DISABLE KEYS */;
INSERT INTO `tb_detalle_equipo_jugador` VALUES (1,1,1);
/*!40000 ALTER TABLE `tb_detalle_equipo_jugador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_equipo`
--

DROP TABLE IF EXISTS `tb_equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_equipo` (
  `idtb_equipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_equipo` varchar(50) DEFAULT NULL,
  `nombre_estadio` varchar(50) DEFAULT NULL,
  `aforo` int(11) DEFAULT NULL,
  `año_fundacion` date DEFAULT NULL,
  `ciudad` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idtb_equipo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_equipo`
--

LOCK TABLES `tb_equipo` WRITE;
/*!40000 ALTER TABLE `tb_equipo` DISABLE KEYS */;
INSERT INTO `tb_equipo` VALUES (1,'Los angeles','gb',15,'1996-05-05','Lima'),(2,'Los angeles','gb',15,'1996-05-05','Lima'),(3,'Los angeles','gb',15,'1996-05-05','Lima');
/*!40000 ALTER TABLE `tb_equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_jugador`
--

DROP TABLE IF EXISTS `tb_jugador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_jugador` (
  `idtb_jugador` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `posicion` varchar(50) DEFAULT NULL,
  `idtb_ligas_partidos` int(11) NOT NULL,
  `descripcion_gol` varchar(255) NOT NULL,
  `goles_equipo_local` int(11) NOT NULL,
  `goles_equipo_visitante` int(11) NOT NULL,
  `minuto_hora_gol` varchar(255) NOT NULL,
  `detalle_idtb_detalle_equipo_jugador` int(11) DEFAULT NULL,
  `idtb_detalle_equipo_jugador` int(11) NOT NULL,
  PRIMARY KEY (`idtb_jugador`),
  KEY `FKn4pu9n0mqttg4vydrxiiihcs3` (`detalle_idtb_detalle_equipo_jugador`),
  CONSTRAINT `FKn4pu9n0mqttg4vydrxiiihcs3` FOREIGN KEY (`detalle_idtb_detalle_equipo_jugador`) REFERENCES `tb_detalle_equipo_jugador` (`idtb_detalle_equipo_jugador`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_jugador`
--

LOCK TABLES `tb_jugador` WRITE;
/*!40000 ALTER TABLE `tb_jugador` DISABLE KEYS */;
INSERT INTO `tb_jugador` VALUES (1,'Javier','1999-08-08','Arquero',0,'',0,0,'',NULL,0),(2,'Diego','1996-06-04','Arquero',0,'',0,0,'',NULL,0),(3,'Arquero','1996-06-04','1',0,'',0,0,'',NULL,0),(4,'Arquero','1996-06-04','1',0,'',0,0,'',NULL,0),(5,'Defensa','1996-06-04','2',0,'',0,0,'',NULL,0),(6,'Diego','1996-06-04','Defensa',0,'',0,0,'',NULL,0),(7,'Diego','1996-06-04','Volante',0,'',0,0,'',NULL,0);
/*!40000 ALTER TABLE `tb_jugador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_ligas_partidos`
--

DROP TABLE IF EXISTS `tb_ligas_partidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_ligas_partidos` (
  `idtb_ligas_partidos` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_partido` date DEFAULT NULL,
  `goles_equipo_local` int(11) DEFAULT NULL,
  `goles_equipo_visitante` int(11) DEFAULT NULL,
  `idtb_detalle_equipo_jugador` int(11) DEFAULT NULL,
  `minuto_hora_gol` varchar(100) DEFAULT NULL,
  `descripcion_gol` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idtb_ligas_partidos`),
  KEY `idtb_detalle_equipo_jugador` (`idtb_detalle_equipo_jugador`),
  CONSTRAINT `tb_ligas_partidos_ibfk_1` FOREIGN KEY (`idtb_detalle_equipo_jugador`) REFERENCES `tb_detalle_equipo_jugador` (`idtb_detalle_equipo_jugador`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_ligas_partidos`
--

LOCK TABLES `tb_ligas_partidos` WRITE;
/*!40000 ALTER TABLE `tb_ligas_partidos` DISABLE KEYS */;
INSERT INTO `tb_ligas_partidos` VALUES (1,'1966-09-09',4,5,1,'','Muchos'),(2,'1966-09-09',4,5,1,'','Muchos'),(3,'1966-09-09',4,5,1,'Now()','Muchos'),(4,'1966-09-09',4,5,1,'26815623 min, 54 sec','Muchos'),(5,'1966-09-09',4,5,1,'18:7:12','Muchos');
/*!40000 ALTER TABLE `tb_ligas_partidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'intralot'
--

--
-- Dumping routines for database 'intralot'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-25 18:40:26
