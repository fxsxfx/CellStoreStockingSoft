-- MariaDB dump 10.19  Distrib 10.4.32-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: tiendatelcel
-- ------------------------------------------------------
-- Server version	10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `accesorios`
--

DROP TABLE IF EXISTS `accesorios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accesorios` (
  `cve_art` int(11) NOT NULL AUTO_INCREMENT,
  `nom_acc` varchar(100) NOT NULL,
  `cvemarca_acc` int(11) DEFAULT NULL,
  `inv_acc` int(11) NOT NULL,
  `pre_acc` float NOT NULL,
  PRIMARY KEY (`cve_art`),
  KEY `fk_accesorio_marca` (`cvemarca_acc`),
  CONSTRAINT `fk_accesorio_marca` FOREIGN KEY (`cvemarca_acc`) REFERENCES `marcas` (`cve_marca`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accesorios`
--

LOCK TABLES `accesorios` WRITE;
/*!40000 ALTER TABLE `accesorios` DISABLE KEYS */;
INSERT INTO `accesorios` VALUES (1,'Cargador rápido Samsung',1,50,299),(2,'Funda Apple iPhone 14',2,30,499),(3,'Audífonos Bluetooth Xiaomi',3,25,349),(4,'Protector pantalla Motorola',4,40,120),(5,'Cable USB Huawei',5,60,89);
/*!40000 ALTER TABLE `accesorios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `celulares`
--

DROP TABLE IF EXISTS `celulares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `celulares` (
  `cve_cel` int(11) NOT NULL AUTO_INCREMENT,
  `nom_cel` varchar(100) NOT NULL,
  `cvemarca_cel` int(11) DEFAULT NULL,
  `ram_cel` varchar(20) DEFAULT NULL,
  `rom_cel` varchar(20) DEFAULT NULL,
  `imei` varchar(20) DEFAULT NULL,
  `inv_cel` int(11) NOT NULL,
  `pre_cel` float NOT NULL,
  PRIMARY KEY (`cve_cel`),
  UNIQUE KEY `imei` (`imei`),
  KEY `fk_celular_marca` (`cvemarca_cel`),
  CONSTRAINT `fk_celular_marca` FOREIGN KEY (`cvemarca_cel`) REFERENCES `marcas` (`cve_marca`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `celulares`
--

LOCK TABLES `celulares` WRITE;
/*!40000 ALTER TABLE `celulares` DISABLE KEYS */;
INSERT INTO `celulares` VALUES (1,'Galaxy A54',1,'6GB','128GB','356789123456789',15,7499),(2,'iPhone 14',2,'6GB','128GB','353456789123456',10,18999),(3,'Redmi Note 12',3,'8GB','256GB','352112233445566',20,5999),(4,'Moto G73',4,'6GB','128GB','357789456123789',12,6399),(5,'Huawei P30',5,'8GB','128GB','351998877665544',8,8299);
/*!40000 ALTER TABLE `celulares` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marcas`
--

DROP TABLE IF EXISTS `marcas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marcas` (
  `cve_marca` int(11) NOT NULL AUTO_INCREMENT,
  `nom_marca` varchar(100) NOT NULL,
  `cveprov_marca` int(11) DEFAULT NULL,
  PRIMARY KEY (`cve_marca`),
  KEY `fk_marca_proveedor` (`cveprov_marca`),
  CONSTRAINT `fk_marca_proveedor` FOREIGN KEY (`cveprov_marca`) REFERENCES `proveedores` (`cve_prov`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marcas`
--

LOCK TABLES `marcas` WRITE;
/*!40000 ALTER TABLE `marcas` DISABLE KEYS */;
INSERT INTO `marcas` VALUES (1,'Samsung',1),(2,'Apple',2),(3,'Xiaomi',3),(4,'Motorola',4),(5,'Huawei',5);
/*!40000 ALTER TABLE `marcas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedores` (
  `cve_prov` int(11) NOT NULL AUTO_INCREMENT,
  `nom_prov` varchar(100) NOT NULL,
  `mail_prov` varchar(100) DEFAULT NULL,
  `tel_prov` varchar(20) DEFAULT NULL,
  `dir_prov` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`cve_prov`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES (1,'Distribuidora Móvil','contacto@distmovil.com','8188880001','Av. Tecnológico 500'),(2,'ProveCel','ventas@provecel.com','8112345678','Calle Morelos 123'),(3,'TecnoMarket','soporte@tecnomarket.mx','8145671234','Av. Universidad 1000'),(4,'GlobalTel','global@telmexico.mx','8122223333','Col. Centro, Monterrey'),(5,'ElectroProveedor','electro@proveedores.com','8134567890','Blvd. Industrial 321');
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-02 13:28:25
