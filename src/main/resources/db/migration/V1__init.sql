CREATE TABLE `inventory`
(
    `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `sku` VARCHAR(255) DEFAULT NULL,
    `quantity` INT DEFAULT NULL
);