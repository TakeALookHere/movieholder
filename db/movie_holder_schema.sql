CREATE SCHEMA `movie_holder` DEFAULT CHARACTER SET utf8 ;
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema movie_holder
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema movie_holder
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `movie_holder` ;
USE `movie_holder` ;

-- -----------------------------------------------------
-- Table `movie_holder`.`movie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie_holder`.`movie` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name_russian` VARCHAR(100) NOT NULL,
  `name_native` VARCHAR(100) NOT NULL,
  `released_date` DATE NOT NULL,
  `plot` VARCHAR(500) NOT NULL,
  `rating` DOUBLE NOT NULL,
  `price` DOUBLE NOT NULL,
  `picture_path` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `movie_holder`.`genre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie_holder`.`genre` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `movie_holder`.`movie_genre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie_holder`.`movie_genre` (
  `movie_id` INT NOT NULL,
  `genre_id` INT NOT NULL,
  INDEX `movie_id_idx` (`movie_id` ASC),
  INDEX `genre_id_idx` (`genre_id` ASC),
  CONSTRAINT `movie_id`
    FOREIGN KEY (`movie_id`)
    REFERENCES `movie_holder`.`movie` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `genre_id`
    FOREIGN KEY (`genre_id`)
    REFERENCES `movie_holder`.`genre` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `movie_holder`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie_holder`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nickname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `movie_holder`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie_holder`.`review` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `movie_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `description` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_id_idx` (`user_id` ASC),
  INDEX `movie_id_idx` (`movie_id` ASC),
  CONSTRAINT `review_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `movie_holder`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `review_movie_id`
    FOREIGN KEY (`movie_id`)
    REFERENCES `movie_holder`.`movie` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `movie_holder`.`country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie_holder`.`country` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `movie_holder`.`movie_country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie_holder`.`movie_country` (
  `movie_id` INT NOT NULL,
  `country_id` INT NOT NULL,
  INDEX `country_id_idx` (`country_id` ASC),
  INDEX `movie_id_idx` (`movie_id` ASC),
  CONSTRAINT `movie_country_country_id`
    FOREIGN KEY (`country_id`)
    REFERENCES `movie_holder`.`country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `movie_country_movie_id`
    FOREIGN KEY (`movie_id`)
    REFERENCES `movie_holder`.`movie` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

ALTER TABLE `movie_holder`.`movie`
CHANGE COLUMN `plot` `plot` VARCHAR(1000) NOT NULL ;

ALTER TABLE `movie_holder`.`user`
CHANGE COLUMN `password` `password` VARBINARY(100) NOT NULL ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
