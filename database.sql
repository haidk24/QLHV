-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: db_qlhv
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `hoc_vien`
--

DROP TABLE IF EXISTS `hoc_vien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoc_vien` (
  `ma_hoc_vien` int NOT NULL AUTO_INCREMENT,
  `ho_ten` varchar(45) DEFAULT NULL,
  `ngay_sinh` date DEFAULT NULL,
  `gioi_tinh` bit(1) DEFAULT NULL,
  `so_dien_thoai` varchar(45) DEFAULT NULL,
  `dia_chi` varchar(45) DEFAULT NULL,
  `tinh_trang` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ma_hoc_vien`)
) ENGINE=InnoDB AUTO_INCREMENT=23123115 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoc_vien`
--

LOCK TABLES `hoc_vien` WRITE;
/*!40000 ALTER TABLE `hoc_vien` DISABLE KEYS */;
INSERT INTO `hoc_vien` VALUES (23100,'Nguyễn Văn An','2000-03-10',_binary '','0963003976','TPHCM',_binary ''),(23101,'Nguyễn Văn Bắc','2001-03-22',_binary '\0','0345678978','TPHN',_binary ''),(23123102,'Nguyễn Văn Cao','2005-07-11',_binary '','0876345434','Nghệ An',_binary '\0'),(23123103,'Nguyễn Văn D','2005-07-13',_binary '','0876345435','Nghệ An',_binary '\0'),(23123104,'Nguyễn Văn Em','2005-07-14',_binary '\0','0876345436','Nghệ An',_binary '\0'),(23123105,'Nguyễn Văn Nam','2005-07-03',_binary '','087634543','Nghệ An',_binary '\0'),(23123106,'Nguyễn Văn G','2005-07-16',_binary '','0876345438','Hà Tĩnh',_binary '\0'),(23123107,'admin2','2025-04-03',_binary '','','',_binary ''),(23123108,'admin3','2025-04-09',_binary '','','',_binary '\0'),(23123109,'admin4','2025-04-15',_binary '\0','','',_binary '\0'),(23123110,'k','2025-04-08',_binary '','','',_binary '\0'),(23123112,'f','2025-04-18',_binary '\0','','',_binary ''),(23123113,'t','2025-04-08',_binary '\0','','',_binary '\0'),(23123114,'l','2025-04-10',_binary '','','',_binary '');
/*!40000 ALTER TABLE `hoc_vien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khoa_hoc`
--

DROP TABLE IF EXISTS `khoa_hoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khoa_hoc` (
  `ma_khoa_hoc` int NOT NULL,
  `ten_khoa_hoc` varchar(45) DEFAULT NULL,
  `mo_ta` varchar(45) DEFAULT NULL,
  `ngay_bat_dau` date DEFAULT NULL,
  `ngay_ket_thuc` date DEFAULT NULL,
  `tinh_trang` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ma_khoa_hoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khoa_hoc`
--

LOCK TABLES `khoa_hoc` WRITE;
/*!40000 ALTER TABLE `khoa_hoc` DISABLE KEYS */;
INSERT INTO `khoa_hoc` VALUES (1001,'Khóa Học A','Khóa Học A','2025-02-04','2025-05-03',_binary ''),(1002,'Khóa Học B','Khóa Học B','2025-04-01','2025-07-12',_binary ''),(1003,'Khóa Học C','Khóa Học C','2025-09-09','2025-12-10',_binary '');
/*!40000 ALTER TABLE `khoa_hoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lop_hoc`
--

DROP TABLE IF EXISTS `lop_hoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lop_hoc` (
  `ma_lop_hoc` int NOT NULL,
  `ma_khoa_hoc` int DEFAULT NULL,
  `ma_hoc_vien` int DEFAULT NULL,
  `ngay_dang_ky` date DEFAULT NULL,
  `tinh_trang` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ma_lop_hoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lop_hoc`
--

LOCK TABLES `lop_hoc` WRITE;
/*!40000 ALTER TABLE `lop_hoc` DISABLE KEYS */;
INSERT INTO `lop_hoc` VALUES (1,1,100001,'2024-03-01',_binary ''),(2,1,100002,'2024-03-01',_binary ''),(3,1,100003,'2024-03-01',_binary ''),(4,1,100004,'2024-03-05',_binary ''),(5,1,100005,'2024-03-14',_binary ''),(6,1,100001,'2024-03-11',_binary ''),(7,1,100001,'2024-03-11',_binary '');
/*!40000 ALTER TABLE `lop_hoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tai_khoan`
--

DROP TABLE IF EXISTS `tai_khoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tai_khoan` (
  `ma_tai_khoan` int NOT NULL,
  `ten_dang_nhap` varchar(45) DEFAULT NULL,
  `mat_khau` varchar(45) DEFAULT NULL,
  `tinh_trang` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ma_tai_khoan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tai_khoan`
--

LOCK TABLES `tai_khoan` WRITE;
/*!40000 ALTER TABLE `tai_khoan` DISABLE KEYS */;
INSERT INTO `tai_khoan` VALUES (1,'admin','123',_binary '');
/*!40000 ALTER TABLE `tai_khoan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-18  9:27:35
