CREATE TABLE `users`  (
                          `id` int(0) NOT NULL AUTO_INCREMENT,
                          `account_id` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
                          `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
                          `token` char(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
                          `gmt_create` bigint(0) NULL DEFAULT NULL,
                          `gmt_modified` bigint(0) NULL DEFAULT NULL,
                          PRIMARY KEY (`id`) USING BTREE
)