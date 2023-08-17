/*
 Navicat Premium Data Transfer

 Source Server         : local-mysql
 Source Server Type    : MySQL
 Source Server Version : 80033
 Source Host           : localhost:3306
 Source Schema         : csrft-learn

 Target Server Type    : MySQL
 Target Server Version : 80033
 File Encoding         : 65001

 Date: 17/08/2023 17:13:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL,
  `username` varchar(25) DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ip` varchar(32) DEFAULT NULL,
  `createTime` date DEFAULT NULL,
  `editTime` date DEFAULT NULL,
  `point` int DEFAULT NULL,
  `card` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`id`, `username`, `password`, `ip`, `createTime`, `editTime`, `point`, `card`) VALUES (1, '1', '123', NULL, NULL, NULL, 880, 3);
INSERT INTO `user` (`id`, `username`, `password`, `ip`, `createTime`, `editTime`, `point`, `card`) VALUES (2, 'hack', '123', NULL, NULL, NULL, NULL, 6);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
