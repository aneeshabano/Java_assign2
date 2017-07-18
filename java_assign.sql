-- MySQL dump 10.13  Distrib 5.5.52, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: java_assign
-- ------------------------------------------------------
-- Server version	5.5.52-0ubuntu0.12.04.1

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

create database if not exists java_assign;
use java_assign;

--
-- Table structure for table `user_contact_details`
--

DROP TABLE IF EXISTS `user_contact_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_contact_details` (
  `contact_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `comments` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`contact_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_contact_details_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_details` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_contact_details`
--

LOCK TABLES `user_contact_details` WRITE;
/*!40000 ALTER TABLE `user_contact_details` DISABLE KEYS */;
INSERT INTO `user_contact_details` VALUES (1,1,'9876543211','primary_contact_number'),(3,1,'7865432101','secondary_contact_number');
/*!40000 ALTER TABLE `user_contact_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_details`
--

DROP TABLE IF EXISTS `user_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_details` (
  `user_id` int(11) NOT NULL,
  `user_firstname` varchar(45) DEFAULT NULL,
  `user_lastname` varchar(45) DEFAULT NULL,
  `user_age` int(11) DEFAULT NULL,
  `user_email` varchar(45) DEFAULT NULL,
  `user_country` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_details`
--

LOCK TABLES `user_details` WRITE;
/*!40000 ALTER TABLE `user_details` DISABLE KEYS */;
INSERT INTO `user_details` VALUES (1,'aakash','mittal',20,'aakash.mittal@gmail.com','India');
/*!40000 ALTER TABLE `user_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-18 13:21:58
