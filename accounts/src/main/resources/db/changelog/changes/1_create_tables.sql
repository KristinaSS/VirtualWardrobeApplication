-- liquibase formatted sql

-- Changeset kristina:2023-08-13-create-account-table
CREATE TABLE IF NOT EXISTS `vw_accounts`.`account` (
                                                            `id` INT NOT NULL AUTO_INCREMENT,
                                                            `name` VARCHAR(100) NOT NULL,
                                                            `email` VARCHAR(100) NOT NULL,
                                                            `password` VARCHAR(45) NOT NULL,
                                                            `account_type` VARCHAR(45) NOT NULL,
                                                            PRIMARY KEY (`id`));

-- Changeset kristina:2023-08-13-create-account-style-table
CREATE TABLE IF NOT EXISTS `vw_accounts`.`account_style` (
                                                                 `id_account` INT NOT NULL,
                                                                 `id_style` INT NOT NULL,
                                                                 `compatibility` INT NOT NULL,
                                                                 PRIMARY KEY (`id_account`, `id_style`));

-- Changeset kristina:2023-08-13-create-keyword-account-table
CREATE TABLE IF NOT EXISTS `vw_accounts`.`keyword_account` (
                                                                   `id_keyword` INT NOT NULL,
                                                                   `id_account` INT NOT NULL,
                                                                   `keyword_strength` INT NOT NULL,
                                                                   PRIMARY KEY (`id_keyword`, `id_account`));