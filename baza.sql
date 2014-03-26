SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Nauczyciel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Nauczyciel` (
  `idNauczyciel` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `imie` VARCHAR(45) NOT NULL,
  `nazwisko` VARCHAR(45) NOT NULL,
  `pesel` CHAR(11) NOT NULL,
  `haslo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idNauczyciel`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Klasa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Klasa` (
  `idKlasa` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nazwa` VARCHAR(45) NOT NULL,
  `rozpoczecie` YEAR NOT NULL,
  `zakonczenie` YEAR NOT NULL,
  `wychowawca` INT UNSIGNED NULL,
  PRIMARY KEY (`idKlasa`),
  INDEX `fk_Klasa_Nauczyciel_idx` (`wychowawca` ASC),
  CONSTRAINT `fk_Klasa_Nauczyciel`
    FOREIGN KEY (`wychowawca`)
    REFERENCES `mydb`.`Nauczyciel` (`idNauczyciel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Uczen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Uczen` (
  `idUczen` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `imie` VARCHAR(45) NOT NULL,
  `nazwisko` VARCHAR(45) NOT NULL,
  `Klasa_idKlasa` INT UNSIGNED NOT NULL,
  `pesel` CHAR(11) NOT NULL,
  `haslo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUczen`, `Klasa_idKlasa`),
  INDEX `fk_Uczen_Klasa1_idx` (`Klasa_idKlasa` ASC),
  CONSTRAINT `fk_Uczen_Klasa1`
    FOREIGN KEY (`Klasa_idKlasa`)
    REFERENCES `mydb`.`Klasa` (`idKlasa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Przedmiot`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Przedmiot` (
  `idPrzedmiot` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nazwa` VARCHAR(45) NOT NULL,
  `Nauczyciel_idNauczyciel` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idPrzedmiot`, `Nauczyciel_idNauczyciel`),
  INDEX `fk_Przedmiot_Nauczyciel1_idx` (`Nauczyciel_idNauczyciel` ASC),
  CONSTRAINT `fk_Przedmiot_Nauczyciel1`
    FOREIGN KEY (`Nauczyciel_idNauczyciel`)
    REFERENCES `mydb`.`Nauczyciel` (`idNauczyciel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Klasa_has_Przedmiot`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Klasa_has_Przedmiot` (
  `Klasa_idKlasa` INT UNSIGNED NOT NULL,
  `Przedmiot_idPrzedmiot` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`Klasa_idKlasa`, `Przedmiot_idPrzedmiot`),
  INDEX `fk_Klasa_has_Przedmiot_Przedmiot1_idx` (`Przedmiot_idPrzedmiot` ASC),
  INDEX `fk_Klasa_has_Przedmiot_Klasa1_idx` (`Klasa_idKlasa` ASC),
  CONSTRAINT `fk_Klasa_has_Przedmiot_Klasa1`
    FOREIGN KEY (`Klasa_idKlasa`)
    REFERENCES `mydb`.`Klasa` (`idKlasa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Klasa_has_Przedmiot_Przedmiot1`
    FOREIGN KEY (`Przedmiot_idPrzedmiot`)
    REFERENCES `mydb`.`Przedmiot` (`idPrzedmiot`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Uczen_has_Przedmiot`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Uczen_has_Przedmiot` (
  `Uczen_idUczen` INT UNSIGNED NOT NULL,
  `Uczen_Klasa_idKlasa` INT UNSIGNED NOT NULL,
  `Przedmiot_idPrzedmiot` INT UNSIGNED NOT NULL,
  `Przedmiot_Nauczyciel_idNauczyciel` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`Uczen_idUczen`, `Uczen_Klasa_idKlasa`, `Przedmiot_idPrzedmiot`, `Przedmiot_Nauczyciel_idNauczyciel`),
  INDEX `fk_Uczen_has_Przedmiot_Przedmiot1_idx` (`Przedmiot_idPrzedmiot` ASC, `Przedmiot_Nauczyciel_idNauczyciel` ASC),
  INDEX `fk_Uczen_has_Przedmiot_Uczen1_idx` (`Uczen_idUczen` ASC, `Uczen_Klasa_idKlasa` ASC),
  CONSTRAINT `fk_Uczen_has_Przedmiot_Uczen1`
    FOREIGN KEY (`Uczen_idUczen` , `Uczen_Klasa_idKlasa`)
    REFERENCES `mydb`.`Uczen` (`idUczen` , `Klasa_idKlasa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Uczen_has_Przedmiot_Przedmiot1`
    FOREIGN KEY (`Przedmiot_idPrzedmiot` , `Przedmiot_Nauczyciel_idNauczyciel`)
    REFERENCES `mydb`.`Przedmiot` (`idPrzedmiot` , `Nauczyciel_idNauczyciel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Oceny`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Oceny` (
  `idOceny` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `wartosc` INT NOT NULL,
  `waga` INT NULL DEFAULT 1,
  `data_wstawienia` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `Uczen_has_Przedmiot_Uczen_idUczen` INT UNSIGNED NOT NULL,
  `Uczen_has_Przedmiot_Uczen_Klasa_idKlasa` INT UNSIGNED NOT NULL,
  `Uczen_has_Przedmiot_Przedmiot_idPrzedmiot` INT UNSIGNED NOT NULL,
  `Uczen_has_Przedmiot_Przedmiot_Nauczyciel_idNauczyciel` INT UNSIGNED NOT NULL,
  `komentarz` VARCHAR(45) NULL,
  PRIMARY KEY (`idOceny`, `Uczen_has_Przedmiot_Uczen_idUczen`, `Uczen_has_Przedmiot_Uczen_Klasa_idKlasa`, `Uczen_has_Przedmiot_Przedmiot_idPrzedmiot`, `Uczen_has_Przedmiot_Przedmiot_Nauczyciel_idNauczyciel`),
  INDEX `fk_Oceny_Uczen_has_Przedmiot1_idx` (`Uczen_has_Przedmiot_Uczen_idUczen` ASC, `Uczen_has_Przedmiot_Uczen_Klasa_idKlasa` ASC, `Uczen_has_Przedmiot_Przedmiot_idPrzedmiot` ASC, `Uczen_has_Przedmiot_Przedmiot_Nauczyciel_idNauczyciel` ASC),
  CONSTRAINT `fk_Oceny_Uczen_has_Przedmiot1`
    FOREIGN KEY (`Uczen_has_Przedmiot_Uczen_idUczen` , `Uczen_has_Przedmiot_Uczen_Klasa_idKlasa` , `Uczen_has_Przedmiot_Przedmiot_idPrzedmiot` , `Uczen_has_Przedmiot_Przedmiot_Nauczyciel_idNauczyciel`)
    REFERENCES `mydb`.`Uczen_has_Przedmiot` (`Uczen_idUczen` , `Uczen_Klasa_idKlasa` , `Przedmiot_idPrzedmiot` , `Przedmiot_Nauczyciel_idNauczyciel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
