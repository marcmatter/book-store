DROP DATABASE IF EXISTS `book_store`;
CREATE DATABASE `book_store`;
USE `book_store`;

-- Setup Tables
CREATE TABLE `author` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(35) NOT NULL,
  `prename` VARCHAR(35)
);

CREATE TABLE `genere` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(35)
);

CREATE TABLE `publisher` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(35) NOT NULL
);

CREATE TABLE `book` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `title` VARCHAR(35) NOT NULL,
  `author_id` int,
  `genere_id` int,
  `publisher_id` int
);

CREATE TABLE `order` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `book_id` int NOT NULL,
  `customer_id` int NOT NULL
);

CREATE TABLE `customer` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(35) NOT NULL,
  `prename` VARCHAR(35)
);

-- Add foreign keys
ALTER TABLE `book` ADD FOREIGN KEY (`author_id`) REFERENCES `author` (`id`);
ALTER TABLE `book` ADD FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`id`);
ALTER TABLE `book` ADD FOREIGN KEY (`genere_id`) REFERENCES `genere` (`id`);

ALTER TABLE `order` ADD FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`);
ALTER TABLE `order` ADD FOREIGN KEY (`book_id`) REFERENCES `book` (`id`);
