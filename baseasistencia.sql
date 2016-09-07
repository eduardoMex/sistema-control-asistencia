SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `baseasistencia` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `baseasistencia` ;

-- -----------------------------------------------------
-- Table `baseasistencia`.`alumno`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `baseasistencia`.`alumno` (
  `idalumno` INT NOT NULL AUTO_INCREMENT ,
  `nombres` VARCHAR(20) NOT NULL ,
  `apellidos` VARCHAR(30) NOT NULL ,
  `dni` CHAR(8) NOT NULL ,
  `direccion` VARCHAR(40) NOT NULL ,
  `sexo` CHAR(1) NOT NULL ,
  `fecha_nacimiento` DATE NOT NULL ,
  `fecha_registro` DATE NOT NULL ,
  `grado` VARCHAR(20) NOT NULL ,
  `seccion` CHAR(1) NOT NULL ,
  PRIMARY KEY (`idalumno`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `baseasistencia`.`cargo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `baseasistencia`.`cargo` (
  `idcargo` INT NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(30) NOT NULL ,
  PRIMARY KEY (`idcargo`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `baseasistencia`.`administrativo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `baseasistencia`.`administrativo` (
  `idadministrativo` INT NOT NULL AUTO_INCREMENT ,
  `idcargo` INT NOT NULL ,
  `nombres` VARCHAR(20) NOT NULL ,
  `apellidos` VARCHAR(30) NOT NULL ,
  `dni` CHAR(8) NOT NULL ,
  `telefono` CHAR(9) NOT NULL ,
  `direccion` VARCHAR(40) NOT NULL ,
  `email` VARCHAR(50) NULL ,
  `sexo` VARCHAR(10) NOT NULL ,
  `fecha_ingreso` DATE NOT NULL ,
  PRIMARY KEY (`idadministrativo`) ,
  INDEX `fk_administrativo_cargo_idx` (`idcargo` ASC) ,
  CONSTRAINT `fk_administrativo_cargo`
    FOREIGN KEY (`idcargo` )
    REFERENCES `baseasistencia`.`cargo` (`idcargo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `baseasistencia`.`trabajador`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `baseasistencia`.`trabajador` (
  `idtrabajador` INT NOT NULL AUTO_INCREMENT ,
  `nombres` VARCHAR(20) NOT NULL ,
  `apellidos` VARCHAR(30) NOT NULL ,
  `dni` CHAR(8) NOT NULL ,
  `telefono` CHAR(9) NOT NULL ,
  `direccion` VARCHAR(40) NOT NULL ,
  `email` VARCHAR(50) NULL ,
  `sexo` VARCHAR(15) NOT NULL ,
  `login` VARCHAR(30) NOT NULL ,
  `password` VARCHAR(30) NOT NULL ,
  `acceso` VARCHAR(15) NOT NULL ,
  `estado` CHAR(1) NOT NULL ,
  `fecha_ingreso` DATE NOT NULL ,
  PRIMARY KEY (`idtrabajador`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `baseasistencia`.`asistencia_docentes`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `baseasistencia`.`asistencia_docentes` (
  `idasistencia` INT NOT NULL AUTO_INCREMENT ,
  `idadministrativo` INT NOT NULL ,
  `fecha` DATE NOT NULL ,
  `hora_ingreso` TIME NULL ,
  `hora_salidad` TIME NULL ,
  `idtrabajador` INT NULL ,
  PRIMARY KEY (`idasistencia`) ,
  INDEX `fk_asistencia_docentes_administrativo_idx` (`idadministrativo` ASC) ,
  INDEX `fk_asistencia_docentes_trabajador_idx` (`idtrabajador` ASC) ,
  CONSTRAINT `fk_asistencia_docentes_administrativo`
    FOREIGN KEY (`idadministrativo` )
    REFERENCES `baseasistencia`.`administrativo` (`idadministrativo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_asistencia_docentes_trabajador`
    FOREIGN KEY (`idtrabajador` )
    REFERENCES `baseasistencia`.`trabajador` (`idtrabajador` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `baseasistencia`.`licencia`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `baseasistencia`.`licencia` (
  `idlicencia` INT NOT NULL AUTO_INCREMENT ,
  `idadministrativo` INT NOT NULL ,
  `fecha` DATE NOT NULL ,
  `tiempo` VARCHAR(45) NOT NULL ,
  `tipo_licencia` VARCHAR(45) NOT NULL ,
  `descripcion` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`idlicencia`) ,
  INDEX `fk_licencia_administrativo_idx` (`idadministrativo` ASC) ,
  CONSTRAINT `fk_licencia_administrativo`
    FOREIGN KEY (`idadministrativo` )
    REFERENCES `baseasistencia`.`administrativo` (`idadministrativo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `baseasistencia`.`permiso`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `baseasistencia`.`permiso` (
  `idpermiso` INT NOT NULL AUTO_INCREMENT ,
  `idalumno` INT NOT NULL ,
  `fecha` DATE NOT NULL ,
  `tiempo` VARCHAR(30) NOT NULL ,
  `descripcion` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`idpermiso`) ,
  INDEX `fk_permiso_alumno_idx` (`idalumno` ASC) ,
  CONSTRAINT `fk_permiso_alumno`
    FOREIGN KEY (`idalumno` )
    REFERENCES `baseasistencia`.`alumno` (`idalumno` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `baseasistencia`.`asistencia_alumnos`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `baseasistencia`.`asistencia_alumnos` (
  `idasistencia_alumnos` INT NOT NULL AUTO_INCREMENT ,
  `idalumno` INT NOT NULL ,
  `fecha` DATE NOT NULL ,
  `hora_ingreso` TIME NULL ,
  `hora_salida` TIME NULL ,
  `idtrabajador` INT NULL ,
  PRIMARY KEY (`idasistencia_alumnos`, `fecha`) ,
  INDEX `fk_asistencia_alumnos_alumno_idx` (`idalumno` ASC) ,
  INDEX `fk_asistencia_docentes_trabajador_idx` (`idtrabajador` ASC) ,
  CONSTRAINT `fk_asistencia_alumnos_alumno`
    FOREIGN KEY (`idalumno` )
    REFERENCES `baseasistencia`.`alumno` (`idalumno` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_asistencia_alumnos_trabajador`
    FOREIGN KEY (`idtrabajador` )
    REFERENCES `baseasistencia`.`trabajador` (`idtrabajador` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
