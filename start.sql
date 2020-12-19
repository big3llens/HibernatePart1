BEGIN;

CREATE TABLE `store`.`books` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(250) NOT NULL,
    PRIMARY KEY (`id`));

COMMIT;