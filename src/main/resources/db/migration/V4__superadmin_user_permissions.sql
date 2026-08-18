INSERT INTO `roles` (`id`, `name`)
VALUES (1, 'SUPER_ADMIN');

INSERT INTO `users` (`id`, `user_name`, `first_name`, `last_name`, `password`, `email`, `is_active`)
VALUES (1, 'superadmin@kals.io', 'SUPER', 'ADMIN', '$2a$10$cC8hXRxiUQ/6Zk4NpnfYwOv5uICyJhk9cwev.JgRNfAjtwtr53MFO', 'superadmin@kals.io', 1);

INSERT INTO `user_role` (`user_id`, `role_id`)
VALUES (1, 1);