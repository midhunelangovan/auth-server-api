CREATE TABLE  `users`(
    `id`   BIGINT AUTO_INCREMENT,
    `user_name` VARCHAR(100) NOT NULL,
    `first_name` VARCHAR(100) NOT NULL,
    `last_name` VARCHAR(100) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    `password` TEXT NOT NULL,
    `is_active` BIT DEFAULT FALSE,
    `last_login_at` TIMESTAMP,
    `created_at`   TIMESTAMP,
    `modified_at` TIMESTAMP,
    `created_by` VARCHAR(100),
    `modified_by` VARCHAR(100),
    PRIMARY KEY (`id`),
    CONSTRAINT `users_email_unique_key_vqibiqbiq` UNIQUE KEY (`email`),
    CONSTRAINT `users_username_unique_key_vqnbibuibiqbiq` UNIQUE KEY (`user_name`)
)
