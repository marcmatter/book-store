DROP DATABASE IF EXISTS `book_store`;
CREATE DATABASE `book_store`;
USE `book_store`;

-- Setup Tables
CREATE TABLE `book` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `title` VARCHAR(50) NOT NULL,
  `author` VARCHAR(50),
  `genere` VARCHAR(50),
  `publisher` VARCHAR(50)
);

CREATE TABLE `order` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `book_id` INT NOT NULL,
  `customer_id` INT NOT NULL,
  `isDelivered` BOOLEAN DEFAULT false
);

CREATE TABLE `customer` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `prename` VARCHAR(50)
);

-- Add foreign keys
ALTER TABLE `order` ADD FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`);
ALTER TABLE `order` ADD FOREIGN KEY (`book_id`) REFERENCES `book` (`id`);
