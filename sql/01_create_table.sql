DROP TABLE IF EXISTS `todos`;
CREATE TABLE IF NOT EXISTS `todos` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `title` VARCHAR(255) NOT NULL COMMENT 'タイトル',
  `done` tinyint(1) NOT NULL DEFAULT '0' COMMENT '完了フラグ',
  `created_at` TIMESTAMP NOT NULL DEFAULT current_timestamp,
  `updated_at` TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'TODO';