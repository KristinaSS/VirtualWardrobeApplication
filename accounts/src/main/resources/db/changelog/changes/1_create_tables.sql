-- liquibase formatted sql

-- Changeset kristina:2023-08-13-create-account-table
CREATE TABLE IF NOT EXISTS `vw_accounts`.`account` (
                                                            `id` INT NOT NULL AUTO_INCREMENT,
                                                            `name` VARCHAR(100) NOT NULL,
                                                            `email` VARCHAR(100) NOT NULL,
                                                            `password` VARCHAR(45) NOT NULL,
                                                            `account_type` VARCHAR(10) NOT NULL,
                                                            `is_active` TINYINT NOT NULL,
                                                            PRIMARY KEY (`id`));