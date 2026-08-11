CREATE TABLE `roles` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `created_at`   TIMESTAMP,
    `modified_at` TIMESTAMP,
    `created_by` VARCHAR(100),
    `modified_by` VARCHAR(100),
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_roles_naenqnbr` (`name`)
);

CREATE TABLE `permissions` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `code` VARCHAR(255) NOT NULL,
    `application_id` BIGINT NOT NULL,
    `description` VARCHAR(255),
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_vbkqnwknqknq_pm_code` (`code`)
);

CREATE TABLE `user_role` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `user_id` BIGINT NOT NULL,
    `role_id` BIGINT NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_biboadnsdnjs_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
    CONSTRAINT `fk_wqwjqbjbj_role_id` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
);

CREATE TABLE `role_permission` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `role_id` BIGINT NOT NULL,
    `permission_id` BIGINT NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_jfskbewfg3g3_role_id` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
    CONSTRAINT `fk_vjvjvqjevjv_perm_id` FOREIGN KEY (`permission_id`) REFERENCES `permissions` (`id`)
);