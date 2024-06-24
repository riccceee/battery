/*
 Navicat Premium Data Transfer

 Source Server         : localhost_13306
 Source Server Type    : MySQL
 Source Server Version : 80035
 Source Host           : localhost:13306
 Source Schema         : battery

 Target Server Type    : MySQL
 Target Server Version : 80035
 File Encoding         : 65001

 Date: 18/06/2024 23:57:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for battery_type
-- ----------------------------
DROP TABLE IF EXISTS `battery_type`;
CREATE TABLE `battery_type`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of battery_type
-- ----------------------------
INSERT INTO `battery_type` VALUES (1, '三元电池');
INSERT INTO `battery_type` VALUES (2, '铁锂电池');

SET FOREIGN_KEY_CHECKS = 1;
