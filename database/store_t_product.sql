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
-- Table structure for table `t_product`
--

DROP TABLE IF EXISTS `t_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_product` (
  `id` int NOT NULL COMMENT 'id',
  `category_id` int DEFAULT NULL COMMENT 'category id',
  `item_type` varchar(100) DEFAULT NULL COMMENT 'item type',
  `title` varchar(100) DEFAULT NULL COMMENT 'title',
  `price` varchar(45) DEFAULT NULL,
  `num` int DEFAULT NULL COMMENT 'inventory num',
  `image` varchar(500) DEFAULT NULL COMMENT 'image path',
  `status` int DEFAULT '1' COMMENT 'product status  1：avaliable   2：sold-out   3：deleted',
  `priority` int DEFAULT NULL COMMENT 'priority',
  `created_time` datetime DEFAULT NULL COMMENT 'created time',
  `modified_time` datetime DEFAULT NULL COMMENT 'last modified',
  `created_user` varchar(50) DEFAULT NULL COMMENT 'created person',
  `modified_user` varchar(50) DEFAULT NULL COMMENT 'last modified user',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product`
--

LOCK TABLES `t_product` WRITE;
/*!40000 ALTER TABLE `t_product` DISABLE KEYS */;
INSERT INTO `t_product` VALUES (10000001,1,'PS5','Horizon Forbidden West Launch Edition - PlayStation 5','69.99',99999,'/images/portal/1Horizon-Forbidden-West-Launch-Edition/',1,2,'2017-10-25 15:08:55','2017-10-25 15:08:55','admin','admin'),(10000002,1,'PS5','Marvel\'s Spider-Man: Miles Morales Standard - PlayStation 5','29.99',99999,'/images/portal/2Marvels-Spider-Man-Miles-Morales-Standard/',1,1,'2017-10-25 15:08:55','2017-10-25 15:08:55','admin','admin'),(10000003,1,'PS5','Call of Duty: Vanguard - PlayStation 5','39.99',99999,'/images/portal/3Call-of-Duty-Vanguard/',1,3,'2017-10-25 15:08:55','2017-10-25 15:08:55','admin','admin'),(10000004,1,'PS5','Elden-Ring----PlayStation-5','49.99',99999,'/images/portal/4Elden-Ring----PlayStation-5/',1,4,'2017-10-25 15:08:55','2017-10-25 15:08:55','admin','admin'),(10000005,1,'PS5','NBA 2K23 Championship Edition - PlayStation 5','149.99',99999,'/images/portal/5NBA-2K23-Championship-Edition--PlayStation-5/',1,5,'2017-10-25 15:08:55','2017-10-25 15:08:55','admin','admin'),(10000006,1,'PS5','God of War Ragnarok Launch Edition - PlayStation 5','69.99',99999,'/images/portal/6God-of-War-Ragnarok-Launch-Edition--PlayStation-5/',1,6,'2017-10-25 15:08:55','2017-10-25 15:08:55','admin','admin'),(10000007,1,'PS5','Madden NFL 23 - PlayStation 5','69.99',99999,'/images/portal/7Madden-NFL-23-PlayStation-5/',1,7,'2017-10-25 15:08:55','2017-10-25 15:08:55','admin','admin');
/*!40000 ALTER TABLE `t_product` ENABLE KEYS */;
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
