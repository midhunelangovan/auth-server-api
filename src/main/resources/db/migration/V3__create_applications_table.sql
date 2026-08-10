CREATE TABLE `applications` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `application_code` BIGINT NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `description` VARCHAR(255),
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_applications_code` (`application_code`)
);