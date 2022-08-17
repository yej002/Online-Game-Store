-- MySQL dump 10.13  Distrib 8.0.27, for macos11 (x86_64)
--
-- Host: 127.0.0.1    Database: store
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_address`
--

DROP TABLE IF EXISTS `t_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_address` (
  `aid` int NOT NULL AUTO_INCREMENT COMMENT 'id of receiving address',
  `uid` int DEFAULT NULL COMMENT 'user id',
  `name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'receipt name',
  `state_name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'province name',
  `city_name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'city name',
  `zip` char(5) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'detailed address',
  `phone` varchar(12) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `is_default` int DEFAULT NULL COMMENT 'default address',
  `created_user` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `modified_user` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_address`
--

LOCK TABLES `t_address` WRITE;
/*!40000 ALTER TABLE `t_address` DISABLE KEYS */;
INSERT INTO `t_address` VALUES (2,7,'test2',NULL,NULL,NULL,'55 9th Street','9377824444',NULL,NULL,NULL,NULL,NULL),(3,6,'test1',NULL,NULL,NULL,'55 9th Street','9377823333',NULL,NULL,NULL,NULL,NULL),(4,2,'Jing Ye',NULL,NULL,NULL,'55 9th Street','6125177777',1,'user01','2022-08-01 03:50:12','user01','2022-08-01 04:46:28'),(5,2,'Jing Ye',NULL,NULL,NULL,'55 9th Street','6125177777',0,'user01','2022-08-01 03:53:29','user01','2022-08-01 03:53:29'),(8,8,'JING YE',NULL,'0','61822','4540 Nicklaus Drive\r\n204','9377828454',1,'test3','2022-08-01 05:30:59','test3','2022-08-01 05:30:59'),(13,2,'test2','CA','San Fransisco',NULL,'55 9th Street','9377824444',NULL,NULL,NULL,NULL,NULL),(14,3,'test1',NULL,NULL,NULL,'55 9th Street','9377823333',NULL,NULL,NULL,NULL,NULL),(16,10,'JING YE','IL','Champaign','61822','4540 Nicklaus Drive\r\n204','9377828454',1,'test5','2022-08-04 06:34:04','test5','2022-08-04 06:34:04'),(17,10,'JING YE','IL','Champaign','61822','4540 Nicklaus Drive\r\n204','9377828454',0,'test5','2022-08-04 06:36:02','test5','2022-08-04 06:36:02'),(18,10,'JING YE','CA','San Francisco','94103','55 9th Street, Apt.1517\r\n1517','16282869063',0,'test5','2022-08-04 06:38:02','test5','2022-08-04 06:38:02'),(19,10,'JING YE','CA','San Francisco','94103','55 9th Street, Apt.1517\r\n1517','16282869063',0,'test5','2022-08-04 06:39:05','test5','2022-08-04 06:39:05'),(23,9,'JING YE','IL','Champaign','61822','4540 Nicklaus Drive\r\n204','9377828454',1,'test4','2022-08-09 06:39:21','test4','2022-08-16 12:10:31'),(26,11,'JING YE','CA','San Francisco','94103','55 9th Street, Apt.1517','16282869063',1,'Demo1','2022-08-16 06:36:24','Demo1','2022-08-16 06:36:24'),(27,11,'JING YE','IL','Champaign','61822','4540 Nicklaus Drive\r\n204','9377828454',0,'Demo1','2022-08-16 06:36:38','Demo1','2022-08-16 06:36:38'),(28,11,'JING YE','IL','Champaign','61822','4540 Nicklaus Drive\r\n204','9377828454',0,'Demo1','2022-08-16 06:56:43','Demo1','2022-08-16 06:56:43'),(29,9,'JING YE','IL','Champaign','61822','4540 Nicklaus Drive\r\n204','9377828454',0,'test4','2022-08-16 12:10:03','test4','2022-08-16 12:10:31'),(31,12,'JING YE','CA','San Francisco','94103','55 9th Street, Apt.1517\r\n1517','16282869063',1,'Demo2','2022-08-17 04:59:59','Demo2','2022-08-17 05:00:11'),(32,12,'JING YE','IL','Champaign','61822','4540 Nicklaus Drive\r\n204','9377828454',0,'Demo2','2022-08-17 05:00:22','Demo2','2022-08-17 05:00:22');
/*!40000 ALTER TABLE `t_address` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-16 20:36:57
