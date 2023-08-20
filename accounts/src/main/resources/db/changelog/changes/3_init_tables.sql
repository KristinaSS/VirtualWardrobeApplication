-- liquibase formatted sql

-- Changeset kristina:2023-08-13-create-accounts
INSERT INTO `vw_accounts`.`account` (`name`, `email`, `password`, `account_type`) VALUES ('Kristina Stoyanova', 'kirsagriza@gmail.com', 'temp', 'USER');
INSERT INTO `vw_accounts`.`account` (`name`, `email`, `password`, `account_type`) VALUES ('Geno Enchev', 'longersoul92@gmail.com', 'temp', 'ADMIN');
