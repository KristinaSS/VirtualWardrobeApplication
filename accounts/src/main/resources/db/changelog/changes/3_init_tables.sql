-- liquibase formatted sql

-- Changeset kristina:2023-08-13-create-accounts
INSERT INTO `vw_accounts`.`account` (`name`, `email`, `password`, `account_type`, `is_active`) VALUES ('Kristina Stoyanova', 'kirsagriza@gmail.com', 'temp', 'USER', '1');
INSERT INTO `vw_accounts`.`account` (`name`, `email`, `password`, `account_type`, `is_active`) VALUES ('Geno Enchev', 'longersoul92@gmail.com', 'temp', 'ADMIN', '1');
