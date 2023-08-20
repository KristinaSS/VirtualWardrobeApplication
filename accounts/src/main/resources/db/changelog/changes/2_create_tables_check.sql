-- liquibase formatted sql

-- Changeset kristina:2023-08-12-create-account-table
-- precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM `vw_accounts`.`account`
-- onFail=MARK_RAN
CREATE TABLE IF NOT EXISTS `vw_accounts`.`account` (
                                                            `id` INT NOT NULL AUTO_INCREMENT,
                                                            `name` VARCHAR(100) NOT NULL,
                                                            `email` VARCHAR(100) NOT NULL,
                                                            `password` VARCHAR(45) NOT NULL,
                                                            `account_type` VARCHAR(10) NOT NULL,
                                                            PRIMARY KEY (`id`));