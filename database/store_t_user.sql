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
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_user` (
  `uid` int NOT NULL AUTO_INCREMENT COMMENT 'unique user id',
  `username` varchar(45) DEFAULT NULL COMMENT 'username',
  `password` char(32) DEFAULT NULL COMMENT 'password',
  `salt` char(36) DEFAULT NULL COMMENT 'encoding user information',
  `phone` varchar(20) DEFAULT NULL COMMENT 'phone number',
  `email` varchar(30) DEFAULT NULL COMMENT 'email address',
  `gender` int DEFAULT NULL COMMENT '0- for female, 1-for male',
  `avatar` varchar(100) DEFAULT NULL COMMENT 'user avatar',
  `is_delete` int DEFAULT NULL COMMENT '0- for not delete, 1- for deleted',
  `created_user` varchar(45) DEFAULT NULL COMMENT 'created user',
  `created_time` datetime DEFAULT NULL COMMENT 'created time',
  `modified_user` varchar(45) DEFAULT NULL COMMENT 'final modified user',
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'user01','123456',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'user01','123456',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'user03','7B3AA728E59F9AC2BD9FA08CB65B5A2D','B2FE4193-3F4B-4882-9D01-456BD5398C58','6281234567','user@gmail.com',0,'avatar.png',0,'user03','2022-07-20 06:51:46','user03','2022-07-30 12:07:09'),(4,'user02','09710806795D853EE609317231061B07','404A1D05-A815-4B04-944E-946E2B12E255',NULL,NULL,NULL,'/upload/avatar.png',0,'user02','2022-07-20 10:42:31','user02','2022-07-30 12:29:53'),(5,'test1','5DABC3986BC79C5DA4DC5BE85E65D9F6','D1089A28-424B-40BC-96F4-F8C606940DF5',NULL,NULL,NULL,NULL,0,'test1','2022-07-20 13:36:07','test1','2022-07-20 13:36:07'),(7,'test2','561081BFD0031CE4C2C927EB7DC065E3','A4FDC1A4-23E3-4E40-8ACC-39F0BB76491B',NULL,NULL,NULL,NULL,0,'test2','2022-07-30 13:45:44','test2','2022-07-30 13:45:44'),(8,'test3','EBE99B584E53AB84FB9525D7383CAAB1','43E45655-2141-4D0B-9DE3-667D7929BB47','6125177211','yejing002@gmail.com',1,'/upload/f0a9fb17-3b6e-40a2-b694-709e23f6dc74.png',0,'test3','2022-08-01 04:24:08','test3','2022-08-01 05:12:48'),(9,'test4','E2B116EDC4AFA6731DE0BDBFC317FB9A','FD6BA8A4-ED0F-4A89-9276-B1D73782492E','+1 9377828454','yejing002@gmail.com',0,'/upload/2e2a8d42-3424-44cc-b22d-705fb3f1dd92.jpeg',0,'test4','2022-08-01 06:02:44','test4','2022-08-17 03:57:54'),(10,'test5','ECE1F53C030E9925709A8F165BCA044B','D2D0668A-266E-4EAE-BA3E-556D9EC578DE',NULL,NULL,NULL,'/upload/cb080b1d-2051-418f-b0f0-a4ae61b2add6.png',0,'test5','2022-08-04 06:30:43','test5','2022-08-04 07:00:33'),(11,'Demo1','54FB9B5EF1794B89170326D45C3678AE','428FD1CD-DB42-418D-B893-95D049F35C7A','(612) 517-7211','yejing002@gmail.com',NULL,NULL,0,'Demo1','2022-08-08 08:59:07','Demo1','2022-08-08 14:03:16'),(12,'Demo2','6FD14181BD7E3015C6234C1509AEA9BE','11AAE723-C9C0-43BC-9377-01D65D0C239D','(612) 517-7211','yejing002@gmail.com',NULL,'/upload/a67c0449-4eb3-403c-9210-a812e856e0c4.png',0,'Demo2','2022-08-17 04:56:55','Demo2','2022-08-17 04:59:37');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
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