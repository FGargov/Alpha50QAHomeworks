-- MariaDB dump 10.19-11.2.0-MariaDB, for Win64 (AMD64)
--
-- Host: 127.0.0.1    Database: car_rental_system
-- ------------------------------------------------------
-- Server version	11.2.0-MariaDB

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
-- Table structure for table `cars`
--

DROP TABLE IF EXISTS `cars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cars` (
  `car_id` int(11) NOT NULL AUTO_INCREMENT,
  `brand` varchar(50) DEFAULT NULL,
  `model` varchar(50) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `kilometers` int(11) DEFAULT NULL,
  `color_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`car_id`),
  KEY `cars_colors_fk` (`color_id`),
  KEY `cars_category_fk` (`category_id`),
  CONSTRAINT `cars_category_fk` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`),
  CONSTRAINT `cars_colors_fk` FOREIGN KEY (`color_id`) REFERENCES `colors` (`color_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cars`
--

LOCK TABLES `cars` WRITE;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;
INSERT INTO `cars` (`car_id`, `brand`, `model`, `year`, `kilometers`, `color_id`, `category_id`) VALUES (1,'Toyota','Corolla',2019,100000,1,2),
(2,'Honda','Civic',2015,151000,3,2),
(3,'Mitsubishi','Pajero',2018,125000,2,3),
(4,'Ford','Mustang',2021,44000,5,5),
(5,'Toyota','RAV4',2023,12000,4,2),
(6,'Nissan','X-Trail',2022,25000,6,3);
/*!40000 ALTER TABLE `cars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categories` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` (`category_id`, `category_name`) VALUES (1,'Small'),
(2,'Mid-size'),
(3,'Large'),
(4,'Limousines'),
(5,'Sport');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colors`
--

DROP TABLE IF EXISTS `colors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `colors` (
  `color_id` int(11) NOT NULL,
  `color_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`color_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colors`
--

LOCK TABLES `colors` WRITE;
/*!40000 ALTER TABLE `colors` DISABLE KEYS */;
INSERT INTO `colors` (`color_id`, `color_name`) VALUES (1,'White'),
(2,'Black'),
(3,'Red'),
(4,'Silver'),
(5,'Blue'),
(6,'Green');
/*!40000 ALTER TABLE `colors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`customer_id`, `first_name`, `last_name`) VALUES (1,'Filip','Gargov'),
(2,'Ivan','Petrov'),
(3,'Kiril','Georgiev'),
(4,'Boyko','Borisov'),
(5,'Asen','Vassilev'),
(6,'Qsen','Gerginenov');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insurances`
--

DROP TABLE IF EXISTS `insurances`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `insurances` (
  `insurance_id` int(11) NOT NULL AUTO_INCREMENT,
  `insurance_type` varchar(40) DEFAULT NULL,
  `cost` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`insurance_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insurances`
--

LOCK TABLES `insurances` WRITE;
/*!40000 ALTER TABLE `insurances` DISABLE KEYS */;
INSERT INTO `insurances` (`insurance_id`, `insurance_type`, `cost`) VALUES (1,'Full Coverage',30.00),
(2,'Collision Damage Waiver',20.00),
(3,'Personal Accident Insurance',15.00);
/*!40000 ALTER TABLE `insurances` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locations`
--

DROP TABLE IF EXISTS `locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `locations` (
  `location_id` int(11) NOT NULL,
  `city` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` (`location_id`, `city`) VALUES (1,'Sofia'),
(2,'Plovdiv'),
(3,'Varna'),
(4,'Burgas'),
(5,'Ruse'),
(6,'Veliko Turnovo'),
(7,'Blagoevgrad');
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservations` (
  `reservation_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `pickup_location_id` int(11) DEFAULT NULL,
  `dropoff_location_id` int(11) DEFAULT NULL,
  `pickup_date` date DEFAULT NULL,
  `dropoff_date` date DEFAULT NULL,
  `car_id` int(11) DEFAULT NULL,
  `insurance_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`reservation_id`),
  KEY `reservations_customer_fk` (`customer_id`),
  KEY `reservations_cars_fk` (`car_id`),
  KEY `reservations_insurances_fk` (`insurance_id`),
  KEY `reservations_dropoff_locations_fk` (`dropoff_location_id`),
  KEY `reservations__pickup_locations_fk` (`pickup_location_id`),
  CONSTRAINT `reservations__pickup_locations_fk` FOREIGN KEY (`pickup_location_id`) REFERENCES `locations` (`location_id`),
  CONSTRAINT `reservations_cars_fk` FOREIGN KEY (`car_id`) REFERENCES `cars` (`car_id`),
  CONSTRAINT `reservations_customer_fk` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `reservations_dropoff_locations_fk` FOREIGN KEY (`dropoff_location_id`) REFERENCES `locations` (`location_id`),
  CONSTRAINT `reservations_insurances_fk` FOREIGN KEY (`insurance_id`) REFERENCES `insurances` (`insurance_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservations`
--

LOCK TABLES `reservations` WRITE;
/*!40000 ALTER TABLE `reservations` DISABLE KEYS */;
INSERT INTO `reservations` (`reservation_id`, `customer_id`, `pickup_location_id`, `dropoff_location_id`, `pickup_date`, `dropoff_date`, `car_id`, `insurance_id`) VALUES (1,1,1,2,'2023-06-30','2023-07-03',1,1),
(2,2,2,3,'2023-07-12','2023-07-22',5,2),
(3,3,5,1,'2023-08-01','2023-08-13',4,3),
(4,5,3,7,'2023-08-11','2023-08-20',6,1),
(5,4,6,4,'2023-06-30','2023-07-08',2,3);
/*!40000 ALTER TABLE `reservations` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-03 17:35:22
