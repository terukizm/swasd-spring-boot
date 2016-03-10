-- CREATE USER
DROP USER IF EXISTS 'swasd'@'localhost';
CREATE USER 'swasd'@'localhost';

-- dev
DROP DATABASE IF EXISTS `swasd_dev`;
CREATE DATABASE `swasd_dev` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
GRANT ALL ON `swasd_dev`.* TO 'swasd'@'localhost' IDENTIFIED BY 'swasd';

-- production
DROP DATABASE IF EXISTS `swasd_production`;
CREATE DATABASE `swasd_production` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
GRANT ALL ON swasd_production.* TO 'swasd'@'localhost' IDENTIFIED BY 'swasd';

-- $ mysql -u swasd -pswasd swasd_dev
-- $ mysql -u swasd -pswasd swasd_production
-- TODO: GRANT -> ALTER USER
-- mysql >  show grants for 'swasd'@'localhost';