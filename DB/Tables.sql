  CREATE TABLE `Categories` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  `parentId` int(11) default null,
  PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
  
  CREATE TABLE `Roles` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
  
  CREATE TABLE `Currency` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
  
  CREATE TABLE `Status` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

  
  CREATE TABLE `Users` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NULL DEFAULT NULL,
  `email` varchar(20) NULL DEFAULT NULL,
  `phone` varchar(20) NULL DEFAULT NULL,
  `role_id` int(11) NULL DEFAULT NULL,
  `registration` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_ROLE` (`role_id`),
  CONSTRAINT `FK_ROLE` FOREIGN KEY (`id`) REFERENCES `roles` (`id`)) 
  ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
  
  CREATE TABLE `Provider` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `status_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_SELLER` (`user_id`),
  INDEX `FK_STATUS` (`status_id`),
  CONSTRAINT `FK_SELLER` FOREIGN KEY (`id`) REFERENCES `users` (`id`),
  CONSTRAINT `FK_STATUS` FOREIGN KEY (`id`) REFERENCES `status` (`id`)) 
  ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
  
  CREATE TABLE `Services` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NULL DEFAULT NULL,
  `description` varchar(200) NULL DEFAULT NULL,
  `category_id` int(11) NULL DEFAULT NULL,
  `price` double NULL DEFAULT NULL,
  `currency_id` int(11) NULL DEFAULT NULL,
  `provider_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_CATEGORY` (`category_id`),
  INDEX `FK_CURRENCY` (`currency_id`),
  INDEX `FK_PROVIDER` (`provider_id`),
  CONSTRAINT `FK_CATEGORY` FOREIGN KEY (`id`) REFERENCES `categories` (`id`),
  CONSTRAINT `FK_CURRENCY` FOREIGN KEY (`id`) REFERENCES `currency` (`id`),
  CONSTRAINT `FK_PROVIDER` FOREIGN KEY (`id`) REFERENCES `provider` (`id`)) 
  ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
  

  CREATE TABLE `Orders` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `alive` boolean NOT NULL DEFAULT 0,
  `date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `service_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_CLIENT` (`user_id`),
  INDEX `FK_SERVICES` (`service_id`),
  CONSTRAINT `FK_CLIENT` FOREIGN KEY (`id`) REFERENCES `users` (`id`),
  CONSTRAINT `FK_SERVICES` FOREIGN KEY (`id`) REFERENCES `services` (`id`)) 
  ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;