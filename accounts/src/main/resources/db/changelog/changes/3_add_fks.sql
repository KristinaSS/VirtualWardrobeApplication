-- liquibase formatted sql

-- Changeset kristina:2023-08-13-add-account_style-fk-gen
ALTER TABLE `vw_accounts`.`account_style`
    ADD INDEX `sty_acc_sty_fk_idx` (`id_style` ASC) VISIBLE;
;
ALTER TABLE `vw_accounts`.`account_style`
    ADD CONSTRAINT `acc_acc_style_fk`
        FOREIGN KEY (`id_account`)
            REFERENCES `vw_accounts`.`account` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;