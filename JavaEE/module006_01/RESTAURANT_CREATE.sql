-- MySQL Workbench Synchronization
-- Generated: 2016-07-08 12:24
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Dimon

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

ALTER TABLE `restaurant`.`DISHS` 
DROP FOREIGN KEY `fk_DISH_INGREDIENT1`;

ALTER TABLE `restaurant`.`MENU` 
DROP FOREIGN KEY `fk_MENU_DISH1`;

ALTER TABLE `restaurant`.`ORDERS` 
DROP FOREIGN KEY `fk_ORDER_EMPLOYEE1`,
DROP FOREIGN KEY `fk_ORDER_DISH1`;

ALTER TABLE `restaurant`.`PREPARED_DISHS` 
DROP FOREIGN KEY `fk_PREPARED_DISH_EMPLOYEE1`;

ALTER TABLE `restaurant`.`POSITIONS` 
CHANGE COLUMN `ID` `POSITION_ID` INT(11) NOT NULL AUTO_INCREMENT COMMENT '' ;

ALTER TABLE `restaurant`.`EMPLOYEE` 
DROP COLUMN `DTYPE`,
DROP COLUMN `NUMBER`,
DROP COLUMN `EMPLOYEE_ID`,
CHANGE COLUMN `SALARY` `SALARY` REAL NULL COMMENT '' ,
ADD COLUMN `EMPLOYEE_ID` INT(11) NOT NULL AUTO_INCREMENT COMMENT '' FIRST,
ADD COLUMN `PHONE` VARCHAR(10) NULL DEFAULT NULL COMMENT '' AFTER `BIRTH_DATE`,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`EMPLOYEE_ID`)  COMMENT '', RENAME TO  `restaurant`.`EMPLOYEES` ;

ALTER TABLE `restaurant`.`INGREDIENTS` 
CHANGE COLUMN `ID` `INGREDIENT_ID` INT(11) NOT NULL AUTO_INCREMENT COMMENT '' ;

ALTER TABLE `restaurant`.`DISHS` 
DROP COLUMN `INGREDIENT_ID`,
CHANGE COLUMN `ID` `DISH_ID` INT(11) NOT NULL AUTO_INCREMENT COMMENT '' ,
CHANGE COLUMN `COST` `COST` REAL NULL COMMENT '' ,
DROP INDEX `fk_DISH_INGREDIENT1_idx` ;

ALTER TABLE `restaurant`.`MENU` 
DROP COLUMN `DISH_ID`,
DROP COLUMN `LIST_DISHES`,
CHANGE COLUMN `ID` `MENU_ID` INT(11) NOT NULL AUTO_INCREMENT COMMENT '' ,
ADD COLUMN `MENU_NAME` TEXT(200) NOT NULL COMMENT '' AFTER `MENU_ID`,
DROP INDEX `fk_MENU_DISH1_idx` ;

ALTER TABLE `restaurant`.`ORDERS` 
DROP COLUMN `DISH_ID`,
CHANGE COLUMN `ID` `ORDER_ID` INT(11) NOT NULL AUTO_INCREMENT COMMENT '' ,
ADD COLUMN `IS_OPEN` TINYINT(1) NULL DEFAULT NULL COMMENT '' AFTER `DATE`,
DROP INDEX `fk_ORDER_DISH1_idx` ;

CREATE TABLE IF NOT EXISTS `restaurant`.`DISH_INGREDIENT` (
  `QUANTITY` REAL NOT NULL COMMENT '',
  `DISH_ID` INT(11) NOT NULL COMMENT '',
  `INGREDIENT_ID` INT(11) NOT NULL COMMENT '',
  INDEX `fk_DISH_INGREDIENT_DISHS1_idx` (`DISH_ID` ASC)  COMMENT '',
  INDEX `fk_DISH_INGREDIENT_INGREDIENTS1_idx` (`INGREDIENT_ID` ASC)  COMMENT '',
  CONSTRAINT `fk_DISH_INGREDIENT_DISHS1`
    FOREIGN KEY (`DISH_ID`)
    REFERENCES `restaurant`.`DISHS` (`DISH_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DISH_INGREDIENT_INGREDIENTS1`
    FOREIGN KEY (`INGREDIENT_ID`)
    REFERENCES `restaurant`.`INGREDIENTS` (`INGREDIENT_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `restaurant`.`ORDER_DISH` (
  `QUANITY` INT(11) NOT NULL COMMENT '',
  `ORDER_ID` INT(11) NOT NULL COMMENT '',
  `DISH_ID` INT(11) NOT NULL COMMENT '',
  INDEX `fk_ORDER_DISH_ORDERS1_idx` (`ORDER_ID` ASC)  COMMENT '',
  INDEX `fk_ORDER_DISH_DISHS1_idx` (`DISH_ID` ASC)  COMMENT '',
  CONSTRAINT `fk_ORDER_DISH_ORDERS1`
    FOREIGN KEY (`ORDER_ID`)
    REFERENCES `restaurant`.`ORDERS` (`ORDER_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ORDER_DISH_DISHS1`
    FOREIGN KEY (`DISH_ID`)
    REFERENCES `restaurant`.`DISHS` (`DISH_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `restaurant`.`DISH_IN_MENU` (
  `DISH_ID` INT(11) NOT NULL COMMENT '',
  `MENU_ID` INT(11) NOT NULL COMMENT '',
  INDEX `fk_DISH_IN_MENU_DISHS1_idx` (`DISH_ID` ASC)  COMMENT '',
  INDEX `fk_DISH_IN_MENU_MENU1_idx` (`MENU_ID` ASC)  COMMENT '',
  CONSTRAINT `fk_DISH_IN_MENU_DISHS1`
    FOREIGN KEY (`DISH_ID`)
    REFERENCES `restaurant`.`DISHS` (`DISH_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DISH_IN_MENU_MENU1`
    FOREIGN KEY (`MENU_ID`)
    REFERENCES `restaurant`.`MENU` (`MENU_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

ALTER TABLE `restaurant`.`ORDERS` 
ADD CONSTRAINT `fk_ORDER_EMPLOYEE1`
  FOREIGN KEY (`EMPLOYEE_ID`)
  REFERENCES `restaurant`.`EMPLOYEES` (`EMPLOYEE_ID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `restaurant`.`PREPARED_DISHS` 
ADD CONSTRAINT `fk_PREPARED_DISH_EMPLOYEE1`
  FOREIGN KEY (`EMPLOYEE_ID`)
  REFERENCES `restaurant`.`EMPLOYEES` (`EMPLOYEE_ID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
