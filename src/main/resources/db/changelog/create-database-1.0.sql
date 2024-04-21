USE dining_reviews_db;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(45) NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `PASSWORD` varchar(45) NOT NULL,
  `PHONE_NUMBER` varchar(10) NOT NULL,
  `CITY` varchar(30) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  UNIQUE KEY `USERNAME_UNIQUE` (`USERNAME`),
  UNIQUE KEY `PHONE_NUMBER_UNIQUE` (`PHONE_NUMBER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `administrators`;
CREATE TABLE `administrators` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `U_ID` bigint NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  KEY `U_ID_idx` (`U_ID`),
  CONSTRAINT `u_id` FOREIGN KEY (`U_ID`) REFERENCES `users` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `cuisine`;
CREATE TABLE `cuisine` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `TYPE` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `TYPE_UNIQUE` (`TYPE`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `restaurants`;
CREATE TABLE `restaurants` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `ADDRESS` varchar(45) NOT NULL,
  `PHONE_NUMBER` varchar(10) NOT NULL,
  `CUISINE_TYPE` bigint DEFAULT NULL,
  `price_range` enum('$','$$','$$$','$$$$') NOT NULL,
  `FOOD_SCORE` double NOT NULL,
  `SERVICE_SCORE` double NOT NULL,
  `ATMOSPHERE_SCORE` double NOT NULL,
  `OVERALL_SCORE` double NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NAME_UNIQUE` (`NAME`),
  UNIQUE KEY `PHONE_NUMBER_UNIQUE` (`PHONE_NUMBER`),
  UNIQUE KEY `id_UNIQUE` (`ID`),
  KEY `cuisine_id_idx` (`CUISINE_TYPE`),
  CONSTRAINT `cuisine_type` FOREIGN KEY (`CUISINE_TYPE`) REFERENCES `dining_reviews_db`.`cuisine` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `reviews`;
CREATE TABLE `reviews` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `RESTAURANT_ID` bigint NOT NULL,
  `AUTHOR` bigint NOT NULL,
  `PUBLISHED_ON` timestamp NOT NULL,
  `status` enum('PENDING','ACCEPTED','REJECTED') NOT NULL,
  `COMMENTARY` tinytext,
  `FOOD_SCORE` double NOT NULL,
  `SERVICE_SCORE` double NOT NULL,
  `ATMOSPHERE_SCORE` double NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  KEY `restaurant_id_idx` (`RESTAURANT_ID`),
  KEY `user_id_idx` (`AUTHOR`),
  CONSTRAINT `author` FOREIGN KEY (`AUTHOR`) REFERENCES `users` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `restaurant_id` FOREIGN KEY (`RESTAURANT_ID`) REFERENCES `restaurants` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;